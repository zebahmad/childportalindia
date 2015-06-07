delimiter $$

CREATE TABLE `report_enrollment` (
  `id` int(11) NOT NULL,
  `YEAR` int(11) NOT NULL,
  `MONTH` int(11) NOT NULL,
  `DISTRICT` varchar(45) NOT NULL,
  `STATE` varchar(45) NOT NULL,
  `AADHAR_NO` varchar(45) NOT NULL,
  `ENROLLED_BY` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

