package progetto.terminal.marittimo.spedizioni.dao;

import progetto.terminal.marittimo.spedizioni.database.DbConnection;
import progetto.terminal.marittimo.spedizioni.model.Porto;
import progetto.terminal.marittimo.spedizioni.model.Ritiro;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class RitiroDao {

    public List<Ritiro> getAllRitiri() {
        List<Ritiro> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM ritiri";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ritiro r = new Ritiro(
                    rs.getInt("id"),
                    rs.getInt("id_utente"),
                    rs.getDouble("peso_ritirato"),
                    rs.getString("camion_utilizzato"),
                    rs.getString("conducente"),
                    rs.getDate("data_ritiro")
                );
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Ritiro> getRitiriByAutista(int idAutista) {
        List<Ritiro> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM ritiri WHERE id_utente = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAutista);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ritiro r = new Ritiro(
                    rs.getInt("id"),
                    rs.getInt("id_utente"),
                    rs.getDouble("peso_ritirato"),
                    rs.getString("camion_utilizzato"),
                    rs.getString("conducente"),
                    rs.getDate("data_ritiro")
                );
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String addRitiro(int idUtente, double peso, String camion, String conducente, Date dataRitiro) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "INSERT INTO ritiri (id_utente, peso_ritirato, camion_utilizzato, conducente, data_ritiro) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUtente);
            stmt.setDouble(2, peso);
            stmt.setString(3, camion);
            stmt.setString(4, conducente);
            stmt.setDate(5, new java.sql.Date(dataRitiro.getTime()));

            int rowsAffected = stmt.executeUpdate();
            return (rowsAffected > 0) ? "{\"esito\":\"ok\"}" : "{\"esito\":\"errore inserimento\"}";
        } catch (SQLException e) {
            e.printStackTrace();
            return "{\"esito\":\"errore connessione\"}";
        }
    }

    public String eliminaRitiro(int id) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "DELETE FROM ritiri WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            return (rowsAffected > 0) ? "{\"esito\":\"ok\"}" : "{\"esito\":\"errore eliminazione\"}";
        } catch (SQLException e) {
            e.printStackTrace();
            return "{\"esito\":\"errore connessione\"}";
        }
    }
}
