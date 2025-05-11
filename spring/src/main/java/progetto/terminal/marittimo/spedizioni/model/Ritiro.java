package progetto.terminal.marittimo.spedizioni.model;

import java.util.Date;

//da aggiungere in db
public class Ritiro {
    private int id;
    private String cliente;
    private double peso;
    private String targaCamion;
    private String nomeAutista;
    private Date dataRitiro;

    public Ritiro(int id, String cliente, double peso, String targaCamion, String nomeAutista, Date dataRitiro) {
        this.id = id;
        this.cliente = cliente;
        this.peso = peso;
        this.targaCamion = targaCamion;
        this.nomeAutista = nomeAutista;
        this.dataRitiro = dataRitiro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTargaCamion() {
        return targaCamion;
    }

    public void setTargaCamion(String targaCamion) {
        this.targaCamion = targaCamion;
    }

    public String getNomeAutista() {
        return nomeAutista;
    }

    public void setNomeAutista(String nomeAutista) {
        this.nomeAutista = nomeAutista;
    }

    public Date getDataRitiro() {
        return dataRitiro;
    }

    public void setDataRitiro(Date dataRitiro) {
        this.dataRitiro = dataRitiro;
    }
}