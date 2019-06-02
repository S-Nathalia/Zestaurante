
package com.uag.restaurante.entidades;

public class Conta {
    private static int id = 0;
    public float saldoFinal;
    private boolean statusAberta;

    
    public void abrirConta(){
        this.id ++;
        this.statusAberta = true;
    }
    
    public void fecharConta(){
        this.statusAberta = false;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public float getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(float saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
    
    public boolean getStatusAberta(){
        return statusAberta;
    }
    
    public void setStatus(boolean status){
        this.statusAberta = status; 
    }
     
}  