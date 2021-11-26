#!/bin/bash
set -e
export PGPASSWORD=$POSTGRES_PASSWORD;
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
  CREATE USER $APP_DB_USER WITH PASSWORD '$APP_DB_PASS';
  CREATE DATABASE $APP_DB_NAME;
  CREATE DATABASE redmineapp1;
  CREATE DATABASE redmineapp2;
  GRANT ALL PRIVILEGES ON DATABASE $APP_DB_NAME TO $APP_DB_USER;
  \connect $APP_DB_NAME $APP_DB_USER
  BEGIN;
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
    password VARCHAR(50),
    mail VARCHAR(100),
    admin BOOLEAN,
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
    user_id INT,
    systemid INT NOT NULL,
    redmineid INT NOT NULL,
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

INSERT INTO SYSTEM(id,type,name) VALUES(1, 'Redmine', 'A Redmine');
INSERT INTO SYSTEM(id,type,name) VALUES(2, 'Redmine', 'B Redmine');

INSERT INTO SYSTEM_PAIR(A_SystemID, B_SystemID) VALUES (1,2);
  COMMIT;
EOSQL