package command.commands;

import command.CanEdit;
import command.ReadsBand;
import data.format.MusicBand;

import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 * This command removes all elements of main collection Stack<MusicBand>, whose value is lower that the arguments'
 */
public class RemoveGreaterCommand extends ReadsBand implements CanEdit {

    @Override
    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String[] argument) {
        if (argument.length > 0) {
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        Stack<MusicBand> stackofgreater = new Stack<>();
        MusicBand someband = addition(mystack);
        for (MusicBand band : mystack) {
            if (band.compareTo(someband) > 0) {
                stackofgreater.push(band);
            }
        }
        for (MusicBand greaterband : stackofgreater) {
            mystack.remove(greaterband);
        }
        return mystack;
    }
}
