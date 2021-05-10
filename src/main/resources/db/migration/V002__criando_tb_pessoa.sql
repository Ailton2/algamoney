create table pessoa(

     id bigint primary key auto_increment,
     nome varchar(30) not null,
     logradouro varchar(100) ,
     numero varchar(10) ,
     bairro varchar(50),
     cep varchar(10),
     cidade varchar(30),
     estado varchar(20) 



)engine=innoDB  default charset=utf8; 