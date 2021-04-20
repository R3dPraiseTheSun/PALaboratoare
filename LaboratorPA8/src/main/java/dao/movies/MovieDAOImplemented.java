package dao.movies;

import Singleton.Singleton;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImplemented implements MovieDAO{
    List<Movie> movies;
    Singleton DBConnection;

    public MovieDAOImplemented() throws SQLException {
        DBConnection = new Singleton();
        movies = new ArrayList<Movie>();
        movies = getEveryMovie();
    }

    @Override
    public List<Movie> getEveryMovie() throws SQLException {
        return DBConnection.getMoviesData();
    }

    @Override
    public Movie getMovieById(int id) {
        for(Movie movieList : movies){
            if(movieList.getId() == id) {
                return movieList;
            }
        }
        return null;
    }

    @Override
    public Movie getMovieByName(String title) {
        for(Movie movieList : movies){
            if(movieList.getTitle().equals(title)) {
                return movieList;
            }
        }
        return null;
    }

    @Override
    public void updateMovie(Movie movie) throws SQLException {
        for(Movie movieList : movies){
            if(movie.getId() == movieList.getId()) {
                movies.get(movieList.getId()).equals(movie);
                DBConnection.updateMovieData(movie);
            }
        }
    }

    @Override
    public void deleteMovie(Movie movie) {
        for(Movie movieList : movies){
            if(movie.getId() == movieList.getId()) {
                movies.remove(movie);
                DBConnection.deleteMoviesData(movie);
                return;
            }
        }
    }

    @Override
    public void createMovieEntry(Movie movie) throws SQLException {
        for(Movie movie1 : movies){
            if(movie.getId() == movie1.getId()) {
                System.out.println("id. " + movie.getId() + " is already used.");
                return;
            }
        }
        movies.add(movie);
        DBConnection.insertMovieData(movie);
    }

    @Override
    public void closeDBConn() {
        DBConnection.closeDbConnection();
    }
}
