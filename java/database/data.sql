BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('brewer','$2a$10$gFM5Y/oDUDKEOGDGKTcQi.IuKQgxUiIuQJjfgOaURA3acpXrzb6o6','ROLE_BREWER');

INSERT INTO brewery (brewery_name, brewery_type, hours, phone_number, street_address_1, city, state_province, history) VALUES ('Happy Times Brewing', 'micro', 'All Day Every Day', '1-800-BREW-NOW', '123 Hops Lane', 'Philadelphia', 'PA', 'short history');
INSERT INTO brewery (brewery_name, brewery_type, hours, website, street_address_1, city, state_province, history) VALUES ('Jumping Orca', 'closed','M-F 6-10pm', 'jumpingorca.com', '78 Happy Way', 'Wayne', 'PA', 'short history');

INSERT INTO beer (beer_name, brewery, description, abv, beer_type) VALUES ('Jumping Joseph', 1, 'It will put a hop in your step', 7.50, 'Saison');

COMMIT TRANSACTION;
