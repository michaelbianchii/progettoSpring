package progetto.terminal.marittimo.spedizioni.dao;

import progetto.terminal.marittimo.spedizioni.database.DbConnection;
import progetto.terminal.marittimo.spedizioni.model.Viaggio;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ViaggioDao {

public List<Viaggio> getAllViaggi() {
    List<Viaggio> lista = new ArrayList<>();
    try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
        String sql = "SELECT * FROM viaggio";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Viaggio v = new Viaggio(
                rs.getInt("id"),
                rs.getString("nome_nave"),
                rs.getString("porto_partenza"),
                rs.getDate("data_partenza"),   
                rs.getString("porto_arrivo"),
                rs.getDate("data_arrivo")
            );
            lista.add(v);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}

public boolean inserisciViaggio(String nome_nave, String portoPartenza, Date dataPartenza, String portoArrivo, Date dataArrivo) {
    String sql = "INSERT INTO viaggio (nome_nave, porto_partenza, data_partenza, porto_arrivo, data_arrivo) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome_nave);
        stmt.setString(2, portoPartenza);
        stmt.setDate(3, dataPartenza);
        stmt.setString(4, portoArrivo);
        stmt.setDate(5, dataArrivo);

        int rowsInserted = stmt.executeUpdate();
        return rowsInserted > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}





}