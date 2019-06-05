package com.uag.restaurante.dados;

import com.uag.restaurante.entidades.Mesa;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositorioMesa implements IRepositorioMesa {
           
    private static RepositorioMesa singleton;
    
    public static RepositorioMesa getSingleton(){
        if (singleton == null){
            singleton = new RepositorioMesa();
        }
        return singleton;  
    }
    private RepositorioMesa(){
        String sql = "CREATE TABLE IF NOT EXISTS Mesas (\n"
                + "	id integer PRIMARY KEY,\n"
                + "     contaId integer,\n"
                + "     ocupado blob NOT NULL\n"
                + ")"; 
        
        try{ 
            Connection conn = ConnectionSQlite.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } 
        catch(SQLException e){}
            
    }    

    @Override
    public ArrayList ler() {
        
        ArrayList<Mesa> listaMesas = new ArrayList<>();
            String sql = "SELECT * FROM Mesas";
        
        try (Connection conn = ConnectionSQlite.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Mesa m = new Mesa(rs.getInt("id"), rs.getInt("contaId"), rs.getBoolean("ocupado"));
                listaMesas.add(m);
            }
            conn.close();
            stmt.close();
        }catch (SQLException e){}
        return listaMesas;     
    }

    @Override
    public void adicionarMesa(Mesa mesa) {
       String sql = "INSERT INTO Mesas (id, contaId, ocupado)VALUES(?,?,?)";
        try{ 
                Connection conn = ConnectionSQlite.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                pstmt.setInt(1, mesa.getId());
                pstmt.setInt(2, mesa.getConta());
                pstmt.setBoolean(3, mesa.isStatusOcupado());
                pstmt.executeUpdate();
                conn.close();
                pstmt.close();
            } 
        catch (SQLException e){}    
    }
    
    @Override
    public void deleteMesa(int mesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionarIdConta(int qnt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fecharIdConta(int idConta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
