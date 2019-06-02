package com.uag.restaurante.entidades;

public class Pedido {
    private int quantidade;
    private String produto;
    private float gramas;
    private float almoco = 13;

    public Pedido(int quantidade, String produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Pedido(int qnt) {
        this.quantidade = qnt;
        this.almoco = almoco * qnt;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public float getGramas() {
        return gramas;
    }

    public void setGramas(float gramas) {
        this.gramas = gramas;
    }

    public float getAlmoco() {
        return almoco;
    }

    public void setAlmoco(float almoco) {
        this.almoco = almoco;
    }   
}
