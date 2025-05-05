package progetto.terminal.marittimo.spedizioni.dao;

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
public class NaveDao {

    private static final String URL = "jdbc:mysql://localhost:3306/spedizioni";
    private static final String USER = "localhost";
    private static final String PASSWORD = "";

    public List<Nave> getAllNavi() {
        List<Nave> navi = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM nave";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Nave nave = new Nave(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
                navi.add(nave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return navi;
    }

    public String inserisciNave(String nome) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO nave (nome) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "errore";
        }
    }
}