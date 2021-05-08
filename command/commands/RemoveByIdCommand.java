package command.commands;


import command.Command;
import data.format.MusicBand;

import java.util.Stack;

/**
 * This command removes all elements form main collection Stack<MusicBand>, whose id value equals argumant
 */
public class RemoveByIdCommand extends Command {

    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String inid) {
        Integer id = Integer.valueOf(inid);
        Stack<MusicBand> newstack = new Stack<>();
        for (MusicBand band : mystack){
            Integer bandid = Integer.valueOf(band.getId());
            if (!bandid.equals(id)){
                newstack.push(band);
            }
        }
        return newstack;
    }

    @Override
    public String describe() {
        return "Удалить из коллекции один элемент, значение поля id которого эквивалентно заданному";
    }
}
