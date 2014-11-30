-- Alex Mantel, Daniel Hofemeister
-- SE1

DROP TABLE mitgliedvon;
DROP TABLE beantwortet;
DROP TABLE antwort;
DROP TABLE frage;
DROP TABLE gruppe;
DROP TABLE nutzer ;

-- Entitaeten 
CREATE TABLE nutzer ( 
  nutzerid    INTEGER       PRIMARY KEY,
  nickname    VARCHAR(50)   NOT NULL,
  passwort    VARCHAR(50)   NOT NULL,
  email       VARCHAR(100)  NOT NULL
);

CREATE TABLE gruppe (
  gruppenid    INTEGER       PRIMARY KEY,
  gruppenname VARCHAR(100)  NOT NULL,
  passwort    VARCHAR(50)   NOT NULL
);

CREATE TABLE frage (
  frageid     INTEGER       PRIMARY KEY,
  gruppeid    INTEGER       REFERENCES gruppe(gruppenid) NOT NULL,
  fragetext   VARCHAR(200)  NOT NULL,
  meduiumtyp  VARCHAR(20),
  medium      BLOB
);

CREATE TABLE antwort (
  antwortid   INTEGER       PRIMARY KEY,
  frageid     INTEGER       REFERENCES frage(frageid) NOT NULL,
  antworttext VARCHAR(50)   NOT NULL,
  istkorrekt  CHAR          CHECK (istkorrekt IN (0,1)) -- BOOLEAN
);

-- Relationen
-- gruppe <-> nutzer
CREATE TABLE mitgliedvon (
  nutzerid    INTEGER REFERENCES nutzer(nutzerid)   NOT NULL,
  gruppenid   INTEGER REFERENCES gruppe(gruppenid)  NOT NULL,
  bestaetigt  CHAR          CHECK (bestaetigt IN (0,1)),  -- BOOLEAN
  istadmin    CHAR          CHECK (istadmin IN (0,1)),    -- BOOLEAN
  PRIMARY KEY (nutzerid, gruppenid)
);

-- nutzer <-> frage
CREATE TABLE beantwortet (
  nutzerid    INTEGER REFERENCES nutzer(nutzerid)   NOT NULL,
  frageid     INTEGER REFERENCES frage(frageid)     NOT NULL,
  istkorrekt  CHAR          CHECK (istkorrekt IN (0,1)), -- BOOLEAN
  PRIMARY KEY (nutzerid, frageid)
);