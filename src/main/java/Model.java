import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Model {

    private static Model instance;
    private static Connection conn = null;

    private Model() {

        String url = "jdbc:mysql://localhost:3306/testeo";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String password = "castelao";

        // hago la conexion en el constructor
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Model getInstance(){
        // solo hago el new si es null
        if (instance == null){
            instance = new Model();
        }
        // devuelvo siempre la unica instancia
        return instance;
    }

    // un metodo del Singleton
    public Connection getConn() {
        return conn;
    }
}
