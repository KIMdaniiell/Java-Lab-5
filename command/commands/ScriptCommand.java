package command.commands;

import command.Commander;
import data.format.MusicBand;
import exceptions.InvalidCommandArgumentExeption;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * This command execute commands from script-file
 */
public class ScriptCommand {

    public void execute(Stack<MusicBand> mycollection, String[] arguments, String outdatapath) throws InvalidCommandArgumentExeption {
        if (arguments.length != 1) {
            throw new InvalidCommandArgumentExeption("Некорректный ввод параметра SCRIPT PATH.");
        } else {
            String script_path = arguments[0];
            File script_file = new File(script_path);
            try {
                Scanner sc = new Scanner(script_file);
                if (sc.hasNext()) {
                    do {
                        Commander.doCommand(mycollection, outdatapath, sc);
                    } while (sc.hasNext());
                } else {
                    System.out.println("Скрип не содержит команд.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Ошибка. Файл не обнаружен");
            }
        }
    }
}
