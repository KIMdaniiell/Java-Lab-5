package command.commands;

import command.CanEdit;
import data.format.MusicBand;
import exceptions.InvalidCommandArgumentExeption;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

/**
 * This command removes elements from main collection Stack<MusicBand>, whos description value equals argument
 */
public class RemoveAnyByDesCommand {

    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String[] arguments) throws InvalidCommandArgumentExeption {
        if (arguments.length != 1) {
            throw new InvalidCommandArgumentExeption("Некорректный ввод параметра DESCRIPTION.");
        } else {
            String description = arguments[0];
            Stack<MusicBand> newstack = new Stack<>();
            Iterator<MusicBand> iterator = mystack.iterator();
            boolean not_deleted = true;

            while (iterator.hasNext()){
                MusicBand band = iterator.next();
                if (not_deleted&&band.getDescription().equals(description)){
                    iterator.remove();
                    not_deleted = false;
                    System.out.println("Элемент с данным описанием был удален.");
                }
            }
            if (not_deleted){
                System.out.println("Элемента с таким описанием не существует.");
            }
            return mystack;
        }

    }
}
