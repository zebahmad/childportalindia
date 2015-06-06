delimiter $$

CREATE TABLE `organization` (
  `ORG_ID` varchar(20) NOT NULL,
  `ORG_TYPE` varchar(20) NOT NULL,
  `ORG_CODE` varchar(20) NOT NULL,
  `ORG_NAME` varchar(30) NOT NULL,
  `ADDRESS` varchar(100) NOT NULL,
  `DISTRICT` varchar(20) NOT NULL,
  `STATE` varchar(20) NOT NULL,
  PRIMARY KEY (`ORG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

