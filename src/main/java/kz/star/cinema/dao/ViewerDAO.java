package kz.star.cinema.dao;

import kz.star.cinema.model.Viewer;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ViewerDAO {

    private final DataSource dataSource;

    public ViewerDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // CREATE
    public void addViewer(Viewer viewer) {
        String sql = "INSERT INTO viewers(name, age, movie) VALUES (?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, viewer.getName());
            ps.setInt(2, viewer.getAge());
            ps.setString(3, viewer.getMovie());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Viewer> getAllViewers() {
        List<Viewer> list = new ArrayList<>();
        String sql = "SELECT * FROM viewers";

        try (Connection conn = dataSource.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Viewer v = new Viewer();
                v.setId(rs.getInt("id"));
                v.setName(rs.getString("name"));
                v.setAge(rs.getInt("age"));
                v.setMovie(rs.getString("movie"));
                list.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public void updateViewerMovie(int id, String movie) {
        String sql = "UPDATE viewers SET movie=? WHERE id=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, movie);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteViewer(int id) {
        String sql = "DELETE FROM viewers WHERE id=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
