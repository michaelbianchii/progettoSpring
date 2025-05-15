package progetto.terminal.marittimo.spedizioni.model;

public class Polizza {
    private int id;
    private String porto_carico;
    private String porto_destinazione;
    private String tipologia_merce;
    private double peso;
    private int id_fornitore;
    private int id_viaggio;
    private int giorni_franchigia;
    private float tariffa_oltre_franchigia;
    private int id_cliente;

    public Polizza(int id, String porto_carico, String porto_destinazione, String tipologia_merce, double peso,
                   int id_fornitore, int id_viaggio, int giorni_franchigia, float tariffa_oltre_franchigia, int id_cliente) {
        this.id = id;
        this.porto_carico = porto_carico;
        this.porto_destinazione = porto_destinazione;
        this.tipologia_merce = tipologia_merce;
        this.peso = peso;
        this.id_fornitore = id_fornitore;
        this.id_viaggio = id_viaggio;
        this.giorni_franchigia = giorni_franchigia;
        this.tariffa_oltre_franchigia = tariffa_oltre_franchigia;
        this.id_cliente = id_cliente;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPorto_carico() {
        return porto_carico;
    }
    public void setPorto_carico(String porto_carico) {
        this.porto_carico = porto_carico;
    }
    public String getPorto_destinazione() {
        return porto_destinazione;
    }
    public void setPorto_destinazione(String porto_destinazione) {
        this.porto_destinazione = porto_destinazione;
    }
    public String getTipologia_merce() {
        return tipologia_merce;
    }
    public void setTipologia_merce(String tipologia_merce) {
        this.tipologia_merce = tipologia_merce;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getId_fornitore() {
        return id_fornitore;
    }

    public void setId_fornitore(int id_fornitore) {
        this.id_fornitore = id_fornitore;
    }
    public int getId_viaggio() {
        return id_viaggio;
    }
    public void setId_viaggio(int id_viaggio) {
        this.id_viaggio = id_viaggio;
    }
    public int getGiorni_franchigia() {
        return giorni_franchigia;
    }

    public void setGiorni_franchigia(int giorni_franchigia) {
        this.giorni_franchigia = giorni_franchigia;
    }
    public float getTariffa_oltre_franchigia() {
        return tariffa_oltre_franchigia;
    }
    public void setTariffa_oltre_franchigia(float tariffa_oltre_franchigia) {
        this.tariffa_oltre_franchigia = tariffa_oltre_franchigia;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

}