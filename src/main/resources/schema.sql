CREATE TABLE member
(
  member_no BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  id VARCHAR2(10) NOT NULL,
  password VARCHAR2(60) NOT NULL,
  name VARCHAR2(20) NULL
);