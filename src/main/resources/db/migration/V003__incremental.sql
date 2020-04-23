CREATE TABLE bids (
id UUID PRIMARY KEY,
offers_id UUID references offers (id),
users_id UUID references users (id),
price numeric not null,
date timestamp not null
);