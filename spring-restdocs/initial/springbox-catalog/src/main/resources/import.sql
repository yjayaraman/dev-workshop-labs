insert into genres (name,ml_id,id) values ('unknown',0,1000);
insert into genres (name,ml_id,id) values ('Action',1,1001);
insert into genres (name,ml_id,id) values ('Adventure',2,1002);
insert into genres (name,ml_id,id) values ('Animation',3,1003);
insert into genres (name,ml_id,id) values ('Children''s',4,1004);
insert into genres (name,ml_id,id) values ('Comedy',5,1005);
insert into genres (name,ml_id,id) values ('Crime',6,1006);
insert into genres (name,ml_id,id) values ('Documentary',7,1007);
insert into genres (name,ml_id,id) values ('Drama',8,1008);
insert into genres (name,ml_id,id) values ('Fantasy',9,1009);
insert into genres (name,ml_id,id) values ('Film-Noir',10,1010);
insert into genres (name,ml_id,id) values ('Horror',11,1011);
insert into genres (name,ml_id,id) values ('Musical',12,1012);
insert into genres (name,ml_id,id) values ('Mystery',13,1013);
insert into genres (name,ml_id,id) values ('Romance',14,1014);
insert into genres (name,ml_id,id) values ('Sci-Fi',15,1015);
insert into genres (name,ml_id,id) values ('Thriller',16,1016);
insert into genres (name,ml_id,id) values ('War',17,1017);
insert into genres (name,ml_id,id) values ('Western',18,1018);

insert into movies(id,title,ml_id,number_in_stock) values (1000,'Toy Story (1995)','1',10);
insert into movies_genres(movie_id, genre_id) values (1000,1003);
insert into movies_genres(movie_id, genre_id) values (1000,1004);
insert into movies_genres(movie_id, genre_id) values (1000,1005);
insert into movies(id,title,ml_id,number_in_stock) values (1001,'GoldenEye (1995)','2',10);
insert into movies_genres(movie_id, genre_id) values (1001,1001);
insert into movies_genres(movie_id, genre_id) values (1001,1002);
insert into movies_genres(movie_id, genre_id) values (1001,1016);
insert into movies(id,title,ml_id,number_in_stock) values (1002,'Four Rooms (1995)','3',10);
insert into movies_genres(movie_id, genre_id) values (1002,1016);
insert into movies(id,title,ml_id,number_in_stock) values (1003,'Get Shorty (1995)','4',10);
insert into movies_genres(movie_id, genre_id) values (1003,1001);
insert into movies_genres(movie_id, genre_id) values (1003,1005);
insert into movies_genres(movie_id, genre_id) values (1003,1008);
insert into movies(id,title,ml_id,number_in_stock) values (1004,'Copycat (1995)','5',10);
insert into movies_genres(movie_id, genre_id) values (1004,1006);
insert into movies_genres(movie_id, genre_id) values (1004,1008);
insert into movies_genres(movie_id, genre_id) values (1004,1016);
insert into movies(id,title,ml_id,number_in_stock) values (1005,'Shanghai Triad (Yao a yao yao dao waipo qiao) (1995)','6',10);
insert into movies_genres(movie_id, genre_id) values (1005,1008);
insert into movies(id,title,ml_id,number_in_stock) values (1006,'Twelve Monkeys (1995)','7',10);
insert into movies_genres(movie_id, genre_id) values (1006,1008);
insert into movies_genres(movie_id, genre_id) values (1006,1015);
insert into movies(id,title,ml_id,number_in_stock) values (1007,'Babe (1995)','8',10);
insert into movies_genres(movie_id, genre_id) values (1007,1004);
insert into movies_genres(movie_id, genre_id) values (1007,1005);
insert into movies_genres(movie_id, genre_id) values (1007,1008);
insert into movies(id,title,ml_id,number_in_stock) values (1008,'Dead Man Walking (1995)','9',10);
insert into movies_genres(movie_id, genre_id) values (1008,1008);
insert into movies(id,title,ml_id,number_in_stock) values (1009,'Richard III (1995)','10',10);
insert into movies_genres(movie_id, genre_id) values (1009,1008);
insert into movies_genres(movie_id, genre_id) values (1009,1017);
insert into movies(id,title,ml_id,number_in_stock) values (1010,'Seven (Se7en) (1995)','11',10);
insert into movies_genres(movie_id, genre_id) values (1010,1006);
insert into movies_genres(movie_id, genre_id) values (1010,1016);
insert into movies(id,title,ml_id,number_in_stock) values (1011,'Usual Suspects, The (1995)','12',10);
insert into movies_genres(movie_id, genre_id) values (1011,1006);
insert into movies_genres(movie_id, genre_id) values (1011,1016);
insert into movies(id,title,ml_id,number_in_stock) values (1012,'Mighty Aphrodite (1995)','13',10);
insert into movies_genres(movie_id, genre_id) values (1012,1005);
insert into movies(id,title,ml_id,number_in_stock) values (1013,'Postino, Il (1994)','14',10);
insert into movies_genres(movie_id, genre_id) values (1013,1008);
insert into movies_genres(movie_id, genre_id) values (1013,1014);
insert into movies(id,title,ml_id,number_in_stock) values (1014,'Mr. Holland''s Opus (1995)','15',10);
insert into movies_genres(movie_id, genre_id) values (1014,1008);
insert into movies(id,title,ml_id,number_in_stock) values (1015,'French Twist (Gazon maudit) (1995)','16',10);
insert into movies_genres(movie_id, genre_id) values (1015,1005);
insert into movies_genres(movie_id, genre_id) values (1015,1014);
insert into movies(id,title,ml_id,number_in_stock) values (1016,'From Dusk Till Dawn (1996)','17',10);
insert into movies_genres(movie_id, genre_id) values (1016,1001);
insert into movies_genres(movie_id, genre_id) values (1016,1005);
insert into movies_genres(movie_id, genre_id) values (1016,1006);
insert into movies_genres(movie_id, genre_id) values (1016,1011);
insert into movies_genres(movie_id, genre_id) values (1016,1016);
insert into movies(id,title,ml_id,number_in_stock) values (1017,'White Balloon, The (1995)','18',10);
insert into movies_genres(movie_id, genre_id) values (1017,1008);
insert into movies(id,title,ml_id,number_in_stock) values (1018,'Antonia''s Line (1995)','19',10);
insert into movies_genres(movie_id, genre_id) values (1018,1008);
insert into movies(id,title,ml_id,number_in_stock) values (1019,'Angels and Insects (1995)','20',10);
insert into movies_genres(movie_id, genre_id) values (1019,1008);
insert into movies_genres(movie_id, genre_id) values (1019,1014);
insert into movies(id,title,ml_id,number_in_stock) values (1020,'Muppet Treasure Island (1996)','21',10);
insert into movies_genres(movie_id, genre_id) values (1020,1001);
insert into movies_genres(movie_id, genre_id) values (1020,1002);
insert into movies_genres(movie_id, genre_id) values (1020,1005);
insert into movies_genres(movie_id, genre_id) values (1020,1012);
insert into movies_genres(movie_id, genre_id) values (1020,1016);
insert into movies(id,title,ml_id,number_in_stock) values (1021,'Braveheart (1995)','22',10);
insert into movies_genres(movie_id, genre_id) values (1021,1001);
insert into movies_genres(movie_id, genre_id) values (1021,1008);
insert into movies_genres(movie_id, genre_id) values (1021,1017);
insert into movies(id,title,ml_id,number_in_stock) values (1022,'Taxi Driver (1976)','23',10);
insert into movies_genres(movie_id, genre_id) values (1022,1008);
insert into movies_genres(movie_id, genre_id) values (1022,1016);
insert into movies(id,title,ml_id,number_in_stock) values (1023,'Rumble in the Bronx (1995)','24',10);
insert into movies_genres(movie_id, genre_id) values (1023,1001);
insert into movies_genres(movie_id, genre_id) values (1023,1002);
insert into movies_genres(movie_id, genre_id) values (1023,1006);
insert into movies(id,title,ml_id,number_in_stock) values (1024,'Birdcage, The (1996)','25',10);
insert into movies_genres(movie_id, genre_id) values (1024,1005);
insert into movies(id,title,ml_id,number_in_stock) values (1025,'Brothers McMullen, The (1995)','26',10);
insert into movies_genres(movie_id, genre_id) values (1025,1005);
insert into movies(id,title,ml_id,number_in_stock) values (1026,'Bad Boys (1995)','27',10);
insert into movies_genres(movie_id, genre_id) values (1026,1001);
insert into movies(id,title,ml_id,number_in_stock) values (1027,'Apollo 13 (1995)','28',10);
insert into movies_genres(movie_id, genre_id) values (1027,1001);
insert into movies_genres(movie_id, genre_id) values (1027,1008);
insert into movies_genres(movie_id, genre_id) values (1027,1016);
