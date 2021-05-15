package command.commands;

import command.NonArgumentable;
import data.format.MusicBand;
import data.Parser;

import java.util.Stack;

/**
 * This command saves main collection Stack<MusicBand> into XML-document
 */
public class SaveCommand implements NonArgumentable { //сохранить коллекцию в файл
    private final String outdata_path;

    public SaveCommand(String outdata_path) {
        this.outdata_path = outdata_path;
    }

    @Override
    public void execute(Stack<MusicBand> mystack, String[] argument) {
        if (argument.length > 0) {
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        Parser.deserialize(outdata_path, mystack);
    }
}
