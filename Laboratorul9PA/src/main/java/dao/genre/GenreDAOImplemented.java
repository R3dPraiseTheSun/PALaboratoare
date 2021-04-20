package dao.genre;

import Singleton.Singleton;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAOImplemented implements GenreDAO {
    List<Genre> genres;
    Singleton DBConnection;

    public GenreDAOImplemented() throws SQLException {
        DBConnection = new Singleton();
        genres = new ArrayList<Genre>();
        genres = getEveryGenre();
    }

    @Override
    public List<Genre> getEveryGenre() throws SQLException {
        return DBConnection.getGenresData();
    }

    @Override
    public Genre getGenreById(int id) {
        for(Genre genreList : genres){
            if(genreList.getId() == id) {
                return genreList;
            }
        }
        return null;
    }

    @Override
    public Genre getGenreByType(String type) {
        for(Genre genreList : genres){
            if(genreList.getType().equals(type)) {
                return genreList;
            }
        }
        return null;
    }

    @Override
    public void updateGenre(Genre genre) throws SQLException {
        for(Genre genreList : genres){
            if(genre.getId() == genreList.getId()) {
                genres.get(genreList.getId()).equals(genre);
                DBConnection.updateGenresData(genre);
            }
        }
    }

    @Override
    public void closeDBConn() {
        DBConnection.closeDbConnection();
    }
}
