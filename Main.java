import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Main {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/PrimerDB";
    String usuario = "Alex";
    String contraseña = "123321.0";
    Connection conexion = null;

    try {
        conexion = DriverManager.getConnection(url, usuario, contraseña);

        // Insert
        String insercionSQL = "INSERT INTO PrimerDB (nombre, edad) VALUES ('Armando', 23)";
        PreparedStatement sentenciaInsercion = conexion.prepareStatement(insercionSQL);
        sentenciaInsercion.setString(1, "Pedro");
        sentenciaInsercion.setInt(2, 25);
        sentenciaInsercion.executeUpdate();
        sentenciaInsercion.close();

        // Update
        String actualizacionSQL = "UPDATE PrimerDB SET edad = 30 WHERE nombre = 'Pedro'";
        PreparedStatement sentenciaActualizacion = conexion.prepareStatement(actualizacionSQL);
        sentenciaActualizacion.setInt(1, 35);
        sentenciaActualizacion.setString(2, "Juan");
        sentenciaActualizacion.executeUpdate();
        sentenciaActualizacion.close();

        // Delete
        String eliminacionSQL = "DELETE FROM PrimerDB WHERE nombre = 'Pedro'";
        PreparedStatement sentenciaEliminacion = conexion.prepareStatement(eliminacionSQL);
        sentenciaEliminacion.setString(1, "Juan");
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