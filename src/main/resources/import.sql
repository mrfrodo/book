
insert into books (id, title, firstname, lastname, created) values (0, 'Jboss Seam', 'Michael Juntao', 'Yuan','1.1.2001')
insert into books (id, title, firstname, lastname, created) values (1, 'Java 4 experts', 'frode', 'johnson','2.1.1999')

update hibernate_sequence set next_val = 2 where next_val = 1;
