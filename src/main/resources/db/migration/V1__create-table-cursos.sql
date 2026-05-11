CREATE TABLE cursos (
                        id bigint not null auto_increment,
                        nome varchar(100) not null,
                        periodo enum("MATUTINO", "VESPERTINO", "NOTURNO", "INTEGRAL") not null,
                        ativo tinyint not null default 1,

                        primary key(id)
);