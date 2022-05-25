import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // recojo la instancia unica
        Model miDB = Model.getInstance();
        // utilizo un método de la instancia
        String miNombre = miDB.getUserById(1);
        Integer miScore = miDB.getScoreByUser(miNombre);
        System.out.println(miNombre + " tiene: " + miScore + " puntos");
    }
}
