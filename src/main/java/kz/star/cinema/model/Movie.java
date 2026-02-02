package kz.star.cinema.model;

import java.util.Objects;

public class Movie {
    private int id;
    private String title;
    private int agelimit;
    private double rating;
    private double price;

    public Movie(){}

    public Movie(int id, String title, int agelimit, double rating, double price) {
        this.id = id;
        this.title = title;
        this.agelimit = agelimit;
        this.rating = rating;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getAgelimit() {
        return agelimit;
    }
    public double getRating() {
        return rating;
    }
    public double getPrice() {
        return price;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAgelimit(int agelimit) {
        this.agelimit = agelimit;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\''+
                ", agelimit=" + agelimit +
                ", rating='" + rating +
                ", price='" + price +
                '}';
    }




}

