CREATE TABLE cc_user( seq int auto_increment not null  primary key,
	cc_id varchar(30) not null,
	cc_email varchar(500) not null,
	cc_passwd varchar(500) not null,
	reg_ymdt datetime default CURRENT_TIMESTAMP,
	del_yn enum('y','n') default 'n'	
);

CREATE UNIQUE INDEX cc_id_index
ON cc_user (cc_id);

insert into cc_user(cc_id,cc_email,cc_passwd) values(
	'id','email',password('passwd')
)
