-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 25, 2023 alle 14:52
-- Versione del server: 10.4.28-MariaDB
-- Versione PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `whatsapp`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `chat`
--

CREATE TABLE `chat` (
  `id_chat` int(11) NOT NULL,
  `nome_chat` varchar(50) NOT NULL,
  `tipo_chat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dump dei dati per la tabella `chat`
--

INSERT INTO `chat` (`id_chat`, `nome_chat`, `tipo_chat`) VALUES
(1, '', 'privata'),
(2, '', 'privata'),
(3, '', 'privata'),
(4, '', 'privata'),
(5, '', 'privata');

-- --------------------------------------------------------

--
-- Struttura della tabella `chatutente`
--

CREATE TABLE `chatutente` (
  `id_utente` char(10) NOT NULL DEFAULT '',
  `id_chat` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dump dei dati per la tabella `chatutente`
--

INSERT INTO `chatutente` (`id_utente`, `id_chat`) VALUES
('0938387071', 3),
('0938387071', 4),
('1698490026', 1),
('1698490026', 5),
('5067662963', 1),
('5067662963', 2),
('5067662963', 3),
('8660692330', 2),
('8660692330', 4),
('8660692330', 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `messaggio`
--

CREATE TABLE `messaggio` (
  `id_messaggio` int(11) NOT NULL,
  `testo` text NOT NULL,
  `data` datetime NOT NULL,
  `mittente` char(10) DEFAULT NULL,
  `id_chat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dump dei dati per la tabella `messaggio`
--

INSERT INTO `messaggio` (`id_messaggio`, `testo`, `data`, `mittente`, `id_chat`) VALUES
(1, 'Ciao Vido', '2023-05-25 14:38:12', '5067662963', 1),
(2, 'Ciao Sina', '2023-05-25 14:38:18', '1698490026', 1),
(3, 'Come sei messo con info?', '2023-05-25 14:38:37', '5067662963', 1),
(4, 'Si', '2023-05-25 14:38:44', '1698490026', 1),
(5, 'Ciao Giuse', '2023-05-25 14:39:33', '5067662963', 2),
(6, 'Ciao Sina', '2023-05-25 14:39:45', '8660692330', 2),
(7, 'Potresti aiutarmi con il programma di info?', '2023-05-25 14:40:05', '5067662963', 2),
(8, 'Si certo, 5 minuti e ci sono', '2023-05-25 14:40:21', '8660692330', 2),
(9, 'Thanks', '2023-05-25 14:40:31', '5067662963', 2),
(10, 'Bro', '2023-05-25 14:41:07', '5067662963', 3),
(11, 'Dimmi', '2023-05-25 14:41:15', '0938387071', 3),
(12, 'Vieni su ds?', '2023-05-25 14:41:31', '5067662963', 3),
(13, 'Quando?', '2023-05-25 14:41:40', '0938387071', 3),
(14, 'Tra 10 minuti riesci?', '2023-05-25 14:41:55', '5067662963', 3),
(15, 'Oke', '2023-05-25 14:42:02', '0938387071', 3),
(16, 'Giuse, Giuse', '2023-05-25 14:43:14', '0938387071', 4),
(17, 'Aiuto per mate?', '2023-05-25 14:43:37', '0938387071', 4),
(18, 'Ok va bene', '2023-05-25 14:43:56', '8660692330', 4),
(19, 'Che grande', '2023-05-25 14:44:32', '0938387071', 4),
(20, 'Giuse stasera devi essere pronto per la run del progetto', '2023-05-25 14:46:07', '1698490026', 5),
(21, 'Oh mamma mia', '2023-05-25 14:46:15', '8660692330', 5),
(22, 'Un\'altra volta fino alle 3?', '2023-05-25 14:46:23', '8660692330', 5),
(23, 'GLS', '2023-05-25 14:46:29', '1698490026', 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `numero_telefono` char(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `foto` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`numero_telefono`, `nome`, `foto`) VALUES
('0938387071', 'Simo', './image/Simo.jpg'),
('1698490026', 'Vido', './image/Vido.jpg'),
('2348287787', 'Ema', './image/Ema.jpg'),
('5067662963', 'Sina', './image/Sina.jpg'),
('8660692330', 'Giuse', './image/Giuse.jpg');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`id_chat`);

--
-- Indici per le tabelle `chatutente`
--
ALTER TABLE `chatutente`
  ADD PRIMARY KEY (`id_utente`,`id_chat`),
  ADD KEY `id_chat` (`id_chat`);

--
-- Indici per le tabelle `messaggio`
--
ALTER TABLE `messaggio`
  ADD PRIMARY KEY (`id_messaggio`),
  ADD KEY `mittente` (`mittente`),
  ADD KEY `id_chat` (`id_chat`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`numero_telefono`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `chat`
--
ALTER TABLE `chat`
  MODIFY `id_chat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT per la tabella `messaggio`
--
ALTER TABLE `messaggio`
  MODIFY `id_messaggio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `chatutente`
--
ALTER TABLE `chatutente`
  ADD CONSTRAINT `chatutente_ibfk_1` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`numero_telefono`),
  ADD CONSTRAINT `chatutente_ibfk_2` FOREIGN KEY (`id_chat`) REFERENCES `chat` (`id_chat`);

--
-- Limiti per la tabella `messaggio`
--
ALTER TABLE `messaggio`
  ADD CONSTRAINT `id_chat` FOREIGN KEY (`id_chat`) REFERENCES `chat` (`id_chat`),
  ADD CONSTRAINT `mittente` FOREIGN KEY (`mittente`) REFERENCES `utente` (`numero_telefono`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
