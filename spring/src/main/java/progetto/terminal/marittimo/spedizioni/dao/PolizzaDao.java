package progetto.terminal.marittimo.spedizioni.dao;

import progetto.terminal.marittimo.spedizioni.model.Polizza;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PolizzaDao {

    private static final String URL = "jdbc:mysql://localhost:3306/spedizioni";
    private static final String USER = "localhost";
    private static final String PASSWORD = "";

    public List<Polizza> getPolizzeByViaggioId(int viaggioId) {
        List<Polizza> polizze = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM polizza WHERE viaggio_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, viaggioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Polizza polizza = new Polizza(
                    rs.getInt("id"),
                    rs.getString("porto_carico"),
                    rs.getString("porto_destinazione"),
                    rs.getString("tipologia_merce"),
                    rs.getDouble("peso"),
                    rs.getString("fornitore")
                );
                polizze.add(polizza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return polizze;
    }

    public String inserisciPolizza(int viaggioId, String portoCarico, String portoDestinazione, String tipologiaMerce, double peso, String fornitore) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO polizza (viaggio_id, porto_carico, porto_destinazione, tipologia_merce, peso, fornitore) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, viaggioId);
            stmt.setString(2, portoCarico);
            stmt.setString(3, portoDestinazione);
            stmt.setString(4, tipologiaMerce);
            stmt.setDouble(5, peso);
            stmt.setString(6, fornitore);
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "errore";
        }
    }
}