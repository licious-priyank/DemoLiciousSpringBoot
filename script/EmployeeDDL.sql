CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `mobile` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `doj` datetime DEFAULT NULL,
  `degree` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `Is_active` tinyint DEFAULT '1',
  PRIMARY KEY (`employee_id`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
