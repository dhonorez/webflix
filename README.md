# webflix

This project illustrates how to use Spring Data Repositories to leverage your database possibilities.

## The Application

The application reads a list of movies from a file, stores them in a database, and finally lists all records in the database.

## Approach

I've tried to make the steps clear by branching each step:
1. HashMap implementation
2. JPA in-memory db
3. JPA mysql
4. mongoDB

## Running

The program can be ran via command-line using the following command:
`mvn spring-boot:run`

MySQL and mongoDB can be ran using docker:
`docker-compose up`

