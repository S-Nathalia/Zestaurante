package com.uag.restaurante.negocio;

import com.uag.restaurante.dados.RepositorioFuncionario;
import com.uag.restaurante.entidades.Funcionario;
import com.uag.restaurante.exceptions.ExceptionAcessoCaixa;
import com.uag.restaurante.exceptions.ExceptionCpfInvalido;
import com.uag.restaurante.exceptions.ExceptionDataNasc;
import com.uag.restaurante.exceptions.ExceptionEnderecoInvalido;
import com.uag.restaurante.exceptions.ExceptionNomeInvalido;
import com.uag.restaurante.exceptions.ExceptionSenha;
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
    public void adicionar(Funcionario funcionario) throws SQLException, Exception, ExceptionNomeInvalido, ExceptionTelefoneInvalido, ExceptionDataNasc, ExceptionSexo, 
            ExceptionAcessoCaixa, ExceptionSenha {
        if(funcionario.getCpf().length() != 11 || funcionario.getCpf().equals(null) || funcionario.getCpf().isEmpty()){
            throw new ExceptionCpfInvalido("CPF INVÁLIDO");
        }
        if(funcionario.getNome().length() < 3 || funcionario.getNome().equals(null) || funcionario.getNome().isEmpty()){
            throw new ExceptionNomeInvalido("NOME INVÁLIDO");
        }
        if(funcionario.getEndereco().equals(null) || funcionario.getEndereco().isEmpty()){
            throw new ExceptionEnderecoInvalido("ENDERECO INVÁLIDO");
        }
        if(funcionario.getTelefone().length() < 8 || funcionario.getTelefone().equals(null) || funcionario.getTelefone().isEmpty()){
            throw new ExceptionTelefoneInvalido("TELEFONE INVÁLIDO");
        }
        if(funcionario.getDataNasc().length() < 6 || funcionario.getDataNasc().equals(null) || funcionario.getDataNasc().isEmpty()){
            throw new ExceptionDataNasc("DATA DE NASCIMENTO INVALIDA");
        }
        if(funcionario.getSexo().isEmpty() || funcionario.getSexo().equals(null)){
            throw new ExceptionSexo("SEXO INVÁLIDO");
        }
        if(funcionario.getAcessarCaixa().isEmpty() || funcionario.getAcessarCaixa() == null){
            throw new ExceptionAcessoCaixa("ACESSO INVALIDO");
        }
        if(funcionario.getSenha() == null || funcionario.getSenha().isEmpty()){
            throw new ExceptionSenha("SENHA NAO PODE SER NULA");
        }
                   
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
