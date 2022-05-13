-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 13 mai 2022 à 18:21
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `archive`
--

CREATE TABLE `archive` (
  `id` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `deleted_at` date NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `archive`
--

INSERT INTO `archive` (`id`, `username`, `email`, `gender`, `deleted_at`, `created_at`) VALUES
(4, 'oussama1', 'fatimafatouma784@gmail.com', 'male', '2022-04-14', '2022-04-14'),
(5, 'oussama455', 'oussama.jmaa@esprit.tn', NULL, '2022-04-14', '2022-04-14'),
(6, 'oussama2', 'oussama.jmaa@esprit.tn', 'male', '2022-04-14', '2022-04-14'),
(7, 'oussama44', 'fatimafatouma784@gmail.com', 'male', '2022-04-14', '2022-04-14'),
(8, 'oussama555', 'fatimafatouma784@gmail.com', 'male', '2022-04-14', '2022-04-14'),
(9, 'fathi', 'jemaaoussama64@gmail.com', NULL, '2022-04-16', '2022-04-16'),
(10, 'oussama jmaa', 'jemaaoussama64@gmail.com', NULL, '2022-04-16', '2022-04-16'),
(11, 'Shockswave99', 'jemaaoussama64@gmail.com', NULL, '2022-04-16', '2022-04-16'),
(12, 'oussama jmaa', 'jemaaoussama64@gmail.com', 'male', '2022-04-18', '2022-04-17'),
(13, 'oussama jmaa', 'jemaaoussama64@gmail.com', 'female', '2022-04-18', '2022-04-18'),
(14, 'oussama jmaa', 'jemaaoussama64@gmail.com', 'male', '2022-04-18', '2022-04-18'),
(15, 'oussama jmaa', 'jemaaoussama64@gmail.com', 'male', '2022-04-19', '2022-04-18'),
(16, 'oussama55', 'oussama.jmaa@esprit.tn', 'female', '2022-04-23', '2022-04-23'),
(17, 'oussama2', 'oussama.jmaa@esprit.tn', 'male', '2022-04-24', '2022-04-23'),
(18, 'oussama jmaa', 'jemaaoussama64@gmail.com', 'female', '2022-04-24', '2022-04-23'),
(19, 'roukaia22', 'roukaia70@gmail.com', 'female', '2022-04-24', '2022-04-23'),
(20, 'oussama2', 'oussama.jmaa@esprit.tn', 'male', '2022-04-24', '2022-04-23'),
(21, 'oussama2', 'oussama.jmaa@esprit.tn', 'male', '2022-04-24', '2022-04-23'),
(22, 'oussama1', 'oussama.jmaa@esprit.tn', 'male', '2022-04-25', '2022-04-24'),
(23, 'oussama55', 'jemaaoussama64@gmail.com', 'male', '2022-04-25', '2022-04-24'),
(24, 'roukaia1', 'roukaia70@gmail.com', 'female', '2022-04-25', '2022-04-25'),
(25, 'oussama22', 'jemaaoussama64@gmail.com', 'male', '2022-04-25', '2022-04-25'),
(26, 'oussama2', 'jemaaoussama64@gmail.com', 'male', '2022-04-25', '2022-04-25'),
(27, 'oussama77', 'fatimafatouma784@gmail.com', 'female', '2022-04-25', '2022-04-16'),
(28, 'roukaia22', 'roukaia70@gmail.com', 'male', '2022-04-25', '2022-04-25'),
(29, 'fatima', 'fatimafatouma784@gmail.com', 'male', '2022-04-27', '2022-04-25'),
(30, 'Oussama Jmâa', 'jemaaoussama64@gmail.com', 'male', '2022-04-27', '2022-04-27'),
(31, 'oussama77', 'jemaaoussama64@gmail.com', 'male', '2022-04-28', '2022-04-27'),
(32, 'oussama24', 'fatimafatouma784@gmail.com', 'male', '2022-04-29', '2022-04-28'),
(33, 'oussama120', 'jemaaoussama64@gmail.com', 'male', '2022-05-12', '2022-05-12'),
(34, 'oussama120', 'jemaaoussama64@gmail.com', 'male', '2022-05-12', '2022-05-12'),
(35, 'oussama120', 'jemaaoussama64@gmail.com', 'male', '2022-05-12', '2022-05-12');

-- --------------------------------------------------------

--
-- Structure de la table `bracket`
--

CREATE TABLE `bracket` (
  `id` int(11) NOT NULL,
  `equipe1` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `equipe2` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status_team1` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status_team2` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `bracket`
--

INSERT INTO `bracket` (`id`, `equipe1`, `equipe2`, `status_team1`, `status_team2`) VALUES
(13, 'easy', 'roukaa', 'winner', 'looser'),
(14, 'hello', 'league', 'looser', 'winner'),
(15, 'easy', 'league', 'Final looser', 'Final winner');

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `discription` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`category_id`, `category_name`, `discription`) VALUES
(2, 'cat4', 'test4'),
(3, 'cat3', 'test3'),
(6, 'arcade', 'arcade games');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `nbproduit` int(11) NOT NULL,
  `date` date NOT NULL,
  `methodedepaiement` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `etat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prixtotale` double NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `nbproduit`, `date`, `methodedepaiement`, `etat`, `prixtotale`, `user_id`) VALUES
(2, 7, '2022-05-13', 'Espece', 'annulé', 55, NULL),
(3, 1, '2022-05-11', 'Cheque', 'En cours', 20, NULL),
(4, 1, '2022-05-11', 'Cheque', 'livré', 20, NULL),
(6, 3, '2022-07-11', 'Espece', 'terminé', 95, NULL),
(7, 2, '2022-05-11', 'Cheque', 'terminé', 110, NULL),
(8, 2, '2022-05-11', 'Cheque', 'terminé', 110, NULL),
(9, 4, '2022-05-11', 'Cheque', 'En cours', 115, NULL),
(10, 2, '2022-06-11', 'Cheque', 'En cours', 110, NULL),
(11, 3, '2023-03-01', 'Espece', 'En cours', 60, NULL),
(12, 66, '2023-01-22', 'Cheque', 'En cours', 1320, NULL),
(13, 8, '2024-01-01', 'Espece', 'Terminé', 160, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `commande_produit`
--

CREATE TABLE `commande_produit` (
  `commande_id` int(11) NOT NULL,
  `produit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `commande_produit`
--

INSERT INTO `commande_produit` (`commande_id`, `produit_id`) VALUES
(11, 6),
(12, 6),
(13, 7);

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `publication_id` int(11) NOT NULL,
  `auteur` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contenu` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `comment`
--

INSERT INTO `comment` (`id`, `publication_id`, `auteur`, `contenu`, `created_at`) VALUES
(3, 1, 'oussama120', 'heloooooo', '2022-05-06 18:19:53'),
(4, 4, 'Roukaia Khelifi', 'bonjour', '2022-05-12 13:44:26'),
(5, 6, 'Roukaia Khelifi', 'hello !', '2022-05-12 14:16:08'),
(6, 7, 'Roukaia Khelifi', 'article1 com', '2022-05-12 15:08:35'),
(7, 1, 'Roukaia Khelifi', 'commentaire2', '2022-05-12 15:11:28');

-- --------------------------------------------------------

--
-- Structure de la table `commentaires`
--

CREATE TABLE `commentaires` (
  `id_com` int(11) NOT NULL,
  `description_com` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `doctrine_migration_versions`
--

CREATE TABLE `doctrine_migration_versions` (
  `version` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `executed_at` datetime DEFAULT NULL,
  `execution_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `doctrine_migration_versions`
--

INSERT INTO `doctrine_migration_versions` (`version`, `executed_at`, `execution_time`) VALUES
('DoctrineMigrations\\Version20220404133945', '2022-04-04 15:39:48', 506),
('DoctrineMigrations\\Version20220406210130', '2022-04-06 23:01:53', 365),
('DoctrineMigrations\\Version20220406211232', '2022-04-06 23:12:35', 51),
('DoctrineMigrations\\Version20220406211643', '2022-04-06 23:16:46', 30),
('DoctrineMigrations\\Version20220406231255', '2022-04-07 01:13:00', 47),
('DoctrineMigrations\\Version20220406234803', '2022-04-07 01:48:08', 35),
('DoctrineMigrations\\Version20220407015056', '2022-04-07 03:51:09', 97),
('DoctrineMigrations\\Version20220414015920', '2022-04-14 03:59:28', 143),
('DoctrineMigrations\\Version20220414021457', '2022-04-14 04:15:42', 29),
('DoctrineMigrations\\Version20220414022612', '2022-04-14 04:26:15', 60),
('DoctrineMigrations\\Version20220414235818', '2022-04-15 01:58:24', 140),
('DoctrineMigrations\\Version20220415004047', '2022-04-15 02:40:52', 129),
('DoctrineMigrations\\Version20220415190247', '2022-04-15 21:03:12', 262),
('DoctrineMigrations\\Version20220415215457', '2022-04-15 23:56:45', 115),
('DoctrineMigrations\\Version20220416040425', '2022-04-16 06:04:37', 91),
('DoctrineMigrations\\Version20220418070213', '2022-04-18 09:02:18', 165),
('DoctrineMigrations\\Version20220419213328', '2022-04-19 23:33:42', 302),
('DoctrineMigrations\\Version20220421041929', '2022-04-21 06:19:36', 257),
('DoctrineMigrations\\Version20220421075622', '2022-04-21 09:56:24', 50),
('DoctrineMigrations\\Version20220421103030', '2022-04-21 12:30:36', 297),
('DoctrineMigrations\\Version20220424055328', '2022-04-24 07:53:34', 667),
('DoctrineMigrations\\Version20220425041344', '2022-04-25 06:13:49', 346),
('DoctrineMigrations\\Version20220425044240', '2022-04-25 06:42:45', 202),
('DoctrineMigrations\\Version20220426235711', '2022-04-27 01:57:18', 634),
('DoctrineMigrations\\Version20220428060448', '2022-04-28 08:05:24', 148),
('DoctrineMigrations\\Version20220428065333', '2022-04-28 08:53:39', 31),
('DoctrineMigrations\\Version20220428071157', '2022-04-28 09:12:00', 27),
('DoctrineMigrations\\Version20220428072206', '2022-04-28 09:22:11', 28),
('DoctrineMigrations\\Version20220428081951', '2022-04-28 10:19:55', 152),
('DoctrineMigrations\\Version20220429135321', '2022-04-29 15:53:27', 739),
('DoctrineMigrations\\Version20220504005820', '2022-05-04 02:58:23', 377),
('DoctrineMigrations\\Version20220504022246', '2022-05-04 04:22:51', 161),
('DoctrineMigrations\\Version20220504023921', '2022-05-04 04:39:24', 39),
('DoctrineMigrations\\Version20220506132644', '2022-05-06 15:26:52', 304),
('DoctrineMigrations\\Version20220506135816', '2022-05-06 15:58:20', 142),
('DoctrineMigrations\\Version20220506162634', '2022-05-06 18:26:38', 180),
('DoctrineMigrations\\Version20220506165452', '2022-05-06 18:54:54', 234),
('DoctrineMigrations\\Version20220510225817', '2022-05-11 00:58:23', 1167),
('DoctrineMigrations\\Version20220511003847', '2022-05-11 02:38:53', 603),
('DoctrineMigrations\\Version20220511004234', '2022-05-11 02:42:41', 147),
('DoctrineMigrations\\Version20220511230059', '2022-05-12 01:01:04', 1207),
('DoctrineMigrations\\Version20220512113629', '2022-05-12 13:36:38', 719),
('DoctrineMigrations\\Version20220512172223', '2022-05-12 19:22:30', 630),
('DoctrineMigrations\\Version20220512225124', '2022-05-13 00:51:29', 700),
('DoctrineMigrations\\Version20220512233046', '2022-05-13 01:30:50', 57),
('DoctrineMigrations\\Version20220512233248', '2022-05-13 01:32:52', 523),
('DoctrineMigrations\\Version20220512233509', '2022-05-13 01:35:13', 54),
('DoctrineMigrations\\Version20220512233707', '2022-05-13 01:37:10', 37),
('DoctrineMigrations\\Version20220512233823', '2022-05-13 01:38:27', 41),
('DoctrineMigrations\\Version20220512234028', '2022-05-13 01:40:32', 38);

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `id` int(11) NOT NULL,
  `nom_equipe` varchar(30) NOT NULL,
  `membres` int(11) DEFAULT NULL,
  `pts_exp` int(11) DEFAULT NULL,
  `tournois_gagne` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `equipe`
--

INSERT INTO `equipe` (`id`, `nom_equipe`, `membres`, `pts_exp`, `tournois_gagne`) VALUES
(48, 'valorant', 5, 555, 555),
(51, 'test', 5, NULL, NULL),
(52, 'hello', 2, NULL, NULL),
(53, 'roukeee', 2, NULL, NULL),
(54, 'hii', 4, NULL, NULL),
(55, 'league', 4, NULL, NULL),
(56, 'vvv', 4, 55, 3),
(57, 'roukaia', 2, NULL, NULL),
(58, 'roukaa', 2, NULL, NULL),
(59, 'eyas888', 5, NULL, NULL),
(62, 'valorant888', 2, NULL, NULL),
(63, 'hello8', 12, NULL, NULL),
(65, 'tattatat', 2, NULL, NULL),
(66, 'test', 5, NULL, NULL),
(67, 'testTEAM', 1, NULL, NULL),
(68, 'AAAAAAAAAA', 5, NULL, NULL),
(69, 'liquid', 4, NULL, NULL),
(70, 'fnatic', 4, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `game`
--

CREATE TABLE `game` (
  `game_id` int(11) NOT NULL,
  `idcategory` int(11) DEFAULT NULL,
  `game_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `game_description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `game_link` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `game_img` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nbr_vu` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `game`
--

INSERT INTO `game` (`game_id`, `idcategory`, `game_name`, `game_description`, `game_link`, `game_img`, `nbr_vu`, `rating`) VALUES
(7, 2, 'roukaia', 'test', 'test', '627b86dc7a61e.png', NULL, 5),
(8, 2, 'Valorant', 'tst', 'testt', '627b8667a9322.jpeg', NULL, 3),
(9, 3, 'league of legends', 'moba game', 'test', '627c2cab177a6.jpeg', NULL, 4),
(10, 2, 'cs global offensive', 'fps game', 'test', '627c2cdb9e603.jpeg', NULL, 4),
(11, 2, 'wild rift', 'moba game', 'test', '627c2d1539885.jpeg', NULL, 1),
(13, 6, 'splinter cell', 'action game', 'http://localhost:8000/game/new', '627d060276ab8.png', NULL, 5);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `recipient_id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `message` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `is_read` tinyint(1) NOT NULL,
  `deleted_from` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE `panier` (
  `id` int(11) NOT NULL,
  `id_produit` int(11) DEFAULT NULL,
  `prix` int(11) NOT NULL,
  `image` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `id` int(11) NOT NULL,
  `id_tournois` int(11) DEFAULT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  `tournois_nom` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `equipe_nom` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`id`, `id_tournois`, `id_equipe`, `tournois_nom`, `equipe_nom`) VALUES
(3, 3, 59, 'test', 'easy'),
(4, 3, 58, 'test', 'roukaa'),
(5, 3, 52, 'test', 'hello'),
(6, 3, 55, 'test', 'league'),
(7, 4, 66, 'test11', 'test'),
(8, 4, 69, 'test11', 'liquid'),
(10, 8, 70, 'tournoi55', 'fnatic');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prix` double NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `quantite` int(11) NOT NULL,
  `avis` int(11) DEFAULT NULL,
  `nbavis` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `nom`, `prix`, `image`, `quantite`, `avis`, `nbavis`) VALUES
(4, 'produit1', 200, '1b3d31a60025ee06510e30e94dd45eae.png', 800, 0, 0),
(6, 'produit88', 20, '1d52d4d78c97612ecd0e65a49ad95279.tmp', 899, 0, 0),
(7, 'produit2', 20, 'c9d3152f8595db9adaeea7699eec15fc.png', 800, 0, 0),
(8, 'micro-casque', 55, 'ba59d400bac75bc7e4a0d570042b0a3f.tmp', 1000, 0, 0),
(10, 'camera', 55, '6b91c5b9e1571e18bc21e3466dfb8fec.jpeg', 66, 0, 0),
(11, 'mannette', 55, '38ff9fd97ca18a6a290db76061ee3b3b.jpeg', 22, 0, 0),
(12, 'testt', 2, '95afcedc884ffed084634e87efe93fa3.tmp', 16, 0, 0),
(13, 'micro-casq', 55, '072d3c2b2398f469da30ada3cdf624be.jpeg', -1, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

CREATE TABLE `promotion` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT 'NULL',
  `prix_pro` int(11) DEFAULT NULL,
  `datef` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT 'NULL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`id`, `nom`, `date`, `prix_pro`, `datef`) VALUES
(7, 'testttt', '22/10/2022', 50, '22/10/2022'),
(8, 'helooo', '22/10/2022', 44, '22/10/2022'),
(9, 'testtt', '22/10/2022', 2, '22/10/2022');

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

CREATE TABLE `publication` (
  `id` int(11) NOT NULL,
  `titre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contenu` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `publication`
--

INSERT INTO `publication` (`id`, `titre`, `contenu`, `image`, `created_at`) VALUES
(1, 'test', 'test', 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg?fbclid=IwAR2YdfZt-GBYM4en8XfGrf5iRY9EnZ6sePr3haqZNbZU8h1Kb6sYtd2P1bU', '2022-05-06 16:42:02'),
(3, 'test', 'qqsqs', 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg?fbclid=IwAR2YdfZt-GBYM4en8XfGrf5iRY9EnZ6sePr3haqZNbZU8h1Kb6sYtd2P1bU', '2022-05-06 18:18:35'),
(4, 'test', 'eezeez', 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg?fbclid=IwAR2YdfZt-GBYM4en8XfGrf5iRY9EnZ6sePr3haqZNbZU8h1Kb6sYtd2P1bU', '2022-05-06 18:19:05'),
(5, 'testt55', 'test', 'https://static.vecteezy.com/packs/media/components/global/search-explore-nav/img/vectors/term-bg-1-666de2d941529c25aa511dc18d727160.jpg', '2022-05-12 13:43:40'),
(6, 'bonjour', 'game', 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg?fbclid=IwAR2YdfZt-GBYM4en8XfGrf5iRY9EnZ6sePr3haqZNbZU8h1Kb6sYtd2P1bU', '2022-05-12 14:15:35'),
(7, 'article1', 'test', 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg?fbclid=IwAR2YdfZt-GBYM4en8XfGrf5iRY9EnZ6sePr3haqZNbZU8h1Kb6sYtd2P1bU', '2022-05-12 15:08:02');

-- --------------------------------------------------------

--
-- Structure de la table `publications`
--

CREATE TABLE `publications` (
  `id_pub` int(11) NOT NULL,
  `titre_pub` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description_pub` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_commentaire` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `rating`
--

CREATE TABLE `rating` (
  `rating_id` int(11) NOT NULL,
  `rating_value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reset_password_request`
--

CREATE TABLE `reset_password_request` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `selector` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hashed_token` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `requested_at` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)',
  `expires_at` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tournois`
--

CREATE TABLE `tournois` (
  `id` int(11) NOT NULL,
  `nom_tournois` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `capacite` int(11) DEFAULT NULL,
  `recompense` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_tournois` date DEFAULT NULL,
  `pts_xp` int(11) DEFAULT NULL,
  `time_t` time DEFAULT NULL,
  `platforme` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `tournois`
--

INSERT INTO `tournois` (`id`, `nom_tournois`, `capacite`, `recompense`, `date_tournois`, `pts_xp`, `time_t`, `platforme`) VALUES
(3, 'test', 4, '2', '2022-05-13', 555, '10:45:00', NULL),
(4, 'test11', 4, '1', '2022-08-06', 25, '13:18:00', NULL),
(5, 'test22', 5, '2', '2022-09-28', 44, '17:29:22', NULL),
(8, 'tournoi55', 4, '1', '2022-05-13', 25, '14:16:00', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tournois_equipe`
--

CREATE TABLE `tournois_equipe` (
  `tournois_id` int(11) NOT NULL,
  `equipe_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `trash`
--

CREATE TABLE `trash` (
  `id` int(11) NOT NULL,
  `sender_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `recipient_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `message` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `deleted_from` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `trash`
--

INSERT INTO `trash` (`id`, `sender_id`, `recipient_id`, `message`, `title`, `deleted_from`) VALUES
(12, 'oussama22', 'oussama55', 'hello', 'wiw', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `equipe` int(30) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `roles` longtext NOT NULL DEFAULT '["ROLE_USER"]' COMMENT '(DC2Type:json)',
  `is_verified` tinyint(1) DEFAULT NULL,
  `unread_m` int(11) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `is_social` tinyint(1) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `java_password` varchar(255) DEFAULT NULL,
  `password2` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`, `username`, `email`, `password`, `gender`, `address`, `phone`, `nationality`, `image`, `equipe`, `created_at`, `roles`, `is_verified`, `unread_m`, `last_login`, `is_social`, `role`, `java_password`, `password2`) VALUES
(183, NULL, NULL, 'oussama55', 'roukaia.khelifi@esprit.tn', '$2a$12$iRA0ZOQ3YhN.eBXtBPZCUu8CGx5Zhc6XzLxXeGNAD9tvQjV0pWWWC', 'female', NULL, 96566945, NULL, '90d52bc7aad7b75d4dd478318c8d2883.png', NULL, '2022-05-12 02:41:33', '[\"ROLE_ADMIN\"]', 0, NULL, '2022-05-12 14:44:39', NULL, 'admin', NULL, NULL),
(198, 'oussama', 'jmaa', 'oussama589', 'jemaaoussama64@gmail.com', '$2a$12$PZv02SAP5L9RDSfPBsiPKuE5bv22K8/gKVHdFbA1euUMuYZArW9YW', 'female', 'nabeul', 22658131, 'Tunisia', 'f13ef7d394c88cb68fbb7e2c00769662.jpeg', NULL, '2022-05-13 00:49:22', '[\"ROLE_USER\"]', 1, NULL, '2022-05-13 01:49:59', NULL, 'client', NULL, NULL),
(201, 'oussama', 'jmaa', 'oussama111', 'oussama.jmaa@esprit.tn', '$2a$12$dAJuh/3YQkUk4AWc0kALtuYgc9pmJXXMLCKVY63uO7FCriYJMNZye', 'female', 'nabeul', 22658131, 'Tunisia', 'C:\\Users\\oussa\\Desktop\\avatar.png', NULL, '2022-05-13 11:36:52', '[\"ROLE_USER\"]', 1, NULL, '2022-05-13 12:38:57', NULL, 'admin', 'Azerty1234@', NULL),
(205, 'oussama', 'jmaa', 'oussama0022', 'roukaia70@gmail.com', '$2a$12$ap/kPVjBqfgmUwVzmOdtGeKagdiKMASiHGtZzy4BWJW9w9mzBi2Nu', 'Male', 'nabeul', 22658131, 'Tunisia', 'C:\\Users\\oussa\\Desktop\\avatar.png', NULL, '2022-05-13 14:09:04', '[\"ROLE_ADMIN\"]', 0, NULL, '2022-05-13 16:42:09', NULL, 'admin', 'Azerty1234@', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `archive`
--
ALTER TABLE `archive`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `bracket`
--
ALTER TABLE `bracket`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`),
  ADD UNIQUE KEY `category_name` (`category_name`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_6EEAA67DA76ED395` (`user_id`);

--
-- Index pour la table `commande_produit`
--
ALTER TABLE `commande_produit`
  ADD PRIMARY KEY (`commande_id`,`produit_id`),
  ADD KEY `IDX_DF1E9E8782EA2E54` (`commande_id`),
  ADD KEY `IDX_DF1E9E87F347EFB` (`produit_id`);

--
-- Index pour la table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_9474526C38B217A7` (`publication_id`);

--
-- Index pour la table `commentaires`
--
ALTER TABLE `commentaires`
  ADD PRIMARY KEY (`id_com`);

--
-- Index pour la table `doctrine_migration_versions`
--
ALTER TABLE `doctrine_migration_versions`
  ADD PRIMARY KEY (`version`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`game_id`),
  ADD KEY `FK_category_id` (`idcategory`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_B6BD307FF624B39D` (`sender_id`),
  ADD KEY `IDX_B6BD307FE92F8F78` (`recipient_id`);

--
-- Index pour la table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_produit` (`id_produit`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_e` (`id_equipe`),
  ADD KEY `fk_t` (`id_tournois`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `publication`
--
ALTER TABLE `publication`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `publications`
--
ALTER TABLE `publications`
  ADD PRIMARY KEY (`id_pub`);

--
-- Index pour la table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`rating_id`);

--
-- Index pour la table `reset_password_request`
--
ALTER TABLE `reset_password_request`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_7CE748AA76ED395` (`user_id`);

--
-- Index pour la table `tournois`
--
ALTER TABLE `tournois`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tournois_equipe`
--
ALTER TABLE `tournois_equipe`
  ADD PRIMARY KEY (`tournois_id`,`equipe_id`),
  ADD KEY `IDX_5E5796AC752534C` (`tournois_id`),
  ADD KEY `IDX_5E5796AC6D861B89` (`equipe_id`);

--
-- Index pour la table `trash`
--
ALTER TABLE `trash`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_8D93D649F85E0677` (`username`),
  ADD UNIQUE KEY `UNIQ_8D93D649E7927C74` (`email`),
  ADD KEY `fk_equipe` (`equipe`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `archive`
--
ALTER TABLE `archive`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT pour la table `bracket`
--
ALTER TABLE `bracket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT pour la table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `commentaires`
--
ALTER TABLE `commentaires`
  MODIFY `id_com` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT pour la table `game`
--
ALTER TABLE `game`
  MODIFY `game_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT pour la table `panier`
--
ALTER TABLE `panier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `participation`
--
ALTER TABLE `participation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `publication`
--
ALTER TABLE `publication`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `publications`
--
ALTER TABLE `publications`
  MODIFY `id_pub` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `rating`
--
ALTER TABLE `rating`
  MODIFY `rating_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reset_password_request`
--
ALTER TABLE `reset_password_request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `tournois`
--
ALTER TABLE `tournois`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `trash`
--
ALTER TABLE `trash`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=206;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FK_6EEAA67DA76ED395` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `commande_produit`
--
ALTER TABLE `commande_produit`
  ADD CONSTRAINT `FK_DF1E9E8782EA2E54` FOREIGN KEY (`commande_id`) REFERENCES `commande` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_DF1E9E87F347EFB` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK_9474526C38B217A7` FOREIGN KEY (`publication_id`) REFERENCES `publication` (`id`);

--
-- Contraintes pour la table `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `FK_232B318CAC9951CC` FOREIGN KEY (`idcategory`) REFERENCES `category` (`category_id`);

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FK_B6BD307FE92F8F78` FOREIGN KEY (`recipient_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_B6BD307FF624B39D` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `FK_24CC0DF2F7384557` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id`);

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `FK_AB55E24F27E0FF8` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id`),
  ADD CONSTRAINT `FK_AB55E24F5DA14302` FOREIGN KEY (`id_tournois`) REFERENCES `tournois` (`id`);

--
-- Contraintes pour la table `reset_password_request`
--
ALTER TABLE `reset_password_request`
  ADD CONSTRAINT `FK_7CE748AA76ED395` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `tournois_equipe`
--
ALTER TABLE `tournois_equipe`
  ADD CONSTRAINT `FK_5E5796AC6D861B89` FOREIGN KEY (`equipe_id`) REFERENCES `equipe` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_5E5796AC752534C` FOREIGN KEY (`tournois_id`) REFERENCES `tournois` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_8D93D6492449BA15` FOREIGN KEY (`equipe`) REFERENCES `equipe` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
