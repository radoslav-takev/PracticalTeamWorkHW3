package team_workhw3.engine;

import team_workhw3.io.ConsoleInputReader;
import team_workhw3.io.ConsoleOutputWriter;
import team_workhw3.utilities.Constants;
import team_workhw3.utilities.InputParser;

import java.security.InvalidParameterException;
import java.util.List;

public class Engine {

    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private CommandManager commandManager;

    public Engine() {
        this.inputReader = new ConsoleInputReader() ;
        this.outputWriter = new ConsoleOutputWriter();
        this.inputParser = new InputParser();
        this.commandManager = new CommandManager();
    }


    public void run() {

        String inputLine = this.inputReader.readLine();

        List<String> initialList = this.inputParser.parseInput(inputLine);

        this.commandManager.addCollectionToList(initialList);
        this.outputWriter.writeLine(this.commandManager.printList());

        while(true) {
            inputLine = this.inputReader.readLine();
            if (Constants.TERMINATING_COMMAND.equals(inputLine)) {
                break;
            }

            List<String> commandParams = this.inputParser.parseInput(inputLine);
            try {
                this.dispatchCommand(commandParams);

            } catch (InvalidParameterException ipe) {
                this.outputWriter.writeLine(ipe.getMessage());

            } catch (IllegalArgumentException iae){
                this.outputWriter.writeLine(iae.getLocalizedMessage());
            }
        }
    }



    private void dispatchCommand(List<String> commandParams) {

        switch(commandParams.get(0)) {
            case "roll":
                this.commandManager.rollList(commandParams);
                this.outputWriter.writeLine(this.commandManager.printList());
                break;
            case "insert":
                this.commandManager.insertString(commandParams);
                this.outputWriter.writeLine(this.commandManager.printList());
                break;
            default:
                throw new IllegalArgumentException(Constants.ERROR_INVALID_COMMAND);

        }
    }

}
