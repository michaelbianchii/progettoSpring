package progetto.terminal.marittimo.spedizioni.dao;

import progetto.terminal.marittimo.spedizioni.model.BuonoConsegna;
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

    private static final String URL = "jdbc:mysql://localhost:3306/tuo_database";
    private static final String USER = "tuo_username";
    private static final String PASSWORD = "tuo_password";

    public List<BuonoConsegna> getBuoniByPolizzaId(int polizzaId) {
        List<BuonoConsegna> buoni = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM buono_consegna WHERE polizza_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, polizzaId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BuonoConsegna buono = new BuonoConsegna(
                    rs.getInt("id"),
                    rs.getInt("polizza_id"),
                    rs.getDouble("peso"),
                    rs.getString("cliente")
                );
                buoni.add(buono);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buoni;
    }

    public String inserisciBuonoConsegna(int polizzaId, double peso, String cliente) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO buono_consegna (polizza_id, peso, cliente) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, polizzaId);
            stmt.setDouble(2, peso);
            stmt.setString(3, cliente);
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "errore";
        }
    }
}