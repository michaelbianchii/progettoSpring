package progetto.terminal.marittimo.spedizioni.model;

import java.util.Date;

public class Ritiro {
    private int id;
    private int id_utente;
    private double peso_ritirato;
    private String camion_utilizzato;
    private String conducente;
    private Date data_ritiro;

    public Ritiro(int id, int id_utente, double peso_ritirato, String camion_utilizzato, String conducente, Date data_ritiro) {
        this.id = id;
        this.id_utente = id_utente;
        this.peso_ritirato = peso_ritirato;
        this.camion_utilizzato = camion_utilizzato;
        this.conducente = conducente;
        this.data_ritiro = data_ritiro;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId_utente() {
        return id_utente;
    }
    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }
    public double getPeso_ritirato() {
        return peso_ritirato;
    }
    public void setPeso_ritirato(double peso_ritirato) {
        this.peso_ritirato = peso_ritirato;
    }
    public String getCamion_utilizzato() {
        return camion_utilizzato;
    }
    public void setCamion_utilizzato(String camion_utilizzato) {
        this.camion_utilizzato = camion_utilizzato;
    }
    public String getConducente() {
        return conducente;
    }
    public void setConducente(String conducente) {
        this.conducente = conducente;
    }
    public Date getData_ritiro() {
        return data_ritiro;
    }
    public void setData_ritiro(Date data_ritiro) {
        this.data_ritiro = data_ritiro;
    }


   
}