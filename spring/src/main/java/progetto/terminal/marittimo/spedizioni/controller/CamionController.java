package progetto.terminal.marittimo.spedizioni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import progetto.terminal.marittimo.spedizioni.dao.CamionDao;
import progetto.terminal.marittimo.spedizioni.model.Camion;

@RestController
@RequestMapping("/camion")
public class CamionController {

    @Autowired
    private CamionDao camionDao;

    // GET http://localhost:8080/camion/all
    @GetMapping("/all")
    public List<Camion> getAllCamion() {
        return camionDao.getAllCamion();
    }

    // GET http://localhost:8080/camion/byAutista?id=10
    @GetMapping("/byAutista")
    public Camion getCamionByAutista(@RequestParam int id) {
        return camionDao.getCamionByAutista(id);
    }

    // POST http://localhost:8080/camion/add
    @PostMapping("/add")
    public String addCamion(@RequestBody Camion c) {
        return camionDao.addCamion(c);
    }

    // DELETE http://localhost:8080/camion/delete?targa=AB123CD
    @DeleteMapping("/delete")
    public String deleteCamion(@RequestParam String targa) {
        return camionDao.deleteCamionByTarga(targa);
    }

    // http://localhost:8080/camion/getTargaByAutistaId?id=10
   @GetMapping("/getTargaByAutistaId")
    public ResponseEntity<?> getTargaByAutistaId(@RequestParam int id) {
        try {
            List<String> targhe = camionDao.getTargheByAutistaId(id);
            
            if (targhe.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nessun camion assegnato all'autista con ID: " + id);
            }
            
            // Restituisce la prima targa disponibile
            return ResponseEntity.ok(targhe.get(0));
            
            // OPPURE restituisce tutte le targhe se l'autista può avere più camion
            // return ResponseEntity.ok(targhe);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Errore durante il recupero della targa: " + e.getMessage());
        }
    }

}

