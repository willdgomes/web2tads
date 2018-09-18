/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.ClienteDAO;

import com.ufpr.tads.web2.beans.Cliente.Cliente;
import com.ufpr.tads.web2.dao.ConnectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gomes
 */
public class ClienteDAO {

    private final String stmtInserir = "INSERT INTO cliente (nome, sobrenome, telefone) VALUES(?,?,?)";
    private final String stmtBuscarClientes = "SELECT id_cliente, cpf_cliente, nome_cliente, email_cliente, data_cliente, rua_cliente, nr_cliente, cep_cliente, cidade_cliente, uf_cliente FROM tb_cliente";
    private final String stmtRemoverClientes = "DELETE FROM cliente WHERE idCliente = ?";
    private final String stmtAtualizarClientes = "UPDATE cliente SET nome = ?, sobrenome = ?, telefone = ? WHERE idCliente = ?";
    
    public void inserirCliente(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir);
            stmt.setString(1, cliente.getNomeCliente());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um cliente no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();;
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }

    public List<Cliente> buscarClientes() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> listaClientes = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarClientes);
            rs = stmt.executeQuery();
            listaClientes = new ArrayList<Cliente>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpfCliente(rs.getString("cpf_cliente"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                cliente.setEmailCliente(rs.getString("email_cliente"));
                listaClientes.add(cliente);
            }  
        return listaClientes;
        }
    catch(SQLException ex){
            throw new RuntimeException("Erro ao listar os clientes no banco de dados. Origem=" + ex.getMessage());
    }
        finally{
            try {
            rs.close();
        } catch (Exception ex) {
            System.out.println("Erro ao fechar rs. Ex=" + ex.getMessage());
        };
        try {
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
        };
        try {
            con.close();;
        } catch (Exception ex) {
            System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
        };
    }

}

    public void removerCliente(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtRemoverClientes);
            stmt.setInt(1, cliente.getIdCliente());
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            throw new RuntimeException("Erro ao excluir o cliente no banco de dados. Origem=" + ex.getMessage());
        }
        finally{
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();;
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
            
    }

    public void atualizarCliente(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtAtualizarClientes);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setInt(4, cliente.getIdCliente());
            stmt.executeUpdate();
            
        }
        catch(SQLException ex){
            throw new RuntimeException("Erro ao atualizar o cliente no banco de dados. Origem=" + ex.getMessage());
        }
        finally{
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();;
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }

    public List<Cliente> buscarClientesParam(String parametro, String colunaPesquisa) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> listaClientes = null;
        String stmtBuscarClientesParam = "SELECT idCliente, nome, sobrenome, telefone FROM cliente WHERE " + colunaPesquisa + " LIKE ?"; 
        try{
            con = ConnectionFactory.getConnection();  
            
            stmt = con.prepareStatement(stmtBuscarClientesParam); 
            stmt.setString(1,'%'+parametro+'%');
            rs = stmt.executeQuery();
            listaClientes = new ArrayList<Cliente>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                listaClientes.add(cliente);
            }  
        return listaClientes;            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao listar os clientes no banco de dados. Origem="+ex.getMessage());            
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar rs. Ex="+ex.getMessage());};
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();;}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};                
        }
    
    }

}
