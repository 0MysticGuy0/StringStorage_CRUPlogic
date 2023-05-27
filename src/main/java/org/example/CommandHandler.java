package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CommandHandler 
{
    public static void printAviableCommands()
    {
        System.out.println("|==================================================|");
        System.out.println("CREATE <строка> - добавить строку");
        System.out.println("GET <индекс> - вывести строку");
        System.out.println("UPDATE <индекс> <строка> - обновить текст строки");
        System.out.println("DELETE <индекс> - удалить строку");
        System.out.println("QUIT - выход");
        System.out.println("|==================================================|");
    }
    public static void process(String command)
    {
        ArrayList<String> commandElements=splitTheCommand(command);

       // for(String e:commandElements) System.out.println(e);

        executeCommand(commandElements);
    }

    private static void executeCommand(ArrayList<String> commandElements)
    {
        String command=commandElements.get(0);
        Integer indx;
        String str;
        try {
            switch (command) {
                case "create":
                    str = getStringParameter(commandElements, 1);
                    StringStorage.add(str);
                    break;
                case "get":
                    indx = getIntegerParameter(commandElements.get(1));
                    StringStorage.get(indx);
                    break;
                case "update":
                    indx = getIntegerParameter(commandElements.get(1));
                    str = getStringParameter(commandElements, 2);
                    StringStorage.update(indx,str);
                    break;
                case "delete":
                    indx = getIntegerParameter(commandElements.get(1));
                    StringStorage.delete(indx);
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

    private static ArrayList<String> splitTheCommand(String command)
    {
        ArrayList<String> commandElements=new ArrayList<>(  Arrays.asList(command.split(" "))   );
        for(int i=0;i<commandElements.size();i++)//удаляю пустые элементы
        {
            if(commandElements.get(i).isBlank())
            {
                commandElements.remove(i);
                i--;
            }
        }
        commandElements.set(0,  commandElements.get(0).toLowerCase());//делаю, чтобы команда была в нижнем регистре
        return commandElements;
    }

    private static void errorMessage(String error)
    {
        System.out.println("Error!!! "+error);
    }

    private static Integer getIntegerParameter(String str) throws IllegalArgumentException
    {
        Integer res=0;
        try {
            res=Integer.parseInt(str);
        }catch(NumberFormatException ex){
            //errorMessage("Incorrect parameter!!!");
            throw new IllegalArgumentException("Needs Integer, not String!");
            //return null;
        }
        return res;
    }

    private static String getStringParameter(ArrayList<String> parameters,int startIndex) throws IndexOutOfBoundsException
    {
        String res="";
        if(startIndex>=parameters.size()){throw new IndexOutOfBoundsException();}
        for (int i = startIndex; i < parameters.size(); i++) {
            res+=parameters.get(i)+" ";
        }
        return res;
    }
}
