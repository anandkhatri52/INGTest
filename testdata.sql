INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope,
authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity,
refresh_token_validity, additional_information, autoapprove)
VALUES('7b5a38705d7b3562655925406a652e32', 'oauth2-resource', '$2a$10$zURAPnRmfe0XPjN3hRfdMu7UI.PVJiVFQEgYl3JdkP6oSNGPuoMQa', 'read,write,trust', 'password,authorization_code,refresh_token,implicit', '', 'ROLE_CLIENT,ROLE_TRUSTED_CLIENT', '1000', NULL, '{}', '');


INSERT INTO users (username, password, enabled) VALUES ('anand', 'pass', '1');
INSERT INTO users (username, password, enabled) VALUES ('khatri', 'pass', '1');


INSERT INTO authorities (username, authority) VALUES ('anand', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('khatri', 'ROLE_USER');




