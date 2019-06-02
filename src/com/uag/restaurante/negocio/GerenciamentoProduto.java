
package com.uag.restaurante.negocio;

import com.uag.restaurante.dados.RepositorioProduto;
import com.uag.restaurante.entidades.Produto;
import java.sql.SQLException;
import java.util.ArrayList;

public class GerenciamentoProduto {
    private static GerenciamentoProduto singleton;
    private RepositorioProduto repositorio;

    private GerenciamentoProduto(){
        this.repositorio = RepositorioProduto.getSingleton();
    }

    public static GerenciamentoProduto getSingleton(){
            if(singleton == null){
            singleton =  new GerenciamentoProduto();
        }
        return singleton;
    }

    public void adicionar(Produto produto) throws SQLException {
        repositorio.adicionar(produto);
    }

    public void remover(Produto produto) throws SQLException {
           repositorio.remover(produto);
    }

    public void atualizar(Produto produto) throws SQLException {
            repositorio.atualizar(produto);
    }

    public ArrayList <Produto> ler() throws SQLException {
        return repositorio.ler();
    }

    public Produto ler(int id){
        ArrayList <Produto> arr = repositorio.ler();
        for(Produto p : arr) {
            if(p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
