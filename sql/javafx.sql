-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Gostitelj: 127.0.0.1
-- Čas nastanka: 09. jan 2023 ob 00.02
-- Različica strežnika: 10.4.17-MariaDB
-- Različica PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Zbirka podatkov: `javafx`
--

-- --------------------------------------------------------

--
-- Struktura tabele `followers_following`
--

CREATE TABLE `followers_following` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_friend` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `followers_following`
--

INSERT INTO `followers_following` (`id`, `id_user`, `id_friend`, `created_at`) VALUES
(188, 2, 3, '2022-12-22 09:49:26'),
(228, 3, 7, '2022-12-26 15:12:54'),
(241, 1, 3, '2022-12-27 18:03:00'),
(242, 7, 3, '2022-12-27 18:23:16'),
(243, 7, 1, '2022-12-27 18:23:36'),
(244, 9, 1, '2022-12-27 18:43:44'),
(245, 9, 3, '2022-12-27 18:43:49'),
(247, 6, 3, '2022-12-28 20:44:23'),
(257, 1, 7, '2022-12-29 18:00:33'),
(263, 3, 1, '2022-12-29 21:05:51'),
(265, 4, 1, '2022-12-31 22:19:10'),
(267, 4, 3, '2022-12-31 22:19:51'),
(285, 3, 2, '2022-12-31 23:46:25'),
(289, 1, 2, '2022-12-31 23:47:09'),
(292, 5, 1, '2022-12-31 23:52:34'),
(293, 5, 2, '2022-12-31 23:52:37'),
(294, 5, 6, '2022-12-31 23:52:40'),
(295, 5, 7, '2022-12-31 23:52:43'),
(301, 5, 8, '2022-12-31 23:54:10'),
(308, 3, 5, '2022-12-31 23:57:27'),
(312, 5, 3, '2023-01-01 00:02:36'),
(313, 8, 3, '2023-01-01 00:04:00'),
(327, 1, 6, '2023-01-01 11:44:30');

-- --------------------------------------------------------

--
-- Struktura tabele `levels`
--

CREATE TABLE `levels` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `picture` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `map` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `levels`
--

INSERT INTO `levels` (`id`, `name`, `picture`, `map`, `created_at`) VALUES
(35, 'Training 1', 'level1.jpg', 'map1.tmx', '2023-01-04 09:06:26'),
(36, 'Training 2', 'level2.jpg', 'map2.tmx', '2023-01-04 09:06:26'),
(37, 'Training 3', 'level3.jpg', 'map3.tmx', '2023-01-04 09:06:26'),
(38, 'V Is For Village', 'level4.jpg', 'map4.tmx', '2023-01-04 09:06:26'),
(39, 'Baddie Bunker 1', 'level5.jpg', 'map5.tmx', '2023-01-04 09:06:26'),
(40, 'Nature Calls', 'level6.jpg', 'map6.tmx', '2023-01-04 09:06:26'),
(41, 'Hostage Hotel', 'level7.jpg', 'map7.tmx', '2023-01-04 09:06:26'),
(42, 'Monkey About', 'level8.jpg', 'map8.tmx', '2023-01-04 09:06:26'),
(43, 'Bad Medicine', 'level9.jpg', 'map9.tmx', '2023-01-04 09:06:26'),
(44, 'Baddie Bunker 2', 'level10.jpg', 'map10.tmx', '2023-01-04 09:06:26'),
(45, 'Pet Detective', 'level11.jpg', 'map11.tmx', '2023-01-04 09:06:26'),
(46, 'Beauty Spot', 'level12.jpg', 'map12.tmx', '2023-01-04 09:06:26'),
(47, 'Candy shop', 'level13.jpg', 'map13.tmx', '2023-01-04 09:06:26'),
(48, 'Sunrise Lobby', 'level14.jpg', 'map14.tmx', '2023-01-04 09:06:26'),
(49, 'Dark Blue Forest', 'level15.jpg', 'map15.tmx', '2023-01-04 09:06:26'),
(50, 'After Life', 'level16.jpg', 'map16.tmx', '2023-01-04 09:06:26'),
(51, 'Save Yourself', 'level17.jpg', 'map17.tmx', '2023-01-04 09:06:26'),
(52, 'Please Help Me', 'level18.jpg', 'map18.tmx', '2023-01-04 09:06:26'),
(53, 'Carantania', 'level19.jpg', 'map19.tmx', '2023-01-04 09:06:26'),
(54, 'Night Invasion', 'level20.jpg', 'map20.tmx', '2023-01-04 09:06:26');

-- --------------------------------------------------------

--
-- Struktura tabele `levels_completed`
--

CREATE TABLE `levels_completed` (
  `id` int(11) NOT NULL,
  `id_level` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `completed` enum('0','1','2') COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `levels_completed`
--

INSERT INTO `levels_completed` (`id`, `id_level`, `id_user`, `completed`, `created_at`) VALUES
(1, 35, 1, '2', '2023-01-04 09:08:31'),
(2, 35, 2, '2', '2023-01-04 09:08:31'),
(3, 35, 3, '1', '2023-01-04 09:08:31'),
(4, 35, 4, '2', '2023-01-04 09:08:31'),
(5, 35, 5, '2', '2023-01-04 09:08:31'),
(6, 35, 6, '2', '2023-01-04 09:08:31'),
(7, 35, 7, '2', '2023-01-04 09:08:31'),
(8, 35, 8, '2', '2023-01-04 09:08:31'),
(9, 35, 9, '2', '2023-01-04 09:08:31'),
(11, 36, 3, '1', '2023-01-04 09:08:31'),
(12, 37, 3, '2', '2023-01-04 09:08:31');

-- --------------------------------------------------------

--
-- Struktura tabele `levels_statistics`
--

CREATE TABLE `levels_statistics` (
  `id` int(11) NOT NULL,
  `id_level` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `used_time` time NOT NULL,
  `current_score` int(11) NOT NULL,
  `max_score` int(11) NOT NULL,
  `deaths` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Struktura tabele `messages`
--

CREATE TABLE `messages` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_friend` int(11) NOT NULL,
  `text` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `messages`
--

INSERT INTO `messages` (`id`, `id_user`, `id_friend`, `text`, `created_at`) VALUES
(1, 3, 1, 'Hej', '2022-12-18 14:25:45'),
(2, 3, 1, 'Kako si?', '2022-12-18 14:26:14'),
(3, 1, 3, 'Vredu pa ti?', '2022-12-18 14:26:33'),
(4, 3, 1, 'Tudi v redu', '2022-12-18 14:26:53'),
(5, 3, 1, 'Kaj počneš?', '2022-12-18 14:27:03'),
(6, 1, 3, 'Nič pa ti', '2022-12-18 14:27:17'),
(7, 3, 1, 'Kako nič?', '2022-12-18 14:38:42'),
(8, 3, 1, 'To je pa zanimivo', '2022-12-18 14:38:57'),
(9, 1, 3, 'Test1', '2022-12-18 18:11:45'),
(10, 3, 1, 'Test2', '2022-12-18 18:14:12'),
(11, 3, 1, 'Test3', '2022-12-18 18:34:42'),
(12, 3, 1, 'Test4', '2022-12-18 18:35:41'),
(13, 1, 3, 'Test5', '2022-12-18 18:37:35'),
(14, 1, 3, 'Test6', '2022-12-18 18:42:41'),
(15, 1, 3, 'Test7', '2022-12-18 18:44:30'),
(16, 1, 3, 'Test8', '2022-12-18 18:50:15'),
(17, 4, 3, 'Hello', '2022-12-27 15:34:36'),
(18, 4, 3, 'How are you?', '2022-12-27 15:34:46'),
(19, 3, 4, 'Im good', '2022-12-27 15:35:08'),
(20, 3, 4, 'How are you?', '2022-12-27 15:35:14');

-- --------------------------------------------------------

--
-- Struktura tabele `messenger`
--

CREATE TABLE `messenger` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_friend` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `messenger`
--

INSERT INTO `messenger` (`id`, `id_user`, `id_friend`, `created_at`) VALUES
(1, 3, 1, '2022-12-18 14:09:40'),
(2, 1, 3, '2022-12-18 14:24:03'),
(3, 3, 4, '2022-12-27 15:32:00'),
(4, 4, 3, '2022-12-27 15:32:09');

-- --------------------------------------------------------

--
-- Struktura tabele `notifications`
--

CREATE TABLE `notifications` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_friend` int(11) NOT NULL,
  `type` enum('0') COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `notifications`
--

INSERT INTO `notifications` (`id`, `id_user`, `id_friend`, `type`, `created_at`) VALUES
(110, 2, 3, '0', '2022-12-22 10:01:50'),
(151, 3, 7, '0', '2022-12-26 15:12:54'),
(155, 2, 1, '0', '2022-12-27 15:57:33'),
(164, 1, 3, '0', '2022-12-27 18:03:00'),
(165, 7, 3, '0', '2022-12-27 18:23:16'),
(167, 9, 1, '0', '2022-12-27 18:43:44'),
(168, 9, 3, '0', '2022-12-27 18:43:49'),
(170, 6, 3, '0', '2022-12-28 20:44:23'),
(180, 1, 7, '0', '2022-12-29 18:00:33'),
(186, 3, 1, '0', '2022-12-29 21:05:51'),
(188, 4, 1, '0', '2022-12-31 22:19:10'),
(190, 4, 3, '0', '2022-12-31 22:19:51'),
(212, 1, 2, '0', '2022-12-31 23:47:09'),
(215, 5, 1, '0', '2022-12-31 23:52:34'),
(217, 5, 6, '0', '2022-12-31 23:52:40'),
(218, 5, 7, '0', '2022-12-31 23:52:43'),
(224, 5, 8, '0', '2022-12-31 23:54:10'),
(231, 3, 5, '0', '2022-12-31 23:57:27'),
(235, 5, 3, '0', '2023-01-01 00:02:36'),
(236, 8, 3, '0', '2023-01-01 00:04:00'),
(250, 1, 6, '0', '2023-01-01 11:44:30');

-- --------------------------------------------------------

--
-- Struktura tabele `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `role` enum('ADMIN','USER') COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `roles`
--

INSERT INTO `roles` (`id`, `id_user`, `role`) VALUES
(1, 3, 'USER'),
(2, 1, 'USER'),
(3, 2, 'USER'),
(4, 4, 'USER'),
(5, 5, 'USER'),
(6, 6, 'USER'),
(7, 7, 'USER'),
(8, 8, 'USER'),
(9, 9, 'USER'),
(10, 10, 'ADMIN');

-- --------------------------------------------------------

--
-- Struktura tabele `settings`
--

CREATE TABLE `settings` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `music` float NOT NULL DEFAULT 100,
  `sound_effect` float NOT NULL DEFAULT 100
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `settings`
--

INSERT INTO `settings` (`id`, `id_user`, `music`, `sound_effect`) VALUES
(1, 1, 100, 100),
(2, 2, 100, 100),
(3, 3, 100, 100),
(4, 4, 100, 100),
(5, 5, 100, 100),
(7, 6, 100, 100),
(8, 7, 100, 100),
(9, 8, 100, 100),
(10, 9, 100, 100);

-- --------------------------------------------------------

--
-- Struktura tabele `skins`
--

CREATE TABLE `skins` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `picture` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Odloži podatke za tabelo `skins`
--

INSERT INTO `skins` (`id`, `name`, `picture`) VALUES
(1, 'Basic Skin', 'player-basic'),
(2, 'Green Skin', 'player-green'),
(3, 'Blue Skin', 'player-blue'),
(4, 'Black Skin', 'player-black'),
(5, 'White Skin', 'player-white'),
(6, 'Purple Skin', 'player-purple');

-- --------------------------------------------------------

--
-- Struktura tabele `skins_owned`
--

CREATE TABLE `skins_owned` (
  `id` int(11) NOT NULL,
  `id_skin` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Odloži podatke za tabelo `skins_owned`
--

INSERT INTO `skins_owned` (`id`, `id_skin`, `id_user`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6),
(7, 1, 7),
(8, 1, 8),
(9, 1, 9),
(10, 2, 3);

-- --------------------------------------------------------

--
-- Struktura tabele `statistics`
--

CREATE TABLE `statistics` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `rank` int(11) NOT NULL,
  `current_xp` int(11) NOT NULL,
  `next_level_xp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `statistics`
--

INSERT INTO `statistics` (`id`, `id_user`, `rank`, `current_xp`, `next_level_xp`) VALUES
(1, 1, 6, 35, 600),
(2, 2, 3, 75, 300),
(3, 3, 2, 55, 200),
(4, 4, 1, 80, 100),
(5, 5, 4, 80, 400),
(6, 6, 9, 450, 900),
(7, 7, 2, 40, 200),
(8, 8, 5, 315, 500),
(9, 9, 6, 589, 600);

-- --------------------------------------------------------

--
-- Struktura tabele `tiles`
--

CREATE TABLE `tiles` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `size` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Odloži podatke za tabelo `tiles`
--

INSERT INTO `tiles` (`id`, `name`, `size`) VALUES
(1, 'cake.png', 70),
(2, 'candy.png', 70),
(3, 'castle.png', 70),
(4, 'choco.png', 70),
(5, 'decorations.png', 70),
(6, 'dirt.png', 70),
(7, 'grass.png', 70),
(8, 'ice.png', 70),
(9, 'industrial.png', 70),
(10, 'metal.png', 70),
(11, 'purple.png', 70);

-- --------------------------------------------------------

--
-- Struktura tabele `units`
--

CREATE TABLE `units` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `health_points` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `units`
--

INSERT INTO `units` (`id`, `name`, `health_points`) VALUES
(1, 'Gun Master', 100),
(2, 'Rifle Guy', 120),
(3, 'Veteran', 200),
(4, 'Tank Master', 500),
(5, 'Commando', 350),
(6, 'Helli-G', 400),
(7, 'Jeep Master', 250);

-- --------------------------------------------------------

--
-- Struktura tabele `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `picture` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email_confirmed` enum('0','1') COLLATE utf8_unicode_ci NOT NULL,
  `email_token` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `email`, `password`, `picture`, `email_confirmed`, `email_token`) VALUES
(1, 'Gasper Pintar', 'q', 'gasper@example.com', 'q', '1-profile-picture.jpg', '0', ''),
(2, 'Mr junk', 'Mr-junk', 'mrjunk@example.com', 'qwqwqwqw', 'basic-picture.jpg', '0', ''),
(3, 'Urban Pintar', 'urban4', 'urban@example.com', 'qwqwqwqw', '3-profile-picture.jpg', '0', ''),
(4, 'Furi Naturi', 'furi-naturi', 'furinaturi@example.com', 'qwqwqwqw', 'basic-picture.jpg', '0', ''),
(5, 'Jaki Kakaki', 'Jaki-Kakaki', 'jakikakaki@example.com', 'qwqwqwqw', 'basic-picture.jpg', '0', ''),
(6, 'Mali Balani', 'malibalani', 'malibalani@example.com', 'qwqwqwqw', 'basic-picture.jpg', '0', ''),
(7, 'Vampirus Disurius', 'vampirus12', 'vampirus@example.com', 'qwqwqwqw', 'basic-picture.jpg', '0', ''),
(8, 'Mr Favoriti', 'favoritimr', 'favoriti@example.com', 'qwqwqwqw', 'basic-picture.jpg', '0', ''),
(9, 'Jato Patato', 'jatopatato123', 'jato@example.com', 'qwqwqwqw', 'basic-picture.jpg', '0', ''),
(10, '', 'admin', '', 'qwqw', '', '0', '');

-- --------------------------------------------------------

--
-- Struktura tabele `weapon_statistics`
--

CREATE TABLE `weapon_statistics` (
  `id` int(11) NOT NULL,
  `katana` int(11) NOT NULL,
  `compact_45` int(11) NOT NULL,
  `knife` int(11) NOT NULL,
  `hands` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Odloži podatke za tabelo `weapon_statistics`
--

INSERT INTO `weapon_statistics` (`id`, `katana`, `compact_45`, `knife`, `hands`, `id_user`) VALUES
(1, 30, 14, 33, 30, 1),
(2, 15, 10, 13, 12, 2),
(3, 10, 6, 15, 10, 3),
(4, 0, 0, 0, 0, 4),
(5, 0, 0, 0, 0, 5),
(6, 0, 0, 0, 0, 6),
(7, 0, 0, 0, 0, 7),
(8, 0, 0, 0, 0, 8),
(9, 0, 0, 0, 0, 9);

--
-- Indeksi zavrženih tabel
--

--
-- Indeksi tabele `followers_following`
--
ALTER TABLE `followers_following`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_friend_user` (`id_friend`);

--
-- Indeksi tabele `levels`
--
ALTER TABLE `levels`
  ADD PRIMARY KEY (`id`);

--
-- Indeksi tabele `levels_completed`
--
ALTER TABLE `levels_completed`
  ADD PRIMARY KEY (`id`),
  ADD KEY `LEVELS_USERS_LEVEL` (`id_level`),
  ADD KEY `LEVELS_USERS_USERS` (`id_user`);

--
-- Indeksi tabele `levels_statistics`
--
ALTER TABLE `levels_statistics`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_level` (`id_level`);

--
-- Indeksi tabele `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_friend` (`id_friend`);

--
-- Indeksi tabele `messenger`
--
ALTER TABLE `messenger`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_friend` (`id_friend`);

--
-- Indeksi tabele `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_friend_user` (`id_friend`);

--
-- Indeksi tabele `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ROLES_USERS` (`id_user`);

--
-- Indeksi tabele `settings`
--
ALTER TABLE `settings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `SETTINGS_USER` (`id_user`);

--
-- Indeksi tabele `skins`
--
ALTER TABLE `skins`
  ADD PRIMARY KEY (`id`);

--
-- Indeksi tabele `skins_owned`
--
ALTER TABLE `skins_owned`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_skin` (`id_skin`),
  ADD KEY `id_user` (`id_user`);

--
-- Indeksi tabele `statistics`
--
ALTER TABLE `statistics`
  ADD PRIMARY KEY (`id`),
  ADD KEY `STATISTICS_USERS` (`id_user`) USING BTREE;

--
-- Indeksi tabele `tiles`
--
ALTER TABLE `tiles`
  ADD PRIMARY KEY (`id`);

--
-- Indeksi tabele `units`
--
ALTER TABLE `units`
  ADD PRIMARY KEY (`id`);

--
-- Indeksi tabele `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indeksi tabele `weapon_statistics`
--
ALTER TABLE `weapon_statistics`
  ADD PRIMARY KEY (`id`),
  ADD KEY `WEAPON_STATISTICS_USERS` (`id_user`);

--
-- AUTO_INCREMENT zavrženih tabel
--

--
-- AUTO_INCREMENT tabele `followers_following`
--
ALTER TABLE `followers_following`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=328;

--
-- AUTO_INCREMENT tabele `levels`
--
ALTER TABLE `levels`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT tabele `levels_completed`
--
ALTER TABLE `levels_completed`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT tabele `levels_statistics`
--
ALTER TABLE `levels_statistics`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT tabele `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT tabele `messenger`
--
ALTER TABLE `messenger`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT tabele `notifications`
--
ALTER TABLE `notifications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=251;

--
-- AUTO_INCREMENT tabele `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT tabele `settings`
--
ALTER TABLE `settings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT tabele `skins`
--
ALTER TABLE `skins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT tabele `skins_owned`
--
ALTER TABLE `skins_owned`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT tabele `statistics`
--
ALTER TABLE `statistics`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT tabele `tiles`
--
ALTER TABLE `tiles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT tabele `units`
--
ALTER TABLE `units`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT tabele `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT tabele `weapon_statistics`
--
ALTER TABLE `weapon_statistics`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Omejitve tabel za povzetek stanja
--

--
-- Omejitve za tabelo `followers_following`
--
ALTER TABLE `followers_following`
  ADD CONSTRAINT `followers_following_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `followers_following_ibfk_2` FOREIGN KEY (`id_friend`) REFERENCES `users` (`id`);

--
-- Omejitve za tabelo `levels_completed`
--
ALTER TABLE `levels_completed`
  ADD CONSTRAINT `LEVELS_USERS_LEVEL` FOREIGN KEY (`id_level`) REFERENCES `levels` (`id`),
  ADD CONSTRAINT `LEVELS_USERS_USERS` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

--
-- Omejitve za tabelo `levels_statistics`
--
ALTER TABLE `levels_statistics`
  ADD CONSTRAINT `levels_statistics_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `levels_statistics_ibfk_2` FOREIGN KEY (`id_level`) REFERENCES `levels` (`id`);

--
-- Omejitve za tabelo `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `messages_ibfk_2` FOREIGN KEY (`id_friend`) REFERENCES `users` (`id`);

--
-- Omejitve za tabelo `messenger`
--
ALTER TABLE `messenger`
  ADD CONSTRAINT `messenger_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `messenger_ibfk_2` FOREIGN KEY (`id_friend`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `messenger_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `messenger_ibfk_4` FOREIGN KEY (`id_friend`) REFERENCES `users` (`id`);

--
-- Omejitve za tabelo `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `notifications_ibfk_2` FOREIGN KEY (`id_friend`) REFERENCES `users` (`id`);

--
-- Omejitve za tabelo `roles`
--
ALTER TABLE `roles`
  ADD CONSTRAINT `ROLES_USERS` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

--
-- Omejitve za tabelo `settings`
--
ALTER TABLE `settings`
  ADD CONSTRAINT `SETTINGS_USER` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

--
-- Omejitve za tabelo `skins_owned`
--
ALTER TABLE `skins_owned`
  ADD CONSTRAINT `skins_owned_ibfk_1` FOREIGN KEY (`id_skin`) REFERENCES `skins` (`id`),
  ADD CONSTRAINT `skins_owned_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

--
-- Omejitve za tabelo `statistics`
--
ALTER TABLE `statistics`
  ADD CONSTRAINT `statistics_users` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

--
-- Omejitve za tabelo `weapon_statistics`
--
ALTER TABLE `weapon_statistics`
  ADD CONSTRAINT `WEAPON_STATISTICS_USERS` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
