package command.commands;

import command.CanEdit;
import command.Command;
import data.format.MusicBand;

import java.util.Stack;

/**
 * This command removes elements from main collection Stack<MusicBand>, whos description value equals argument
 */
public class RemoveAnyByDesCommand extends Command {
    //не реализует интерфейс CanEdit потому что принимает аргумент
    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String description) {
        System.out.println("description - "+description);
        Stack<MusicBand> newstack = new Stack<>();
        for (MusicBand band : mystack){
            if (!band.getDescription().equals(description)){
                newstack.push(band);
            }
        }
        return newstack;
    }

    @Override
    public String describe() {
        return "Удалить из коллекции один элемент, значение поля description которого эквивалентно заданному";
    }
}
