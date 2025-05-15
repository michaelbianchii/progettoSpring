-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 15, 2025 alle 22:30
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spedizioni`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `buono_di_consegna`
--

CREATE TABLE `buono_di_consegna` (
  `id` int(11) NOT NULL,
  `id_polizza` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `nome_nave` varchar(100) NOT NULL,
  `peso` decimal(10,2) NOT NULL,
  `id_autista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `buono_di_consegna`
--

INSERT INTO `buono_di_consegna` (`id`, `id_polizza`, `id_cliente`, `nome_nave`, `peso`, `id_autista`) VALUES
(1, 1, 4, 'MSC Aurora', 1000.00, 10),
(2, 2, 4, 'Blue Ocean', 1500.00, 10),
(3, 3, 6, 'Costa Mare', 2000.00, 11);

-- --------------------------------------------------------

--
-- Struttura della tabella `camion`
--

CREATE TABLE `camion` (
  `targa` varchar(20) NOT NULL,
  `modello` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `id_autista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `camion`
--

INSERT INTO `camion` (`targa`, `modello`, `marca`, `id_autista`) VALUES
('AB123CD', 'XF 105', 'DAF', 10),
('CD789EF', 'Touring', 'Iveco', 10),
('EF456GH', 'Actros', 'Mercedes', 11);

-- --------------------------------------------------------

--
-- Struttura della tabella `nave`
--

CREATE TABLE `nave` (
  `nome_nave` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `nave`
--

INSERT INTO `nave` (`nome_nave`) VALUES
('Blue Ocean'),
('Costa Mare'),
('MSC Aurora');

-- --------------------------------------------------------

--
-- Struttura della tabella `polizze_di_carico`
--

CREATE TABLE `polizze_di_carico` (
  `id` int(11) NOT NULL,
  `porto_carico` varchar(100) NOT NULL,
  `porto_destinazione` varchar(100) NOT NULL,
  `tipologia_merce` varchar(100) NOT NULL,
  `peso` decimal(10,2) NOT NULL,
  `id_fornitore` int(11) NOT NULL,
  `id_viaggio` int(11) NOT NULL,
  `giorni_franchigia` int(11) NOT NULL DEFAULT 3,
  `tariffa_oltre_franchigia` float NOT NULL DEFAULT 50,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `polizze_di_carico`
--

INSERT INTO `polizze_di_carico` (`id`, `porto_carico`, `porto_destinazione`, `tipologia_merce`, `peso`, `id_fornitore`, `id_viaggio`, `giorni_franchigia`, `tariffa_oltre_franchigia`, `id_cliente`) VALUES
(1, 'Genova', 'Palermo', 'Frutta fresca', 2500.50, 2, 1, 3, 50, 4),
(2, 'Napoli', 'Barcellona', 'Elettrodomestici', 3800.00, 2, 2, 2, 75, 4),
(3, 'Barcellona', 'Genova', 'Materiali edili', 4200.00, 2, 3, 4, 60, 6);

-- --------------------------------------------------------

--
-- Struttura della tabella `porto`
--

CREATE TABLE `porto` (
  `nome_porto` varchar(100) NOT NULL,
  `nazione` varchar(32) NOT NULL,
  `linea` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `porto`
--

INSERT INTO `porto` (`nome_porto`, `nazione`, `linea`) VALUES
('Barcellona', 'Spagna', 'Europa'),
('Genova', 'Italia', 'Europa'),
('Napoli', 'Italia', 'Europa'),
('Palermo', 'Italia', 'Europa');

-- --------------------------------------------------------

--
-- Struttura della tabella `ritiri`
--

CREATE TABLE `ritiri` (
  `id` int(11) NOT NULL,
  `id_utente` int(11) NOT NULL,
  `peso_ritirato` decimal(10,2) NOT NULL,
  `camion_utilizzato` varchar(20) NOT NULL,
  `id_conducente` int(11) NOT NULL,
  `data_ritiro` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `ritiri`
--

INSERT INTO `ritiri` (`id`, `id_utente`, `peso_ritirato`, `camion_utilizzato`, `id_conducente`, `data_ritiro`) VALUES
(1, 4, 500.00, 'AB123CD', 10, '2025-05-10 08:30:00'),
(2, 6, 750.00, 'CD789EF', 10, '2025-05-15 09:15:00');

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `ruolo` enum('admin','cliente','fornitore','autista') NOT NULL DEFAULT 'cliente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`id`, `username`, `password`, `ruolo`) VALUES
(1, 'admin', 'admin123', 'admin'),
(2, 'fornitore1', 'fornitore123', 'fornitore'),
(3, 'lucia', 'ciao123', 'cliente'),
(4, 'mario', 'mario123', 'cliente'),
(6, 'paolo', 'paolo123', 'cliente'),
(10, 'autista1', 'autista123', 'autista'),
(11, 'autista2', 'autista456', 'autista');

-- --------------------------------------------------------

--
-- Struttura della tabella `viaggio`
--

CREATE TABLE `viaggio` (
  `id` int(11) NOT NULL,
  `nome_nave` varchar(100) NOT NULL,
  `porto_partenza` varchar(100) NOT NULL,
  `data_partenza` date NOT NULL,
  `porto_arrivo` varchar(100) NOT NULL,
  `data_arrivo` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `viaggio`
--

INSERT INTO `viaggio` (`id`, `nome_nave`, `porto_partenza`, `data_partenza`, `porto_arrivo`, `data_arrivo`) VALUES
(1, 'MSC Aurora', 'Genova', '2025-05-10', 'Palermo', '2025-05-12'),
(2, 'Blue Ocean', 'Napoli', '2025-05-08', 'Barcellona', '2025-05-11'),
(3, 'Costa Mare', 'Barcellona', '2025-05-15', 'Genova', '2025-05-17');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `buono_di_consegna`
--
ALTER TABLE `buono_di_consegna`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_polizza` (`id_polizza`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `nome_nave` (`nome_nave`),
  ADD KEY `id_autista` (`id_autista`);

--
-- Indici per le tabelle `camion`
--
ALTER TABLE `camion`
  ADD PRIMARY KEY (`targa`),
  ADD KEY `id_autista` (`id_autista`);

--
-- Indici per le tabelle `nave`
--
ALTER TABLE `nave`
  ADD PRIMARY KEY (`nome_nave`);

--
-- Indici per le tabelle `polizze_di_carico`
--
ALTER TABLE `polizze_di_carico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `porto_carico` (`porto_carico`),
  ADD KEY `porto_destinazione` (`porto_destinazione`),
  ADD KEY `id_fornitore` (`id_fornitore`),
  ADD KEY `id_viaggio` (`id_viaggio`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indici per le tabelle `porto`
--
ALTER TABLE `porto`
  ADD PRIMARY KEY (`nome_porto`);

--
-- Indici per le tabelle `ritiri`
--
ALTER TABLE `ritiri`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_utente` (`id_utente`),
  ADD KEY `camion_utilizzato` (`camion_utilizzato`),
  ADD KEY `id_conducente` (`id_conducente`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indici per le tabelle `viaggio`
--
ALTER TABLE `viaggio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nome_nave` (`nome_nave`),
  ADD KEY `porto_partenza` (`porto_partenza`),
  ADD KEY `porto_arrivo` (`porto_arrivo`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `buono_di_consegna`
--
ALTER TABLE `buono_di_consegna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `polizze_di_carico`
--
ALTER TABLE `polizze_di_carico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `ritiri`
--
ALTER TABLE `ritiri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `buono_di_consegna`
--
ALTER TABLE `buono_di_consegna`
  ADD CONSTRAINT `buono_di_consegna_ibfk_1` FOREIGN KEY (`id_polizza`) REFERENCES `polizze_di_carico` (`id`),
  ADD CONSTRAINT `buono_di_consegna_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `utente` (`id`),
  ADD CONSTRAINT `buono_di_consegna_ibfk_3` FOREIGN KEY (`nome_nave`) REFERENCES `nave` (`nome_nave`),
  ADD CONSTRAINT `buono_di_consegna_ibfk_4` FOREIGN KEY (`id_autista`) REFERENCES `utente` (`id`);

--
-- Limiti per la tabella `camion`
--
ALTER TABLE `camion`
  ADD CONSTRAINT `camion_ibfk_1` FOREIGN KEY (`id_autista`) REFERENCES `utente` (`id`);

--
-- Limiti per la tabella `polizze_di_carico`
--
ALTER TABLE `polizze_di_carico`
  ADD CONSTRAINT `polizze_di_carico_ibfk_1` FOREIGN KEY (`porto_carico`) REFERENCES `porto` (`nome_porto`),
  ADD CONSTRAINT `polizze_di_carico_ibfk_2` FOREIGN KEY (`porto_destinazione`) REFERENCES `porto` (`nome_porto`),
  ADD CONSTRAINT `polizze_di_carico_ibfk_3` FOREIGN KEY (`id_fornitore`) REFERENCES `utente` (`id`),
  ADD CONSTRAINT `polizze_di_carico_ibfk_4` FOREIGN KEY (`id_viaggio`) REFERENCES `viaggio` (`id`),
  ADD CONSTRAINT `polizze_di_carico_ibfk_5` FOREIGN KEY (`id_cliente`) REFERENCES `utente` (`id`);

--
-- Limiti per la tabella `ritiri`
--
ALTER TABLE `ritiri`
  ADD CONSTRAINT `ritiri_ibfk_1` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`),
  ADD CONSTRAINT `ritiri_ibfk_2` FOREIGN KEY (`camion_utilizzato`) REFERENCES `camion` (`targa`),
  ADD CONSTRAINT `ritiri_ibfk_3` FOREIGN KEY (`id_conducente`) REFERENCES `utente` (`id`);

--
-- Limiti per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  ADD CONSTRAINT `viaggio_ibfk_1` FOREIGN KEY (`nome_nave`) REFERENCES `nave` (`nome_nave`),
  ADD CONSTRAINT `viaggio_ibfk_2` FOREIGN KEY (`porto_partenza`) REFERENCES `porto` (`nome_porto`),
  ADD CONSTRAINT `viaggio_ibfk_3` FOREIGN KEY (`porto_arrivo`) REFERENCES `porto` (`nome_porto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
