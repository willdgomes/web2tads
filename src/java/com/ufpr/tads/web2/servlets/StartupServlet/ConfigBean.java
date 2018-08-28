/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets.StartupServlet;

import java.io.Serializable;

/**
 *
 * @author gomes
 */
public class ConfigBean implements Serializable {
    private String emailAdmin;

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }


}
