package kz.star.cinema.model;

public class Viewer extends Person{
    private int id;
    private String movie;

    public Viewer(){
        super();
    }

    public Viewer(int id, String name, int age, String movie) {
        super(name, age);
        this.id = id;
        this.movie = movie;
    }
    @Override
    public String getRole() {
        return "Viewer";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMovie() {
        return movie;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }

}
