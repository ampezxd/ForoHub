create table topics(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(2000) not null,
    fechaCreacion datetime not null,
    autor_id bigint not null,

    primary key (id)

)