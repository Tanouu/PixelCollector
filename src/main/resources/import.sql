INSERT INTO `users` (`id`, `birth_date`, `email`, `password`, `photo`, `2fa_enabled`, `username`, `wallet_address`) VALUES (1, '2002-12-17', 'ethanpacheco.t@gmail.com', '$2a$10$P9xNS7GJSohjHGWe3uOw.OtEiBiZvdBPQ8NZDchoCTLUAwS.u9mka', 'oui', b'0', 'Tanouu', '0fgfdfgdghggjkghkhkhhb');
INSERT INTO `users` (`id`, `birth_date`, `email`, `password`, `photo`, `2fa_enabled`, `username`, `wallet_address`) VALUES (2, '2002-12-17', 'p.tanou@outlook.fr', '$2a$10$VSyg4gtb4xKYfuhx0swZIOlIRf4FOVRAsGFH5Pe11m8uv7za1vHXK', 'oui', b'1', 'Tanou', '0fgfdfgdgf');

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES (2, 1);

INSERT INTO `roles` (`id`, `name`) VALUES (1, 'USER');
INSERT INTO `roles` (`id`, `name`) VALUES (2, 'ADMIN');

INSERT INTO `nft` (`id`, `photo`, `rarity`, `owner_id`) VALUES (1, 'Rare.png', 'rare', 2);
INSERT INTO `nft` (`id`, `photo`, `rarity`, `owner_id`) VALUES (2, 'PeuCommun.png', 'peu commun', 1);
INSERT INTO `nft` (`id`, `photo`, `rarity`, `owner_id`) VALUES (3, 'Commun.png', 'commun', 2);
INSERT INTO `nft` (`id`, `photo`, `rarity`, `owner_id`) VALUES (4, 'Legendaire.png', 'légendaire', 2);
INSERT INTO `nft` (`id`, `photo`, `rarity`, `owner_id`) VALUES (5, 'Rare2.png', 'rare', 2);
INSERT INTO `nft` (`id`, `photo`, `rarity`, `owner_id`) VALUES (6, 'Commun2.png', 'commun', 2);
INSERT INTO `nft` (`id`, `photo`, `rarity`, `owner_id`) VALUES (7, 'Epique.png', 'epique', 2);


INSERT INTO `sell` (`id`, `date_sale`, `prix`, `nft_id`, `date_buy`) VALUES (1, '2024-04-22 14:24:52.000000', 1000, 1, NULL);
INSERT INTO `sell` (`id`, `date_sale`, `prix`, `nft_id`, `date_buy`) VALUES (2, '2024-04-22 15:05:00.000000', 10, 2, '2024-04-22 15:05:10.000000');
INSERT INTO `sell` (`id`, `date_sale`, `prix`, `nft_id`, `date_buy`) VALUES (3, '2024-04-22 16:39:30.000000', 500, 3, NULL);
INSERT INTO `sell` (`id`, `date_sale`, `prix`, `nft_id`, `date_buy`) VALUES (4, '2024-04-22 16:42:52.000000', 900, 4, NULL);
INSERT INTO `sell` (`id`, `date_sale`, `prix`, `nft_id`, `date_buy`) VALUES (5, '2024-04-22 16:43:07.000000', 800, 5, NULL);
INSERT INTO `sell` (`id`, `date_sale`, `prix`, `nft_id`, `date_buy`) VALUES (6, '2024-04-22 16:43:20.000000', 700, 6, NULL);
INSERT INTO `sell` (`id`, `date_sale`, `prix`, `nft_id`, `date_buy`) VALUES (7, '2024-04-22 16:43:34.000000', 600, 7, NULL);
