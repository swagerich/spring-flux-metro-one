CREATE TABLE "users"
(
    "user_id"   SERIAL PRIMARY KEY,
    "name"      varchar,
    "last_name" varchar,
    "document_type" varchar,
    "document_number" integer UNIQUE,
    "password"  varchar,
    "phone"     varchar,
    "email"     varchar UNIQUE,
    "card_number" integer UNIQUE,
    "role"      varchar
);

CREATE TABLE "transport_cards"
(
    "transpocard_id" SERIAL PRIMARY KEY,
    "card_number"    varchar(20) UNIQUE,
    "balance" decimal(10,2),
    "user_id"        integer
);

CREATE TABLE "bank_cards"
(
    "bankcard_id"     SERIAL PRIMARY KEY,
    "card_number"     integer UNIQUE,
    "expiration_date" timestamp,
    "cvv"             integer,
    "user_id"         integer
);

CREATE TABLE "recharges"
(
    "recharge_id"    SERIAL PRIMARY KEY,
    "amount" decimal(10,2),
    "created_at"     timestamp,
    "transpocard_id" integer,
    "bankcard_id"    integer
);

ALTER TABLE "transport_cards"
    ADD CONSTRAINT "fk_transportCard_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");

ALTER TABLE "bank_cards"
    ADD CONSTRAINT "fk_bankCard_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");

ALTER TABLE "recharges"
    ADD CONSTRAINT "fk_recharge_transpocard_id" FOREIGN KEY ("transpocard_id") REFERENCES "transport_cards" ("transpocard_id");

ALTER TABLE "recharges"
    ADD CONSTRAINT "fk_recharge_bankcard_id" FOREIGN KEY ("bankcard_id") REFERENCES "bank_cards" ("bankcard_id");

INSERT INTO "users" ("name", "last_name","document_type", "document_number", "password", "phone", "email","card_number") values ('erich', 'hc','DNI', 75999263, '12345','956738065','erich@gmail.com',123455678)
