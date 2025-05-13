package progetto.terminal.marittimo.spedizioni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import progetto.terminal.marittimo.spedizioni.dao.UtenteDao;
import progetto.terminal.marittimo.spedizioni.model.Utente;


@RestController
@RequestMapping(path= "/utente")
public class UtenteController {

    @Autowired
    private UtenteDao utenteDao;

    // http://localhost:8080/utente/doLogin?username=admin&password=admin123
    // torna esito: ok se lo trova
    @GetMapping("/doLogin")
    @ResponseBody
    public String doLogin(@RequestParam String username, @RequestParam String password) {
        //manca md5 della password
        return utenteDao.doLogin(username, password);
    }

    // http://localhost:8080/utente/doRegistrazione?username=user&password=user&ruolo=admin
    // torna esito: ok se lo inserisce correttamente
    @GetMapping("/doRegistrazione")
    public String doRegistrazione(@RequestParam String username, @RequestParam String password) {
        return utenteDao.doRegistrazione(username, password);
    }

    // http://localhost:8080/utente/getUtenti
    // torna utenti json 
    @GetMapping("/getUtenti")
    public List<Utente> getUtenti() {
        return utenteDao.getUtenti();
    }

}