create table Tables (tID int,tCapacity int, primary key(tID));

create table signInfo(uName varchar(10),pword varchar(25),user varchar(7));

create table product(pID int, pname varchar(25), price double, primary key (pID));

create table receipt(rdate date, rID int, primary key(rID));

create table reservation( tableNo int, resID int, resDate date, primary key(resID), foreign key(tableNo) references Tables(tID));

create table recHist(price double, pID int, rID int, foreign key(pID) references product(pID), foreign key(rID) references receipt(rID));