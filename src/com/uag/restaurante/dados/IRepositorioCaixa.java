package com.uag.restaurante.dados;

import com.uag.restaurante.entidades.Caixa;
import java.util.ArrayList;

public interface IRepositorioCaixa {
    public ArrayList<Caixa> dadosCaixa();
    public void fecharCaixa();
    public void abrirCaixa();
}
