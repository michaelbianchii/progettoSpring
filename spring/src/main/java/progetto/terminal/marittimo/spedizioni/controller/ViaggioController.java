package progetto.terminal.marittimo.spedizioni.controller;

import progetto.terminal.marittimo.spedizioni.dao.ViaggioDao;
import progetto.terminal.marittimo.spedizioni.model.Viaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.sql.Date;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioDao viaggioDao;

    // http://localhost:8080/viaggi/getAll
    @GetMapping("/getAll")
    public List<Viaggio> getAllViaggi() {
        return viaggioDao.getAllViaggi();
    }

    @GetMapping("/inserisciViaggio")
    public String inserisciViaggio(@RequestParam String nome_nave, @RequestParam String portoPartenza,
                                @RequestParam Date dataPartenza, @RequestParam String portoArrivo,
                                @RequestParam Date dataArrivo) {
        boolean success = viaggioDao.inserisciViaggio(nome_nave, portoPartenza, dataPartenza, portoArrivo, dataArrivo);
        return success ? "Inserimento riuscito" : "Errore inserimento";
    }

}