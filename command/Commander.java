package command;

import command.commands.*;
import data.format.MusicBand;
import exceptions.InvalidCommandArgumentExeption;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * This class reads and executes commands
 */
public class    Commander {
    /*
     *This class has a static method doCommand which reads commands
     *and executes them via necessary *Command class. The use of this method
     * is in the Main class and ScriptCommand class.
     */
    static int rec_counter = 0;

    public static void doCommand(Stack<MusicBand> mystack, String data_path, Scanner sc) {

        String offer = sc.nextLine();
        try {
            String command_word = offer.toLowerCase().split(" ")[0];
            String[] arguments = new String[offer.split(" ").length - 1];
            for (int i = 0; i < offer.split(" ").length - 1; i++) {
                arguments[i] = offer.split(" ")[i + 1];
            }

            switch (command_word) {
                case "help":
                    new HelpCommand().execute(mystack, arguments);
                    break;
                case "info":
                    new InfoCommand().execute(mystack, arguments);
                    break;
                case "show":
                    new ShowCommand().execute(mystack, arguments);
                    break;
                case "clear":
                    mystack = new ClearCommand().execute(mystack, arguments);
                    break;
                case "save":
                    new SaveCommand(data_path).execute(mystack, arguments);
                    break;
                case "exit":
                    new ExitCommand().execute(mystack, arguments);
                    break;
                case "reorder":
                    mystack = new ReorderCommand().execute(mystack, arguments);
                    break;
                case "sort":
                    mystack = new SortCommand().execute(mystack, arguments);
                    break;
                case "print_field_descending_description":
                    new PrintDescriptionCommand().execute(mystack, arguments);
                    break;
                case "filter_less_than_genre":
                    new FilterCommand().execute(mystack, arguments);
                    break;
                case "add":
                    new AddCommand().execute(mystack, arguments);
                    break;
                case "remove_greater":
                    mystack = new RemoveGreaterCommand().execute(mystack, arguments);
                    break;
                case "update":
                    mystack = new UpdateCommand().execute(mystack, arguments);
                    break;
                case "remove_any_by_description":
                    mystack = new RemoveAnyByDesCommand().execute(mystack, arguments);
                    break;
                case "remove_by_id":
                    mystack = new RemoveByIdCommand().execute(mystack, arguments);
                    break;
                case "execute_script":
                    rec_counter++;
                    if (rec_counter >= 5) {
                        System.out.println("Глубина рекурсии достигла предела (5). Остановка.");
                    } else {
                        new ScriptCommand().execute(mystack, arguments, data_path);
                    }
                    System.out.println(rec_counter);
                    rec_counter--;
                    break;
                default:
                    System.out.println("Неизвестная команда\nПовторите ввод.");
            }
        } catch (InvalidCommandArgumentExeption e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода аргумента.\nПовторите ввод.");
        }
    }

}
