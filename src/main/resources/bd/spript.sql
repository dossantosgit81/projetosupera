create table customer(
  id bigint not null auto_increment,
  name varchar (100) not null,
  email varchar(100) not null,
  primary key(id)
);


create table category(
  id bigint not null auto_increment,
  name varchar(150) not null,
  primary key(id)
);

create table product(
  id bigint not null auto_increment,
  description varchar(255) not null,
  price numeric(19,2) not null,
  category_id integer,
  primary key(id),
  constraint fk_categoryProd foreign key (category_id) references category(id)
);

create table score(
  score numeric(19,2) not null,
  customer_id integer,
  product_id integer,
  constraint fk_customer_score foreign key (customer_id) references customer(id),
  constraint fk_product_score foreign key (product_id) references product(id)
);


create table cart_item(
  id bigint not null auto_increment,
  freight numeric(19,2) ,
  qtd integer,
  subtotal numeric(19,2),
  total numeric(19,2) ,
  customer_id integer,
  product_id integer,
  primary key(id),
  constraint fk_customer_cart_item foreign key (customer_id) references customer(id),
  constraint fk_product_cart_item foreign key (product_id) references product(id)
);



