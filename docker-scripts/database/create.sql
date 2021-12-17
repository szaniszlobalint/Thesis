CREATE DATABASE redmineapp1
OWNER =  postgres
ENCODING = 'UTF-8'
LC_COLLATE = 'en_US.utf8'
LC_CTYPE = 'en_US.utf8'
TABLESPACE = pg_default
CONNECTION LIMIT = -1;

CREATE DATABASE redmineapp2
OWNER =  postgres
ENCODING = 'UTF-8'
LC_COLLATE = 'en_US.utf8'
LC_CTYPE = 'en_US.utf8'
TABLESPACE = pg_default
CONNECTION LIMIT = -1;

\c redmineapp

CREATE TABLE IF NOT EXISTS public.SYSTEM (
    ID serial PRIMARY KEY NOT NULL,
    type VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.SYSTEM_PAIR (
    ID serial PRIMARY KEY NOT NULL,
    A_SystemID INT UNIQUE NOT NULL,
    B_SystemID INT NOT NULL,
    FOREIGN KEY (A_SystemID) REFERENCES SYSTEM (ID),
    FOREIGN KEY (B_SystemID) REFERENCES SYSTEM (ID)
);

CREATE TABLE IF NOT EXISTS public.SYSTEM_USER (
    ID serial PRIMARY KEY NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    login VARCHAR(50) NOT NULL,
    systemID INT NOT NULL,
    redmineID INT NOT NULL,
    FOREIGN KEY (systemID) REFERENCES SYSTEM(ID)
);
CREATE TABLE IF NOT EXISTS public.SYSTEM_USER_PAIR (
    ID serial PRIMARY KEY NOT NULL,
    auserid INT UNIQUE NOT NULL,
    buserid INT UNIQUE NOT NULL,
    FOREIGN KEY (auserid) REFERENCES SYSTEM_USER (ID),
    FOREIGN KEY (buserid) REFERENCES SYSTEM_USER (ID)
);
CREATE TABLE IF NOT EXISTS public.PROJECT (
    ID serial PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    identifier VARCHAR(100) NOT NULL,
    description VARCHAR(100),
    systemid INT,
    redmineid INT NOT NULL,
    FOREIGN KEY (systemid) REFERENCES SYSTEM(ID)

);
CREATE TABLE IF NOT EXISTS public.PROJECT_PAIR (
    ID serial PRIMARY KEY NOT NULL,
    A_ProjectID INT UNIQUE NOT NULL,
    B_ProjectID INT UNIQUE NOT NULL,
    FOREIGN KEY (A_ProjectID) REFERENCES PROJECT (ID),
    FOREIGN KEY (B_ProjectID) REFERENCES PROJECT (ID)
);

CREATE TABLE IF NOT EXISTS public.APP_USER (
    ID serial PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    mail VARCHAR(100) UNIQUE NOT NULL
);

INSERT INTO SYSTEM(id,type,name) VALUES(1, 'Redmine', 'A Redmine');
INSERT INTO SYSTEM(id,type,name) VALUES(2, 'Redmine', 'B Redmine');

INSERT INTO SYSTEM_PAIR(A_SystemID, B_SystemID) VALUES (1,2);
--
-- INSERT INTO SYSTEM_USER(firstname, lastname, login, password, mail, admin, systemID, redmineID) VALUES ('test', 'test', 'test', 'asd', 'test@gmail.com', true, 1, 3 );
-- INSERT INTO SYSTEM_USER(firstname, lastname, login, password, mail, admin, systemID, redmineID) VALUES ('tester', 'tester', 'tester', 'asd', 'tester@gmail.com', true, 2, 4 );
-- INSERT INTO SYSTEM_USER(firstname, lastname, login, password, mail, admin, systemID, redmineID) VALUES ('József', 'Kiss', 'kissjozsi', 'asd', 'kissjozsi@gmail.com', false, 1, 2 );
-- INSERT INTO SYSTEM_USER(firstname, lastname, login, password, mail, admin, systemID, redmineID) VALUES ('József', 'Kiss', 'jozsi12', 'asd', 'kissjozsi@gmail.com', false, 2, 6 );
-- INSERT INTO SYSTEM_USER(firstname, lastname, login, password, mail, admin, systemID, redmineID) VALUES ('János', 'Nagy', 'nagyjanos', 'asd', 'nagyjanos@gmail.com', false, 1, 8 );
-- INSERT INTO SYSTEM_USER(firstname, lastname, login, password, mail, admin, systemID, redmineID) VALUES ('János', 'Nagy', 'nagyjanos34', 'asd', 'nagyjanos@gmail.com', false,2, 9 );
--
-- INSERT INTO SYSTEM_USER_PAIR(A_UserID, B_UserID) VALUES (1,2);
-- INSERT INTO SYSTEM_USER_PAIR(A_UserID, B_UserID) VALUES (3,4);
-- INSERT INTO SYSTEM_USER_PAIR(A_UserID, B_UserID) VALUES (5,6);
--
--
-- INSERT INTO PROJECT(name, identifier, description)  VALUES ('test','test','testing');
-- INSERT INTO PROJECT(name, identifier, description)  VALUES ('tester','tester','for testing');
-- INSERT INTO PROJECT(name, identifier, description)  VALUES ('important_project','important','Important to get this done');
-- INSERT INTO PROJECT(name, identifier, description)  VALUES ('weird_project','weird','This project is weird');
--
-- INSERT INTO PROJECT_PAIR(A_ProjectID, B_ProjectID) VALUES (1,2);
-- INSERT INTO PROJECT_PAIR(A_ProjectID, B_ProjectID) VALUES (3,4);
--
-- INSERT INTO APP_USER(username, password,mail)VALUES ('test', 'test', 'test@test.com');
-- INSERT INTO APP_USER(username, password,mail)VALUES ('tester', 'tester', 'tester@tester.com');
-- INSERT INTO APP_USER(username, password,mail)VALUES ('kissjozsi', 'kissjozsi','kiss@jozsi.com');
-- INSERT INTO APP_USER(username, password,mail)VALUES ('jozsi12', 'jozsi12','jozsi12@gmail.com');
-- INSERT INTO APP_USER(username, password,mail)VALUES ('nagyjanos', 'nagyjanos', 'nagy@janos.com');
-- INSERT INTO APP_USER(username, password,mail)VALUES ('nagyjanos34', 'nagyjanos34', 'nagy@janos34.com');