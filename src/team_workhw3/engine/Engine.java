package team_workhw3.engine;

import team_workhw3.io.ConsoleInputReader;
import team_workhw3.io.ConsoleOutputWriter;
import team_workhw3.utilities.Constants;
import team_workhw3.utilities.InputParser;

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

        //TO DO first list print after user input
        this.initialListPrint();

        while(true) {

            inputLine = this.inputReader.readLine();
            if (Constants.TERMINATING_COMMAND.equals(inputLine)) {
                break;
            }

            List<String> commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
        }
    }



    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch(command) {

        }
    }

    private void initialListPrint() {
    }

}
