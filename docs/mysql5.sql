create database nextware_global character set UTF8 collate utf8_bin;

CREATE TABLE palindrome (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    list varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;