-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 18 Décembre 2020 à 16:21
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `projet_uber`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_client_cli`
--

CREATE TABLE IF NOT EXISTS `t_client_cli` (
  `cli_id` int(11) NOT NULL AUTO_INCREMENT,
  `cli_nom` varchar(60) COLLATE utf8_bin NOT NULL,
  `cli_prenom` varchar(60) COLLATE utf8_bin NOT NULL,
  `cli_numero_tel` varchar(10) COLLATE utf8_bin NOT NULL,
  `cli_email` varchar(60) COLLATE utf8_bin NOT NULL,
  `cli_adresse` varchar(300) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cli_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=7 ;

--
-- Contenu de la table `t_client_cli`
--

INSERT INTO `t_client_cli` (`cli_id`, `cli_nom`, `cli_prenom`, `cli_numero_tel`, `cli_email`, `cli_adresse`) VALUES
(1, 'DeGrasse', 'Artus ', '0544636953', 'ArtusDeGrasse@jourrapide.com', '30, rue de Groussay\r\n12000 RODEZ'),
(2, 'Porter ', 'Moïse', '0132472827', 'PorterMoise@jourrapide.com', '95, rue du Fossé des Tanneurs\r\n77200 TORCY'),
(3, 'Bilodeau', 'Royden ', '0372103333', 'RoydenBilodeau@armyspy.com', '75, rue de Geneve\r\n80080 AMIENS'),
(4, 'L''Hiver', 'Charles ', '0138376425', 'CharlesLHiver@jourrapide.com', '86, rue des Lacs\r\n95220 HERBLAY'),
(5, 'Vernadeau', 'Angelette ', '0443302148', 'AngeletteVernadeau@dayrep.com', '8, Chemin Du Lavarin Sud\r\n06800 CAGNES-SUR-MER'),
(6, 'Briard', 'Romaine', '0466730789', 'RomaineBriard@teleworm.us', '19, Rue St Ferréol\r\n69330 MEYZIEU');

-- --------------------------------------------------------

--
-- Structure de la table `t_commentaire_com`
--

CREATE TABLE IF NOT EXISTS `t_commentaire_com` (
  `com_id` int(11) NOT NULL AUTO_INCREMENT,
  `com_texte` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `cli_id` int(11) DEFAULT NULL,
  `plt_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`com_id`),
  KEY `fk_commentaire_client` (`cli_id`),
  KEY `fk_commentaire_plat` (`plt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `t_historique_hst`
--

CREATE TABLE IF NOT EXISTS `t_historique_hst` (
  `hst_id` int(11) NOT NULL AUTO_INCREMENT,
  `cli_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`hst_id`),
  KEY `fk_historique_client` (`cli_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `t_panier_pan`
--

CREATE TABLE IF NOT EXISTS `t_panier_pan` (
  `pan_id` int(11) NOT NULL AUTO_INCREMENT,
  `pan_total` float DEFAULT NULL,
  `pan_data` date DEFAULT NULL,
  `cli_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pan_id`),
  KEY `fk_panier_client` (`cli_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `t_panier_plat_tpp`
--

CREATE TABLE IF NOT EXISTS `t_panier_plat_tpp` (
  `pan_id` int(11) NOT NULL,
  `plt_id` int(11) NOT NULL,
  KEY `fk_panier_tpp` (`pan_id`),
  KEY `fk_plat_tpp` (`plt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `t_photo_pht`
--

CREATE TABLE IF NOT EXISTS `t_photo_pht` (
  `pht_id` int(11) NOT NULL AUTO_INCREMENT,
  `pht_photo` varbinary(200) DEFAULT NULL,
  `com_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pht_id`),
  KEY `fk_photo_commentaire` (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `t_plat_historique_tph`
--

CREATE TABLE IF NOT EXISTS `t_plat_historique_tph` (
  `plt_id` int(11) NOT NULL,
  `hst_id` int(11) NOT NULL,
  KEY `fk_plat_tph` (`plt_id`),
  KEY `fk_historique_tph` (`hst_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `t_plat_plt`
--

CREATE TABLE IF NOT EXISTS `t_plat_plt` (
  `plt_id` int(11) NOT NULL AUTO_INCREMENT,
  `plt_nom` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `plt_description` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `plt_prix` float DEFAULT NULL,
  `rst_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`plt_id`),
  KEY `fk_plat_restaurant` (`rst_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `t_restaurant_rst`
--

CREATE TABLE IF NOT EXISTS `t_restaurant_rst` (
  `rst_id` int(11) NOT NULL AUTO_INCREMENT,
  `rst_nom` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `rst_description` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`rst_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `t_commentaire_com`
--
ALTER TABLE `t_commentaire_com`
  ADD CONSTRAINT `fk_commentaire_plat` FOREIGN KEY (`plt_id`) REFERENCES `t_plat_plt` (`plt_id`),
  ADD CONSTRAINT `fk_commentaire_client` FOREIGN KEY (`cli_id`) REFERENCES `t_client_cli` (`cli_id`);

--
-- Contraintes pour la table `t_historique_hst`
--
ALTER TABLE `t_historique_hst`
  ADD CONSTRAINT `fk_historique_client` FOREIGN KEY (`cli_id`) REFERENCES `t_client_cli` (`cli_id`);

--
-- Contraintes pour la table `t_panier_pan`
--
ALTER TABLE `t_panier_pan`
  ADD CONSTRAINT `fk_panier_client` FOREIGN KEY (`cli_id`) REFERENCES `t_client_cli` (`cli_id`);

--
-- Contraintes pour la table `t_panier_plat_tpp`
--
ALTER TABLE `t_panier_plat_tpp`
  ADD CONSTRAINT `fk_plat_tpp` FOREIGN KEY (`plt_id`) REFERENCES `t_plat_plt` (`plt_id`),
  ADD CONSTRAINT `fk_panier_tpp` FOREIGN KEY (`pan_id`) REFERENCES `t_panier_pan` (`pan_id`);

--
-- Contraintes pour la table `t_photo_pht`
--
ALTER TABLE `t_photo_pht`
  ADD CONSTRAINT `fk_photo_commentaire` FOREIGN KEY (`com_id`) REFERENCES `t_commentaire_com` (`com_id`);

--
-- Contraintes pour la table `t_plat_historique_tph`
--
ALTER TABLE `t_plat_historique_tph`
  ADD CONSTRAINT `fk_historique_tph` FOREIGN KEY (`hst_id`) REFERENCES `t_historique_hst` (`hst_id`),
  ADD CONSTRAINT `fk_plat_tph` FOREIGN KEY (`plt_id`) REFERENCES `t_plat_plt` (`plt_id`);

--
-- Contraintes pour la table `t_plat_plt`
--
ALTER TABLE `t_plat_plt`
  ADD CONSTRAINT `fk_plat_restaurant` FOREIGN KEY (`rst_id`) REFERENCES `t_restaurant_rst` (`rst_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
