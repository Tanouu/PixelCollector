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
CREATE DATABASE IF NOT EXISTS `pixelcollector` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pixelcollector`;

-- Listage de la structure de table pixelcollector. admin
CREATE TABLE IF NOT EXISTS `admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3x1e18lmu2r0xekpql9xme0pp` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Listage des données de la table pixelcollector.admin : ~0 rows (environ)

-- Listage de la structure de table pixelcollector. auctions
CREATE TABLE IF NOT EXISTS `auctions` (
  `current_price` double NOT NULL,
  `end_date` date NOT NULL,
  `start_date` date NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nft_id` bigint(20) NOT NULL,
  `owner_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgupu8pibvwptwstx61bpcmpjc` (`owner_id`),
  CONSTRAINT `FKgupu8pibvwptwstx61bpcmpjc` FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Listage des données de la table pixelcollector.auctions : ~0 rows (environ)

-- Listage de la structure de table pixelcollector. collections
CREATE TABLE IF NOT EXISTS `collections` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_nft` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Listage des données de la table pixelcollector.collections : ~0 rows (environ)

-- Listage de la structure de table pixelcollector. nft
CREATE TABLE IF NOT EXISTS `nft` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `owner_id` bigint(20) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `rarity` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKahuvv187jbcewhkx17kkvj8u0` (`owner_id`),
  CONSTRAINT `FKahuvv187jbcewhkx17kkvj8u0` FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Listage des données de la table pixelcollector.nft : ~7 rows (environ)
INSERT INTO `nft` (`id`, `owner_id`, `photo`, `rarity`) VALUES
	(1, 2, 'Rare.png', 'rare'),
	(2, 1, 'PeuCommun.png', 'peu commun'),
	(3, 2, 'Commun.png', 'commun'),
	(4, 2, 'Legendaire.png', 'légendaire'),
	(5, 2, 'Rare2.png', 'rare'),
	(6, 2, 'Commun2.png', 'commun'),
	(7, 2, 'Epique.png', 'epique'),
	(8, 3, 'Legendaire.png', 'légendaire'),
	(9, 4, 'Epique.png', 'epique'),
	(10, 3, 'Commun.png', 'commun');

-- Listage de la structure de table pixelcollector. roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Listage des données de la table pixelcollector.roles : ~2 rows (environ)
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'USER'),
	(2, 'ADMIN');

-- Listage de la structure de table pixelcollector. sell
CREATE TABLE IF NOT EXISTS `sell` (
  `prix` double DEFAULT NULL,
  `date_buy` datetime(6) DEFAULT NULL,
  `date_sale` datetime(6) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `nft_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnp9t95isqutsw8cxwsc3hod5i` (`nft_id`),
  CONSTRAINT `FKnp9t95isqutsw8cxwsc3hod5i` FOREIGN KEY (`nft_id`) REFERENCES `nft` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Listage des données de la table pixelcollector.sell : ~7 rows (environ)
INSERT INTO `sell` (`prix`, `date_buy`, `date_sale`, `id`, `nft_id`) VALUES
	(1000, NULL, '2024-04-22 14:24:52.000000', 1, 1),
	(10, '2024-04-22 15:05:10.000000', '2024-04-22 15:05:00.000000', 2, 2),
	(500, NULL, '2024-04-22 16:39:30.000000', 3, 3),
	(900, NULL, '2024-04-22 16:42:52.000000', 4, 4),
	(800, NULL, '2024-04-22 16:43:07.000000', 5, 5),
	(700, NULL, '2024-04-22 16:43:20.000000', 6, 6),
	(600, NULL, '2024-04-22 16:43:34.000000', 7, 7),
	(300, NULL, '2024-04-25 15:53:17.000000', 8, 10);

-- Listage de la structure de table pixelcollector. sell_seq
CREATE TABLE IF NOT EXISTS `sell_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Listage des données de la table pixelcollector.sell_seq : ~1 rows (environ)
INSERT INTO `sell_seq` (`next_val`) VALUES
	(1);

-- Listage de la structure de table pixelcollector. support_ticket
CREATE TABLE IF NOT EXISTS `support_ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `creation_date` varchar(255) NOT NULL,
  `message` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Listage des données de la table pixelcollector.support_ticket : ~0 rows (environ)

-- Listage de la structure de table pixelcollector. users
CREATE TABLE IF NOT EXISTS `users` (
  `2fa_enabled` bit(1) NOT NULL,
  `birth_date` date NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `wallet_address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK_l8ei97je165nvih6t685vwx5d` (`wallet_address`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Listage des données de la table pixelcollector.users : ~2 rows (environ)
INSERT INTO `users` (`2fa_enabled`, `birth_date`, `id`, `email`, `password`, `photo`, `username`, `wallet_address`) VALUES
	(b'0', '2002-12-17', 1, 'ethanpacheco.t@gmail.com', '$2a$10$P9xNS7GJSohjHGWe3uOw.OtEiBiZvdBPQ8NZDchoCTLUAwS.u9mka', 'PeuCommun.png', 'Tanouu', '0fgfdfgdghggjkghkhkhhb'),
	(b'1', '2002-12-17', 2, 'p.tanou@outlook.fr', '$2a$10$VSyg4gtb4xKYfuhx0swZIOlIRf4FOVRAsGFH5Pe11m8uv7za1vHXK', 'Legendaire.png', 'Tanou', '0fgfdfgdgf'),
	(b'1', '1111-11-11', 3, 'cynthia@cycy.com', '$2a$10$xkOORo2jOWl7GpcxBi9vquSOj5kfQe/pg6RXK/VkeFIILXMKQembe', 'Commun.png', 'Cycy', 'jkhjklhjklghljkh'),
	(b'1', '1111-11-11', 4, 'jc@jc.com', '$2a$10$0MJuU2atGbw1oJ0YpPg5ReF6UuHis9v52mPKd6W7.ejjy8QkVFZmW', 'Epique.png', 'JC', 'jklhljkhljkhljkh'),
	(b'1', '1111-11-11', 5, 'alexis@email.com', '$2a$10$9YptLO8PgP0pe/MZmDfw0.RC2ARJdLDha2MHc3TqU31BM7KxZRtPe', 'Rare2.png', 'Alexis', 'jkljklmjkljpljiopjuq');

-- Listage de la structure de table pixelcollector. user_roles
CREATE TABLE IF NOT EXISTS `user_roles` (
  `role_id` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Listage des données de la table pixelcollector.user_roles : ~2 rows (environ)
INSERT INTO `user_roles` (`role_id`, `user_id`) VALUES
	(1, 2),
	(1, 1),
	(1, 3),
	(1, 4),
	(1, 5);

-- Listage de la structure de déclencheur pixelcollector. AfterUserInsert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER';
DELIMITER //
CREATE TRIGGER AfterUserInsert AFTER INSERT ON users
FOR EACH ROW
BEGIN
    INSERT INTO user_roles (user_id, role_id) VALUES (NEW.id, 1);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
