package com.ecalazaes.ErickEmissorMicroservico.controllers;

import com.ecalazaes.ErickEmissorMicroservico.dto.UsuarioPlanoSaudeDTO;
import com.ecalazaes.ErickEmissorMicroservico.entities.UsuarioPlanoSaude;
import com.ecalazaes.ErickEmissorMicroservico.services.UsuarioPlanoSaudeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioPlanoSaudeController {

    private UsuarioPlanoSaudeService service;

    public UsuarioPlanoSaudeController(UsuarioPlanoSaudeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioPlanoSaude> inserirUsuario(@RequestBody UsuarioPlanoSaude usuario) {
        UsuarioPlanoSaude novoUsuario = service.inserirUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
}
