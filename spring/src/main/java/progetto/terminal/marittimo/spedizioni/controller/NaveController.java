package progetto.terminal.marittimo.spedizioni.controller;

import progetto.terminal.marittimo.spedizioni.dao.NaveDao;
import progetto.terminal.marittimo.spedizioni.model.Nave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/api/navi")
public class NaveController {

    @Autowired
    private NaveDao naveDao;

    // http://localhost:8080/api/navi/getAll
    @GetMapping("/getAll")
    @ResponseBody
    public List<Nave> getAllNavi() {
        return naveDao.getAllNavi();
    }


    // http://localhost:8080/api/navi/addNave?nome=nomeNave
    @PostMapping("/addNave")
    @ResponseBody
    public String inserisciNave(@RequestParam String nome) {
        return naveDao.inserisciNave(nome);
    }
}
