
package com.uag.restaurante.negocio;

import com.uag.restaurante.dados.RepositorioProduto;
import com.uag.restaurante.entidades.Produto;
import com.uag.restaurante.exceptions.ExceptionNomeInvalido;
import com.uag.restaurante.exceptions.ExceptionQuantidade;
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

    public void adicionar(Produto produto) throws SQLException, Exception, ExceptionQuantidade,
            ExceptionNomeInvalido {
        if(produto.getNome().isEmpty() || produto.getNome().equals(null)){  
            throw new ExceptionNomeInvalido("NOME INVÁLIDO");
        }
        if(produto.getQuantidade() == 0){
            throw new ExceptionQuantidade("QUANTIDADE INVALIDA");
        }   
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
