package org.example;

import java.util.ArrayList;

public class CommandProcessor
{
    StringStorage storage;
    CommandParser parser;
    public CommandProcessor(StringStorage storage)
    {
        this.storage=storage;
        parser=new CommandParser();
    }
    public static void printAvailableCommands()
    {
        System.out.println("|==================================================|");
        System.out.println("CREATE <строка> - добавить строку");
        System.out.println("GET <индекс> - вывести строку");
        System.out.println("UPDATE <индекс> <строка> - обновить текст строки");
        System.out.println("DELETE <индекс> - удалить строку");
        System.out.println("QUIT - выход");
        System.out.println("|==================================================|");
    }
    public void process(String command)
    {
        try
        {
            ArrayList<String> commandElements = parser.parse(command);
            executeCommand(commandElements);
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private void executeCommand(ArrayList<String> commandElements)
    {
        String command=commandElements.get(0);
        Integer indx;
        String str;
        try {
            switch (command) {
                case "create":
                    str = parser.getStringParameter(commandElements, 1);
                    storage.add(str);
                    break;
                case "get":
                    indx = parser.getIntegerParameter(commandElements.get(1));
                    storage.get(indx);
                    break;
                case "update":
                    indx = parser.getIntegerParameter(commandElements.get(1));
                    str = parser.getStringParameter(commandElements, 2);
                    storage.update(indx,str);
                    break;
                case "delete":
                    indx = parser.getIntegerParameter(commandElements.get(1));
                    storage.delete(indx);
                    break;
                case "quit":
                    System.exit(0);
                    break;

                default:
                    errorMessage("Unknown command!!!");
            }
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }catch(IndexOutOfBoundsException ex){
            errorMessage("The Argument is Empty!");
        }
    }

    private static void errorMessage(String error)
    {
        System.out.println("Error!!! "+error);
    }
}
