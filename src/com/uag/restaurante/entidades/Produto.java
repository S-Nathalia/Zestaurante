
package com.uag.restaurante.entidades;

public class Produto {

    private int id;
    private String nome;
    private float valor;
    private int quantidade;

    public Produto(int id, String nome, float valor, int quantidade) {
      this.id = id;
      this.nome = nome;
      this.valor = valor;
      this.quantidade = quantidade;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }



}
