DROP TABLE IF EXISTS track;
CREATE TABLE track(
    id SERIAL primary key,
    name VARCHAR(100) NOT NULL,
    artist_name VARCHAR(50) Not NULL,
    album_name VARCHAR(100) Not NULL,
    rate float(1) Not NULL,
    lyrics TEXT not NULL
);

DROP TABLE IF EXISTS appuser;
CREATE TABLE appuser(
    email VARCHAR(100) primary key,
    password VARCHAR(50) Not NULL
);