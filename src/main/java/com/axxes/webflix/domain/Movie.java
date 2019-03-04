package com.axxes.webflix.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;

@Document
public class Movie {

    @Id
    private int id;

    @Field
    private String imdb;

    @Field
    private String name;

    @Field
    private int year;

    @Field
    private int score;

    @Field
    private String[] tags;

    public Movie(){}

    public Movie(int id, String imdb, String name, int year, int score, String[] tags) {
        this.id = id;
        this.imdb = imdb;
        this.name = name;
        this.year = year;
        this.score = score;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", imdb='" + imdb + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", score=" + score +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }

}
