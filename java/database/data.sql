BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('brewer','$2a$10$gFM5Y/oDUDKEOGDGKTcQi.IuKQgxUiIuQJjfgOaURA3acpXrzb6o6','ROLE_BREWER');

INSERT INTO brewery (brewery_name, brewer, brewery_type, hours, phone_number, street_address_1, city, state_province, history) VALUES ('Happy Times Brewing', 3, 'micro', 'All Day Every Day', '1-800-BREW-NOW', '123 Hops Lane', 'Philadelphia', 'PA', 'short history');
INSERT INTO brewery (brewery_name, brewery_type, hours, website, street_address_1, city, state_province, history) VALUES ('Jumping Orca', 'closed','M-F 6-10pm', 'jumpingorca.com', '78 Happy Way', 'Wayne', 'PA', 'short history');



INSERT INTO beer (beer_id, beer_name, description, abv, beer_type) 
VALUES (DEFAULT, 'Golden Gryphon Ale', 'A smooth and radiant ale that boasts a gentle honey undertone. Its mythical name reflects its delicate balance between malt sweetness and hoppy bitterness.', 5.5, 'Golden Ale');

INSERT INTO beer (beer_id, beer_name, description, abv, beer_type) 
VALUES (DEFAULT, 'Mystic Mountain Stout', 'Description: Dark as a moonless night and as mysterious as the mountains from which it gets its name. This stout presents bold flavors of dark chocolate and roasted coffee.', 8.0, 'Imperial Stout');

INSERT INTO beer (beer_id, beer_name, description, abv, beer_type) 
VALUES (DEFAULT, 'Lunar Lagoon Lager', 'A crisp and refreshing brew with a light body and clear golden hue. The perfect beer to unwind after a long day, evoking images of a calm lagoon under the moon''s silver light.', 4.7, 'Lager');

INSERT INTO beer (beer_id, beer_name, description, abv, beer_type) 
VALUES (DEFAULT, 'Solar Flare Saison', 'Bursting with spicy and fruity notes, this effervescent saison is reminiscent of a sunburst on a summer day, energetic and full of life.', 6.2, 'Saison');

INSERT INTO beer (beer_id, beer_name, description, abv, beer_type) 
VALUES (DEFAULT, 'Tempestuous Teak IPA', 'A tropical IPA, enriched with the nuances of teakwood. Hints of mango and pine contrast with a gentle woody backbone.', 6.8, 'India Pale Ale');

INSERT INTO beer (beer_id, beer_name, description, abv, beer_type) 
VALUES (DEFAULT, 'Borealis Breeze Berliner Weisse', 'A tart and tangy offering that paints your palate with the cool colors of the northern lights. Pairs well with a dash of fruity syrup or enjoyed on its own.', 3.8, 'Berliner Weisse');

INSERT INTO beer (beer_id, beer_name, description, abv, beer_type) 
VALUES (DEFAULT, 'Tidal Twist Tripel', 'A traditional Belgian-style brew with a twist. Notes of banana, clove, and citrus are carried forth by a strong tidal wave of alcohol warmth.', 9.0, 'Berliner Weisse');

INSERT INTO beer (beer_id, beer_name, description, abv, beer_type) 
VALUES (DEFAULT, 'Cerulean Cove Kölsch', 'A clear and coastal brew, its mellow maltiness is complemented by a subtle fruitiness, transporting drinkers to serene blue coves.', 4.9, 'Kölsch');

INSERT INTO beer (beer_id, beer_name, description, abv, beer_type) 
VALUES (DEFAULT, 'Prairie Phoenix Pilsner', 'A crisp and effervescent pilsner that rises from the depths of traditional brewing techniques, showcasing sharp hoppy notes amidst a malty backbone.', 5.0, 'Pilsner');

INSERT INTO beer (beer_id, beer_name, description, abv, beer_type) 
VALUES (DEFAULT, 'Eldritch Ember ESB', 'A beer that evokes the warmth of an ember''s glow, it perfectly balances the bitterness of traditional hops with the caramel sweetness of malt.', 5.6, 'Extra Special Bitter (ESB)');

INSERT INTO brewery_beer (brewery_id, beer_id)
VALUES ((SELECT brewery_id FROM brewery WHERE brewery_name = 'Happy Times Brewing'), (SELECT beer_id FROM beer WHERE beer_name = 'Golden Gryphon Ale'));

INSERT INTO brewery_beer (brewery_id, beer_id)
VALUES ((SELECT brewery_id FROM brewery WHERE brewery_name = 'Happy Times Brewing'), (SELECT beer_id FROM beer WHERE beer_name = 'Cerulean Cove Kölsch'));



INSERT INTO day(name)
VALUES('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday')
COMMIT TRANSACTION;
