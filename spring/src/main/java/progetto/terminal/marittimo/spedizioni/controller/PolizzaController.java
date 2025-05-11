package progetto.terminal.marittimo.spedizioni.controller;

import progetto.terminal.marittimo.spedizioni.dao.PolizzaDao;
import progetto.terminal.marittimo.spedizioni.model.Polizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polizze")
public class PolizzaController {

    @Autowired
    private PolizzaDao polizzaDao;

    // http://localhost:8080/polizze/getPolizzaByCliente?clienteId=1
    @GetMapping("/getPolizzaByCliente")
    @ResponseBody
    public List<Polizza> getPolizzeByClienteId(@RequestParam int clienteId) {
        return polizzaDao.getPolizzeByClienteId(clienteId);
    }

    /*@PostMapping
    public String inserisciPolizza(@RequestParam int viaggioId, @RequestParam String portoCarico,
                                   @RequestParam String portoDestinazione, @RequestParam String tipologiaMerce,
                                   @RequestParam double peso, @RequestParam String fornitore) {
        return polizzaDao.inserisciPolizza(viaggioId, portoCarico, portoDestinazione, tipologiaMerce, peso, fornitore);
    }*/
}
