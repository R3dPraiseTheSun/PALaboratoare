import Singleton.Singleton;
import dao.movies.Movie;
import dao.movies.MovieDAO;
import dao.movies.MovieDAOImplemented;
import exceltodb.ConvertExcelToDB;

import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        MovieDAO movieDAO = new MovieDAOImplemented();

        for(Movie movie : movieDAO.getEveryMovie()){
            System.out.println(movie.toString());
        }
        System.out.println();

        //test entry
        Movie test = new Movie(
                11,
                "TestTitle",
                "2000-01-01",
                99,
                10
        );
        movieDAO.createMovieEntry(test);

        for(Movie movie : movieDAO.getEveryMovie()){
            System.out.println(movie.toString());
        }
        movieDAO.deleteMovie(test);

        System.out.println();
        for(Movie movie : movieDAO.getEveryMovie()){
            System.out.println(movie.toString());
        }

        movieDAO.closeDBConn();

/*        try {
            new ConvertExcelToDB().convert();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }*/
    }
}
