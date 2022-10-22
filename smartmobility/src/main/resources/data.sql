-- insert autonomous car data
INSERT INTO t_autonomous_car (id, model, manufacturer, number_of_seats, registration_plate, battery_level)
VALUES (1, 'Z1', 'AUDI', 4, 'DWA-0001', 1),
       (2, '5000', 'FIAT', 2, 'KRX-0002', 0.5),
       (3, '20', 'TESLA', 7, 'SKY-0001', 0.2);

-- insert user data
INSERT INTO t_user(id, first_name, last_name, email)
VALUES (1, 'Michael', 'Jordan', 'michael.jordan@chicago-bulls.com'),
       (2, 'Magic', 'Johnson', 'magic.johnson@los-angeles-lakers.com'),
       (3, 'Dirk', 'Nowitzki', 'dirk.nowitzki@dallas-mavericks.com');
