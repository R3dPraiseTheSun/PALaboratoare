package exceltodb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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


    public void convert() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File excelFile = new File(classLoader.getResource("IMDb movies.csv").getFile());
        String excelFilePath = excelFile.getPath();

        try {
            FileInputStream inputStream = new FileInputStream(excelFilePath);

            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();

            Connection connection = DriverManager.getConnection(URL, username, password);
            connection.setAutoCommit(false);

            String sqlMov = "INSERT INTO MOVIES (name, enrolled, progress) VALUES (?, ?, ?)";
            String sqlGen = "INSERT INTO GENRE (name, enrolled, progress) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlMov);

            int count = 0;

            rowIterator.next(); // skip the header row

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
