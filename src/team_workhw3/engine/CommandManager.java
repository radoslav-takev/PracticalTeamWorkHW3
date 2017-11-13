package team_workhw3.engine;

import java.util.LinkedList;
import java.util.List;

public class CommandManager {

    private List<String> list;

    public CommandManager() {
        this.list = new LinkedList<>();
    }

    protected void addCollectionToList(List<String> listToAdd){
        this.list.addAll(listToAdd);
    }

    //TO DO COMMANDS

}
