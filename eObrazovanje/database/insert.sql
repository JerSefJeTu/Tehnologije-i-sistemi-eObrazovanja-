use eobrazovanje;
set foreign_key_checks = 0;


-- delete all rows
truncate table administrator;
truncate table dokument;
truncate table korisnik;
truncate table kurs; 
truncate table pohadjanje;
truncate table polaganje_ispita;
truncate table predavac;
truncate table predavac_kursevi;
truncate table predispitna_obaveza;
truncate table predispitna_predavac;
truncate table predmet;
truncate table student;
truncate table uplata;
truncate table vrsta_predavaca;
truncate table predavac_predmeti;
truncate table predavac_kursevi;
truncate table polaganje_ispita;
truncate table predispitna_obaveza;
truncate table pohadjanje;
set foreign_key_checks = 1;



insert into predmet (naziv) values ('Osnove Programiranja');
insert into predmet (naziv) values ('XML Tehnologije');

insert into kurs (naziv,predmet_id) values('Osnove Programiranja 2015' ,1);
insert into kurs (naziv,predmet_id) values('Osnove Programiranja 2016' ,1);

insert into korisnik(user_name,password,tip_korisnika) values('admin','$2a$04$SwzgBrIJZhfnzOw7KFcdzOTiY6EFVwIpG7fkF/D1w26G1.fWsi.aK','ADMIN');
insert into administrator(korisnik_id) values(1);

insert into korisnik(user_name,password,tip_korisnika) values('predavac','$2a$10$YNBzKhqMEAz6VT3ShzmpruOiUrytz3tLec/nwyN/GTifF/leWq7cK','PREDAVAC');
insert into predavac(korisnik_id,aktivan) values(2,true);

insert into korisnik(user_name,password,tip_korisnika,first_name)values('student','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','govnusina');
insert into student(korisnik_id,stanje) values(3,0);
insert into korisnik(user_name,password,tip_korisnika,first_name)values('aca','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','aca');
insert into student(korisnik_id,stanje) values(4,0);
insert into korisnik(user_name,password,tip_korisnika,first_name)values('djoka','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','djoka');
insert into student(korisnik_id,stanje) values(5,0);
insert into korisnik(user_name,password,tip_korisnika,first_name)values('steva','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','steva');
insert into student(korisnik_id,stanje) values(6,0);
insert into korisnik(user_name,password,tip_korisnika,first_name)values('mita','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','mita');
insert into student(korisnik_id,stanje) values(7,0);

insert into predavac_predmeti values(2,1);
insert into predavac_kursevi values(2,1);
insert into polaganje_ispita(broj_bodova,ocena)values(22,2);
insert into polaganje_ispita(broj_bodova,ocena)values(22,2);
insert into polaganje_ispita(broj_bodova,ocena)values(22,2);
insert into polaganje_ispita(broj_bodova,ocena)values(22,2);
insert into predispitna_obaveza(broj_bodova,min_bodova,maxbodova,polozio,polaganje_ispita_id)values(11,10,15,1,1);
insert into predispitna_obaveza(broj_bodova,min_bodova,maxbodova,polozio,polaganje_ispita_id)values(11,10,15,1,1);
insert into predispitna_obaveza(broj_bodova,min_bodova,maxbodova,polozio,polaganje_ispita_id)values(11,10,15,1,1);
insert into pohadjanje(kurs_id,polaganje_id,student_korisnik_id)values(1,1,3);
insert into pohadjanje(kurs_id,polaganje_id,student_korisnik_id)values(1,2,4);
insert into pohadjanje(kurs_id,polaganje_id,student_korisnik_id)values(2,3,5);
insert into pohadjanje(kurs_id,polaganje_id,student_korisnik_id)values(2,4,6);
insert into pohadjanje(kurs_id,polaganje_id,student_korisnik_id)values(2,5,7);
