package command.commands;

import command.Command;
import command.NonArgumentable;
import data.format.MusicBand;

import java.util.Stack;

/**
 * This command prints value of description field of every element in main collection Stack<MusicBand>
 */
public class PrintDescriptionCommand extends Command implements NonArgumentable {
    //вывести значения поля description всех элементов в порядке убывания
    @Override
    public String describe() {
        return "Выводит значения поля description всех элементов в порядке убывания";
    }

    @Override
    public void execute(Stack<MusicBand> mystack,String[] argument) {
        if (argument.length>1){
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        for (MusicBand band: mystack){
            System.out.println(band.getDescription());
        }
    }
}
