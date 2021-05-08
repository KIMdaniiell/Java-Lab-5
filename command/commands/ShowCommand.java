package command.commands;

import command.Command;
import command.NonArgumentable;
import data.format.MusicBand;

import java.util.Stack;

/**
 * This command prints every element of main collection Stack<MusicBand>
 */
public class ShowCommand extends Command implements NonArgumentable {
    //вывести в стандартный поток вывода все элементы коллекции в строковом представлении
    @Override
    public String describe() {
        return "Выводит в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public void execute(Stack<MusicBand> mystack, String[] argument) {
        if (argument.length>1){
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        for (MusicBand band : mystack){
            System.out.println(band.toString());
        }
    }

}
