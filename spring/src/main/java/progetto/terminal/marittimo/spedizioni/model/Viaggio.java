package progetto.terminal.marittimo.spedizioni.model;

import java.util.Date;

public class Viaggio {
    private int id;
    private int naveId;
    private String portoPartenza;
    private Date dataPartenza;
    private String portoArrivo;
    private Date dataArrivo;
    
    public Viaggio(int id, int naveId, String portoPartenza, Date dataPartenza, String portoArrivo, Date dataArrivo) {
        this.id = id;
        this.naveId = naveId;
        this.portoPartenza = portoPartenza;
        this.dataPartenza = dataPartenza;
        this.portoArrivo = portoArrivo;
        this.dataArrivo = dataArrivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNaveId() {
        return naveId;
    }

    public void setNaveId(int naveId) {
        this.naveId = naveId;
    }

    public String getPortoPartenza() {
        return portoPartenza;
    }

    public void setPortoPartenza(String portoPartenza) {
        this.portoPartenza = portoPartenza;
    }

    public Date getDataPartenza() {
        return dataPartenza;
    }

    public void setDataPartenza(Date dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public String getPortoArrivo() {
        return portoArrivo;
    }

    public void setPortoArrivo(String portoArrivo) {
        this.portoArrivo = portoArrivo;
    }

    public Date getDataArrivo() {
        return dataArrivo;
    }

    public void setDataArrivo(Date dataArrivo) {
        this.dataArrivo = dataArrivo;
    }
}