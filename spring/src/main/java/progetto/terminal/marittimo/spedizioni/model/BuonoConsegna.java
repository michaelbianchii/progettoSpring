package progetto.terminal.marittimo.spedizioni.model;

public class BuonoConsegna {
    private int id;
    private int id_polizza;
    private int id_cliente;
    private String nome_nave;
    private double peso;
    private int id_autista;

    public BuonoConsegna(int id, int id_polizza, int id_cliente, String nome_nave, double peso, int id_autista) {
        this.id = id;
        this.id_polizza = id_polizza;
        this.id_cliente = id_cliente;
        this.nome_nave = nome_nave;
        this.peso = peso;
        this.id_autista = id_autista;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_polizza() {
        return id_polizza;
    }
    public void setId_polizza(int id_polizza) {
        this.id_polizza = id_polizza;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getNome_nave() {
        return nome_nave;
    }
    public void setNome_nave(String nome_nave) {
        this.nome_nave = nome_nave;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getId_autista() {
        return id_autista;
    }
    public void setId_autista(int id_autista) {
        this.id_autista = id_autista;
    }

}