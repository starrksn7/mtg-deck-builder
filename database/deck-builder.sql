DROP TABLE IF EXISTS user, deck, cards;

DROP SEQUENCE IF EXISTS user_id, deck_id, card_id;

CREATE SEQUENCE user_id
	INCREMENT BY 1
	START WITH 1
	NO MAXVALUE

CREATE SEQUENCE deck_id
	INCREMENT BY 1
	START WITH 1
	NO MAXVALUE
	
CREATE SEQUENCE card_id
	INCREMENT BY 1
	START WITH 1
	NO MAXVALUE
	
CREATE TABLE user (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL,
	password_hash varcar(200) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE TABLE deck (
	deck_id int NOT NULL DEFAULT nextval('seq_deck_id'),
	user_id int NOT NULL,
	card_id int NOT NULL,
	CONSTRAINT PK_deck PRIMARY KEY (deck_id),
	CONSTRAINT FK_deck_user FOREIGN KEY (user_id) REFERENCES user (user_id)
);

CREATE TABLE cards (
	card_id int NOT NULL DEFAULT nextval('seq_card_id'),
	card_name varchar(50) NOT NULL,
	scryfall_link varchar(100) NOT NULL,
	image_link varchar(100) NOT NULL,
	mana_cost varchar(20),
	cmc decimal(10, 1),
	card_type varchar(30),
	oracle_text varchar(200),
	CONSTRAINT PK_cards PRIMARY KEY (card_id) REFERENCES deck (card_id)
	CONSTRAINT FK_cards_deck FOREIGN KEY (card_id) 
);