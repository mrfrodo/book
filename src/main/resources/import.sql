
insert into books (id, title, firstname, lastname, created) values (0, 'Jboss Seam', 'Michael Juntao', 'Yuan','1.1.2001')
insert into books (id, title, firstname, lastname, created) values (1, 'Java 4 experts', 'frode', 'johnson','2.1.1999')
insert into books (id, title, firstname, lastname, created) values (2, 'Java 4 experts22', 'frode22', 'johnson','2.1.1999')

update hibernate_sequence set next_val = (select MAX(id) from books) +1