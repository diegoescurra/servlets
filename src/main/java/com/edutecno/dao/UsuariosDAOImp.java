package com.edutecno.dao;

import com.edutecno.modelo.Horoscopo;
import com.edutecno.modelo.Usuario;
import com.edutecno.procesaconexion.generaConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAOImp {


    private Connection conexion;

    public UsuariosDAOImp() {
        try {

            this.conexion = generaConexion.getConnection();
        } catch (
                SQLException e) {
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
    }


    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios;";
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setAnimal(rs.getString("animal"));
                lista.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;

    }

    public void cerrarConexion() {
        generaConexion.closeConnection(conexion);
    }
}
