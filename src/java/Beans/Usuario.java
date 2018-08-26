/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author gomes
 */
public class Usuario {
    
    int id;
    String login;
    String senha;
    String nome;

    public Usuario(String nome, String login, String senha) {
        this.nome=nome;
        this.login=login;
        this.senha=senha;
    }

    public Usuario() {
        
    }

    public Usuario(String id, String login, String senha, String nome) {
        this.id=Integer.parseInt(id);
        this.nome=nome;
        this.login=login;
        this.senha=senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
