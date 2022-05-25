import java.util.List;

/**
 * Interface para definir los métodos en el Model
 */
public interface IUsuariosDAO {
        // declaración de métodos para acceder a la base de datos
        // y pasarlos a los objetos de la clase Usuario
        public List<Usuario> obtenerUsuarios();
        public Usuario obtenerUsuario(int id);
        public void actualizarUsuario(Usuario usuario);
        public void eliminarUsuario(Usuario usuario);
}