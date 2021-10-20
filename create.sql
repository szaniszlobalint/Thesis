CREATE DATABASE redmineapp
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
    B_SystemID INT UNIQUE NOT NULL,
    FOREIGN KEY (A_SystemID) REFERENCES SYSTEM (ID),
    FOREIGN KEY (B_SystemID) REFERENCES SYSTEM (ID)
);

CREATE TABLE IF NOT EXISTS public.SYSTEM_USER (
    ID serial PRIMARY KEY NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    mail VARCHAR(100) NOT NULL,
    admin BOOLEAN NOT NULL,
    System_ID INT,
    FOREIGN KEY (System_ID) REFERENCES SYSTEM(ID)
);
CREATE TABLE IF NOT EXISTS public.SYSTEM_USER_PAIR (
    ID serial PRIMARY KEY NOT NULL,
    A_UserID INT UNIQUE NOT NULL,
    B_UserID INT UNIQUE NOT NULL,
    FOREIGN KEY (A_UserID) REFERENCES SYSTEM_USER (ID),
    FOREIGN KEY (B_UserID) REFERENCES SYSTEM_USER (ID)
);
CREATE TABLE IF NOT EXISTS public.PROJECT (
    ID serial PRIMARY KEY NOT NULL,
    name VARCHAR(100) UNIQUE NOT NULL,
    identifier VARCHAR(100) UNIQUE NOT NULL,
    description VARCHAR(100) NOT NULL,
    user_id INT UNIQUE,
    system_id INT UNIQUE,
    FOREIGN KEY (user_id) REFERENCES SYSTEM_USER(ID),
    FOREIGN KEY (system_id) REFERENCES SYSTEM(ID)

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

CREATE TABLE IF NOT EXISTS public.ISSUE(
    ID      serial PRIMARY KEY,
    project json NOT NULL,
    tracker json,
    status  json
);

INSERT INTO SYSTEM(id,type,name) VALUES(1, 'Redmine', 'A Redmine');
INSERT INTO SYSTEM(id,type,name) VALUES(2, 'Redmine', 'B Redmine');

INSERT INTO SYSTEM_PAIR(A_SystemID, B_SystemID) VALUES (1,2);

INSERT INTO SYSTEM_USER(ID, firstname, lastname, login, password, mail, admin) VALUES (1, 'test', 'test', 'test', 'asd', 'test@gmail.com', true );
INSERT INTO SYSTEM_USER(ID, firstname, lastname, login, password, mail, admin) VALUES (2, 'tester', 'tester', 'tester', 'asd', 'tester@gmail.com', true );
INSERT INTO SYSTEM_USER(ID, firstname, lastname, login, password, mail, admin) VALUES (3, 'József', 'Kiss', 'kissjozsi', 'asd', 'kissjozsi@gmail.com', false );
INSERT INTO SYSTEM_USER(ID, firstname, lastname, login, password, mail, admin) VALUES (4, 'József', 'Kiss', 'jozsi12', 'asd', 'kissjozsi@gmail.com', false );
INSERT INTO SYSTEM_USER(ID, firstname, lastname, login, password, mail, admin) VALUES (5, 'János', 'Nagy', 'nagyjanos', 'asd', 'nagyjanos@gmail.com', false );
INSERT INTO SYSTEM_USER(ID, firstname, lastname, login, password, mail, admin) VALUES (6, 'János', 'Nagy', 'nagyjanos34', 'asd', 'nagyjanos@gmail.com', false );

INSERT INTO SYSTEM_USER_PAIR(A_UserID, B_UserID) VALUES (1,2);
INSERT INTO SYSTEM_USER_PAIR(A_UserID, B_UserID) VALUES (3,4);
INSERT INTO SYSTEM_USER_PAIR(A_UserID, B_UserID) VALUES (5,6);


INSERT INTO PROJECT(ID, name, identifier, description)  VALUES (1,'test','test','testing');
INSERT INTO PROJECT(ID, name, identifier, description)  VALUES (2,'tester','tester','for testing');
INSERT INTO PROJECT(ID, name, identifier, description)  VALUES (3,'important_project','important','Important to get this done');
INSERT INTO PROJECT(ID, name, identifier, description)  VALUES (4,'weird_project','weird','This project is weird');

INSERT INTO PROJECT_PAIR(A_ProjectID, B_ProjectID) VALUES (1,2);
INSERT INTO PROJECT_PAIR(A_ProjectID, B_ProjectID) VALUES (3,4);

INSERT INTO APP_USER(username, password,mail)VALUES ('test', 'test', 'test@test.com');
INSERT INTO APP_USER(username, password,mail)VALUES ('tester', 'tester', 'tester@tester.com');
INSERT INTO APP_USER(username, password,mail)VALUES ('kissjozsi', 'kissjozsi','kiss@jozsi.com');
INSERT INTO APP_USER(username, password,mail)VALUES ('jozsi12', 'jozsi12','jozsi12@gmail.com');
INSERT INTO APP_USER(username, password,mail)VALUES ('nagyjanos', 'nagyjanos', 'nagy@janos.com');
INSERT INTO APP_USER(username, password,mail)VALUES ('nagyjanos34', 'nagyjanos34', 'nagy@janos34.com');