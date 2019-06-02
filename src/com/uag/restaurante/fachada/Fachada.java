package com.uag.restaurante.fachada;

import com.uag.restaurante.entidades.Funcionario;
import com.uag.restaurante.entidades.Mesa;
import com.uag.restaurante.entidades.Pedido;
import com.uag.restaurante.entidades.Produto;
import com.uag.restaurante.exceptions.ExceptionCpfInvalido;
import com.uag.restaurante.exceptions.ExceptionNomeInvalido;
import com.uag.restaurante.negocio.GerenciamentoCaixa;
import com.uag.restaurante.negocio.GerenciamentoFuncionario;
import com.uag.restaurante.negocio.GerenciamentoMesa;
import com.uag.restaurante.negocio.GerenciamentoPedido;
import com.uag.restaurante.negocio.GerenciamentoProduto;
import java.sql.SQLException;
import java.util.ArrayList;

public class Fachada {
    private static Fachada singleton;
    private GerenciamentoFuncionario funcionarios;
    private GerenciamentoProduto produtos;
    private GerenciamentoCaixa caixa;
    private GerenciamentoMesa mesas;
    private GerenciamentoPedido pedido;

    private Fachada(){
        funcionarios = GerenciamentoFuncionario.getSingleton();
        produtos = GerenciamentoProduto.getSingleton();
    }
    public static Fachada getSingleton(){
        if (singleton ==  null){
            singleton = new Fachada();
        }
        return singleton;
    }
   
    //CAIXA---------------------------------------------------------------------------------------------------------------------------------   
    
     public ArrayList lerDadosCaixa(){
        return caixa.status();
    }
    
    //MESA---------------------------------------------------------------------------------------------------------------
    public void adicionarMesa(Mesa mesa){
        mesas.adicionarMesa(mesa);
    }
    
    public ArrayList<Mesa> consultarMesa(int id){
        return  mesas.consultar();    
    }
    
    //PEDIDOS---------------------------------------------------------------------------------------------------
    public void adicionarPedido(int qnt, String produto){
        Pedido pedido = new Pedido(qnt, produto);
    //    pedidos.adicionar(pedido);
    }
    //FUNCIONARIO-----------------------------------------------------------------------------------------------
    public void adicionarFuncionario(String cpf, String nome, String endereco, String telefone, String dataNasc, String sexo, String acessarCaixa, String senha) throws SQLException, Exception{
        Funcionario funcionario = new Funcionario(cpf, nome, endereco, telefone, dataNasc, sexo, acessarCaixa, senha);
        funcionarios.adicionar(funcionario);
    }
    
    public void removerFuncionario(String cpf, String nome, String endereco, String telefone, String dataNasc, String sexo, String acessarCaixa, String senha) throws SQLException, ExceptionCpfInvalido, ExceptionNomeInvalido, Exception{
        Funcionario funcionario = new Funcionario(cpf, nome, endereco, telefone, dataNasc, sexo, acessarCaixa, senha);
        funcionarios.remover(funcionario);
    }
    
    public void atualizarFuncionario(String cpf, String nome, String endereco, String telefone, String dataNasc, String sexo, String acessarCaixa, String senha) throws SQLException, ExceptionNomeInvalido{
        Funcionario funcionario = new Funcionario(cpf, nome, endereco, telefone, dataNasc, sexo, acessarCaixa, senha);
        funcionarios.atualizar(funcionario);
    }

    public ArrayList lerFuncionarios() throws SQLException{
        return funcionarios.ler();
    }

    //PRODUTO--------------------------------------------------------------------------------------------------------------
    public void adicionarProduto(int id, String nome, float valor, int quantidade) throws SQLException{
        Produto produto = new Produto(id, nome, valor, quantidade);
        produtos.adicionar(produto);
    }
    
    public void removerProduto(int id, String nome, float valor, int quantidade) throws SQLException{
        Produto produto = new Produto(id, nome, valor, quantidade);
        produtos.remover(produto);
    }
    
    public void atualizarProduto(String nome, int id, float valor, int quantidade) throws SQLException{
        Produto produto = new Produto(id, nome, valor, quantidade);
        produtos.atualizar(produto);
    }
    
    public ArrayList lerProduto() throws SQLException{
        return produtos.ler();
    }
}
