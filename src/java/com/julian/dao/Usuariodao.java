/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import controladores.Usuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author estudiante.2016
 */
public class Usuariodao {
    Connection conex = null;
    Statement sql = null;
    String db_name = "prueba";
    String db_usuario = "root";
    String db_pass = "julian";
    
    public Usuariodao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conex = (Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + db_name , db_usuario , db_pass );
            sql = conex.createStatement();
        } catch (Exception ex) {
            Logger.getLogger(Usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public void anadirUsuario(Usuario user) {
        try {
            PreparedStatement preparedStatement = conex
                    .prepareStatement("insert into usuarios(nombre,email,rol) values (?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, user.getNombreusuario());
            preparedStatement.setString(2, user.getEmailusuario());
            preparedStatement.setString(3, user.getRolusuario());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int usuarioId) {
        try {
            PreparedStatement preparedStatement = conex
                    .prepareStatement("delete from usuarios where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, usuarioId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarUsuario(Usuario user) {
        try {
            PreparedStatement preparedStatement = conex
                    .prepareStatement("update usuarios set nombre=?, email=?, rol=?" +
                            "where id=?");
                    
            // Parameters start with 1
            preparedStatement.setString(1, user.getNombreusuario() );
            preparedStatement.setString(2, user.getEmailusuario() );
            preparedStatement.setString(3, user.getRolusuario() );
            preparedStatement.setInt(4, user.getIdusuario() );
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> users = new ArrayList<Usuario>();
        try {
            Statement statement = conex.createStatement();
            ResultSet rs = statement.executeQuery("select * from usuarios");
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setIdusuario( rs.getInt("id") );
                user.setNombreusuario( rs.getString("nombre") );
                user.setEmailusuario( rs.getString("email") );
                user.setRolusuario( rs.getString("rol") );
                
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public Usuario getUsuarioPorId(int userId) {
        Usuario user = new Usuario();
        try {
            PreparedStatement preparedStatement = conex.
                    prepareStatement("select * from usuarios where id=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setIdusuario( rs.getInt("id") );
                user.setNombreusuario( rs.getString("nombre") );
                user.setEmailusuario( rs.getString("email") );
                user.setRolusuario( rs.getString("rol") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    } 
}
