CREATE TABLE supplier(
sid varchar,
sname varchar(50),
CONSTRAINT pk_supplier_sid PRIMARY KEY (sid)
);

CREATE TABLE user(
name varchar(50),
password varchar(50),
email varchar(50),
address varchar(50),
phone varchar(50),
country varchar(50),
role varchar(50),
enabled boolean,
CONSTRAINT pk_user_email PRIMARY KEY (email)
);

CREATE TABLE category(
cid varchar(50),
cname varchar(50),
CONSTRAINT pk_category_cid PRIMARY KEY (cid)
);

CREATE TABLE products(
pid int,
pname varchar(50),
pDescription varchar(200),
pPrice int,
pStock int,
pImage varchar(50),
CONSTRAINT pk_products_pid PRIMARY KEY (pid)
);