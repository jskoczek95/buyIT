CREATE TABLE offers (
id UUID PRIMARY KEY UNIQUE NOT NULL,
title varchar(255) NOT NULL,
description varchar(2000) NOT NULL,
price numeric NOT NULL
);

ALTER TABLE users ALTER COLUMN id SET NOT NULL;