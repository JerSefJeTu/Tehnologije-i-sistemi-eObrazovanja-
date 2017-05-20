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
set foreign_key_checks = 1;



insert into predmet (naziv) values ('Osnove Programiranja');
insert into predmet (naziv) values ('XML Tehnologije');

insert into kurs (naziv,predmet_id) values('Osnove Programiranja 2015' ,1);

insert into korisnik(user_name,password,tip_korisnika) values('admin','$2a$04$SwzgBrIJZhfnzOw7KFcdzOTiY6EFVwIpG7fkF/D1w26G1.fWsi.aK','ADMIN');
insert into administrator(korisnik_id) values(1);

insert into korisnik(user_name,password,tip_korisnika) values('predavac','$2a$10$YNBzKhqMEAz6VT3ShzmpruOiUrytz3tLec/nwyN/GTifF/leWq7cK','PREDAVAC');
insert into predavac(korisnik_id,aktivan) values(2,true);

insert into korisnik(user_name,password,tip_korisnika) values('student','$2a$10$a/wDPpymAawmvgHnSpaWaeem6Wr.QXDtp2ECeFA63EmtWO5X2ejeu','STUDENT');
insert into student(korisnik_id,stanje) values(3,0);


