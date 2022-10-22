-- insert autonomous car data
INSERT INTO t_autonomous_car (model, manufacturer, number_of_seats, registration_plate, battery_level)
VALUES ('Z1', 'AUDI', 4, 'DWA-0001', 1),
       ('5000', 'FIAT', 2, 'KRX-0002', 0.5),
       ('20', 'TESLA', 7, 'SKY-0001', 0.2);

-- insert user data
INSERT INTO t_user(first_name, last_name, email)
VALUES ('Michael', 'Jordan', 'michael.jordan@chicago-bulls.com'),
       ('Magic', 'Johnson', 'magic.johnson@los-angeles-lakers.com'),
       ('Dirk', 'Nowitzki', 'dirk.nowitzki@dallas-mavericks.com');
