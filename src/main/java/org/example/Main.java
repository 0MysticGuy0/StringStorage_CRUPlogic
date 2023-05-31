package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner inp = new Scanner(System.in)) {
            StringStorage storage = new StringStorage();
            CommandParser parser=new CommandParser();

            CommandProcessor.printAvailableCommands();
            CommandProcessor processor = new CommandProcessor(parser,storage);
            while (true) {
                System.out.print("> ");

                try {
                    var command = parser.parse(inp.nextLine());
                    processor.process(command);
                } catch (Exception ex) {  System.out.println(ex.getMessage());    }

                System.out.println("________________________________________");
            }
        }
    }
}