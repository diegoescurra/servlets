package com.edutecno.dao;

import com.edutecno.modelo.Horoscopo;
import com.edutecno.procesaconexion.generaConexion; // Importa la clase de conexión
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoroscopoDAO {

    private Connection conexion;

    public HoroscopoDAO() {
        try {
            this.conexion = generaConexion.getConnection();
        } catch (SQLException e) {
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
    }


    public List<Horoscopo> listarTodos() {
        List<Horoscopo> lista = new ArrayList<>();
        String sql = "SELECT * FROM horoscopo;";
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Horoscopo horoscopo = new Horoscopo();
                horoscopo.setAnimal(rs.getString("animal"));
                horoscopo.setFechaInicio(rs.getDate("fecha_inicio"));
                horoscopo.setFechaFin(rs.getDate("fecha_fin"));
                lista.add(horoscopo);
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
