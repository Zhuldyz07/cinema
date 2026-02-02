package kz.star.cinema.dao;
import kz.star.cinema.model.Movie;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieDAO {

    private final DataSource dataSource;

    public MovieDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // CREATE
    public void addMovie(Movie movie) {
        String sql = "INSERT INTO movies(title, agelimit, rating, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getAgelimit());
            ps.setDouble(3, movie.getRating());
            ps.setDouble(4, movie.getPrice());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Movie> getAllMovies() {
        List<Movie> list = new ArrayList<>();
        String sql = "SELECT * FROM movies";

        try (Connection conn = dataSource.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Movie m = new Movie();
                m.setId(rs.getInt("id"));
                m.setTitle(rs.getString("title"));
                m.setAgelimit(rs.getInt("agelimit"));
                m.setRating(rs.getDouble("rating"));
                m.setPrice(rs.getDouble("price"));
                list.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // SORT by rating
    public List<Movie> getMoviesSortedByRating() {
        List<Movie> list = new ArrayList<>();
        String sql = "SELECT * FROM movies ORDER BY rating DESC";

        try (Connection conn = dataSource.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Movie m = new Movie();
                m.setId(rs.getInt("id"));
                m.setTitle(rs.getString("title"));
                m.setAgelimit(rs.getInt("agelimit"));
                m.setRating(rs.getDouble("rating"));
                m.setPrice(rs.getDouble("price"));
                list.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public void updateMoviePrice(int id, double price) {
        String sql = "UPDATE movies SET price=? WHERE id=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, price);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteMovie(int id) {
        String sql = "DELETE FROM movies WHERE id=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
