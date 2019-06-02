/*package com.uag.gatitoscaninos.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.uag.gatitoscaninos.negocio.modelo.Cliente;
import com.uag.gatitoscaninos.negocio.modelo.Endereco;
import com.uag.gatitoscaninos.negocio.modelo.Pet;
import com.uag.gatitoscaninos.negocio.modelo.Produto;
import com.uag.gatitoscaninos.negocio.modelo.Telefone;

public class RepositorioCliente implements IRepositorioCliente {

	@Override
	public void inserirCliente(Cliente cliente, boolean pets) throws ErroNoBancoException {
		try{
			Connection conn = RepositorioSQLite.getSingleton().connect();
			String sql = "INSERT INTO cliente (nomeCompleto, cpf, rg, deleted) VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cliente.getNomeCompleto());
			pstmt.setString(2, cliente.getCpf());
			pstmt.setString(3, cliente.getRg());
			pstmt.setInt(4, 0);
			pstmt.execute();
			cliente.setId(consultarUltimoId());
			cliente.getTelefone().setIdDono(cliente.getId());
			inserirTelefoneCliente(cliente.getTelefone());
			cliente.getEndereco().setIdDono(cliente.getId());
			inserirEnderecoCliente(cliente.getEndereco());
			if (pets == true) {
				IRepositorioPet repPet = new RepositorioPet();
				repPet.inserirPets(cliente);
			}
		} catch(SQLException ex){
			System.out.println(ex.getMessage());
			throw new ErroNoBancoException(ex.getMessage());
		}
		
	}
	
	
	public void inserirTelefoneCliente(Telefone telefone) throws ErroNoBancoException{
		try{
			Connection conn = RepositorioSQLite.getSingleton().connect();
			String sql = "INSERT INTO telefoneCliente (idDono, ddd, numero) VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, telefone.getIdDono());
			pstmt.setString(2, telefone.getDdd());
			pstmt.setString(3, telefone.getNumero());
			pstmt.execute();
		}catch (SQLException ex){
			throw new ErroNoBancoException(ex.getMessage());
		}
	}
	
	public void inserirEnderecoCliente(Endereco endereco) throws ErroNoBancoException{
		try{
			Connection conn = RepositorioSQLite.getSingleton().connect();
			String sql = "INSERT INTO enderecoCliente (idDono, nCasa, rua, bairro, cidade, estado, cep) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endereco.getIdDono());
			pstmt.setString(2, endereco.getnCasa());
			pstmt.setString(3, endereco.getRua());
			pstmt.setString(4, endereco.getBairro());
			pstmt.setString(5, endereco.getCidade());
			pstmt.setString(6, endereco.getEstado());
			pstmt.setString(7, endereco.getCep());
			pstmt.execute();
		} catch(SQLException ex){
			throw new ErroNoBancoException(ex.getMessage());
		}
	}

	public int consultarUltimoId() throws ErroNoBancoException {
		String sql = "SELECT seq FROM sqlite_sequence WHERE name == 'cliente';";
		
		try (Connection conn = RepositorioSQLite.getSingleton().connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            return Integer.parseInt(rs.getString("seq"));
		} catch (SQLException e) {	
			throw new ErroNoBancoException(e.getMessage());
       	}
	}


	@Override
	public void excluirCliente(int id) throws DadoNãoExistenteNaTabelaException {
		String sql ="UPDATE cliente SET deleted = 1 WHERE id = ?";
		
		try (Connection conn = RepositorioSQLite.getSingleton().connect();
		    	PreparedStatement pstmt = conn.prepareStatement(sql)) {
		 
		        pstmt.setInt(1, id);
		        pstmt.executeUpdate();
		       
		    } catch (SQLException e) {
		    	throw new DadoNãoExistenteNaTabelaException();
		    }
	}

	@Override
	public void consultarClientes(ArrayList<Cliente> cliente) throws ErroNoBancoException {
		String sql = "SELECT * FROM cliente WHERE deleted == 0";
    	
    	try (Connection conn = RepositorioSQLite.getSingleton().connect();
    		Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
    		
            Cliente novoCliente = null;
            int id;
            String nome, cpf, rg;
            Telefone telefone = null;
            Endereco endereco = null;
            RepositorioPet repPet = new RepositorioPet();
            
            while (rs.next()) {
            	id = rs.getInt("id");
            	nome = rs.getString("nomeCompleto");
            	cpf = rs.getString("cpf");
            	rg = rs.getString("rg");
            	telefone = consultarTelefoneDeUmCliente(id);
            	endereco = consultarEnderecoDeUmCliente(id);
            	novoCliente = new Cliente(id,nome,cpf,rg, telefone, endereco);
            	cliente.add(novoCliente);
            }
            for (int i = 0; i < cliente.size(); i++) {
            	repPet.consultarPetsDeUmCliente(cliente.get(i));
            }
       } catch (SQLException e) {
    	   throw new ErroNoBancoException(e.getMessage());
       }	
		
	}
	
	public Telefone consultarTelefoneDeUmCliente(int id) throws ErroNoBancoException {
		String sql = "SELECT * FROM telefoneCliente WHERE idDono == " + id;
		
		try (Connection conn = RepositorioSQLite.getSingleton().connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
			Telefone telefone = null;
            String ddd, numero;
			while (rs.next()) {
            	ddd = rs.getString("ddd");
            	numero = rs.getString("numero");
            	telefone = new Telefone(id, ddd, numero);
            }
			return telefone;
		} catch (SQLException e) {
			throw new ErroNoBancoException(e.getMessage());
       	}
	}
	
	public Endereco consultarEnderecoDeUmCliente(int id) throws ErroNoBancoException {
		String sql = "SELECT * FROM enderecoCliente WHERE idDono == " + id;
		
		try (Connection conn = RepositorioSQLite.getSingleton().connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
			Endereco endereco = null;
            String nCasa, rua, bairro, cidade, estado, cep;
			while (rs.next()) {
            	nCasa = rs.getString("nCasa");
            	rua = rs.getString("rua");
            	bairro = rs.getString("bairro");
            	cidade = rs.getString("cidade");
            	estado = rs.getString("estado");
            	cep = rs.getString("cep");
            	endereco = new Endereco(id, nCasa, rua, bairro, cidade, estado, cep);
            	
            }
			return endereco;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ErroNoBancoException(e.getMessage());
       	}
	}


	@Override
	public void atualizarTelefoneCliente(Telefone telefone) throws ErroNoBancoException {
		String sql = "UPDATE telefoneCliente SET ddd = ?, numero = ? WHERE idDono = ?";
				
		try (Connection conn = RepositorioSQLite.getSingleton().connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
						 
				pstmt.setString(1, telefone.getDdd());
				pstmt.setString(2, telefone.getNumero());
				pstmt.setInt(3, telefone.getIdDono());;
				pstmt.executeUpdate();       
			   	} catch (SQLException e) {
			    	throw new ErroNoBancoException(e.getMessage());
			    }		
	}


	@Override
	public void atualizarEnderecoCliente(Endereco endereco) throws ErroNoBancoException {
		String sql = "UPDATE enderecoCliente SET nCasa = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE idDono = ?";
		
		try (Connection conn = RepositorioSQLite.getSingleton().connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
						 
				pstmt.setString(1, endereco.getnCasa());
				pstmt.setString(2, endereco.getRua());
				pstmt.setString(3, endereco.getBairro());
				pstmt.setString(4, endereco.getCidade());
				pstmt.setString(5, endereco.getEstado());
				pstmt.setString(6, endereco.getCep());
				pstmt.setInt(7, endereco.getIdDono());
				pstmt.executeUpdate();       
			   	} catch (SQLException e) {
			   		throw new ErroNoBancoException(e.getMessage());
			    }		
	}
}
*/