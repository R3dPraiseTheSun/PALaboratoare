package dao.genre;

import java.sql.SQLException;
import java.util.List;

public interface GenreDAO {
    public List<Genre> getEveryGenre() throws SQLException;
    public Genre getGenreById(int id);
    public Genre getGenreByType(String type);

    public void updateGenre(Genre genre) throws SQLException;

    public void closeDBConn();
}
