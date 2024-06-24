package com.App_Service_Back.concessionarias;

import java.io.Serializable;

public class ConcessionariasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;

    // Getters and Setters
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
}