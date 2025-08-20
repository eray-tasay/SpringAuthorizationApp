insert into vendors (username, password, company, register_timestamp) values ('vendor1', '{noop}123', 'company1', current_timestamp);
insert into vendors (username, password, company, register_timestamp) values ('vendor2', '{noop}1234', 'company2', current_timestamp);
insert into vendors (username, password, company, register_timestamp) values ('vendor3', '{noop}12345', 'company3', current_timestamp);

insert into purchasers (username, password, email, birth_date) values ('eray', '{noop}123', 'eray.tasay@hotmial.com', '1995-08-23');
insert into purchasers (username, password, email, birth_date) values ('ahmet', '{noop}1234', 'ahmet.celik@hotmial.com', '1994-08-20');
insert into purchasers (username, password, email, birth_date) values ('zeynep', '{noop}1235', 'zeynep.su@gmail.com', '2000-01-09');

insert into products (name, price, vendor_id) values ('product1', 100, 1);
insert into products (name, price, vendor_id) values ('product2', 200, 1);
insert into products (name, price, vendor_id) values ('product3', 300, 1);

insert into products (name, price, vendor_id) values ('product3', 100, 2);
insert into products (name, price, vendor_id) values ('product4', 200, 2);
insert into products (name, price, vendor_id) values ('product5', 300, 2);

insert into products (name, price, vendor_id) values ('product6', 100, 3);
insert into products (name, price, vendor_id) values ('product7', 200, 3);
insert into products (name, price, vendor_id) values ('product8', 300, 3);

insert into purchases (purchaser_id, product_id) values (1, 1);
insert into purchases (purchaser_id, product_id) values (1, 4);
insert into purchases (purchaser_id, product_id) values (1, 7);

insert into purchases (purchaser_id, product_id) values (2, 2);
insert into purchases (purchaser_id, product_id) values (2, 5);
insert into purchases (purchaser_id, product_id) values (2, 8);

insert into purchases (purchaser_id, product_id) values (3, 3);
insert into purchases (purchaser_id, product_id) values (3, 6);
insert into purchases (purchaser_id, product_id) values (3, 9);
