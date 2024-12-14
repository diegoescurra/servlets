package com.edutecno.dao;

import com.edutecno.modelo.Horoscopo;
import com.edutecno.procesaconexion.generaConexion; // Importa la clase de conexión
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoroscopoDAO {

    HoroscopoDAOImp hdaoimp = new HoroscopoDAOImp();

    List<Horoscopo> listaHoroscopos = hdaoimp.listarTodos();


    public List<Horoscopo> listarHoroscopo() {

        return listaHoroscopos;
    }

}
