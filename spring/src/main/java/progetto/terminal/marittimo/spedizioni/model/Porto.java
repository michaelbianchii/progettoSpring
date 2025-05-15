package progetto.terminal.marittimo.spedizioni.model;

public class Porto {
    private String nome_porto;
    private String nazione;
    private String linea;

    public Porto(String nome_porto, String nazione, String linea) {
        this.nome_porto = nome_porto;
        this.nazione = nazione;
        this.linea = linea;
    }

    public String getNome_porto() {
        return nome_porto;
    }

    public void setNome_porto(String nome_porto) {
        this.nome_porto = nome_porto;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }
}
