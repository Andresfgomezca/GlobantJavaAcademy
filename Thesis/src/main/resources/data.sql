DELETE FROM confirmation_token;
DELETE FROM users;
ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE confirmation_token_id_seq RESTART WITH 1;
