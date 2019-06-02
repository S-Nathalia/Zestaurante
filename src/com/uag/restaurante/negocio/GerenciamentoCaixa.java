package com.uag.restaurante.negocio;

import com.uag.restaurante.dados.RepositorioCaixa;
import com.uag.restaurante.entidades.Caixa;
import java.util.ArrayList;

public class GerenciamentoCaixa {
    private static GerenciamentoCaixa singleton;
    private RepositorioCaixa repositorio;
     
    private GerenciamentoCaixa(){
        this.repositorio = repositorio.getSingleton();

    }
    public static GerenciamentoCaixa getSingleton(){
            if(singleton == null){
                singleton =  new GerenciamentoCaixa();
            }
        return singleton;
    }
    
    public ArrayList<Caixa> status(){
        return repositorio.dadosCaixa();
    }
}
    