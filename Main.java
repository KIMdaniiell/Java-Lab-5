import command.Commander;
import data.Parser;

import java.util.Scanner;
import java.util.Stack;
import data.format.MusicBand;

/**
 * @author Ким Даниил Кванхенович
 */

public class Main {

    public static void main(String[] args){

        String data_path = System.getenv("DPATH");
        if (data_path==null){
            System.out.println("Переменная окружения не найдена");
        } else {
            String outdata_path = data_path;
            Stack<MusicBand> mycollection = Parser.serialize(data_path);

            /**
             * Code need for receiving commands from terminal
             */
            Commander commander = new Commander();
            Scanner sc = new Scanner(System.in);
            while (true) {                                              //while not receiving "exit" command
                commander.doCommand(mycollection, outdata_path, sc);
            }
        }

    }
}
