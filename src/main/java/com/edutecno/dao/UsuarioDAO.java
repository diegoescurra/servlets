package com.edutecno.dao;
import java.util.List;
import com.edutecno.modelo.Usuario;

public interface UsuarioDAO {
    boolean registrarUsuario(Usuario usuario);
    boolean actualizarUsuario(Usuario usuario);
    boolean eliminarUsuario(int id);
    Usuario obtenerUsuarioPorId(int id);
    Usuario obtenerUsuarioPorUsername(String username);
    Usuario obtenerUsuarioPorCredenciales(String username, String password);
    List<Usuario> listarUsuarios();
}
