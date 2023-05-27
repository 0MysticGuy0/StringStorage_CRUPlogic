package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandParser
{
    public ArrayList<String> parse(String command) throws IllegalArgumentException
    {
        ArrayList<String> commandElements=new ArrayList<>(  Arrays.asList(  command.split(" ")  )   );

        for(int i=0;i<commandElements.size();i++)//удаляю пустые элементы
        {
            if(commandElements.get(i).isBlank())
            {
                commandElements.remove(i);
                i--;
            }
        }

        if(commandElements.size()==0) throw new IllegalArgumentException("You entered empty string!!!");

        commandElements.set(0, commandElements.get(0).toLowerCase());//делаю, чтобы команда была в нижнем регистре
        return commandElements;

    }

    public Integer getIntegerParameter(String str) throws IllegalArgumentException
    {
        Integer res;
        try
        {
            res=Integer.parseInt(str);
        }catch(NumberFormatException ex)
        {
            throw new IllegalArgumentException("Needs Integer, not String!");
        }
        return res;
    }

    public String getStringParameter(ArrayList<String> parameters,int startIndex) throws IndexOutOfBoundsException
    {
        String res="";
        if(startIndex>=parameters.size()){throw new IndexOutOfBoundsException();}
        for (int i = startIndex; i < parameters.size(); i++) {
            res+=parameters.get(i)+" ";
        }
        return res;
    }

}
