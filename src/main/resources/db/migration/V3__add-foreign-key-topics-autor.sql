alter table topics
add constraint fk_topics_autor
foreign key (autor_id)
references autor(id);