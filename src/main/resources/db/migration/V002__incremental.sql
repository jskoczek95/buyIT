CREATE TABLE offers (
id UUID PRIMARY KEY UNIQUE NOT NULL,
title varchar(255) NOT NULL,
description varchar(2000) NOT NULL,
starting_price numeric NOT NULL,
expiration_date timestamp not null,
user_id UUID references users (id) not null
);