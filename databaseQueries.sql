CREATE TABLE supplier(
sid int,
sname varchar(50),
CONSTRAINT pk_supplier_sid PRIMARY KEY (sid)
);

CREATE TABLE user(
uid int,
name varchar(50),
password varchar(50),
email varchar(50),
address varchar(50),
phone varchar(50),
country varchar(50),
role varchar(50),
enabled boolean,
CONSTRAINT pk_user_uid PRIMARY KEY (uid)
);

CREATE TABLE category(
cid int,
cname varchar(50),
CONSTRAINT pk_category_cid PRIMARY KEY (cid)
);

CREATE TABLE products(
pid int,
productName varchar(50),
productDescription varchar(200),
productPrice int,
stock int,
productImage varchar(50),
CONSTRAINT pk_products_pid PRIMARY KEY (pid)
);