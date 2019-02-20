-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 20 fév. 2019 à 21:02
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `securiface`
--

-- --------------------------------------------------------

--
-- Structure de la table `agents`
--

DROP TABLE IF EXISTS `agents`;
CREATE TABLE IF NOT EXISTS `agents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `poste` varchar(50) DEFAULT NULL,
  `matricule` int(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `chemin_photo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agents`
--

INSERT INTO `agents` (`id`, `nom`, `prenom`, `poste`, `matricule`, `password`, `chemin_photo`) VALUES
(14, 'Castle', 'Franck', 'Gardien', 89654, 'MotdePasseFranck', './src/main/photo.jpg'),
(13, 'Bond', 'James', 'Gardien', 54782, 'MotdePasseJames', './src/main/photo.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

DROP TABLE IF EXISTS `materiel`;
CREATE TABLE IF NOT EXISTS `materiel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `date_ajout` varchar(25) DEFAULT NULL,
  `dern_retrait` varchar(25) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`id`, `nom`, `date_ajout`, `dern_retrait`, `description`, `quantite`) VALUES
(40, 'Menottes', '2019.02.19', NULL, 'Menottes 45mm', 8),
(38, 'Gilet Pare-Balle', '2019.02.19', NULL, 'Gilet Pare-Balle en Kevlar', 6),
(39, 'Tazer', '2019.02.19', NULL, 'Pistolet Tazer 58W', 6),
(37, 'Grapin', '2019.02.19', '2019.02.20', 'Grapin de sécurité 45mm', 0);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomAgent` varchar(30) NOT NULL,
  `nomMateriel` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nomAgent` (`nomAgent`),
  KEY `nomMateriel` (`nomMateriel`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `nomAgent`, `nomMateriel`) VALUES
(1, 'Castle', 'Grapin');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
