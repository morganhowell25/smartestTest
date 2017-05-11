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
INSERT INTO tbl_user (role, uname, encodedPWD) VALUES ('admin', 'admin', 'admin1');

CREATE TABLE tbl_test(
	pincode VARCHAR(255) PRIMARY KEY,
	tid INT,
	testObj TEXT
);

CREATE TABLE tbl_gradedtest(
	sid INT,
	pincode VARCHAR(255),
	gradedTestObj TEXT,
	score VARCHAR(255),
	PRIMARY KEY (sid, pincode)
);	

CREATE TABLE tbl_deptLOs(
	cat1 VARCHAR(255),
	cat2 VARCHAR(255),
	correct VARCHAR(255),
	total VARCHAR(255),
	PRIMARY KEY (cat1, cat2)
);

CREATE TABLE tbl_testLOs(
	pincode VARCHAR(255), 
	cat1 VARCHAR(255),
	cat2 VARCHAR(255),
	correct VARCHAR(255),
	total VARCHAR(255),
	PRIMARY KEY (pincode, cat1, cat2)
);
