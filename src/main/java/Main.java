import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // recojo la instancia unica
        Model miDB = Model.getInstance();
        // utilizo un método de la instancia
        Connection miConn = miDB.getConn();
    }
}
