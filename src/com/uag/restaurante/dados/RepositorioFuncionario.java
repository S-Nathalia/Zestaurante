package com.uag.restaurante.dados;

import com.uag.restaurante.entidades.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RepositorioFuncionario implements IRepositorioFuncionario{

    private static RepositorioFuncionario singleton;

    public static RepositorioFuncionario getSingleton(){
        if (singleton == null){
            singleton = new RepositorioFuncionario();
        }
        return singleton;
    }
    private RepositorioFuncionario(){
        String sql = "CREATE TABLE IF NOT EXISTS Funcionarios (\n"
                + "	cpf text PRIMARY KEY,\n"
                + "	nome text NOT NULL,\n"
                + "     endereco text,\n"
                + "	telefone text,\n"
                + "	dataNasc text,\n"
                + "	sexo text,\n"
                + "	acessarCaixa text,\n"
                + "	senha text\n"
                + ")";

        try{
            Connection conn = ConnectionSQlite.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        } catch(SQLException e){}
    }

    @Override
    public void adicionar(Funcionario funcionario) throws SQLException{
       String sql = "INSERT INTO Funcionarios (cpf,nome,endereco,telefone,dataNasc,sexo,acessarCaixa,senha)VALUES(?,?,?,?,?,?,?,?)";
        try{
                Connection conn = ConnectionSQlite.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, funcionario.getCpf());
                pstmt.setString(2, funcionario.getNome());
                pstmt.setString(3, funcionario.getEndereco());
                pstmt.setString(4, funcionario.getTelefone());
                pstmt.setString(5, funcionario.getDataNasc());
                pstmt.setString(6, funcionario.getSexo());
                pstmt.setString(7, funcionario.getAcessarCaixa());
                pstmt.setString(8, funcionario.getSenha());
                pstmt.executeUpdate();
                conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remover(Funcionario funcionario){
         String sql = "DELETE FROM Funcionarios WHERE cpf = ?";

        try (Connection conn = ConnectionSQlite.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, funcionario.getCpf());
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void atualizar(Funcionario funcionario){
        String sql = "UPDATE Funcionarios SET nome = ?, endereco = ?, telefone = ?, dataNasc = ?, sexo = ?, acessarCaixa = ?, senha = ? WHERE cpf = ?";


        try (Connection conn = ConnectionSQlite.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {


                pstmt.setString(1, funcionario.getCpf());
                pstmt.setString(2, funcionario.getNome());
                pstmt.setString(3, funcionario.getEndereco());
                pstmt.setString(4, funcionario.getTelefone());
                pstmt.setString(5, funcionario.getDataNasc());
                pstmt.setString(6, funcionario.getSexo());
                pstmt.setString(7, funcionario.getAcessarCaixa());
                pstmt.setString(8, funcionario.getSenha());
                pstmt.executeUpdate();
                conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    ResultSet resultSet = null;

    @Override
    public ArrayList <Funcionario> ler(){
        String sql = "SELECT * FROM Funcionarios";
        ArrayList <Funcionario> ListaFuncionarios = new ArrayList<>();

        try (Connection conn = ConnectionSQlite.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
               Funcionario f = new Funcionario(rs.getString("cpf"), rs.getString("nome"), rs.getString("endereco"),rs.getString("telefone"),  rs.getString("dataNasc"), rs.getString("sexo"), rs.getString("acessarCaixa"), rs.getString("senha"));
               ListaFuncionarios.add(f);
            }
            conn.close();
            stmt.close();
         }

         catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ListaFuncionarios;
    }
}