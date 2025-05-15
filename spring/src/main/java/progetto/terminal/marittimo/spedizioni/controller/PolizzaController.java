package progetto.terminal.marittimo.spedizioni.controller;

import progetto.terminal.marittimo.spedizioni.dao.PolizzaDao;
import progetto.terminal.marittimo.spedizioni.model.Polizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // http://localhost:8080/polizze/getPolizzaByFornitore?id=2
    @GetMapping("/getPolizzaByFornitore")
    @ResponseBody
    public List<Polizza> getPolizzaByFornitore(@RequestParam int id) {
        return polizzaDao.getPolizzaByFornitore(id);
    }

     // http://localhost:8080/polizze/getAllPolizze
    @GetMapping("/getAllPolizze")
    @ResponseBody
    public List<Polizza> getAllPolizze() {
        return polizzaDao.getAllPolizze();
    }

   
    // Endpoint per inserire una nuova polizza tramite POST con JSON nel body
    @PostMapping("/inserisciPolizza")
    public ResponseEntity<String> inserisciPolizza(@RequestBody Polizza polizza) {
        boolean success = polizzaDao.inserisciPolizza(polizza);
        if (success) {
            return ResponseEntity.ok("Inserimento riuscito");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore inserimento");
        }
    }
}
