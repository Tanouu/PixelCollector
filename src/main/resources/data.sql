-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           5.7.36 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Listage de la structure de la base pour pixelcollector
CREATE DATABASE IF NOT EXISTS `pixelcollector` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pixelcollector`;

-- Listage de la structure de table pixelcollector. admin
CREATE TABLE IF NOT EXISTS `admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3x1e18lmu2r0xekpql9xme0pp` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table pixelcollector.admin : ~0 rows (environ)

-- Listage de la structure de table pixelcollector. auctions
CREATE TABLE IF NOT EXISTS `auctions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `current_price` double NOT NULL,
  `end_date` date NOT NULL,
  `nft_id` bigint(20) NOT NULL,
  `start_date` date NOT NULL,
  `owner_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgupu8pibvwptwstx61bpcmpjc` (`owner_id`),
  CONSTRAINT `FKgupu8pibvwptwstx61bpcmpjc` FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table pixelcollector.auctions : ~0 rows (environ)

-- Listage de la structure de table pixelcollector. collections
CREATE TABLE IF NOT EXISTS `collections` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_nft` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table pixelcollector.collections : ~0 rows (environ)

-- Listage de la structure de table pixelcollector. nft
CREATE TABLE IF NOT EXISTS `nft` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `photo` varchar(255) NOT NULL,
  `rarity` varchar(255) NOT NULL,
  `owner_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKahuvv187jbcewhkx17kkvj8u0` (`owner_id`),
  CONSTRAINT `FKahuvv187jbcewhkx17kkvj8u0` FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Listage des données de la table pixelcollector.nft : ~6 rows (environ)
INSERT INTO `nft` (`id`, `photo`, `rarity`, `owner_id`) VALUES
	(1, 'Rare.png', 'rare', 2),
	(2, 'PeuCommun.png', 'peu commun', 1),
	(3, 'Commun.png', 'commun', 2),
	(4, 'Legendaire.png', 'légendaire', 2),
	(5, 'Rare2.png', 'rare', 2),
	(6, 'Commun2.png', 'commun', 2),
	(7, 'Epique.png', 'epique', 2);

-- Listage de la structure de table pixelcollector. roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Listage des données de la table pixelcollector.roles : ~2 rows (environ)
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'USER'),
	(2, 'ADMIN');

-- Listage de la structure de table pixelcollector. sell
CREATE TABLE IF NOT EXISTS `sell` (
  `id` bigint(20) NOT NULL,
  `date_vente` datetime(6) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `utilisateur_id` bigint(20) DEFAULT NULL,
  `nft_id` bigint(20) DEFAULT NULL,
  `date_sale` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa4riyib05b9g9csx0ddb9wt2o` (`utilisateur_id`),
  KEY `FKnp9t95isqutsw8cxwsc3hod5i` (`nft_id`),
  CONSTRAINT `FKa4riyib05b9g9csx0ddb9wt2o` FOREIGN KEY (`utilisateur_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKnp9t95isqutsw8cxwsc3hod5i` FOREIGN KEY (`nft_id`) REFERENCES `nft` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table pixelcollector.sell : ~6 rows (environ)
INSERT INTO `sell` (`id`, `date_vente`, `prix`, `nft_id`, `date_sale`) VALUES
	(1, '2024-04-22 14:24:52.000000', 1000, 1, NULL),
	(2, '2024-04-22 15:05:00.000000', 10, 2, '2024-04-22 15:05:10.000000'),
	(3, '2024-04-22 16:39:30.000000', 500, 3, NULL),
	(4, '2024-04-22 16:42:52.000000', 900, 4, NULL),
	(5, '2024-04-22 16:43:07.000000', 800, 5, NULL),
	(6, '2024-04-22 16:43:20.000000', 700, 6, NULL),
	(7, '2024-04-22 16:43:34.000000', 600, 7, NULL);

-- Listage de la structure de table pixelcollector. sell_seq
CREATE TABLE IF NOT EXISTS `sell_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table pixelcollector.sell_seq : ~0 rows (environ)
INSERT INTO `sell_seq` (`next_val`) VALUES
	(1),
	(1);

-- Listage de la structure de table pixelcollector. support_ticket
CREATE TABLE IF NOT EXISTS `support_ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_date` varchar(255) NOT NULL,
  `message` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table pixelcollector.support_ticket : ~0 rows (environ)

-- Listage de la structure de table pixelcollector. users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `2fa_enabled` bit(1) NOT NULL,
  `username` varchar(255) NOT NULL,
  `wallet_address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK_l8ei97je165nvih6t685vwx5d` (`wallet_address`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Listage des données de la table pixelcollector.users : ~11 rows (environ)
INSERT INTO `users` (`id`, `birth_date`, `email`, `password`, `photo`, `2fa_enabled`, `username`, `wallet_address`) VALUES
	(1, '2002-12-17', 'ethanpacheco.t@gmail.com', '$2a$10$P9xNS7GJSohjHGWe3uOw.OtEiBiZvdBPQ8NZDchoCTLUAwS.u9mka', 'oui', b'0', 'Tanouu', '0fgfdfgdghggjkghkhkhhb'),
	(2, '2002-12-17', 'p.tanou@outlook.fr', '$2a$10$VSyg4gtb4xKYfuhx0swZIOlIRf4FOVRAsGFH5Pe11m8uv7za1vHXK', 'oui', b'1', 'Tanou', '0fgfdfgdgf');

-- Listage de la structure de table pixelcollector. user_roles
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table pixelcollector.user_roles : ~2 rows (environ)
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
	(2, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
