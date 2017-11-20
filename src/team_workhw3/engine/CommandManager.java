package team_workhw3.engine;

import team_workhw3.utilities.Constants;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class CommandManager {

    private List<String> list;

    public CommandManager() {
        this.list = new LinkedList<>();
    }

    void addCollectionToList(List<String> listToAdd){
        this.list.addAll(listToAdd);
    }

    String printList() {
        return String.join(" ", this.list);
    }

    void rollList(List<String> commandParams) {
        if (commandParams.size() == 2){

            switch(commandParams.get(1)){
                case "left":
                    String firstElement = this.list.get(0);
                    this.list.add(firstElement);
                    this.list.remove(0);
                    return;

                case "right":
                    String lastElement = this.list.get(this.list.size()-1);
                    this.list.add(0, lastElement);
                    this.list.remove(this.list.size()-1);
                    return;
            }
        }
        throw new InvalidParameterException(Constants.ERROR_INVALID_COMMAND_PARAMETER);
    }
    void insertString(List<String> commandParams) {
        if (commandParams.size() == 3) {
            try {
                int index = Integer.parseInt(commandParams.get(1));
                this.list.add(index -1, commandParams.get(2));
                return;
            } catch (Exception e) {
                throw new InvalidParameterException(String.format("Error: invalid index %s", commandParams.get(1)));
            }
        }
        throw new InvalidParameterException(Constants.ERROR_INVALID_COMMAND_PARAMETER);
    }
	void reverse(List<String> commandParams){
        if (commandParams.size() == 1) {
            Collections.reverse(this.list);
            return;
        }
        throw new InvalidParameterException(Constants.ERROR_INVALID_COMMAND_PARAMETER);
    }
	void sort(List<String> commandParams){
        if (commandParams.size() == 1) {
            Collections.sort(this.list);
            return;
        }
        throw new InvalidParameterException(Constants.ERROR_INVALID_COMMAND_PARAMETER);
    }

    void append(List<String> commandParams) {
        if (commandParams.size() == 2) {
            String text = commandParams.get(1);
            this.list.add(list.size(), text);
            return;
        }

    }

    void prepend(List<String> commandParams) {
        if (commandParams.size() == 2) {
            String text = commandParams.get(1);
            this.list.add(0, text);
            return;
        }
    }
	
    void delete(List<String> commandParams) {
        if (commandParams.size() == 2) {
            try {
                int index = Integer.parseInt(commandParams.get(1));
                this.list.remove(index);
                return;
            } catch (Exception e) {
                throw new InvalidParameterException(String.format("Error: invalid index %s", commandParams.get(1)));
            }
        }
        throw new InvalidParameterException(Constants.ERROR_INVALID_COMMAND_PARAMETER);
    }

    String count(List<String> commandParams) {
        int counter = 0;
        if (commandParams.size() == 2) {
            String searchText = commandParams.get(1);
            for (int i = 0; i < this.list.size(); i++) {
                if (searchText.equals(this.list.get(i))) {
                    counter++;
                }
            }
            return String.valueOf(counter);
        }

        throw new InvalidParameterException(Constants.ERROR_INVALID_COMMAND_PARAMETER);
    }


}
