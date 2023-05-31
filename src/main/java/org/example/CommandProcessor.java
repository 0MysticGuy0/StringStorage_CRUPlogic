package org.example;

import java.util.ArrayList;

public class CommandProcessor
{
    private final StringStorage storage;
    private final CommandParser parser;
    public CommandProcessor(CommandParser parser,StringStorage storage)
    {
        this.storage=storage;
        this.parser=parser;
    }
    public static void printAvailableCommands()
    {
        System.out.println("|==================================================|");
        System.out.println("| CREATE <строка> - добавить строку                |");
        System.out.println("| GET - вывести все существующие строки            |");
        System.out.println("| GET <индекс> - вывести строку                    |");
        System.out.println("| UPDATE <индекс> <строка> - обновить текст строки |");
        System.out.println("| DELETE <индекс> - удалить строку                 |");
        System.out.println("| HELP - список доступных команд                   |");
        System.out.println("| QUIT - выход                                     |");
        System.out.println("|==================================================|");
    }
    public void process( ArrayList<String> commandElements)
    {
        String command=commandElements.get(0);
        Integer indx;
        String str;
        try {
            switch (command) {
                case "create":
                    str = parser.getStringParameter(commandElements, 1);
                    System.out.println("String saved with id = "+ storage.add(str));
                    break;
                case "get":
                    if(commandElements.size()==1) {//get all the strings
                        for(var string: storage.getAll().entrySet()){
                            System.out.println("String "+string.getKey()+" : "+string.getValue());
                        }
                    }
                    else {
                        indx = parser.getIntegerParameter(commandElements.get(1));
                        System.out.println(storage.get(indx));
                    }
                    break;
                case "update":
                    indx = parser.getIntegerParameter(commandElements.get(1));
                    str = parser.getStringParameter(commandElements, 2);
                    storage.update(indx,str);
                    System.out.println("String "+indx+" was updated!");
                    break;
                case "delete":
                    indx = parser.getIntegerParameter(commandElements.get(1));
                    storage.delete(indx);
                    System.out.println("String "+indx+" was deleted!");
                    break;
                case "help":
                    printAvailableCommands();
                    break;
                case "quit":
                    System.exit(0);
                    break;

                default:
                    errorMessage("Unknown command!!!");
            }
        } catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        } catch(IndexOutOfBoundsException ex){
            errorMessage("The Argument is Empty!");
        }
    }

    private static void errorMessage(String error) {
        System.out.println("Error!!! "+error);
    }
}
