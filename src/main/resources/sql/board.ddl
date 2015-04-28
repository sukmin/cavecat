create table board (seq bigint auto_increment primary key,
	title varchar(1000) not null,
    content text,
    read_count bigint default 0,
    reg_id varchar(30),
    mod_id varchar(30),
    reg_ymdt datetime,
    mod_ymdt datetime,
    del_yn enum('y','n') default 'n'
 )