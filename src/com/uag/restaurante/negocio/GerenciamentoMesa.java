
package com.uag.restaurante.negocio;

import com.uag.restaurante.dados.RepositorioMesa;
import com.uag.restaurante.entidades.Mesa;
import java.util.ArrayList;

public class GerenciamentoMesa {
        
    private static GerenciamentoMesa singleton;
    private RepositorioMesa repositorio;
    
    private GerenciamentoMesa(){
        this.repositorio = RepositorioMesa.getSingleton();
    }
    
    public static GerenciamentoMesa getSingleton(){
            if(singleton == null){
            singleton =  new GerenciamentoMesa();
        }
        return singleton;
    }

    
    public void adicionarMesa(Mesa mesa){
        repositorio.adicionarMesa(mesa);
    }
    
    public void adicionarConta(){    
    }
    
    public void fecharConta(){
    }

    public ArrayList<Mesa> consultar() {
        return repositorio.ler();
    }
}
