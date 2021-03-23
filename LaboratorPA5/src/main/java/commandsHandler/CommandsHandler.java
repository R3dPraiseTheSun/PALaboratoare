package commandsHandler;

import catalog.Catalog;
import commands.Commands;
import commands.Save;
import exceptions.InvalidCatalogException;
import exceptions.InvalidCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandsHandler implements Commands {
    private String command;
    public CommandsHandler(String command){
        this.command = command;
    }
    public void ExecuteCommand() throws InvalidCommand, IOException {
        switch (command){
            case "create":
                System.out.print("Catalog name: ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String name = reader.readLine();
                createCatalog(name, System.getProperty("user.home") + "\\Desktop\\" + name + ".catalog");
                break;
            case "save":
                break;
            case "load":
                break;
            case "add":
                break;
            case "list":
                break;
            case "play":
                break;
            case "exit":
                break;
            default:
                throw new InvalidCommand("Command not found");
        }
    }
    private void createCatalog(String name, String path){
        try{
            Catalog catalog = new Catalog(name, path);
            Save.save(catalog);
        } catch (IOException | InvalidCatalogException exception) {
            exception.printStackTrace();
        }
    }
}
