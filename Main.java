import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Main {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    String usuario = "tu_usuario";
    String contraseña = "tu_contraseña";
    Connection conexion = null;

    try {
        conexion = DriverManager.getConnection(url, usuario, contraseña);

        // Inserción (INSERT)
        String insercionSQL = "INSERT INTO mi_tabla (nombre, edad) VALUES (?, ?)";
        PreparedStatement sentenciaInsercion = conexion.prepareStatement(insercionSQL);
        sentenciaInsercion.setString(1, "EjemploNombre");
        sentenciaInsercion.setInt(2, 25);
        sentenciaInsercion.executeUpdate();
        sentenciaInsercion.close();

        // Actualización (UPDATE)
        String actualizacionSQL = "UPDATE mi_tabla SET edad = ? WHERE nombre = ?";
        PreparedStatement sentenciaActualizacion = conexion.prepareStatement(actualizacionSQL);
        sentenciaActualizacion.setInt(1, 30);
        sentenciaActualizacion.setString(2, "EjemploNombre");
        sentenciaActualizacion.executeUpdate();
        sentenciaActualizacion.close();

        // Eliminación (DELETE)
        String eliminacionSQL = "DELETE FROM mi_tabla WHERE nombre = ?";
        PreparedStatement sentenciaEliminacion = conexion.prepareStatement(eliminacionSQL);
        sentenciaEliminacion.setString(1, "EjemploNombre");
        sentenciaEliminacion.executeUpdate();
        sentenciaEliminacion.close();

        System.out.println("Operaciones de INSERT, UPDATE y DELETE completadas con éxito.");

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  }
}