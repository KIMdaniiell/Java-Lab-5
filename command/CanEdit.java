package command;

import data.format.MusicBand;

import java.util.Stack;

/**
 * This interface is implemented by commands, which does change order/content of main collection (Stack<MusicBand>)
 */
public interface CanEdit {
    public Stack<MusicBand> execute(Stack<MusicBand> mystack, String[] argument);
}
