package com.uag.restaurante.dados;

import com.uag.restaurante.entidades.Caixa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RepositorioCaixa implements IRepositorioCaixa{
    private static RepositorioCaixa singleton;
    
    public static RepositorioCaixa getSingleton(){
        if (singleton == null){
            singleton = new RepositorioCaixa();
        }
        return singleton;    
    }
    
    private RepositorioCaixa(){
        String sql = "CREATE TABLE IF NOT EXISTS Caixa (\n"
                     + "        saldoInicial real,\n"
                     + "	saldo real NOT NULL,\n"
                     + "        aberto blob NOT NULL,\n"
                     + "	data text NOT NULL\n"
                     + ")";
        try{ 
            Connection conn = ConnectionSQlite.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        } catch(SQLException e){}
    }
    
    public ArrayList<Caixa> dadosCaixa(){
        String sql = "SELECT * FROM Caixa";
        ArrayList<Caixa> caixa = new ArrayList<>();
        
        try (Connection conn = ConnectionSQlite.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()){
                Caixa c = new Caixa (rs.getFloat("saldo"), rs.getFloat("saldoInicial"), rs.getString("data"), rs.getBoolean("aberto"));
                caixa.add(c);
            }
            conn.close();
            stmt.close();
        }catch (SQLException e) {}
        
        return caixa;
    }

    @Override
    public void fecharCaixa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void abrirCaixa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
