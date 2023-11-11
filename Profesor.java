import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Profesor {
    private int codigo;
    private String nombre;
    private String profesion;

    public Profesor(int codigo, String nombre, String profesion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesion = profesion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void insertarEnBD() {
        String url = "jdbc:mysql://localhost:3306/PrimerDB";
        String usuario = "Alex";
        String contraseña = "123321.0";
      
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String query = "INSERT INTO profesor (codigo, nombre, profesion) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setInt(1, this.codigo);
                statement.setString(2, this.nombre);
                statement.setString(3, this.profesion);
                statement.executeUpdate();
                System.out.println("¡Inserción correcta en la base de datos!");
            } catch (SQLException e) {
                System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión con la base de datos: " + e.getMessage());
        }
    }
}
