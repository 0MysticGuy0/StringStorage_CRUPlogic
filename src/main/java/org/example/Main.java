package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        while(true)
        {
            CommandHandler.process(inp.nextLine());
            System.out.println("____________________");
        }
    }
}