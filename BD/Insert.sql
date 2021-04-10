
--book table--

insert into BOOK values (NULL, 'Gone with the Wind', 'Margaret Mithcell');
insert into BOOK values (NULL, 'Numele trandafirului', 'Umberto Eco');
insert into BOOK values (NULL, 'Marele Gatsby', 'F. Scott Fitzgerald');
insert into BOOK values (NULL, '10 negri mititei', 'Agatha Christie');
insert into BOOK values (NULL, 'Doamna Bovary', 'Gustave Flaubert');

select * from  BOOK;

--comic book table--

insert into COMICBOOK values (NULL, 'The Amazing Spider-Man', 40);
insert into COMICBOOK values (NULL, 'The Amazing Spider-Man', 41);
insert into COMICBOOK values (NULL, 'The Amazing Spider-Man', 42);
insert into COMICBOOK values (NULL, 'Captain America', 20);
insert into COMICBOOK values (NULL, 'Captain America', 21);

select * from COMICBOOK;

--client table--

insert into CLIENT values (NULL, 'Dorina Matei');
insert into CLIENT values (NULL, 'Andrei Radu');
insert into CLIENT values (NULL, 'Carla Irimia');
insert into CLIENT values (NULL, 'Leo Popa');
insert into CLIENT values (NULL, 'Geanina Marcu');

select * from CLIENT;

--rental table--
insert into RENTAL values (NULL, '3/02/2020','15/02/2020',
    (select id_book from BOOK where id_book=1),NULL, (select id_client from CLIENT where id_client=1));








