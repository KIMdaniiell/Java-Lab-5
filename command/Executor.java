package command;
import command.commands.*;
import data.format.MusicBand;

import java.util.Stack;

/**
 * This class offers to Command classes and recalling their command methods
 */
public final class Executor {
    //Выполняет команды (не зависит от их реализации)
    public static void help(Stack<MusicBand> mystack, String[] argument){
        new HelpCommand().execute(mystack, argument);
    }
    public static void info(Stack<MusicBand> mystack, String[] argument){
        new InfoCommand().execute(mystack, argument);
    }
    public static void show(Stack<MusicBand> myband, String[] argument){
        new ShowCommand().execute(myband, argument);
    }
    public static Stack<MusicBand> clear(Stack<MusicBand> mystack, String[] argument){
        mystack = new ClearCommand().execute(mystack, argument);
        return mystack;
    }
    public static void save(Stack<MusicBand> mystack, String path, String[] argument){
        new SaveCommand(path).execute(mystack, argument);
    }
    public static void exit(Stack<MusicBand> mystack, String[] argument) {
        new ExitCommand().execute(mystack, argument);
    }
    public static Stack<MusicBand> reorder(Stack<MusicBand> mystack, String[] argument){
        mystack = new ReorderCommand().execute(mystack, argument);
        return mystack;
    }
    public static Stack<MusicBand> sort(Stack<MusicBand> mystack, String[] argument){
        mystack = new SortCommand().execute(mystack, argument);
        return mystack;
    }
    public static void print_field_descending_description(Stack<MusicBand> mystack, String[] argument){
        new PrintDescriptionCommand().execute(mystack, argument);
    }
    public static void filter_less_than_genre (Stack<MusicBand> mystack, String[] argument) {
        new FilterCommand().execute(mystack, argument);
    }
    public static void add (Stack<MusicBand> mystack, String[] argument){
        new AddCommand().execute(mystack, argument);
    }
    public static Stack<MusicBand> remove_greater(Stack<MusicBand> mystack, String[] argument) {
        mystack = new RemoveGreaterCommand().execute(mystack, argument);
        return mystack;
    }
    public static Stack<MusicBand> update (Stack<MusicBand> mystack, String argument) {
        mystack = new UpdateCommand().execute(mystack,argument);
        return mystack;
    }
    public static Stack<MusicBand> remove_any_by_description (Stack<MusicBand> mystack, String argument) {
        mystack = new RemoveAnyByDesCommand().execute(mystack,argument);
        return mystack;
    }
    public static Stack<MusicBand> remove_by_id (Stack<MusicBand> mystack, String argument) {
        mystack = new RemoveByIdCommand().execute(mystack,argument);
        return mystack;
    }
    public static void execute_script (Stack<MusicBand> mystack, String argument, String outdatapath){
        new ScriptCommand().execute(mystack,argument,outdatapath);
    }
}
