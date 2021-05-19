alter table pessoa drop column cidade;
alter table pessoa drop column estado;

alter table pessoa add column cidade_id bigint(20);
alter table pessoa add constraint fk_cidade foreign key (cidade_id) references cidade(id);