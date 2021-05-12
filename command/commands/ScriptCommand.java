package command.commands;

import command.Commander;
import data.format.MusicBand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * This command execute commands from script-file
 */
public class ScriptCommand {

    public void execute (Stack<MusicBand> mycollection, String script_path, String outdatapath){
        File script_file = new File(script_path);

        try {
            Scanner sc = new Scanner(script_file);
            if (sc.hasNext()) {
                String offer;
                Commander commander = new Commander();
                do {
                    commander.doCommand(mycollection, outdatapath, sc);
                } while (sc.hasNext());

            } else {
                System.out.println("Скрип не содержит команд.");
            }
        } catch (FileNotFoundException e){
            System.out.println("Ошибка. Файл не обнаружен");
        }

    }
}
