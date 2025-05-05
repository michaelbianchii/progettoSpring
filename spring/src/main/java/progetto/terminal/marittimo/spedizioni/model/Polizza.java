package progetto.terminal.marittimo.spedizioni.model;

public class Polizza {
    private int id;
    private String portoCarico;
    private String portoDestinazione;
    private String tipologiaMerce;
    private double peso;
    private String fornitore;

    
    public Polizza(int id, String portoCarico, String portoDestinazione, String tipologiaMerce, double peso, String fornitore) {
        this.id = id;
        this.portoCarico = portoCarico;
        this.portoDestinazione = portoDestinazione;
        this.tipologiaMerce = tipologiaMerce;
        this.peso = peso;
        this.fornitore = fornitore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPortoCarico() {
        return portoCarico;
    }

    public void setPortoCarico(String portoCarico) {
        this.portoCarico = portoCarico;
    }

    public String getPortoDestinazione() {
        return portoDestinazione;
    }

    public void setPortoDestinazione(String portoDestinazione) {
        this.portoDestinazione = portoDestinazione;
    }

    public String getTipologiaMerce() {
        return tipologiaMerce;
    }

    public void setTipologiaMerce(String tipologiaMerce) {
        this.tipologiaMerce = tipologiaMerce;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getFornitore() {
        return fornitore;
    }

    public void setFornitore(String fornitore) {
        this.fornitore = fornitore;
    }
}