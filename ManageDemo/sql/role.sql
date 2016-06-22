CREATE TABLE `role` (
  `RoleId` varchar(45) NOT NULL,
  `RoleName` varchar(45) NOT NULL,
  `UPDUSER` varchar(30) DEFAULT NULL,
  `UPDDATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;