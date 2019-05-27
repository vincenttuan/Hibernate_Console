-- Book_Category 多對多關聯表
CREATE TABLE Book_Category(
    cb_id integer primary key generated always as identity,
    c_id integer constraint c_id_fk references category(c_id),
    b_id integer constraint b_id_fk references book(b_id)
);


