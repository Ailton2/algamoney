create table lancamento(

     id bigint primary key auto_increment,
     descricao varchar(30) not null,
     data_vencimento DATE not null ,
     data_pagamento DATE,
     valor DECIMAL(10,2) not null,
     observacao varchar(150),
     tipo varchar(20) not null,
     id_categoria BIGINT(20) not null,
     id_pessoa BIGINT(20) not null,
     foreign key (id_categoria) references categoria(id),
     foreign key (id_pessoa) references pessoa(id)

)engine=innoDB  default charset=utf8; 