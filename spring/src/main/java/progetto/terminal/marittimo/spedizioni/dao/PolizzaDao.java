package progetto.terminal.marittimo.spedizioni.dao;

import progetto.terminal.marittimo.spedizioni.database.DbConnection;
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


    // metodo per prendere tutte le polizze di un cliente
   public List<Polizza> getPolizzeByClienteId(int clienteId) {
    List<Polizza> polizze = new ArrayList<>();

    String sql = "SELECT * FROM polizze_di_carico WHERE id_cliente = ?";

    try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, clienteId);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Polizza polizza = new Polizza(
                    rs.getInt("id"),
                    rs.getString("porto_carico"),
                    rs.getString("porto_destinazione"),
                    rs.getString("tipologia_merce"),
                    rs.getDouble("peso"),
                    rs.getInt("id_fornitore"),
                    rs.getInt("id_viaggio"),
                    rs.getInt("giorni_franchigia"),
                    rs.getFloat("tariffa_oltre_franchigia"),
                    rs.getInt("id_cliente")
                );
                polizze.add(polizza);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return polizze;
}

public List<Polizza> getPolizzaByFornitore(int idFornitore) {
    List<Polizza> lista = new ArrayList<>();

    try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
        String sql = "SELECT * FROM polizze_di_carico WHERE id_fornitore = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idFornitore);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Polizza p = new Polizza(
                rs.getInt("id"),
                rs.getString("porto_carico"),
                rs.getString("porto_destinazione"),
                rs.getString("tipologia_merce"),
                rs.getDouble("peso"),
                rs.getInt("id_fornitore"),
                rs.getInt("id_viaggio"),
                rs.getInt("giorni_franchigia"),
                rs.getFloat("tariffa_oltre_franchigia"),
                rs.getInt("id_cliente")
            );
            lista.add(p);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

public List<Polizza> getAllPolizze() {
    List<Polizza> lista = new ArrayList<>();
    try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
        String sql = "SELECT * FROM polizze_di_carico";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Polizza p = new Polizza(
                rs.getInt("id"),
                rs.getString("porto_carico"),
                rs.getString("porto_destinazione"),
                rs.getString("tipologia_merce"),
                rs.getDouble("peso"),
                rs.getInt("id_fornitore"),
                rs.getInt("id_viaggio"),
                rs.getInt("giorni_franchigia"),
                rs.getFloat("tariffa_oltre_franchigia"),
                rs.getInt("id_cliente")
            );
            lista.add(p);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}


 public boolean inserisciPolizza(Polizza p) {
        String sql = "INSERT INTO polizze_di_carico (porto_carico, porto_destinazione, tipologia_merce, peso, id_fornitore, id_viaggio, giorni_franchigia, tariffa_oltre_franchigia, id_cliente) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getPorto_carico());
            stmt.setString(2, p.getPorto_destinazione());
            stmt.setString(3, p.getTipologia_merce());
            stmt.setDouble(4, p.getPeso());
            stmt.setInt(5, p.getId_fornitore());
            stmt.setInt(6, p.getId_viaggio());
            stmt.setInt(7, p.getGiorni_franchigia());
            stmt.setFloat(8, p.getTariffa_oltre_franchigia());
            stmt.setInt(9, p.getId_cliente());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}