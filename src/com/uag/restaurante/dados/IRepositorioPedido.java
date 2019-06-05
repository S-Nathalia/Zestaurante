package com.uag.restaurante.dados;

import com.uag.restaurante.entidades.Pedido;

public interface IRepositorioPedido {
    public void criarPedido();
    public void deletarPedido();
    public void mudarPedidio();
    public Pedido lerPedido();
        
}
