package progetto.terminal.marittimo.spedizioni.controller;

import org.springframework.web.bind.annotation.*;

import progetto.terminal.marittimo.spedizioni.dao.BuonoConsegnaDao;
import progetto.terminal.marittimo.spedizioni.model.BuonoConsegna;
import progetto.terminal.marittimo.spedizioni.model.Nave;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@RequestMapping("/buoni")
public class BuonoConsegnaController {

    @Autowired
    private BuonoConsegnaDao buonoConsegnaDao;

    // GET http://localhost:8080/buoni/getBuoniDisponibiliByAutista?id=10
    @GetMapping("/getBuoniDisponibiliByAutista")
    public List<BuonoConsegna> getBuoniDisponibiliByAutista(@RequestParam int id) {
        return buonoConsegnaDao.getBuoniDisponibiliByAutista(id);
    }

    // POST opzionale per inserire un nuovo buono
    @PostMapping("/add")
    public String addBuono(@RequestBody BuonoConsegna b) {
        return buonoConsegnaDao.addBuonoConsegna(b);
    }
}
