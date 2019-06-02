package com.uag.restaurante.dados;

import com.uag.restaurante.entidades.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioFuncionario {

    void adicionar(Funcionario funcionario) throws SQLException;

    void remover(Funcionario funcionario) throws SQLException;

    void atualizar(Funcionario funcionario) throws SQLException;

    ArrayList <Funcionario> ler() throws SQLException;
}
