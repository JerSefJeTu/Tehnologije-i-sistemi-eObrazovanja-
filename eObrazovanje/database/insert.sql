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

insert into korisnik(user_name,password,tip_korisnika,first_name, last_name,jmbg,current_address,date_of_birth,e_mail,phone_number,place_of_origin) values('predavac','$2a$10$YNBzKhqMEAz6VT3ShzmpruOiUrytz3tLec/nwyN/GTifF/leWq7cK','PREDAVAC','Predavač','Predavačić','06069667132007','Predavačka ulica 11, Novi Sad', '1966-06-06', 'predavač@mail.net','067/333-333','Novi Sad, Srbija');
insert into predavac(korisnik_id,aktivan) values(2,true);

insert into korisnik(user_name,password,tip_korisnika,first_name, last_name,jmbg,current_address,date_of_birth,e_mail,phone_number,place_of_origin)values('student','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','Imenko','Prezimenković','06069967132007','Studentska ulica 17, Sombor', '1996-06-06', 'student@mail.net','067/555-333','Sombor, Srbija');
insert into student(korisnik_id,stanje) values(3,0);
insert into korisnik(user_name,password,tip_korisnika,first_name, last_name,jmbg,current_address,date_of_birth,e_mail,phone_number,place_of_origin)values('pera','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','Petar','Petrović','01019900185332','Perina ulica 1, Novi Sad','1990-01-01','pera@mail.net','063/555-333','Novi Sad, Srbija');
insert into student(korisnik_id,stanje) values(4,0);
insert into korisnik(user_name,password,tip_korisnika,first_name, last_name,jmbg,current_address,date_of_birth,e_mail,phone_number,place_of_origin)values('djole','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','Djordje','Djordjević','05109930181368','Djoletova ulica 2, Beograd','1993-10-05','djole@mail.net','062/555-333','Beograd, Srbija');
insert into student(korisnik_id,stanje) values(5,0);
insert into korisnik(user_name,password,tip_korisnika,first_name, last_name,jmbg,current_address,date_of_birth,e_mail,phone_number,place_of_origin)values('marko','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','Marko','Marković','18039890881358','Maretova ulica 2, Niš','1989-03-18','mare@mail.net','065/555-333','Niš, Srbija');
insert into student(korisnik_id,stanje) values(6,0);
insert into korisnik(user_name,password,tip_korisnika,first_name, last_name,jmbg,current_address,date_of_birth,e_mail,phone_number,place_of_origin)values('steva','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','Stevan','Stevanović','11109950164365','Stevina ulica 2, Kragujevac','1995-10-11','steva@mail.net','066/555-333','Kragujevac, Srbija');
insert into student(korisnik_id,stanje) values(7,0);
insert into korisnik(user_name,password,tip_korisnika,first_name, last_name,jmbg,current_address,date_of_birth,e_mail,phone_number,place_of_origin)values('laza','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','Stevan','Stevanović','11109950164365','Stevina ulica 2, Kragujevac','1995-10-11','steva@mail.net','066/555-333','Kragujevac, Srbija');
insert into student(korisnik_id,stanje) values(8,0);
insert into korisnik(user_name,password,tip_korisnika,first_name, last_name,jmbg,current_address,date_of_birth,e_mail,phone_number,place_of_origin)values('djoka','$2a$10$MGAEQ8fwJbZxknoCoXdnwuZAZiZeU30bm55kDhinBQhC4KFxuToBK','STUDENT','Stevan','Stevanović','11109950164365','Stevina ulica 2, Kragujevac','1995-10-11','steva@mail.net','066/555-333','Kragujevac, Srbija');
insert into student(korisnik_id,stanje) values(9,0);

insert into predavac_predmeti values(2,1);
insert into predavac_predmeti values(2,2);
insert into predavac_kursevi values(2,1);

insert into predispitna_obaveza(broj_bodova,min_bodova,maxbodova,polozio,naziv_obaveze,kurs_id)values(0,10,15,1,'Kolokvijum 1',1);
insert into predispitna_obaveza(broj_bodova,min_bodova,maxbodova,polozio,naziv_obaveze,kurs_id)values(0,10,15,1,'Kolokvijum 2',1);
insert into predispitna_obaveza(broj_bodova,min_bodova,maxbodova,polozio,naziv_obaveze,kurs_id)values(0,10,15,1,'Usmeni',1);





insert into uplata(iznos,svrha_uplate,student_korisnik_id)values(111,'Skolarina',3);
insert into uplata(iznos,svrha_uplate,student_korisnik_id)values(111,'Skolarina',3);
insert into uplata(iznos,svrha_uplate,student_korisnik_id)values(111,'Skolarina',3);


