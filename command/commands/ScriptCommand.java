package command.commands;

import command.Command;
import command.Executor;
import command.NonArgumentable;
import data.format.MusicBand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * This command execute commands from script-file
 */
public class ScriptCommand extends Command {
    @Override
    public String describe() {
        return null;
    }
    public void execute(Stack<MusicBand> mycollection, String script_path, String outdatapath){
        File script_file = new File(script_path);
        try {
            Scanner sc = new Scanner(script_file);
            String offer ;
            do {
                offer = sc.nextLine();
                System.out.println("You printed: " + offer);
                try {
                    switch (offer.toLowerCase().split(" ")[0]) {
                        case "help":
                            System.out.println(offer.split(offer.split(" ")[0] + " ").length);
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
                            Executor.save(mycollection, outdatapath, offer.split(offer.split(" ")[0] + " "));
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
                            mycollection = Executor.update(mycollection, offer.toLowerCase().split(" ")[1]);
                            break;
                        case "remove_any_by_description":
                            mycollection = Executor.remove_any_by_description(mycollection, offer.split(offer.split(" ")[0] + " ")[1]);
                            break;
                        case "remove_by_id":
                            mycollection = Executor.remove_by_id(mycollection, offer.split(offer.split(" ")[0] + " ")[1]);
                            break;
                        case "execute_script":
                            Executor.execute_script(mycollection, offer.split(offer.split(" ")[0] + " ")[1], outdatapath);
                            break;
                        default:
                            System.out.println("Неизвестная команда\nПовторите ввод.");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Неверный формат ввода команды. Отсутствует аргумент.\nПовторите ввод");
                }
            } while (sc.hasNext());
        }
        catch (FileNotFoundException e){
            System.out.println("Ошибка. Файл не обнаружен");
        }

    }
}
