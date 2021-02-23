

DROP TABLE IF EXISTS users, series, rating, status;

CREATE TABLE users (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL
);

CREATE TABLE series (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    synopsis VARCHAR(250) NOT NULL,
    genres VARCHAR(250) NOT NULL,
    coverPicture VARCHAR(250) NOT NULL,
    releaseDate DATE NOT NULL
);

CREATE TABLE rating (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    score INT NOT NULL,
    comment VARCHAR(250) NOT NULL,
    CONSTRAINT seriesId FOREIGN KEY (series)
    CONSTRAINT userId FOREIGN KEY (users)
);

CREATE TABLE status (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    status VARCHAR(250) NOT NULL,
    CONSTRAINT seriesId FOREIGN KEY (series)
    CONSTRAINT userId FOREIGN KEY (users)
);

