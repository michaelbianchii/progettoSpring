-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 04, 2025 alle 13:29
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
-- Struttura della tabella `autista`
--

CREATE TABLE `autista` (
  `nome_autista` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `autista`
--

INSERT INTO `autista` (`nome_autista`) VALUES
('Luigi Bianchi'),
('Marco Verdi');

-- --------------------------------------------------------

--
-- Struttura della tabella `buono_di_consegna`
--

CREATE TABLE `buono_di_consegna` (
  `id` int(11) NOT NULL,
  `id_polizza` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `nome_nave` varchar(100) DEFAULT NULL,
  `peso` decimal(10,2) DEFAULT NULL,
  `nome_autista` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `buono_di_consegna`
--

INSERT INTO `buono_di_consegna` (`id`, `id_polizza`, `id_cliente`, `nome_nave`, `peso`, `nome_autista`) VALUES
(1, 1, 1, 'MSC Aurora', 2500.50, 'Luigi Bianchi'),
(2, 2, 2, 'Blue Ocean', 3800.00, 'Marco Verdi');

-- --------------------------------------------------------

--
-- Struttura della tabella `camion`
--

CREATE TABLE `camion` (
  `targa` varchar(20) NOT NULL,
  `modello` varchar(100) DEFAULT NULL,
  `marca` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `camion`
--

INSERT INTO `camion` (`targa`, `modello`, `marca`) VALUES
('AB123CD', 'XF 105', 'DAF'),
('EF456GH', 'Actros', 'Mercedes');

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `indirizzo` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `indirizzo`, `telefono`, `mail`) VALUES
(1, 'Supermercati Rossi', 'Via Napoli 88, Napoli', '0811122333', 'logistica@rossi.it'),
(2, 'Cantine Verdi', 'Via Vino 12, Palermo', '0919988776', 'ordini@verdi.it');

-- --------------------------------------------------------

--
-- Struttura della tabella `fornitore`
--

CREATE TABLE `fornitore` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `indirizzo` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `fornitore`
--

INSERT INTO `fornitore` (`id`, `nome`, `indirizzo`, `telefono`, `mail`) VALUES
(1, 'ItalCargo S.p.A.', 'Via Roma 123, Milano', '0234567890', 'info@italcargo.it'),
(2, 'Maritime SRL', 'Lungomare 45, Genova', '0101234567', 'contatti@maritime.it');

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
  `porto_carico` varchar(100) DEFAULT NULL,
  `porto_destinazione` varchar(100) DEFAULT NULL,
  `tipologia_merce` varchar(100) DEFAULT NULL,
  `peso` decimal(10,2) DEFAULT NULL,
  `id_fornitore` int(11) DEFAULT NULL,
  `id_viaggio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `polizze_di_carico`
--

INSERT INTO `polizze_di_carico` (`id`, `porto_carico`, `porto_destinazione`, `tipologia_merce`, `peso`, `id_fornitore`, `id_viaggio`) VALUES
(1, 'Genova', 'Palermo', 'Frutta fresca', 2500.50, 1, 1),
(2, 'Napoli', 'Barcellona', 'Elettrodomestici', 3800.00, 2, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `porto`
--

CREATE TABLE `porto` (
  `nome_porto` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `porto`
--

INSERT INTO `porto` (`nome_porto`) VALUES
('Barcellona'),
('Genova'),
('Napoli'),
('Palermo');

-- --------------------------------------------------------

--
-- Struttura della tabella `viaggio`
--

CREATE TABLE `viaggio` (
  `id` int(11) NOT NULL,
  `nome_nave` varchar(100) DEFAULT NULL,
  `porto_partenza` varchar(100) DEFAULT NULL,
  `data_partenza` date DEFAULT NULL,
  `porto_arrivo` varchar(100) DEFAULT NULL,
  `data_arrivo` date DEFAULT NULL,
  `linea` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `viaggio`
--

INSERT INTO `viaggio` (`id`, `nome_nave`, `porto_partenza`, `data_partenza`, `porto_arrivo`, `data_arrivo`, `linea`) VALUES
(1, 'MSC Aurora', 'Genova', '2025-05-10', 'Palermo', '2025-05-12', 'Linea A'),
(2, 'Blue Ocean', 'Napoli', '2025-05-08', 'Barcellona', '2025-05-11', 'Linea B');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `autista`
--
ALTER TABLE `autista`
  ADD PRIMARY KEY (`nome_autista`);

--
-- Indici per le tabelle `buono_di_consegna`
--
ALTER TABLE `buono_di_consegna`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_polizza` (`id_polizza`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `nome_nave` (`nome_nave`),
  ADD KEY `nome_autista` (`nome_autista`);

--
-- Indici per le tabelle `camion`
--
ALTER TABLE `camion`
  ADD PRIMARY KEY (`targa`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `fornitore`
--
ALTER TABLE `fornitore`
  ADD PRIMARY KEY (`id`);

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
  ADD KEY `id_viaggio` (`id_viaggio`);

--
-- Indici per le tabelle `porto`
--
ALTER TABLE `porto`
  ADD PRIMARY KEY (`nome_porto`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `fornitore`
--
ALTER TABLE `fornitore`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `polizze_di_carico`
--
ALTER TABLE `polizze_di_carico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `buono_di_consegna`
--
ALTER TABLE `buono_di_consegna`
  ADD CONSTRAINT `buono_di_consegna_ibfk_1` FOREIGN KEY (`id_polizza`) REFERENCES `polizze_di_carico` (`id`),
  ADD CONSTRAINT `buono_di_consegna_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `buono_di_consegna_ibfk_3` FOREIGN KEY (`nome_nave`) REFERENCES `nave` (`nome_nave`),
  ADD CONSTRAINT `buono_di_consegna_ibfk_4` FOREIGN KEY (`nome_autista`) REFERENCES `autista` (`nome_autista`);

--
-- Limiti per la tabella `polizze_di_carico`
--
ALTER TABLE `polizze_di_carico`
  ADD CONSTRAINT `polizze_di_carico_ibfk_1` FOREIGN KEY (`porto_carico`) REFERENCES `porto` (`nome_porto`),
  ADD CONSTRAINT `polizze_di_carico_ibfk_2` FOREIGN KEY (`porto_destinazione`) REFERENCES `porto` (`nome_porto`),
  ADD CONSTRAINT `polizze_di_carico_ibfk_3` FOREIGN KEY (`id_fornitore`) REFERENCES `fornitore` (`id`),
  ADD CONSTRAINT `polizze_di_carico_ibfk_4` FOREIGN KEY (`id_viaggio`) REFERENCES `viaggio` (`id`);

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
