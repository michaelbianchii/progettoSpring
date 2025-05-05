package progetto.terminal.marittimo.spedizioni.controller;

import progetto.terminal.marittimo.spedizioni.dao.ViaggioDao;
import progetto.terminal.marittimo.spedizioni.model.Viaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioDao viaggioDao;

    @GetMapping("/nave/{naveId}")
    public List<Viaggio> getViaggiByNaveId(@PathVariable int naveId) {
        return viaggioDao.getViaggiByNaveId(naveId);
    }

    @PostMapping
    public String inserisciViaggio(@RequestParam int naveId, @RequestParam String portoPartenza,
                                   @RequestParam Date dataPartenza, @RequestParam String portoArrivo,
                                   @RequestParam Date dataArrivo) {
        return viaggioDao.inserisciViaggio(naveId, portoPartenza, dataPartenza, portoArrivo, dataArrivo);
    }
}