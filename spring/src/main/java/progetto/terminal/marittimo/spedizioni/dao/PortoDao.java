package progetto.terminal.marittimo.spedizioni.dao;

import progetto.terminal.marittimo.spedizioni.database.DbConnection;
import progetto.terminal.marittimo.spedizioni.model.Nave;
import progetto.terminal.marittimo.spedizioni.model.Porto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PortoDao {

    // metodo per ottenere tutte le navi
    public List<Porto> getPorti() {
        List<Porto> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM porto";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome_porto");
                String nazione = rs.getString("nazione");
                String linea = rs.getString("linea");
                Porto p = new Porto(nome, nazione, linea);
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // metodo per inserire una nuova nave
    public String addPorto(String nome_porto, String nazione, String linea) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "INSERT INTO porto (nome_porto, nazione, linea) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome_porto);
            stmt.setString(2, nazione);
            stmt.setString(3, linea);

           int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                return "{\"esito\":\"ok\"}";
            } else {
                return "{\"esito\":\"errore inserimento\"}";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "{\"esito\":\"errore connessione\"}";
        }
    }

    public String eliminaPorto(String nome_porto) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "DELETE FROM porto WHERE nome_porto = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome_porto);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                return "{\"esito\":\"ok\"}";
            } else {
                return "{\"esito\":\"errore eliminazione\"}";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "{\"esito\":\"errore connessione\"}";
        }
    }
    
}
