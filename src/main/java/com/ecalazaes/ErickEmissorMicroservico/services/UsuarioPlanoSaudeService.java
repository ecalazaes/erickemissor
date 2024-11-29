package com.ecalazaes.ErickEmissorMicroservico.services;

import com.ecalazaes.ErickEmissorMicroservico.dto.UsuarioPlanoSaudeDTO;
import com.ecalazaes.ErickEmissorMicroservico.entities.UsuarioPlanoSaude;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsuarioPlanoSaudeService {

    private final AmqpTemplate amqpTemplate;
    private final String QUEUE_NAME = "Fila";

    public UsuarioPlanoSaudeService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public UsuarioPlanoSaude inserirUsuario(UsuarioPlanoSaude usuarioPlanoSaude) {
        UsuarioPlanoSaudeDTO usuarioDTO = new UsuarioPlanoSaudeDTO(
                usuarioPlanoSaude.getId(),
                usuarioPlanoSaude.getNome(),
                usuarioPlanoSaude.getMatricula()
        );
        enviarParaFila(usuarioDTO);
        return usuarioPlanoSaude;
    }

    private void enviarParaFila(UsuarioPlanoSaudeDTO usuarioDTO) {
        amqpTemplate.convertAndSend(QUEUE_NAME, usuarioDTO);
    }
}
