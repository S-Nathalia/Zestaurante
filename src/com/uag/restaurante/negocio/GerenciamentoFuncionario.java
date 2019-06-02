package com.uag.restaurante.negocio;

import com.uag.restaurante.dados.RepositorioFuncionario;
import com.uag.restaurante.entidades.Funcionario;
import com.uag.restaurante.exceptions.ExceptionAcessarCaixa;
import com.uag.restaurante.exceptions.ExceptionCpfInvalido;
import com.uag.restaurante.exceptions.ExceptionDataNasc;
import com.uag.restaurante.exceptions.ExceptionNomeInvalido;
import com.uag.restaurante.exceptions.ExceptionSexo;
import com.uag.restaurante.exceptions.ExceptionTelefoneInvalido;
import java.sql.SQLException;
import java.util.ArrayList;


public class GerenciamentoFuncionario{

    private static GerenciamentoFuncionario singleton;
    private RepositorioFuncionario repositorio;

    private GerenciamentoFuncionario(){
        this.repositorio = RepositorioFuncionario.getSingleton();
    }

    public static GerenciamentoFuncionario getSingleton(){
            if(singleton == null){
            singleton =  new GerenciamentoFuncionario();
        }
        return singleton;

    }
    public void adicionar(Funcionario funcionario) throws SQLException, Exception, ExceptionNomeInvalido, ExceptionTelefoneInvalido, ExceptionDataNasc, ExceptionSexo, ExceptionAcessarCaixa {
        repositorio.adicionar(funcionario);
    }

    public void remover(Funcionario funcionario) throws SQLException, ExceptionCpfInvalido, Exception {
        repositorio.remover(funcionario);
        }

    public void atualizar(Funcionario funcionario) throws SQLException {
        repositorio.atualizar(funcionario);
    }

    public ArrayList <Funcionario> ler() throws SQLException {
        return repositorio.ler();
    }
}
