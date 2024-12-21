package com.edutecno.dao;
import com.edutecno.modelo.Usuario;
import com.edutecno.procesaconexion.generaConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImp implements UsuarioDAO {
    private Connection conexion;

    public UsuarioDAOImp() {
        try {

            this.conexion = generaConexion.getConnection();
        } catch (SQLException e) {
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (id, nombre, username, email, fecha_nacimiento, password, animal) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexion;
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, usuario.getId());
            pstm.setString(2, usuario.getNombre());
            pstm.setString(3, usuario.getUsername());
            pstm.setString(4, usuario.getEmail());
            pstm.setDate(5, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            pstm.setString(6, usuario.getPassword());
            pstm.setString(7, usuario.getAnimal());

            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, username = ?, email = ?, fecha_nacimiento = ?, password = ?, animal = ? WHERE id = ?";
        try (
             PreparedStatement pstm = conexion.prepareStatement(sql)) {

            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getUsername());
            pstm.setString(3, usuario.getEmail());
            pstm.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            pstm.setString(5, usuario.getPassword());
            pstm.setString(6, usuario.getAnimal());
            pstm.setInt(7, usuario.getId());

            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (
             PreparedStatement pstm = conexion.prepareStatement(sql)) {

            pstm.setInt(1, id);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (
             PreparedStatement pstm = conexion.prepareStatement(sql)) {

            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("password"),
                        rs.getString("animal")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Usuario obtenerUsuarioPorUsername(String username) {
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        try (
                PreparedStatement pstm = conexion.prepareStatement(sql)) {

            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("password"),
                        rs.getString("animal")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (
             PreparedStatement pstm = conexion.prepareStatement(sql)) {

            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("password"),
                        rs.getString("animal")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (
             PreparedStatement pstm = conexion.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("password"),
                        rs.getString("animal")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
}
