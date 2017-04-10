# cassandra-assignment


create table user ( email text PRIMARY KEY, password text, userId int);

create table video ( video_Id Int, video_name text PRIMARY KEY, userId int, year timestamp );

create table videoByYear ( video_Id int, video_name text, userId int, year timestamp, PRIMARY KEY (userId,year) );
