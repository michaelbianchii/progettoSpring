package progetto.terminal.marittimo.spedizioni.controller;

import progetto.terminal.marittimo.spedizioni.dao.NaveDao;
import progetto.terminal.marittimo.spedizioni.model.Nave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/navi")
public class NaveController {

    @Autowired
    private NaveDao naveDao;

    // http://localhost:8080/navi/getNavi
    @GetMapping("/getNavi")
    @ResponseBody
    public List<Nave> getAllNavi() {
        return naveDao.getAllNavi();
    }


    // http://localhost:8080/api/navi/addNave?nome_nave=nomeNave
    @GetMapping("/addNave")
    @ResponseBody
    public String addNave(@RequestParam String nome_nave) {
        return naveDao.addNave(nome_nave);
    }

     @DeleteMapping("/removeNave")
    public ResponseEntity<String> removeNave(@RequestParam String nome_nave) {
        boolean deleted = naveDao.deleteNave(nome_nave);
        if (deleted) {
            return ResponseEntity.ok("Nave eliminata");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Impossibile eliminare la nave");
        }
    }
}
