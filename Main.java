import command.Commander;
import data.Parser;

import java.util.Scanner;
import java.util.Stack;

import data.format.MusicBand;

/**
 * @author Ким Даниил Кванхенович
 */

public class Main {

    public static void main(String[] args) {

        String data_path = System.getenv("DPATH");
        if (data_path == null) {
            System.out.println("Переменная окружения не найдена");
            System.exit(1);
        } else {

            /* Forming collection of instances of MusicBand class */
            Stack<MusicBand> collection = Parser.serialize(data_path);

            /* Code need for receiving commands from terminal */
            Scanner sc = new Scanner(System.in);
            while (true) {                                              //while not receiving "exit" command
                Commander.doCommand(collection, data_path, sc);
            }
        }

    }
}
