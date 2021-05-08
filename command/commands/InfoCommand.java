package command.commands;
import java.time.LocalDate;
import java.util.Date;
import command.Command;
import command.NonArgumentable;
import data.format.MusicBand;

import java.util.Stack;

/**
 * This command prints information about content of main collection Stack<MusicBand>
 */
public class InfoCommand extends Command implements NonArgumentable {
    //вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
    @Override
    public String describe() {
        return "Выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    @Override
    public void execute(Stack<MusicBand> mystack, String[] argument) {
        if (argument.length>1){
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        System.out.println("Тип : " + mystack.getClass().getName());
        System.out.println("Количество элементов : " + mystack.size());
        System.out.println("Дата инициализации : " + LocalDate.now());
        for (MusicBand band : mystack){
            System.out.println(band.toString());
        }
    }
}
