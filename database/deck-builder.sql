DROP TABLE IF EXISTS users, decks, cards;

DROP SEQUENCE IF EXISTS seq_user_id, seq_deck_id, seq_card_id;

CREATE SEQUENCE seq_user_id
	INCREMENT BY 1
	START WITH 1
	NO MAXVALUE;

CREATE SEQUENCE seq_deck_id
	INCREMENT BY 1
	START WITH 1
	NO MAXVALUE;
	
CREATE SEQUENCE seq_card_id
	INCREMENT BY 1
	START WITH 1
	NO MAXVALUE;
	
CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE TABLE decks (
	deck_id int NOT NULL DEFAULT nextval('seq_deck_id'),
	user_id int NOT NULL,
	commander varchar(50) NOT NULL,
	CONSTRAINT PK_decks PRIMARY KEY (deck_id),
	CONSTRAINT FK_decks_user FOREIGN KEY (user_id) REFERENCES users (user_id)
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
	colors varchar(15),
	color_identity varchar(15),
	keywords varchar(100),
	legal boolean DEFAULT null,
	CONSTRAINT PK_cards PRIMARY KEY (card_id)
);

CREATE TABLE deck_cards (
	deck_id int NOT NULL,
	card_id int NOT NULL,
	CONSTRAINT PK_deck_cards PRIMARY KEY (deck_id, card_id),
	CONSTRAINT FK_deck_cards_decks FOREIGN KEY (deck_id) REFERENCES decks (deck_id),
	CONSTRAINT FK_deck_cards_card FOREIGN KEY (card_id) REFERENCES cards (card_id)
);