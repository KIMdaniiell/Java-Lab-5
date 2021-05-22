package command.commands;

import command.ReadsBand;
import data.format.MusicBand;
import exceptions.InvalidCommandArgumentExeption;
import exceptions.InvalidInputValueException;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * This command updates elements of main collection Stack<MusicBand>, whose id equals argument
 */
public class UpdateCommand extends ReadsBand {

    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String[] arguments) throws InvalidCommandArgumentExeption {
        if (arguments.length != 1) {
            throw new InvalidCommandArgumentExeption("Некорректный ввод параметра ID.");
        } else {
            Integer curentid = Integer.valueOf(arguments[0]);
            boolean has_this_id = false;
            for (MusicBand band: mystack){
                if (band.getId().equals(curentid)){
                    has_this_id = true;
                }
            }
            if (has_this_id==false){
                throw new InvalidCommandArgumentExeption("Некорректный ввод параметра ID. Элемента с таким ID не существует.");
            }
            MusicBand oldband = new MusicBand();
            MusicBand newband = addition(mystack);
            Integer id = curentid;
            newband.saveID(id);
            for (MusicBand band : mystack) {
                if (band.getId().equals(id)) {
                    oldband = band;
                }
            }
            Collections.replaceAll(mystack, oldband, newband);
            System.out.println("Элемент с данным ID был обновлен.");
            return mystack;
        }

    }

}
