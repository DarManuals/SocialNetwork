-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Июл 30 2016 г., 13:36
-- Версия сервера: 10.1.13-MariaDB
-- Версия PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `socnet`
--

-- --------------------------------------------------------

--
-- Структура таблицы `friendship`
--

CREATE TABLE `friendship` (
  `friendship_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `read_user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `friendship`
--

INSERT INTO `friendship` (`friendship_id`, `user_id`, `read_user_id`) VALUES
(1, 1, 6),
(2, 1, 10),
(3, 8, 1),
(4, 16, 1),
(6, 16, 6),
(10, 1, 17),
(11, 16, 17),
(12, 1, 16);

-- --------------------------------------------------------

--
-- Структура таблицы `posts`
--

CREATE TABLE `posts` (
  `post_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `post_msg` text NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `posts`
--

INSERT INTO `posts` (`post_id`, `user_id`, `post_msg`, `date`) VALUES
(9, 1, 'текст на русском. запись директ из бд', '2016-07-25 13:52:33'),
(13, 1, 'руские буквы', '2016-07-25 13:57:45'),
(14, 1, 'Очередной тест', '2016-07-25 15:27:11'),
(15, 2, 'Test post msg from user', '2016-07-25 15:48:12'),
(16, 1, 'sefsef', '2016-07-25 16:12:05'),
(17, 7, 'User', '2016-07-25 17:29:58'),
(19, 1, 'admin', '2016-07-25 18:07:56'),
(21, 1, 'after all', '2016-07-25 18:29:40'),
(22, 10, 'test from mobile', '2016-07-26 00:04:44'),
(25, 17, 'Первая публикация', '2016-07-26 01:40:43'),
(28, 16, 'Новый тестовый текст', '2016-07-28 15:01:08'),
(29, 18, 'Первый пост', '2016-07-29 22:23:33'),
(30, 16, 'Очередной тест', '2016-07-29 22:36:55'),
(31, 16, '1', '2016-07-30 00:21:47'),
(32, 16, '2', '2016-07-30 00:21:49'),
(33, 16, '3', '2016-07-30 00:21:52'),
(34, 16, '4', '2016-07-30 13:46:50'),
(35, 1, '6', '2016-07-30 13:55:27'),
(36, 16, '5', '2016-07-30 14:21:19');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3'),
(6, 'Daragan', '21232f297a57a5a743894a0e4a801fc3'),
(8, 'admin2', '21232f297a57a5a743894a0e4a801fc3'),
(10, 'Bogdan', '21232f297a57a5a743894a0e4a801fc3'),
(16, 'user', '21232f297a57a5a743894a0e4a801fc3'),
(17, 'darbodya', '21232f297a57a5a743894a0e4a801fc3'),
(18, 'DaraganB', '21232f297a57a5a743894a0e4a801fc3'),
(19, 'Alex', '1c40fa303dbcc33d6f34f682a38408d1');

--
-- Триггеры `users`
--
DELIMITER $$
CREATE TRIGGER `ins_user_to_detail` AFTER INSERT ON `users` FOR EACH ROW INSERT INTO user_details(user_id) VALUES (NEW.user_id)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Структура таблицы `user_details`
--

CREATE TABLE `user_details` (
  `user_detail_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `city` varchar(64) NOT NULL DEFAULT 'City',
  `birth_date` date DEFAULT '2016-07-14',
  `job` varchar(128) NOT NULL DEFAULT 'Job',
  `about` varchar(256) NOT NULL DEFAULT 'About'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_details`
--

INSERT INTO `user_details` (`user_detail_id`, `user_id`, `city`, `birth_date`, `job`, `about`) VALUES
(1, 1, 'Днепр', '1992-05-17', 'Java developer', 'Лентяй - кофеман'),
(4, 6, 'City', '2016-07-14', 'Job', 'About'),
(6, 8, 'City', '2016-07-14', 'Job', 'About'),
(8, 10, 'City', '2016-07-14', 'Job', 'About'),
(28, 17, 'Днепропетровск', '1992-05-17', 'Работа', 'Пару слов о себе'),
(32, 18, 'Городище', '2016-07-29', 'Обычная работа', 'Чет там про себя'),
(34, 16, 'Городок', '1992-05-17', 'Работушка', 'Работничек в городишке)'),
(35, 19, 'City', '2016-07-14', 'Job', 'About');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `friendship`
--
ALTER TABLE `friendship`
  ADD PRIMARY KEY (`friendship_id`);

--
-- Индексы таблицы `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`post_id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Индексы таблицы `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`user_detail_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `friendship`
--
ALTER TABLE `friendship`
  MODIFY `friendship_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT для таблицы `posts`
--
ALTER TABLE `posts`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT для таблицы `user_details`
--
ALTER TABLE `user_details`
  MODIFY `user_detail_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
