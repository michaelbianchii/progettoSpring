package progetto.terminal.marittimo.spedizioni.dao;

import progetto.terminal.marittimo.spedizioni.database.DbConnection;
import progetto.terminal.marittimo.spedizioni.model.Nave;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class NaveDao {

    // metodo per ottenere tutte le navi
    public List<Nave> getAllNavi() {
        List<Nave> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM nave";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome_nave");
                Nave nave = new Nave(nome);
                lista.add(nave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // metodo per inserire una nuova nave
    public String inserisciNave(String nome) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "INSERT INTO nave (nome_nave) VALUES (?)";
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