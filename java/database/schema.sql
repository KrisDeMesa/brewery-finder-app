BEGIN TRANSACTION;

DROP TABLE IF EXISTS brewery_beer;
DROP TABLE IF EXISTS beer;
DROP TABLE IF EXISTS brewery;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE brewery (
	brewery_id SERIAL PRIMARY KEY,
	brewer int,
	brewery_name varchar(200),
	hours varchar(200),
--	open_time time
--	close_time time
	contact_info varchar(500),
	address varchar(300),
	history varchar(1000),
	active boolean
);

CREATE TABLE beer (
	beer_id SERIAL PRIMARY KEY,
	beer_name varchar(200),
	brewery int,
	description varchar(600),
	abv decimal(4,2),
	beer_type varchar(100),
	CONSTRAINT fk_beer_brewery FOREIGN KEY (brewery) REFERENCES brewery(brewery_id)
);

CREATE TABLE brewery_beer (
	brewery_id int,
	beer_id int,
	CONSTRAINT pk_brewery_beer PRIMARY KEY (brewery_id, beer_id),
	CONSTRAINT fk_brewery_beer_brewery_id FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id),
	CONSTRAINT fk_brewery_beer_beer_id FOREIGN KEY (beer_id) REFERENCES beer(beer_id)
);

COMMIT TRANSACTION;
