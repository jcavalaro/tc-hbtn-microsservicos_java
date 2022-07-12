package com.example.jpah2demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private int DDD;

    @NotNull
    private int numero;

    @ManyToOne
    @JsonIgnoreProperties("telefone")
    private Cliente cliente_id;

    public Telefone() {
    }

    public Telefone(long id, int DDD, int numero, Cliente cliente_id) {
        this.id = id;
        this.DDD = DDD;
        this.numero = numero;
        this.cliente_id = cliente_id;
    }

    public Telefone(long id, int DDD, int numero) {
        this.id = id;
        this.DDD = DDD;
        this.numero = numero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }
}
