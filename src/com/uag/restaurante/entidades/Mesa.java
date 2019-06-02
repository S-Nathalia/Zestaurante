
package com.uag.restaurante.entidades;

public class Mesa {
    private int id;
    private int contaId;
    private boolean statusOcupado;

    public Mesa(int id, int conta, boolean statusOcupado) {
        this.id = id;
        this.contaId = conta;
        this.statusOcupado = statusOcupado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConta() {
        return contaId;
    }

    public void setConta(int conta) {
        this.contaId = conta;
    }

    public boolean isStatusOcupado() {
        return statusOcupado;
    }

    public void setStatusOcupado(boolean statusOcupado) {
        this.statusOcupado = statusOcupado;
    }
}
