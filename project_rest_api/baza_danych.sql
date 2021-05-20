-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Czas generowania: 13 Kwi 2021, 07:34
-- Wersja serwera: 8.0.13-4
-- Wersja PHP: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `UNaSLibajY`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `projekt`
--

CREATE TABLE `projekt` (
  `projekt_id` int(11) NOT NULL,
  `data_czas_utworzenia` datetime(6) NOT NULL,
  `data_oddania` date NOT NULL,
  `nazwa` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `opis` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `projekt`
--

INSERT INTO `projekt` (`projekt_id`, `data_czas_utworzenia`, `data_oddania`, `nazwa`, `opis`) VALUES
(1, '2021-04-12 12:21:18.273023', '2021-04-30', 'Tworzenie Rest API', 'stworzyc proste rest api'),
(2, '2021-04-12 03:10:08.172460', '2021-04-30', 'Projekt na studia', 'Stworzyc projekt na studia'),
(3, '2021-04-12 19:35:35.367507', '2021-04-30', 'Projekt z laboratorium', 'Wykonać projekt na laboratorium'),
(4, '2021-04-12 08:32:07.117460', '2021-04-30', 'Aplikacja mobilna', 'Napisać aplikacje mobilna');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `projekt_student`
--

CREATE TABLE `projekt_student` (
  `projekt_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `projekt_student`
--

INSERT INTO `projekt_student` (`projekt_id`, `student_id`) VALUES
(3, 1),
(1, 2),
(4, 3),
(2, 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `imie` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nazwisko` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nr_indeksu` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `stacjonarny` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `student`
--

INSERT INTO `student` (`student_id`, `email`, `imie`, `nazwisko`, `nr_indeksu`, `stacjonarny`) VALUES
(1, 'asd@asd.pl', 'Eliasz', 'Macedoński', '111222', b'1'),
(2, 'qwe@qwe.pl', 'Tomasz', 'Tomaszewski', '222333', b'1'),
(3, 'bnm@bnm.pl', 'Halina', 'Adamska', '444555', b'0'),
(4, 'tyu@tyu.pl', 'Robert', 'Robczyński', '666777', b'0');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user_data`
--

CREATE TABLE `user_data` (
  `id` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `login` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `user_data`
--

INSERT INTO `user_data` (`id`, `email`, `login`, `password`, `role`) VALUES
(1, 'mail@mail.pl', 'admin', '$2a$10$MW83JqMQi7l7TcereGOjBuMxN6vD2oA1wO981mZy8i0WdHL8F0YVy', 'ADMIN');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zadanie`
--

CREATE TABLE `zadanie` (
  `zadanie_id` int(11) NOT NULL,
  `dataczas_dodania` datetime(6) NOT NULL,
  `kolejnosc` int(11) DEFAULT NULL,
  `nazwa` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `opis` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `projekt_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `zadanie`
--

INSERT INTO `zadanie` (`zadanie_id`, `dataczas_dodania`, `kolejnosc`, `nazwa`, `opis`, `projekt_id`) VALUES
(1, '2021-04-15 07:21:17.281562', 1, 'Utworzyć projekt', 'Stworzyć projekt w android studio', 4),
(2, '2021-04-16 09:19:18.367258', 1, 'Utworzyć projekt', 'Stworzyć projekt rest api', 1),
(3, '2021-04-15 06:17:17.320882', 1, 'Zrobić specyfikacje', 'wykonać specyfikacje', 2),
(4, '2021-04-20 07:20:18.273585', 2, 'Napisać kod aplikacji', 'Napisać kod aplikacji', 2),
(5, '2021-04-27 09:22:13.367570', 3, 'Zrobić dokumentacje', 'Wykonać dokumentacje projektu', 2),
(6, '2021-04-15 06:18:14.226616', 1, 'Napisać kod aplikacji', 'Napisać kod aplikacji', 3),
(7, '2021-04-27 10:32:21.281609', 2, 'Napisać sprawozdanie', 'stworzyc sprawozdanie  kodu aplikacji', 3);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `projekt`
--
ALTER TABLE `projekt`
  ADD PRIMARY KEY (`projekt_id`);

--
-- Indeksy dla tabeli `projekt_student`
--
ALTER TABLE `projekt_student`
  ADD PRIMARY KEY (`projekt_id`,`student_id`),
  ADD KEY `FK2ebjqgpiwil7l8tsp0bf18u0w` (`student_id`);

--
-- Indeksy dla tabeli `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indeksy dla tabeli `user_data`
--
ALTER TABLE `user_data`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `zadanie`
--
ALTER TABLE `zadanie`
  ADD PRIMARY KEY (`zadanie_id`),
  ADD KEY `FKaupfb9wjo0o9fu7bm2s5tifid` (`projekt_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `projekt`
--
ALTER TABLE `projekt`
  MODIFY `projekt_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `zadanie`
--
ALTER TABLE `zadanie`
  MODIFY `zadanie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `projekt_student`
--
ALTER TABLE `projekt_student`
  ADD CONSTRAINT `FK2ebjqgpiwil7l8tsp0bf18u0w` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `FKewgsag67wtfolcpc3vbjf96ky` FOREIGN KEY (`projekt_id`) REFERENCES `projekt` (`projekt_id`);

--
-- Ograniczenia dla tabeli `zadanie`
--
ALTER TABLE `zadanie`
  ADD CONSTRAINT `FKaupfb9wjo0o9fu7bm2s5tifid` FOREIGN KEY (`projekt_id`) REFERENCES `projekt` (`projekt_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
