# smartTest.sql

DROP DATABASE IF EXISTS smarttest_db;
CREATE DATABASE smarttest_db;
USE smarttest_db;
CREATE TABLE tbl_user(
	id INT AUTO_INCREMENT PRIMARY KEY,
	role VARCHAR(255),
	uname VARCHAR(255),
	encodedPWD VARCHAR(255)
);

CREATE TABLE tbl_test(
	pincode INT PRIMARY KEY,
	tid INT,
	testObj TEXT
);

CREATE TABLE tbl_gradedtest(
	sid INT,
	pincode INT,
	gradedTestObj TEXT,
	score INT
	PRIMARY KEY (sid, pincode)
);	

CREATE TABLE tbl_deptLO(
	cat1 VARCHAR(255),
	cat2 VARCHAR(255),
	correct INT,
	total INT,
	PRIMARY KEY (cat1, cat2)
);

CREATE TABLE tbl_testLOs(
	tid INT,
	pincode INT, 
	cat1 VARCHAR(255),
	cat2 VARCHAR(255),
	correct INT,
	total INT,
	PRIMARY KEY (tid, pincode)
);
