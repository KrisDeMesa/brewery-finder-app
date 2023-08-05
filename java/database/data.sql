BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO brewery (brewery_name, hours, contact_info, address, history, active) VALUES ('Happy Times Brewing', 'All Day Every Day', '1-800-BREW-NOW', '123 Hops Lane Philadelphia PA', 'short history', true);
INSERT INTO brewery (brewery_name, hours, contact_info, address, history, active) VALUES ('Okay Times Brewing', 'Saturday and Sunday 12pm-12am', 'info@okaytimesbrewing.com', '1 Misty Drive Philadelphia PA', 'short history', true);
INSERT INTO brewery (brewery_name, hours, contact_info, address, history, active) VALUES ('Jumping Orca', 'M-F 6-10pm', 'jumpingorca.com', '78 Happy Way Wayne PA', 'short history', false);

INSERT INTO beer (beer_name, brewery, description, abv, beer_type) VALUES ('Jumping Joseph', 1, 'It will put a hop in your step', 7.50, 'Saison');

COMMIT TRANSACTION;
