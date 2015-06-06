delimiter $$

CREATE TABLE `stat_date_keys` (
  `ID` varchar(45) NOT NULL,
  `yearValue` int(11) NOT NULL,
  `monthValue` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

