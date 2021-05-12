package command;

import command.commands.*;
import data.format.MusicBand;

import java.util.Scanner;
import java.util.Stack;

/**
 *  This class reads and executes commands
 */
public class Commander {
    /*
    *This class has a static method doCommand which reads commands
    *and executes them via necessary *Command class. The use of this method
    * is in the Main class and ScriptCommand class.
     */

    public static void doCommand(Stack<MusicBand> mystack, String data_path, Scanner sc){

        String offer = sc.nextLine();
        try {
            switch (offer.toLowerCase().split(" ")[0]) {
                case "help":
                    new HelpCommand().execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "info":
                    new InfoCommand().execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "show":
                    new ShowCommand().execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "clear":
                    mystack = new ClearCommand().execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "save":
                    new SaveCommand(data_path).execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "exit":
                    new ExitCommand().execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "reorder":
                    mystack = new ReorderCommand().execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "sort":
                    mystack = new SortCommand().execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "print_field_descending_description":
                    new PrintDescriptionCommand().execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "filter_less_than_genre":
                    new FilterCommand().execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "add":
                    new AddCommand().execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "remove_greater":
                    mystack = new RemoveGreaterCommand().execute(mystack, offer.split(offer.split(" ")[0] + " "));
                    break;
                case "update":
                    mystack = new UpdateCommand().execute(mystack, offer.split(offer.split(" ")[0] + " ")[1]);
                    break;
                case "remove_any_by_description":
                    mystack = new RemoveAnyByDesCommand().execute(mystack, offer.split(offer.split(" ")[0] + " ")[1]);
                    break;
                case "remove_by_id":
                    mystack = new RemoveByIdCommand().execute(mystack, offer.split(offer.split(" ")[0] + " ")[1]);
                    break;
                case "execute_script":
                    new ScriptCommand().execute(mystack, offer.split(offer.split(" ")[0] + " ")[1], data_path);
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
        } catch (OutOfMemoryError e) {
            System.out.println("Закончилась память.");
        }
    }

}
