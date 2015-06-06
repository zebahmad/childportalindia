delimiter $$

CREATE TABLE `person` (
  `AADHAR_NO` varchar(100) NOT NULL,
  `FIRST_NAME` varchar(50) NOT NULL,
  `LAST_NAME` varchar(50) NOT NULL,
  `FATHER_NAME` varchar(50) DEFAULT NULL,
  `MOTHER_NAME` varchar(50) DEFAULT NULL,
  `GENDER` varchar(1) NOT NULL,
  `DOB` datetime NOT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `STATE` varchar(45) NOT NULL,
  `DISTRICT` varchar(30) DEFAULT NULL,
  `MOBILE` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AADHAR_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

