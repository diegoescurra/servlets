package com.edutecno.procesaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class generaConexion {

    // Configuración de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/horoscopo";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Constructor privado para evitar instancias
    private generaConexion() {
    }

    // Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se pudo cargar el controlador JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
            throw e;
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: No se pudo cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}