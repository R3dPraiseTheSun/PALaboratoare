package dao.movies;

public class Movie {
    private int id;
    private String title;
    private String releaseDate;
    private int duration;
    private float score;

    public Movie(int id, String title, String releaseDate, int duration, float score){
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public int getDuration() {
        return duration;
    }
    public float getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }
}
