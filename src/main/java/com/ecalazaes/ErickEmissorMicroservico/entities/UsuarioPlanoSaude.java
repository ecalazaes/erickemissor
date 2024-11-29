package com.ecalazaes.ErickEmissorMicroservico.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class UsuarioPlanoSaude implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String matricula;

    public UsuarioPlanoSaude() {
    }

    public UsuarioPlanoSaude(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioPlanoSaude that = (UsuarioPlanoSaude) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
