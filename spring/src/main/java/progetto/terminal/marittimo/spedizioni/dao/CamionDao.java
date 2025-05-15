package progetto.terminal.marittimo.spedizioni.dao;

import progetto.terminal.marittimo.spedizioni.database.DbConnection;
import progetto.terminal.marittimo.spedizioni.model.Camion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CamionDao {

    public List<Camion> getAllCamion() {
        List<Camion> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM camion";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Camion c = new Camion(
                    rs.getString("targa"),
                    rs.getString("modello"),
                    rs.getString("marca"),
                    rs.getInt("id_autista")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Camion getCamionByAutista(int id_autista) {
        Camion camion = null;
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM camion WHERE id_autista = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_autista);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                camion = new Camion(
                    rs.getString("targa"),
                    rs.getString("modello"),
                    rs.getString("marca"),
                    rs.getInt("id_autista")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return camion;
    }

    public String addCamion(Camion c) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "INSERT INTO camion (targa, modello, marca, id_autista) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getTarga());
            stmt.setString(2, c.getModello());
            stmt.setString(3, c.getMarca());
            stmt.setInt(4, c.getId_autista());

            int rows = stmt.executeUpdate();
            return rows > 0 ? "{\"esito\":\"ok\"}" : "{\"esito\":\"errore inserimento\"}";
        } catch (SQLException e) {
            e.printStackTrace();
            return "{\"esito\":\"errore connessione\"}";
        }
    }

    public String deleteCamionByTarga(String targa) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "DELETE FROM camion WHERE targa = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, targa);

            int rows = stmt.executeUpdate();
            return rows > 0 ? "{\"esito\":\"ok\"}" : "{\"esito\":\"errore eliminazione\"}";
        } catch (SQLException e) {
            e.printStackTrace();
            return "{\"esito\":\"errore connessione\"}";
        }
    }

    public List<String> getTargheByAutistaId(int id_autista) {
    List<String> targhe = new ArrayList<>();
    try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT targa FROM camion WHERE id_autista = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_autista);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                targhe.add(rs.getString("targa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return targhe;
    }

}

