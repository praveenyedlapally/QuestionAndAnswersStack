create database quickcode;
grant all privileges on quickcode.* to root@localhost identified by 'root';

CREATE TABLE `user` (
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `question` (
  `questionId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  PRIMARY KEY (`questionId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE `answer` (
  `answerId` int(11) NOT NULL AUTO_INCREMENT,
  `answerText` varchar(100) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL,
  `questionId` int(11) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  PRIMARY KEY (`answerId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


CREATE TABLE `question` (
  `questionId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  PRIMARY KEY (`questionId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


