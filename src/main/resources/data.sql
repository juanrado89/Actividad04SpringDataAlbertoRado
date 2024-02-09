INSERT INTO product (sku, description,price,stock) VALUES
                                                       ('ni idea','jamon de york',3.20,30),
                                                       ('ni idea','fregasuelos',1.20,40),
                                                       ('ni idea','atun',2.50,100),
                                                       ('ni idea','ventilador',39.99,10),
                                                       ('ni idea','jabon de manos',2.80,35),
                                                       ('ni idea','napolitanaa de chocolate',3.60,50),
                                                       ('ni idea','mejillones',2.20,80),
                                                       ('ni idea','televisor 32 pulgadas',390.20,10),
                                                       ('ni idea','gel de ducha',3.90,30),
                                                       ('ni idea','palmera de chocolate',1.80,10);


INSERT INTO category (product_id, name) VALUES
                                            (1,'Perecedero'),
                                            (2,'Limpieza'),
                                            (3,'Conservas'),
                                            (4,'Electrodomesticos'),
                                            (5,'Higiene personal'),
                                            (6,'Bolleria'),
                                            (7,'Conservas'),
                                            (8,'Electrodomesticos'),
                                            (9,'Higiene personal'),
                                            (10,'Bolleria'),
                                            (8,'Conservas'),
                                            (9,'Limpieza'),
                                            (10,'Perecedero');

INSERT INTO customer (address, email,first_name, last_name, password,phone_number) VALUES
                                                                                                    ('Calle falsa 123', 'cuentafalsa@gmail.com','james', 'bond', '1234567','222555666'),
                                                                                                    ('Elm street', 'fredy@gmail.com','Freddy', 'Krugger', '1234567','999666333');