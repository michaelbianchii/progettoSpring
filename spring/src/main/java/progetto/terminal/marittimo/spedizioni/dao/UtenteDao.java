package progetto.terminal.marittimo.spedizioni.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import progetto.terminal.marittimo.spedizioni.database.DbConnection;

@Component
public class UtenteDao {
    public String doLogin(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM utente WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                String ruolo = rs.getString("ruolo");

                String json = String.format(
                    "{\"esito\":\"ok\", \"id\":%d, \"username\":\"%s\", \"password\":\"%s\", \"ruolo\":\"%s\"}",
                    id, username, password, ruolo
                );

                return json;
            } else {
                return "{\"esito\":\"errore credenziali errate\"}";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "{\"esito\":\"errore nella connessione\"}";
        }
    }

    public String doRegistrazioneConRuolo(String username, String password, String ruolo) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "INSERT INTO utente (username, password, ruolo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password); // da hashare
            stmt.setString(3, ruolo);    // es: "CLIENTE", "AUTOTRASPORTATORE", "ADMIN"
            
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

    public String doRegistrazione(String username, String password) {
        //enum default cliente
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "INSERT INTO utente (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password); 

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return "{\"esito\":\"ok\"}";
            } else {
                return "{\"esito\":\"errore_inserimento\"}";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "{\"esito\":\"errore_connessione\"}";
        }
    }


}
