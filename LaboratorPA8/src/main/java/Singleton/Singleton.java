package Singleton;

import dao.genre.Genre;
import dao.movies.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Singleton {

    private final String URL, username, password;
    private Connection connection;

    public Singleton() throws SQLException {
        this.URL = "jdbc:mysql://localhost:3306/lab8";
        this.username = "root";
        this.password = "1234";

        try {
            connection = DriverManager.getConnection(URL, username, password);
            System.out.println("\nThe connection to the MySQL database server was successful.");
        } catch (SQLException e) {
            System.out.println("\nError trying to connect to the server\nError message:\n");
            e.printStackTrace();
        }
    }

    public List<Movie> getMoviesData(){
        try {
            Statement statement = connection.createStatement();

            String sql = "SELECT movieID, title, release_date, duration, score FROM MOVIES";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Movie> movies = new ArrayList<Movie>();
            while(resultSet.next()){
                movies.add(new Movie(
                        resultSet.getInt("movieID"),
                        resultSet.getString("title"),
                        resultSet.getString("release_date"),
                        resultSet.getInt("duration"),
                        resultSet.getFloat("score")
                ));
            }
            resultSet.close();
            return movies;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void insertMovieData(Movie movie){
        try {
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO MOVIES (movieID, title, release_date, duration, score) " +
                    "VALUES (" +
                    movie.getId() + ", " +
                    "'" + movie.getTitle() + "'" + ", " +
                    "STR_TO_DATE(" + "'" + movie.getReleaseDate() + "'" + ",'%Y-%m-%d'), " +
                    movie.getDuration() + ", " +
                    movie.getScore() +
            ")";
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateMovieData(Movie movie){
        try {
            Statement statement = connection.createStatement();

            String sql = "UPDATE MOVIES " +
                    "SET title = " + movie.getTitle() + ", " +
                    "release_date = " + movie.getReleaseDate() + ", " +
                    "duration = " + movie.getDuration() + ", " +
                    "score = " + movie.getScore() +
                    "WHERE moviesID = " +movie.getId();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteMoviesData(Movie movie){
        try {
            Statement statement = connection.createStatement();

            String sql = "DELETE FROM MOVIES " +
                    "WHERE movieID = " + movie.getId();

            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Genre> getGenresData(){
        try {
            Statement statement = connection.createStatement();

            String sql = "SELECT movieID, title, release_date, duration, score FROM MOVIES";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Genre> genres = new ArrayList<Genre>();
            while(resultSet.next()){
                genres.add(new Genre(
                        resultSet.getInt("movieID"),
                        resultSet.getString("name")
                ));
            }
            resultSet.close();
            return genres;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void insertGenresData(Genre genre){
        try {
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO MOVIES (genreID, name) " +
                    "VALUES (" +
                    genre.getId() + ", " +
                    "'" + genre.getType() + "')";

            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateGenresData(Genre movie){
        try {
            Statement statement = connection.createStatement();

            String sql = "UPDATE MOVIES " +
                    "SET name = " + movie.getType() + ", " +
                    "WHERE moviesID = " +movie.getId();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteGenresData(Movie movie){
        try {
            Statement statement = connection.createStatement();

            String sql = "DELETE FROM MOVIES " +
                    "WHERE movieID = " + movie.getId();

            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeDbConnection(){
        try {
            connection.close();
            System.out.println("Connection closed successfully");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}