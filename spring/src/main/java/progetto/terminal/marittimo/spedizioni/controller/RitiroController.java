package progetto.terminal.marittimo.spedizioni.controller;

import progetto.terminal.marittimo.spedizioni.dao.RitiroDao;
import progetto.terminal.marittimo.spedizioni.model.Ritiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ritiri")
public class RitiroController {

    @Autowired
    private RitiroDao ritiroDao;

    @GetMapping
    public List<Ritiro> getAllRitiri() {
        return ritiroDao.getAllRitiri();
    }

    @PostMapping
    public String inserisciRitiro(@RequestParam String cliente, @RequestParam double peso,
                                  @RequestParam String targaCamion, @RequestParam String nomeAutista,
                                  @RequestParam Date dataRitiro) {
        return ritiroDao.inserisciRitiro(cliente, peso, targaCamion, nomeAutista, dataRitiro);
    }
}
