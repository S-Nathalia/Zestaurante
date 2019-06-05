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

    @Override
    public void criarPedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarPedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mudarPedidio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedido lerPedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
