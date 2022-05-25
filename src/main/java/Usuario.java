/**
 * Clase para manejar los datos de la tabla Usuarios
 */
public class Usuario {
    private int id;
    private String name;
    private int score;

    public Usuario() {
        super();
    }
    public Usuario(int id, String name, int score){
        super();
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
