package command.commands;

import command.CanEdit;
import data.format.MusicBand;
import exceptions.InvalidCommandArgumentExeption;

import java.util.Collections;
import java.util.Stack;

/**
 * This command removes elements from main collection Stack<MusicBand>, whos description value equals argument
 */
public class RemoveAnyByDesCommand {

    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String[] arguments) throws InvalidCommandArgumentExeption {
        if (arguments.length!=1){
            throw new InvalidCommandArgumentExeption("Некорректный ввод параметра DESCRIPTION.");
        } else {
            String description = arguments[0];
            Stack<MusicBand> newstack = new Stack<>();
            for (MusicBand band : mystack){
                if (band.getDescription().equals(description)){
                    newstack.push(band);
                }
            }
            for (MusicBand band: newstack){
                mystack.remove(band);
            }
            return mystack;
        }

    }
}
