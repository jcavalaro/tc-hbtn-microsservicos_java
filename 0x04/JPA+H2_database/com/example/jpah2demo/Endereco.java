package com.example.jpah2demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name= "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String logradouro;

    @NotNull
    private String endereco;

    @NotNull
    private int numero;

    @NotNull
    private String bairro;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;

    @ManyToOne
    @JsonIgnoreProperties("endereco")
    private Cliente cliente_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Endereco(long id, String logradouro, String endereco, int numero, String bairro, String cidade, String estado, Cliente cliente_id) {
        this.id = id;
        this.logradouro = logradouro;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cliente_id = cliente_id;
    }

    public Endereco(long id, String logradouro, String endereco, int numero, String bairro, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
}
