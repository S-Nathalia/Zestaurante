
package com.uag.restaurante.dados;

import com.uag.restaurante.entidades.Mesa;
import java.util.ArrayList;

public interface IRepositorioMesa {
    public ArrayList<Mesa> ler();
    public void adicionarIdConta(int qnt); //adicionar id da conta
    public void adicionarMesa(Mesa mesa);
    public void deleteMesa(int mesa);
    public void fecharIdConta(int idConta);
}
