DROP TABLE IF EXISTS PERSON;
DROP TABLE IF EXISTS PHONE;
 
CREATE TABLE PERSON (
  ID VARCHAR(36) PRIMARY KEY,
  NAME VARCHAR(100) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  PASSWORD VARCHAR(255) NOT NULL,
  TOKEN VARCHAR(255)NOT NULL,
  IS_ACTIVE BOOLEAN NOT NULL,
  CREATED TIMESTAMP NOT NULL,
  LAST_LOGIN TIMESTAMP NOT NULL,
  UNIQUE (EMAIL)
);

CREATE TABLE PHONE (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  PERSON_ID VARCHAR(36) NOT NULL,
  NUMBER VARCHAR(36) NOT NULL,
  CITY_CODE VARCHAR(36) NOT NULL,
  COUNTRY_CODE VARCHAR(36) NOT NULL,
  UNIQUE (PERSON_ID, NUMBER)
);

ALTER TABLE PHONE ADD FOREIGN KEY (PERSON_ID) REFERENCES PERSON(ID);

-- -- H2
-- -- INSERT INTO HAIR_COLOUR(ID,CODE)VALUES(1,'black');
-- -- INSERT INTO HAIR_COLOUR(ID,CODE)VALUES(2,'red');
-- -- INSERT INTO HAIR_COLOUR(ID,CODE)VALUES(3,'yellow');
-- -- INSERT INTO HAIR_COLOUR(ID,CODE)VALUES(4,'brown');
-- -- INSERT INTO HAIR_COLOUR(ID,CODE)VALUES(5,'white');
-- -- 
-- -- INSERT INTO PERSONA (ID, NAME, LAST_NAME, ADDRESS,SIMPLE_PHONE_NUMBER,HAIR_COLOUR) VALUES (1, 'omar','guillen','santiago',123445,'brown');
-- -- INSERT INTO PERSONA (ID, NAME, LAST_NAME, ADDRESS,SIMPLE_PHONE_NUMBER,HAIR_COLOUR) VALUES (2, 'karina','garri','santiago',24567247,'brown');
-- -- INSERT INTO PERSONA (ID, NAME, LAST_NAME, ADDRESS,SIMPLE_PHONE_NUMBER,HAIR_COLOUR) VALUES (3, 'jose','garri','santiago',647843,'white');
-- -- 
-- 
