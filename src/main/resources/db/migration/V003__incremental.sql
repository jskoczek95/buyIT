CREATE TABLE bids (
id UUID PRIMARY KEY NOT NULL,
offer_id UUID references offers(id) NOT NULL,
user_id UUID references users(id) NOT NULL,
user_offer numeric NOT NULL,
date timestamp NOT NULL
);