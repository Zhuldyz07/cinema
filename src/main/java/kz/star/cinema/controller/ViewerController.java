package kz.star.cinema.controller;
import kz.star.cinema.dao.ViewerDAO;
import kz.star.cinema.model.Viewer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/viewers")
public class ViewerController {

    private final ViewerDAO viewerDAO;

    public ViewerController(ViewerDAO viewerDAO) {
        this.viewerDAO = viewerDAO;
    }

    // CREATE (POST)
    @PostMapping
    public String addViewer(@RequestBody Viewer viewer) {
        viewerDAO.addViewer(viewer);
        return "Viewer added successfully";
    }

    // READ (GET)
    @GetMapping
    public List<Viewer> getAllViewers() {
        return viewerDAO.getAllViewers();
    }

    // UPDATE
    @PutMapping("/{id}/movie")
    public String updateViewerMovie(@PathVariable int id, @RequestParam String movie) {
        viewerDAO.updateViewerMovie(id, movie);
        return "Viewer movie updated";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteViewer(@PathVariable int id) {
        viewerDAO.deleteViewer(id);
        return "Viewer deleted";
    }
}
