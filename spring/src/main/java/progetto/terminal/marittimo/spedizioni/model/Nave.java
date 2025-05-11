package progetto.terminal.marittimo.spedizioni.model;

public class Nave {
    private String nome_nave;

    public Nave(String nome_nave) {
        this.nome_nave = nome_nave;
    }

    public String getNome_nave() {
        return nome_nave;
    }

    public void setNome_nave(String nome_nave) {
        this.nome_nave = nome_nave;
    }
}
