create database test;
use test;
create table user(
   USER_ID INT NOT NULL AUTO_INCREMENT,
   USERNAME VARCHAR(100),
   PASSWORD VARCHAR(40),
   GENDER VARCHAR(10),
   EMAIL VARCHAR(100),
   PRIMARY KEY ( USER_ID )
);