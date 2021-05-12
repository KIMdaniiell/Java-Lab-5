package command.commands;

import command.NonArgumentable;
import data.format.MusicBand;
import data.format.MusicGenre;

import java.lang.reflect.Array;
import java.util.*;

/**
 * This command prints elements of main collection Stack<MusicBand>, whose describe value is lower than the arguments'
 */
public class FilterCommand implements NonArgumentable {

    @Override
    public void execute(Stack<MusicBand> mystack, String[] argument) {
        if (argument.length>1){
            System.out.println("Некорректный ввод. Лишний аргумент.");
        }
        System.out.println("Введите одну из констант MusicGenre:");
        for (MusicGenre genre: MusicGenre.values()){
            System.out.print(genre+"\t");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        String offer = sc.nextLine();

        while (!MusicGenre.contains(offer)){
            System.out.println("Введена строка, не является именем константы MusicGenre");
            System.out.println("Введите одну из констант MusicGenre:");
            for (MusicGenre genre: MusicGenre.values()){
                System.out.print(genre+"\t");
            }
            System.out.println();
            offer = sc.nextLine();
        }
        for (MusicBand band: mystack){
            if (band.getGenre().compareTo(MusicGenre.valueOf(offer))<0) {
                System.out.println(band.toString());
            }
        }
    }

}
