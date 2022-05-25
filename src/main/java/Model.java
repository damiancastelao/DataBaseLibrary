import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Model implements IUsuariosDAO {

    private static Model instance;
    private static Connection conn = null;
    private Statement stmt;
    private ResultSet rs;

    private Model() {
        // cadena de conexión
        String url = "jdbc:sqlite:/Users/damiannogueiras/Documents/Damian/ProyIdeaProjects/DataBaseLibrary/soundAdventure.sqlite";

        // hago la conexion en el constructor
        // creo un Statement para reusar
        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Base del Singleton
     * @return instancia de la clase Model
     */
    public static Model getInstance(){
        // solo hago el new si es null
        if (instance == null){
            instance = new Model();
        }
        // devuelvo siempre la unica instancia
        return instance;
    }

    // métodos generales que hacen consultas/inserciones/etc

    /**
     * Busca el nombre segun el id del usuario
     * @param id del usuario
     * @return nombre del usuario
     */
    public String getUserById(int id){
        Usuario _usuario = obtenerUsuario(id);
        return _usuario.getName();
    }


    /**
     * Devuelve el marcador en funcion del usuario
     * @param name del usuario
     * @return el marcador
     */
    public Integer getScoreByUser(String name) {
        // recojo todos los usuarios
        List<Usuario> _todos = obtenerUsuarios();
        // busco segun el nombre
        for (Usuario _usuario : _todos) {
            if (_usuario.getName().equals(name)) {
                return _usuario.getScore();
            }
        }
        // si no lo encuentro devuelvo cero
        return 0;
    }

    // métodos para obtener de la base de datos los usuarios
    // y pasarlos a objetos
    @Override
    public List<Usuario> obtenerUsuarios() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> _todos = new ArrayList<>();
        try {
            // recojo los resultados
            rs = stmt.executeQuery(sql);
            // loop por los usuarios
            while (rs.next()) {
                Usuario aux = new Usuario(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("score")
                );

                _todos.add(aux);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return _todos;
    }

    @Override
    public Usuario obtenerUsuario(int id) {
        String sql = "SELECT * FROM usuarios WHERE id=" + id + " LIMIT 1";
        Usuario _usuario = null;

        try {
            // recojo los resultados
            rs = stmt.executeQuery(sql);
            // loop por los resultados
            // aunque al poner LIMIT 1 nos garantizamos solo un resultado
            while (rs.next()) {
                _usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("score")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // devuelvo lo obtenido
        return _usuario;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        // TODO
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        // TODO
    }
}
