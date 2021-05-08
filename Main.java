import data.Parser;

import java.util.Scanner;
import java.util.Stack;
import command.Executor;
import data.format.MusicBand;

/**
 * @author Ким Даниил Кванхенович
 */

public class Main {
    /**
     * Method main of this progect
     * @param args
     */
    public static void main(String[] args){
        String data_path = System.getenv("DPATH");
        String outdata_path = data_path;


        Stack<MusicBand> mycollection = Parser.serialize(data_path);


        /**
         * Code need for reciving commands from terminal
         */
        Scanner sc = new Scanner(System.in);
        String offer = sc.nextLine();
        while (offer.length()!=0) {
            try {
                switch (offer.toLowerCase().split(" ")[0]) {
                    case "help":
                        Executor.help(mycollection, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "info":
                        Executor.info(mycollection, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "show":
                        Executor.show(mycollection, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "clear":
                        mycollection = Executor.clear(mycollection, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "save":
                        Executor.save(mycollection, outdata_path, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "exit":
                        Executor.exit(mycollection, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "reorder":
                        mycollection = Executor.reorder(mycollection, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "sort":
                        mycollection = Executor.sort(mycollection, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "print_field_descending_description":
                        Executor.print_field_descending_description(mycollection, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "filter_less_than_genre":
                        Executor.filter_less_than_genre(mycollection, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "add":
                        Executor.add(mycollection, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "remove_greater":
                        mycollection = Executor.remove_greater(mycollection, offer.split(offer.split(" ")[0] + " "));
                        break;
                    case "update":
                        mycollection = Executor.update(mycollection, offer.split(offer.split(" ")[0] + " ")[1]);
                        break;
                    case "remove_any_by_description":
                        mycollection = Executor.remove_any_by_description(mycollection, offer.split(offer.split(" ")[0] + " ")[1]);
                        break;
                    case "remove_by_id":
                        mycollection = Executor.remove_by_id(mycollection, offer.split(offer.split(" ")[0] + " ")[1]);
                        break;
                    case "execute_script":
                        Executor.execute_script(mycollection, offer.split(offer.split(" ")[0] + " ")[1], outdata_path);
                        break;
                    default:
                        System.out.println("Неизвестная команда\nПовторите ввод.");
                }
            } catch (NumberFormatException e){
                System.out.println("Неверный формат ввода аргумента.\nПовторите ввод.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Неверный формат ввода команды. Отсутствует аргумент.\nПовторите ввод.");
            } catch (StackOverflowError e) {
                System.out.println("Произошло переполнение стека.");
            }
            offer = sc.nextLine();
        }

        Parser.deserialize(outdata_path,mycollection);


    }
}
