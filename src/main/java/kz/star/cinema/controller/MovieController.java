package kz.star.cinema.controller;

import kz.star.cinema.dao.MovieDAO;
import kz.star.cinema.model.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieDAO movieDAO;

    public MovieController(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    // CREATE
    @PostMapping
    public String addMovie(@RequestBody Movie movie) {
        movieDAO.addMovie(movie);
        return "Movie added successfully";
    }

    // READ
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    // SORT by rating
    @GetMapping("/sorted")
    public List<Movie> getMoviesSortedByRating() {
        return movieDAO.getMoviesSortedByRating();
    }

    // UPDATE
    @PutMapping("/{id}/price")
    public String updateMoviePrice(@PathVariable int id, @RequestParam double price) {
        movieDAO.updateMoviePrice(id, price);
        return "Movie price updated";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable int id) {
        movieDAO.deleteMovie(id);
        return "Movie deleted";
    }
}
