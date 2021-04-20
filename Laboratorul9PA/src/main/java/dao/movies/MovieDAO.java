package dao.movies;

import java.sql.SQLException;
import java.util.List;

public interface MovieDAO {
    public List<Movie> getEveryMovie() throws SQLException;
    public Movie getMovieById(int id);
    public Movie getMovieByName(String title);

    public void createMovieEntry(Movie movie) throws SQLException;

    public void updateMovie(Movie movie) throws SQLException;
    public void deleteMovie(Movie movie);

    public void closeDBConn();
}
