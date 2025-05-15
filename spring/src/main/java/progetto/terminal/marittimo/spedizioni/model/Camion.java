package progetto.terminal.marittimo.spedizioni.model;

public class Camion {
    private String targa;
    private String modello;
    private String marca;
    private int id_autista;

    public Camion(String targa, String modello, String marca, int id_autista) {
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
        this.id_autista = id_autista;
    }

    // GETTER e SETTER
    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId_autista() {
        return id_autista;
    }

    public void setId_autista(int id_autista) {
        this.id_autista = id_autista;
    }
}
