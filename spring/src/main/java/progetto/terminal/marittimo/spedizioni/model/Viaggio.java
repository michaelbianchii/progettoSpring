package progetto.terminal.marittimo.spedizioni.model;

import java.util.Date;

public class Viaggio {
    private int id;
    private String nome_nave;
    private String porto_partenza;
    private Date data_partenza;
    private String porto_arrivo;
    private Date data_arrivo;

    public Viaggio(int id, String nome_nave, String porto_partenza, Date data_partenza, String porto_arrivo, Date data_arrivo) {
        this.id = id;
        this.nome_nave = nome_nave;
        this.porto_partenza = porto_partenza;
        this.data_partenza = data_partenza;
        this.porto_arrivo = porto_arrivo;
        this.data_arrivo = data_arrivo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome_nave() {
        return nome_nave;
    }
    public void setNome_nave(String nome_nave) {
        this.nome_nave = nome_nave;
    }
    public String getPorto_partenza() {
        return porto_partenza;
    }
    public void setPorto_partenza(String porto_partenza) {
        this.porto_partenza = porto_partenza;
    }
    public Date getData_partenza() {
        return data_partenza;
    }
    public void setData_partenza(Date data_partenza) {
        this.data_partenza = data_partenza;
    }
    public String getPorto_arrivo() {
        return porto_arrivo;
    }
    public void setPorto_arrivo(String porto_arrivo) {
        this.porto_arrivo = porto_arrivo;
    }
    public Date getData_arrivo() {
        return data_arrivo;
    }

    public void setData_arrivo(Date data_arrivo) {
        this.data_arrivo = data_arrivo;
    }

}