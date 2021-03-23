package exceptions;

public class InvalidCommand extends Exception {
    public InvalidCommand(String err){
        super(err);
    }
}
