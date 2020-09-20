drop table  if exists book;
create table book(
  id bigint(20) not null auto_increment,
  reader varchar(128) DEFAULT NULL,
  isbn varchar(128) DEFAULT NULL,
  title varchar(128) DEFAULT NULL,
  author varchar(128) DEFAULT NULL,
  description varchar(128) DEFAULT NULL,
  primary key(id)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8;