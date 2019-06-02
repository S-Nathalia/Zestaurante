package com.uag.restaurante.dados;

import com.uag.restaurante.entidades.Pedido;

public class RepositorioPedido implements IRepositorioPedido{
    private static RepositorioPedido singleton;

    public static RepositorioPedido getSingleton(){
        if (singleton == null){
            singleton = new RepositorioPedido();
        }
        return singleton;
    }

    public void adicionar(Pedido pedido) {
    
    }
}
