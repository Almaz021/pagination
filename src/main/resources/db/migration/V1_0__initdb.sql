create sequence author_seq;

create table author
(
    uuid uuid    NOT NULL,
    name VARCHAR NOT NULL,
    CONSTRAINT account_id_pk PRIMARY KEY (uuid),
    CONSTRAINT account_name_uq UNIQUE (name)
);

create table author_info
(
    uuid     uuid primary key,
    age     INT,
    popular BOOLEAN,
    rating  FLOAT,
    constraint fk_author_info foreign key (uuid) references author (uuid)
);

create table profession(
    id INT,
    name VARCHAR,
    actuality_status VARCHAR
);
