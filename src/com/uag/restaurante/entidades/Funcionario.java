
package com.uag.restaurante.entidades;

public class Funcionario {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String dataNasc;
    private String sexo;
    private String acessarCaixa;
    private String senha;

    public Funcionario(String cpf, String nome, String endereco, String telefone, String dataNasc, String sexo, String acessarCaixa, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.acessarCaixa = acessarCaixa;
        this.senha = senha;
        this.endereco = endereco;
    }



    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAcessarCaixa() {
        return acessarCaixa;
    }

    public void setAcessarCaixa(String acessarCaixa) {
        this.acessarCaixa = acessarCaixa;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
