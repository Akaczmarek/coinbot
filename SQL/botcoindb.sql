-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Sam 18 Novembre 2017 à 13:36
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `botcoindb`
--

-- --------------------------------------------------------

--
-- Structure de la table `configuration`
--

CREATE TABLE `configuration` (
  `betValue` double DEFAULT NULL,
  `secureValue` double DEFAULT NULL,
  `riskLevel` int(11) DEFAULT NULL,
  `stopBotAfter` tinyint(1) DEFAULT NULL,
  `stopBot` tinyint(1) DEFAULT NULL,
  `daysOrdersBloqued` int(11) DEFAULT NULL,
  `daysOneOrderBloqued` int(11) DEFAULT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `configuration`
--

INSERT INTO `configuration` (`betValue`, `secureValue`, `riskLevel`, `stopBotAfter`, `stopBot`, `daysOrdersBloqued`, `daysOneOrderBloqued`, `idUser`) VALUES
(12, 11, 11, 0, 0, 1, 0, 1),
(123, 142, 9, 1, 1, 142, 1, 2),
(12, 112, 112, 0, 1, 12, 43, 3),
(5, 4, 89, 0, 10, 142, 1, 4);

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `idCrypto` int(11) NOT NULL,
  `cryptoName` varchar(25) DEFAULT NULL,
  `cryptoCode` varchar(25) DEFAULT NULL,
  `infoTimeStamp` timestamp NULL DEFAULT NULL,
  `bidBtc` double DEFAULT NULL,
  `askBtc` double DEFAULT NULL,
  `cryptoVolume` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `cours`
--

INSERT INTO `cours` (`idCrypto`, `cryptoName`, `cryptoCode`, `infoTimeStamp`, `bidBtc`, `askBtc`, `cryptoVolume`) VALUES
(1, 'BTC', 'BTC-CASH', '2017-10-31 23:00:00', 12, 14, 12),
(2, 'LTC', 'BTC-LTC', '2017-11-05 23:00:00', 12312, 12, 7);

-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

CREATE TABLE `historique` (
  `idOrder` int(11) NOT NULL,
  `orderType` tinyint(1) DEFAULT NULL,
  `timeStampSendOrder` timestamp NULL DEFAULT NULL,
  `timeStampActiveOrder` timestamp NULL DEFAULT NULL,
  `timeStampCancelledOrder` timestamp NULL DEFAULT NULL,
  `valueCryptoOrder` double DEFAULT NULL,
  `volumeOrder` double DEFAULT NULL,
  `idUser` int(11) NOT NULL,
  `idCrypto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `historique`
--

INSERT INTO `historique` (`idOrder`, `orderType`, `timeStampSendOrder`, `timeStampActiveOrder`, `timeStampCancelledOrder`, `valueCryptoOrder`, `volumeOrder`, `idUser`, `idCrypto`) VALUES
(1, 0, '2017-10-31 23:00:00', '2017-11-08 23:00:00', '2017-10-31 23:00:00', 12, 123, 1, 1),
(2, 1, '2017-11-01 23:00:00', '2017-11-02 23:00:00', '2017-11-03 23:00:00', 123, 1234, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `userName` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`idUser`, `userName`) VALUES
(1, 'GHISLAIN'),
(2, 'JOSE'),
(3, 'FARID'),
(4, 'ALAIN');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `configuration`
--
ALTER TABLE `configuration`
  ADD PRIMARY KEY (`idUser`);

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`idCrypto`);

--
-- Index pour la table `historique`
--
ALTER TABLE `historique`
  ADD PRIMARY KEY (`idOrder`),
  ADD KEY `FK_Historique_idUser` (`idUser`),
  ADD KEY `FK_Historique_idCrypto` (`idCrypto`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `idCrypto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `historique`
--
ALTER TABLE `historique`
  MODIFY `idOrder` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `configuration`
--
ALTER TABLE `configuration`
  ADD CONSTRAINT `FK_Configuration_idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `historique`
--
ALTER TABLE `historique`
  ADD CONSTRAINT `FK_Historique_idCrypto` FOREIGN KEY (`idCrypto`) REFERENCES `cours` (`idCrypto`),
  ADD CONSTRAINT `FK_Historique_idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
