CREATE TABLE cidade (
  id bigint primary key auto_increment,
  nome varchar(120) NOT NULL,
  id_estado bigint(20) NOT NULL,
  foreign key (id_estado) references estado(id)
) engine=innoDB  default charset=utf8; 
