package command.commands;

import command.ReadsBand;
import data.format.MusicBand;
import exceptions.InvalidInputValueException;

import java.util.Scanner;
import java.util.Stack;

/**
 * This command updates elements of main collection Stack<MusicBand>, whose id equals argument
 */
public class UpdateCommand extends ReadsBand {

    public Stack<MusicBand> execute (Stack<MusicBand> mystack,String curentid){
        Stack<MusicBand> newstack = new Stack<>();
        Integer id = Integer.valueOf(curentid);
        boolean listhasid = false;
        for (MusicBand band: mystack){
            if (Integer.valueOf(band.getId().toString()).equals(id)){
              band = addition(newstack);
              band.saveID(id);
              listhasid = true;
            }
            newstack.push(band);
        }
        if (!listhasid){
            System.out.println("Элемент с таким значением не существует.");
        }

        return newstack;
    }

}
