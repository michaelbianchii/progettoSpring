package progetto.terminal.marittimo.spedizioni.model;

public class BuonoConsegna {
    private int id;
    private int polizzaId;
    private double peso;
    private String cliente;

    
    public BuonoConsegna(int id, int polizzaId, double peso, String cliente) {
        this.id = id;
        this.polizzaId = polizzaId;
        this.peso = peso;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPolizzaId() {
        return polizzaId;
    }

    public void setPolizzaId(int polizzaId) {
        this.polizzaId = polizzaId;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}