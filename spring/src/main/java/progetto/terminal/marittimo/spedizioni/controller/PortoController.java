package progetto.terminal.marittimo.spedizioni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import progetto.terminal.marittimo.spedizioni.dao.PortoDao;
import progetto.terminal.marittimo.spedizioni.model.Porto;

@RestController
@RequestMapping(path= "/porti")
public class PortoController {

    @Autowired
    private PortoDao portoDao;

    // http://localhost:8080/porti/getPorti
    @GetMapping("/getPorti")
    @ResponseBody
    public List<Porto> getPorti() {
        return portoDao.getPorti();
    }


    // http://localhost:8080/porti/addPorto?nome_porto=nome&nazione=nazione&linea=linea
    // torna esito: ok se lo inserisce correttamente

    @GetMapping("/addPorto")
    @ResponseBody
    public String addPorto(@RequestParam String nome_porto, @RequestParam String nazione, @RequestParam String linea) {
        return portoDao.addPorto(nome_porto, nazione, linea);
    }

    // http://localhost:8080/porti/eliminaPorto?nome_porto=nome
    @GetMapping("/eliminaPorto")
    @ResponseBody
    public String eliminaPorto(@RequestParam String nome_porto) {
        return portoDao.eliminaPorto(nome_porto);
    }
}