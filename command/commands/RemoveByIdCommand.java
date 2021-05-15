package command.commands;

import data.format.MusicBand;
import exceptions.InvalidCommandArgumentExeption;

import java.util.Stack;

/**
 * This command removes all elements form main collection Stack<MusicBand>, whose id value equals argumant
 */
public class RemoveByIdCommand {

    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String[] arguments) throws InvalidCommandArgumentExeption {
        if (arguments.length != 1) {
            throw new InvalidCommandArgumentExeption("Некорректный ввод параметра ID.");
        } else {
            Integer id = Integer.valueOf(arguments[0]);
            Stack<MusicBand> newstack = new Stack<>();
            for (MusicBand band : mystack) {
                Integer bandid = Integer.valueOf(band.getId().toString());
                if (bandid.equals(id)) {
                    newstack.push(band);
                }
            }
            for (MusicBand band : newstack) {
                mystack.remove(band);
            }
            return mystack;
        }

    }
}
