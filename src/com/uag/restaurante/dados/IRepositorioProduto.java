package com.uag.restaurante.dados;

import com.uag.restaurante.entidades.Produto;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioProduto {
    void adicionar(Produto produto) throws SQLException;
    void atualizar(Produto produto) throws SQLException;
    void remover(Produto produto) throws SQLException;
    ArrayList<Produto> ler() throws SQLException;
}
