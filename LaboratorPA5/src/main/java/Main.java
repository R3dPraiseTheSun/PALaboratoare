import catalog.Catalog;
import commands.*;
import exceptions.InvalidCatalogException;
import exceptions.InvalidCommand;
import itemtypes.Song;

import freemarker.template.*;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.strings.StringsParser;
import org.xml.sax.SAXException;

import java.io.*;


public class Main implements Commands {
    public static void main(String[] args) throws IOException, InvalidCatalogException, InvalidCommand, ClassNotFoundException, TemplateException, TikaException, SAXException {
        /*        Main app = new Main();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter catalog name: ");
        String name = reader.readLine();

        app.createCatalog(name, null);
        app.createCatalog(name + 2, System.getProperty("user.home") + "\\Desktop\\catalog.ser");
        app.loadCatalog(System.getProperty("user.home") + "\\Desktop\\catalog.ser");

        Catalog catalog = new Catalog("Inca un catalog", System.getProperty("user.home") + "\\Desktop\\catalog2.ser");
        catalog.addItem(new Song(System.getProperty("user.home") + "\\Desktop\\music.mp3"));
        catalog.getItemByID(0).executeFile();
        catalog.listItems();*/


        Catalog catalog = new Catalog();
        boolean isRunning = true;
        while(isRunning){
            System.out.print("Waiting command: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command = reader.readLine();
            switch (command) {
                case "exit":
                    isRunning = false;
                    break;
                case "create":
                    System.out.print("Catalog name: ");
                    BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
                    String name = nameReader.readLine();
                    System.out.print("Catalog path: ");
                    BufferedReader pathReader = new BufferedReader(new InputStreamReader(System.in));
                    catalog = createCatalog(name, pathReader.readLine() + name + ".catalog");
                    break;
                case "save":
                    Save.save(catalog);
                    break;
                case "load":
                    //C:\Users\paula\Desktop\Catalogs\
                    System.out.print("Catalog path: ");
                    BufferedReader pathReaderLoad = new BufferedReader(new InputStreamReader(System.in));
                    catalog = Load.load(pathReaderLoad.readLine());
                    break;
                case "add":
                    //C:\Users\paula\Desktop\Catalogs\Songs
                    System.out.print("Song artist: ");
                    BufferedReader nameReaderAdd = new BufferedReader(new InputStreamReader(System.in));
                    String artistName = nameReaderAdd.readLine();
                    System.out.print("Song path: ");
                    BufferedReader pathReaderAdd = new BufferedReader(new InputStreamReader(System.in));
                    catalog.addItem(new Song(artistName, pathReaderAdd.readLine()));
                    break;
                case "list":
                    List.list(catalog);
                    break;
                case "play":
                    if(catalog.getItemList().size() == 0)
                        throw new InvalidCommand("No songs in this catalog");
                    System.out.println("Select a number between 0 and " + (catalog.getItemList().size()-1) + ":");
                    BufferedReader songID = new BufferedReader(new InputStreamReader(System.in));
                    int id = songID.read() - 48;
                    Play.play(catalog, id);
                    System.out.print("Song artist: " + catalog.getItemByID(id).getArtist() + "\n");
                    break;
                case "report":
                    Report.report(catalog);
                    break;
                case "info":
                    Info.info(catalog);
                    break;
                default:
                    throw new InvalidCommand("command not found");
            }
        }
    }

    private static Catalog createCatalog(String name, String path){
        Catalog catalog = new Catalog();
        try{
            catalog = new Catalog(name, path);
            Save.save(catalog);
        } catch (IOException | InvalidCatalogException exception) {
            exception.printStackTrace();
        }
        return catalog;
    }

    private void loadCatalog(String path) {
        try {
            System.out.println(Load.load(path));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classException) {
            System.out.println("Class not found.");
            classException.printStackTrace();
        }
    }
}
