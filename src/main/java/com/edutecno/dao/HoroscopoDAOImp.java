package com.edutecno.dao;
import com.edutecno.modelo.Horoscopo;
import com.edutecno.procesaconexion.generaConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoroscopoDAOImp implements HoroscopoDAO{

    private Connection conexion;

    public HoroscopoDAOImp() {
        try {

            this.conexion = generaConexion.getConnection();
        } catch (
                SQLException e) {
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
    }


    @Override
    public List<Horoscopo> obtenerHoroscopo() {
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
