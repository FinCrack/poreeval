CREATE TABLE PUBLIC.USERS 
(
    ID INT PRIMARY KEY,
    USERNAME VARCHAR(50) UNIQUE NOT NULL,
    PRIVILEGE INT NOT NULL,
    PASSWORD VARCHAR(50) NOT NULL CHECK (LENGTH (PASSWORD) >= 6),
    EMAIL VARCHAR NOT NULL
);

ALTER TABLE USERS ADD EMAIL VARCHAR NOT NULL;

CREATE TABLE PUBLIC.PRODUCTS
(
    EAN NUMERIC(13,0) PRIMARY KEY,
    NAME VARCHAR(150) NOT NULL,
    DESCRIPTION VARCHAR,
    PICTURE BYTEA 
);

CREATE TABLE PUBLIC.REVIEWS
(
    ID INT PRIMARY KEY,
    RATING INT NOT NULL CHECK (RATING BETWEEN 0 AND 5),
    TEXT VARCHAR,
    EAN NUMERIC(13,0) REFERENCES PRODUCTS(EAN),
    USER_ID INT REFERENCES USERS(ID),
    REVIEW_DATE DATE NOT NULL DEFAULT CURRENT_DATE
);


CREATE OR REPLACE FUNCTION AVG_RATING(EAN NUMERIC) 
RETURNS NUMERIC AS
'SELECT AVG(RATING) FROM REVIEWS WHERE EAN = $1' LANGUAGE SQL;


--Testen - funktioniert so nicht
CREATE OR REPLACE FUNCTION BEST_RATED()
RETURNS TABLE (EAN INT, NAME VARCHAR, DESCRIPTION VARCHAR, PICTURE BYTEA, RATING NUMERIC) AS
'SELECT P.EAN, P.NAME, P.DESCRIPTION, P.PICTURE, AVG(R.RATING) 
FROM PRODUCTS P INNER JOIN REVIEWS R ON P.EAN = R.EAN
WHERE P.EAN = (SELECT EAN FROM REVIEWS GROUP BY EAN HAVING AVG(RATING) = MAX(AVG(RATING)) LIMIT 1)' LANGUAGE SQL;