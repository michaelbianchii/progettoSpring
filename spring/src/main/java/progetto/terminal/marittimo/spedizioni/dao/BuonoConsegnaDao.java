package progetto.terminal.marittimo.spedizioni.dao;

import progetto.terminal.marittimo.spedizioni.database.DbConnection;
import progetto.terminal.marittimo.spedizioni.model.BuonoConsegna;
import progetto.terminal.marittimo.spedizioni.model.Nave;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BuonoConsegnaDao {

   public List<BuonoConsegna> getBuoniDisponibiliByAutista(int idAutista) {
    List<BuonoConsegna> lista = new ArrayList<>();
    try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
        
        String sql = "SELECT * FROM buono_di_consegna WHERE id_autista = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idAutista);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            BuonoConsegna b = new BuonoConsegna(
                rs.getInt("id"),
                rs.getInt("id_polizza"),
                rs.getInt("id_cliente"),
                rs.getString("nome_nave"),
                rs.getDouble("peso"),
                rs.getInt("id_autista")
            );
            lista.add(b);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}


    // Puoi implementare questo se ti serve in futuro
    public String addBuonoConsegna(BuonoConsegna b) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "INSERT INTO buono_di_consegna (id_polizza, id_cliente, nome_nave, peso, id_autista) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, b.getId_polizza());
            stmt.setInt(2, b.getId_cliente());
            stmt.setString(3, b.getNome_nave());
            stmt.setDouble(4, b.getPeso());
            stmt.setInt(5, b.getId_autista());

            int rows = stmt.executeUpdate();
            return rows > 0 ? "{\"esito\":\"ok\"}" : "{\"esito\":\"errore inserimento\"}";

        } catch (SQLException e) {
            e.printStackTrace();
            return "{\"esito\":\"errore connessione\"}";
        }
    }
}
