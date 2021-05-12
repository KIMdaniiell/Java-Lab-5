package command.commands;

import data.format.MusicBand;

import java.util.Stack;

/**
 * This command removes all elements form main collection Stack<MusicBand>, whose id value equals argumant
 */
public class RemoveByIdCommand {

    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String inid) {
        Integer id = Integer.valueOf(inid);
        Stack<MusicBand> newstack = new Stack<>();
        for (MusicBand band : mystack){
            Integer bandid = Integer.valueOf(band.getId().toString());
            if (!bandid.equals(id)){
                newstack.push(band);
            }
        }
        return newstack;
    }
}
