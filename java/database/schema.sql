BEGIN TRANSACTION;

--DROP TABLE IF EXISTS brewery_day
DROP TABLE IF EXISTS brewery_beer;
DROP TABLE IF EXISTS beer;
DROP TABLE IF EXISTS brewery;
--DROP TABLE IF EXISTS day;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS rating;
DROP TABLE IF EXISTS event_info;
DROP TABLE IF EXISTS blog;
DROP TABLE IF EXISTS update_info;

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
	open_db_id varchar(100),
	brewery_name varchar(200),
	brewery_type varchar(30),
	hours varchar(200),
	phone_number varchar(20),
	website varchar (100),
	street_address_1 varchar(200),
	street_address_2 varchar(100),
	city varchar(50),
	state_province varchar(50),
	postal_code varchar(20),
	country varchar(100),
	latitude decimal(8,6),
	longitude decimal(8,6),
	history varchar(1000),
	CONSTRAINT fk_brewery_brewer FOREIGN KEY (brewer) REFERENCES users(user_id)
);

CREATE TABLE beer (
	beer_id SERIAL PRIMARY KEY,
	beer_name varchar(200),
	description varchar(600),
	abv decimal(4,2),
	beer_type varchar(100)
	
);

CREATE TABLE brewery_beer (
	brewery_id int,
	beer_id int,
	CONSTRAINT pk_brewery_beer PRIMARY KEY (brewery_id, beer_id),
	CONSTRAINT fk_brewery_beer_brewery_id FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id),
	CONSTRAINT fk_brewery_beer_beer_id FOREIGN KEY (beer_id) REFERENCES beer(beer_id)
);

CREATE TABLE review (
    review_id SERIAL PRIMARY KEY,
    user_id int,
    beer_id int,
    title varchar(200),
    description varchar(1000),
    brewer_response varchar(1000),
    CONSTRAINT fk_review_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_review_beer_id FOREIGN KEY (beer_id) REFERENCES beer(beer_id)
);

CREATE TABLE days (
    day_name varchar(20) PRIMARY KEY
);

CREATE TABLE brewery_days (
    brewery_id int,
    day_name varchar(20),
	open_status boolean,
    start_time varchar(20),
    end_time varchar(20),
    CONSTRAINT pk_brewery_days PRIMARY KEY (brewery_id, day_name),
    CONSTRAINT fk_brewery_days_brewery_id FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id),
    CONSTRAINT fk_brewery_days_day_name FOREIGN KEY (day_name) REFERENCES days(day_name)
);

CREATE TABLE rating (
    user_id int,
    beer_id int,
    amount int,
    CONSTRAINT pk_rating PRIMARY KEY (user_id, beer_id),
    CONSTRAINT fk_rating_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_rating_beer_id FOREIGN KEY (beer_id) REFERENCES beer(beer_id)
);

CREATE TABLE event_info (
    event_id SERIAL PRIMARY KEY,
    brewery_id int,
    title varchar(100),
    text varchar(2000),
    event_time timestamp,
    CONSTRAINT fk_event_brewery_id FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)
);

CREATE TABLE blog (
    blog_id SERIAL PRIMARY KEY,
    brewery_id int,
    title varchar(100),
    text varchar(2000),
    event_time timestamp,
    CONSTRAINT fk_blog_brewery_id FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)
);

CREATE TABLE update_info (
    update_id SERIAL PRIMARY KEY,
    brewery_id int,
    title varchar(100),
    text varchar(2000),
    update_date date,
    CONSTRAINT fk_update_info_brewery_id FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)
);

COMMIT TRANSACTION;
