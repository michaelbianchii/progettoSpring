package progetto.terminal.marittimo.spedizioni.dao;

import progetto.terminal.marittimo.spedizioni.model.Viaggio;
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
public class ViaggioDao {

    private static final String URL = "jdbc:mysql://localhost:3306/tuo_database";
    private static final String USER = "tuo_username";
    private static final String PASSWORD = "tuo_password";

    public List<Viaggio> getViaggiByNaveId(int naveId) {
        List<Viaggio> viaggi = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM viaggio WHERE nave_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, naveId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Viaggio viaggio = new Viaggio(
                    rs.getInt("id"),
                    rs.getInt("nave_id"),
                    rs.getString("porto_partenza"),
                    rs.getDate("data_partenza"),
                    rs.getString("porto_arrivo"),
                    rs.getDate("data_arrivo")
                );
                viaggi.add(viaggio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viaggi;
    }

    public String inserisciViaggio(int naveId, String portoPartenza, Date dataPartenza, String portoArrivo, Date dataArrivo) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO viaggio (nave_id, porto_partenza, data_partenza, porto_arrivo, data_arrivo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, naveId);
            stmt.setString(2, portoPartenza);
            stmt.setDate(3, new java.sql.Date(dataPartenza.getTime()));
            stmt.setString(4, portoArrivo);
            stmt.setDate(5, new java.sql.Date(dataArrivo.getTime()));
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "errore";
        }
    }
}