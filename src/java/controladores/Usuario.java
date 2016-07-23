/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/**
 *
 * @author estudiante.2016
 */
public class Usuario {
    private int idusuario;
    private String nombreusuario;
    private String emailusuario;
    private String rolusuario;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getEmailusuario() {
        return emailusuario;
    }

    public void setEmailusuario(String emailusuario) {
        this.emailusuario = emailusuario;
    }

    public String getRolusuario() {
        return rolusuario;
    }

    public void setRolusuario(String rolusuario) {
        this.rolusuario = rolusuario;
    }
    
    @Override
    public String toString() {
        return "Usuario [idusuario=" + idusuario + ", nombreusuario=" + nombreusuario
                + ", emailusuario=" + emailusuario + ", rolusuario="
                + rolusuario + "]";
    }   
}