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

    // Endpoint: GET http://localhost:8080/ritiri/getRitiriByAutistaId?autistaId=1
    @GetMapping("/getRitiriByAutistaId")
    public List<Ritiro> getRitiriByAutista(@RequestParam int autistaId) {
        return ritiroDao.getRitiriByAutista(autistaId);
    }

    // (Opzionale) GET http://localhost:8080/ritiri/getAll
    @GetMapping("/getAll")
    public List<Ritiro> getAllRitiri() {
        return ritiroDao.getAllRitiri();
    }

    //POST http://localhost:8080/ritiri/add
    @GetMapping("/add")
    public String addRitiro(@RequestBody Ritiro r) {
        return ritiroDao.addRitiro(
            r.getId_utente(),
            r.getPeso_ritirato(),
            r.getCamion_utilizzato(),
            r.getConducente(),
            r.getData_ritiro()
        );
    }

    //DELETE http://localhost:8080/ritiri/delete?id=5
    @DeleteMapping("/delete")
    public String deleteRitiro(@RequestParam int id) {
        return ritiroDao.eliminaRitiro(id);
    }
}
