package com.uag.restaurante.entidades;

public class Caixa {
    private float saldo;
    private boolean status;
    private float saldoInicial;
    private String data;

    public Caixa(float saldo, float saldoInicial, String data, boolean status) {
        this.saldo = saldo;
        this.saldoInicial = saldoInicial;
        this.data = data;
        this.status = status;
    }
    
    public void abrirCaixa(float valor){
        if(isStatus() == false){
            setStatus(true);
            setSaldoInicial(0);
            setSaldo(0);
            try{
                setSaldoInicial(valor);   
            }
            catch(Exception e){}  
        }
    }
  
    public void fecharCaixa(){
        this.status = false;   
    }
    
    public void tirarDinheiro(float valor){
        if(valor < getSaldo()){
                setSaldo(getSaldo() - valor);
        }
    }
         
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }       
}


