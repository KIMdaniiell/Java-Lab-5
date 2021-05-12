package command.commands;

import command.CanEdit;
import data.format.MusicBand;

import java.util.Stack;

/**
 * This command removes elements from main collection Stack<MusicBand>, whos description value equals argument
 */
public class RemoveAnyByDesCommand {

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
}
