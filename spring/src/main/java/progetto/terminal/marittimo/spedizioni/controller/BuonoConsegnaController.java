package progetto.terminal.marittimo.spedizioni.controller;

import org.springframework.web.bind.annotation.*;

import progetto.terminal.marittimo.spedizioni.dao.BuonoConsegnaDao;
import progetto.terminal.marittimo.spedizioni.model.BuonoConsegna;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@RequestMapping("/api/buoni")
public class BuonoConsegnaController {

    @Autowired
    private BuonoConsegnaDao buonoConsegnaDao;

    @GetMapping("/polizza/{polizzaId}")
    public List<BuonoConsegna> getBuoniByPolizzaId(@PathVariable int polizzaId) {
        return buonoConsegnaDao.getBuoniByPolizzaId(polizzaId);
    }

    @PostMapping
    public String inserisciBuonoConsegna(@RequestParam int polizzaId, @RequestParam double peso,
                                         @RequestParam String cliente) {
        return buonoConsegnaDao.inserisciBuonoConsegna(polizzaId, peso, cliente);
    }
}