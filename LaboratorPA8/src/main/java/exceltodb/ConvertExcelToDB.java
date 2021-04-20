package exceltodb;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ConvertExcelToDB {
    private String URL = "jdbc:mysql://localhost:3306/lab8";
    private String username = "root";
    private String password = "1234";

    public ConvertExcelToDB() throws IOException {
    }


    public void convert() throws IOException {
        /*String excelFilePath = "C:\\Users\\paula\\Desktop\\LaboratorPA8\\src\\main\\resources\\IMDb_movies.csv";

        try {
            FileInputStream inputStream = new FileInputStream(excelFilePath);

            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();

            Connection connection = DriverManager.getConnection(URL, username, password);
            connection.setAutoCommit(false);

            String sqlMov = "INSERT INTO MOVIES (movieID, title, release_date, duration, score) VALUES(?, ?, ?, ?, ?)";
            String sqlGen = "INSERT INTO GENRE (genreID, name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlMov);

            rowIterator.next();

            while(rowIterator.hasNext()){
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                System.out.println(cellIterator.next().getStringCellValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

        BufferedReader input = new BufferedReader(new FileReader(new File("C:\\Users\\paula\\Desktop\\LaboratorPA8\\src\\main\\resources\\IMDb_movies.csv")));
        try {
            String line = null;
            String[] st = null;

            while ((line = input.readLine()) != null) {
                st = line.replace("\"", "").split(",");

                System.out.println("INSERT INTO MOVIES "
                        + "(movieID, title, release_date, duration) VALUES "
                        + "(" + st[0] + ", " + st[1] + ", " + st[4] + ", " + st[6] + ")"
                        + ";"
                        + "COMMIT;\n");
            }
        } finally {
            input.close();
        }
    }
}
