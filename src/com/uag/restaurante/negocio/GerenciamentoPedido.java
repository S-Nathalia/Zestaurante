package com.uag.restaurante.negocio;

import com.uag.restaurante.dados.RepositorioPedido;
import com.uag.restaurante.entidades.Pedido;

public class GerenciamentoPedido {
    private static GerenciamentoPedido singleton;
    private RepositorioPedido repositorio;
    
    private GerenciamentoPedido(){
        this.repositorio = RepositorioPedido.getSingleton();
    }
    
    public static GerenciamentoPedido getSingleton(){
            if(singleton == null){
            singleton =  new GerenciamentoPedido();
        }
        return singleton;
    }
    
    public void adicionar(Pedido pedido){
        try{
            if(pedido.getQuantidade() == 0){
                System.out.println("QUANTIDADE NULA");
                return;
            }
        }catch(Exception e){}
        
        repositorio.adicionar(pedido); 
    }       
}
