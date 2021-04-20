package dao.genre;

public class Genre {
    private int id;
    private String type;

    public Genre(int id, String type){
        this.id = id;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
