package progetto.terminal.marittimo.spedizioni.controller;

import progetto.terminal.marittimo.spedizioni.dao.NaveDao;
import progetto.terminal.marittimo.spedizioni.model.Nave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/navi")
public class NaveController {

    @Autowired
    private NaveDao naveDao;

    @GetMapping
    public List<Nave> getAllNavi() {
        return naveDao.getAllNavi();
    }

    @PostMapping
    public String inserisciNave(@RequestParam String nome) {
        return naveDao.inserisciNave(nome);
    }
}
