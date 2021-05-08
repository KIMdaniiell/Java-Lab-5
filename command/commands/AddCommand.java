package command.commands;

import command.CanEdit;
import command.Command;
import command.ReadsBand;
import data.format.MusicBand;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

/**
 * This command adds new element info main collection Stack<MusicBand>
 */
public class AddCommand extends ReadsBand implements CanEdit{
    //"Добавляет новый элемент в коллекцию"

    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String[] argument) {
        if (argument.length>1){
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        MusicBand myband = addition(mystack);
        Collections.sort(mystack);
        Integer id = 1;
        for (MusicBand band : mystack){
            Integer bandid = Integer.valueOf(band.getId());
            if (bandid.equals(id)){
                id+=1;
            }
        }
        myband.saveID(id);
        mystack.push(myband);
        return mystack;
    }


    public String describe() {
        return "Добавляет новый элемент в коллекцию";
    }

}
