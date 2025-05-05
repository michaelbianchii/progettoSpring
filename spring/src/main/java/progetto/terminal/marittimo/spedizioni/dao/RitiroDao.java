package progetto.terminal.marittimo.spedizioni.dao;

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

    private static final String URL = "jdbc:mysql://localhost:3306/spedizioni";
    private static final String USER = "localhost";
    private static final String PASSWORD = "";

    public List<Ritiro> getAllRitiri() {
        List<Ritiro> ritiri = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM ritiro";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ritiro ritiro = new Ritiro(
                    rs.getInt("id"),
                    rs.getString("cliente"),
                    rs.getDouble("peso"),
                    rs.getString("targa_camion"),
                    rs.getString("nome_autista"),
                    rs.getDate("data_ritiro")
                );
                ritiri.add(ritiro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ritiri;
    }

    public String inserisciRitiro(String cliente, double peso, String targaCamion, String nomeAutista, Date dataRitiro) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO ritiro (cliente, peso, targa_camion, nome_autista, data_ritiro) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente);
            stmt.setDouble(2, peso);
            stmt.setString(3, targaCamion);
            stmt.setString(4, nomeAutista);
            stmt.setDate(5, new java.sql.Date(dataRitiro.getTime()));
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "errore";
        }
    }
}