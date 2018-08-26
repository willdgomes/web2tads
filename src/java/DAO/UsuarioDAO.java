/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Usuario;
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
public class UsuarioDAO {
    
    private String stmtBuscaUsuario = "select id_usuario, login_usuario, senha_usuario,nome_usuario from tb_usuario where login_usuario = ? and senha_usuario = ?";
    private String insereUsuario = "insert into tb_usuario (nome_usuario, login_usuario, senha_usuario) values (?, ?, ?)";
    private String buscarTodosUsuarios = "select * from tb_usuario";
    public Usuario lerUsuario (String login, String senha){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscaUsuario);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();   
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(Integer.parseInt(rs.getString("id_usuario")));
                u.setLogin(rs.getString("login_usuario"));
                u.setSenha(rs.getString("senha_usuario"));
                u.setNome(rs.getString("nome_usuario"));
                return u;
            }
            else {
                return null;
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar usuario" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }
    
    public boolean inserirUsuario (Usuario u){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insereUsuario);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.executeUpdate();
            return true;
        }
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar usuario" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }

    public List<Usuario> buscarTodosUsuarios() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> listaUsuarios = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscarTodosUsuarios);
            rs = stmt.executeQuery();
            listaUsuarios = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getString("id_usuario"), rs.getString("login_usuario"), rs.getString("senha_usuario"), rs.getString("nome_usuario"));
                listaUsuarios.add(usuario);
            }  
        return listaUsuarios;
        }
    catch(SQLException ex){
            throw new RuntimeException("Erro ao listar os usuarios no banco de dados. Origem=" + ex.getMessage());
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
}

