create table board (seq bigint auto_increment primary key,
	title varchar(1000) not null,
    content text,
    short_url varchar(1000),
    read_count bigint default 0,
    reg_id varchar(30),
    mod_id varchar(30),
    reg_ymdt datetime default CURRENT_TIMESTAMP,
    mod_ymdt datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    del_yn enum('y','n') default 'n'
 )