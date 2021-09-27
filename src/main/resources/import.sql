insert into customer(id, name, email) values (1, 'Cristiano Ronaldo', 'cr7@gmail.com');
insert into customer(id, name, email) values (2, 'Chris Paul', 'cp3@gmail.com');
insert into customer(id, name, email) values (3, 'Ronaldo Nazário', 'r9@gmail.com');
insert into customer(id, name, email) values (4, 'Kyre Irving', 'k2@gmail.com');
insert into customer(id, name, email) values (5, 'Lionel Messi', 'm10@gmail.com');
insert into customer(id, name, email) values (6, 'Lebron James', 'lj23@gmail.com');

insert into category(id, name) values (1, 'esporte');
insert into category(id, name) values (2, 'aventura');
insert into category(id, name) values (3, 'estrategia');

insert into product (id, description, price, category_id) values (1, 'Clash Royale', 25.00, 3);
insert into product (id, description, price, category_id) values (2, 'Clash of Clans', 10.00, 3);
insert into product (id, description, price, category_id) values (3, 'Xadrez', 10.00, 2);
insert into product (id, description, price, category_id) values (4, 'Dama', 5.00, 2);
insert into product (id, description, price, category_id) values (5, 'Fifa Mobile', 50.00, 1);
insert into product (id, description, price, category_id) values (6, 'NBA Mobile', 25.00, 1);

insert into score (score, customer_id, product_id) values (4.5, 1, 1);
insert into score (score, customer_id, product_id) values (3.7, 2, 2);
insert into score (score, customer_id, product_id) values (4.9, 3, 3);
insert into score (score, customer_id, product_id) values (2.2, 4, 4);
insert into score (score, customer_id, product_id) values (5, 5, 5);
insert into score (score, customer_id, product_id) values (4.6, 6, 6);

insert into cart_item (id, freight, qtd, subtotal, total, customer_id, product_id) values (1, 20.00, 2, 50.00, 70.00, 1, 1);
insert into cart_item (id, freight, qtd, subtotal, total, customer_id, product_id) values (2, 10.00, 1, 10.00, 20.00, 2, 3);

