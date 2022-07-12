package com.example.jpah2demo.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome;

    @NotNull
    private int idade;

    @NotNull
    private String email;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private List<Telefone> telefones = new ArrayList<>();



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private List<Endereco> endereco = new ArrayList<>();

    public Cliente() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public Cliente(long id, String nome, int idade, String email, List<Telefone> telefones, List<Endereco> endereco) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    public Cliente(long id, String nome, int idade, String email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }
}
