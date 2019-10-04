# Agaflix
#### Online Movie Streaming, 4th October 2019
#### By **Cates NSENGIYUMVA, Esther Carrelle RANGIRA, Ange INGABIRE, Blandine UWASE**
## Description
An Online movie streaming for local movies
## Setup/Installation Requirements
* Go to GitHub account => www.github.com/esthcarelle
* Go to my repositories.
* Select Movies.
* Click on the green button labeled: clone or download. you can clone or download it directly into your computer.
* Unzip the folder.
* You should have all the project files.
## BDD
* The user will signup for an account.
* The user will be able to login using his/her credentials.
* Once logged in, the user will have a page where he can choose any movie to watch.
* As an admin, he/she will be able to add or delete movies.
* The admin will be able to see all users, and be able to delete them.
In PSQL:
* CREATE DATABASE users;
* CREATE TABLE videos (id serial PRIMARY KEY, video varchar, caption varchar);
* CREATE TABLE users (id serial PRIMARY KEY, name varchar, email varchar, password varchar);
* CREATE TABLE admins (id serial PRIMARY KEY, name varchar, email varchar, password varchar);
## Known Bugs
There no bugs in the application.
## Technologies Used
* Java
* Spark Java
* JQuery
* Postgresql
* Heroku
## Support and contact details
If you run into errors, please feel free to contact us on github.
### License
Copyright (c) 2019 **Cates NSENGIYUMVA, Esther Carrelle RANGIRA, Ange INGABIRE, Blandine UWASE**