package com.uag.restaurante.dados;

import com.uag.restaurante.dados.IRepositorioProduto;
import com.uag.restaurante.entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RepositorioProduto implements IRepositorioProduto{

    private static RepositorioProduto singleton;

    public static RepositorioProduto getSingleton(){
        if (singleton == null){
            singleton = new RepositorioProduto();
        }
        return singleton;
    }
    private RepositorioProduto(){
        String sql = "CREATE TABLE IF NOT EXISTS Produtos (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	nome text NOT NULL,\n"
                + "	valor real,\n"
                + "     quantidade integer\n"
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
    public void adicionar(Produto produto) throws SQLException{
       String sql = "INSERT INTO Produtos (id, nome, valor, quantidade)VALUES(?,?,?,?)";
        try{
                Connection conn = ConnectionSQlite.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, produto.getId());
                pstmt.setString(2, produto.getNome());
                pstmt.setFloat(3, (float)produto.getValor());
                pstmt.setInt(4, (int)produto.getQuantidade());
                pstmt.executeUpdate();
                conn.close();
                pstmt.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remover(Produto produto){
         String sql = "DELETE FROM Produtos WHERE id = ?";

        try (Connection conn = ConnectionSQlite.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, produto.getId());
            pstmt.executeUpdate();
            conn.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void atualizar(Produto produto){
        String sql = "UPDATE Produtos SET valor = ?, quantidade = ? WHERE id = ?";
        try (Connection conn = ConnectionSQlite.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setFloat(1, (float)produto.getValor());
            pstmt.setInt(2, (int)produto.getQuantidade());
            pstmt.executeUpdate();
            conn.close();
            pstmt.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public ArrayList <Produto> ler() {
        String sql = "SELECT * FROM Produtos";
        ArrayList <Produto> ListaProdutos = new ArrayList<>();

        try (Connection conn = ConnectionSQlite.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getFloat("valor"), rs.getInt("quantidade"));
               ListaProdutos.add(p);
            }

            conn.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return ListaProdutos;
    }
    //aa
}
