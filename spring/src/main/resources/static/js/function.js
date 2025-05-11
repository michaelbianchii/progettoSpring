async function loginCliente(username, password) {
    // funzione per il login del cliente
    // fa md5 della password (manca)

    // chiama il servizio di login del cliente
    // se il login va a buon fine, salva il cliente in sessionStorage
    
    // http://localhost:8080/utente/doLogin?username=admin&password=hashed_admin123
    let url = "http://localhost:8080/utente/doLogin?username="+username+"&password="+password;
    try {
        let response = await fetch(url);
        let data = await response.json();
        
        return data;
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function getRuolo(username, password) {
    
    // http://localhost:8080/utente/getRuolo?username=admin&password=hashed_admin123
    let url = "http://localhost:8080/utente/getRuolo?username="+username+"&password="+password;
   try {
        let response = await fetch(url);
        let data = await response.json();
        
        return data;
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function getId(username, password) {
    // http://localhost:8080/utente/getId?username=admin&password=hashed_admin123
    let url = "http://localhost:8080/utente/getId?username="+username+"&password="+password;
   try {
        let response = await fetch(url);
        let data = await response.json();
        
        return data;
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function registraUtente(username, password) {
    // funzione per la registrazione dell'utente
    // fa md5 della password (manca)
    // chiama il servizio di registrazione dell'utente
    // se la registrazione va a buon fine, salva l'utente in sessionStorage

    let url = "http://localhost:8080/utente/doRegistrazione?username="+username+"&password="+password;
   try {
        let response = await fetch(url);
        let data = await response.json();
        
        return data;
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


//funzione per ottenere l'utente autenticato dal sessionStorage
function getCurrentUser() {
    let user = sessionStorage.getItem("utente");
    if (user) {
        return JSON.parse(user);
    } else {
        return null;
    }
}

//funzione per verificare se l'utente è autenticato
function isAuthenticated() {
    return getCurrentUser() !== null;
}

//funzione per fare il logout
function logout() {
    sessionStorage.removeItem("utente");
    window.location.href = "login.html";
}

//funzione per ottenere le polizze di carico per un cliente
function getPolizzeByCliente(clienteId) {
    return fetch(`/polizze/getPolizzaByCliente?clienteId=${clienteId}`)
        .then(response => response.json())
        .then(data => data)
        .catch(error => {
            console.error('Errore nel recupero delle polizze:', error);
        });
}

//funzione per ottenere i buoni di consegna per un cliente
function getBuoniByCliente(clienteId) {
    return fetch(`/buoni/getByCliente?clienteId=${clienteId}`)
        .then(response => response.json())
        .then(data => data)
        .catch(error => {
            console.error('Errore nel recupero dei buoni:', error);
        });
}

//funzione per ottenere lo storico dei ritiri per un cliente
function getStoricoRitiri(clienteId) {
    return fetch(`/ritiri/getByCliente?clienteId=${clienteId}`)
        .then(response => response.json())
        .then(data => data)
        .catch(error => {
            console.error('Errore nel recupero dello storico ritiri:', error);
        });
}
