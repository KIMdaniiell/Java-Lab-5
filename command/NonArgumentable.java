package command;

import data.format.MusicBand;

import java.util.Stack;

/**
 * This interface is implemented by commands, which does not change order/content of main collection (Stack<MusicBand>)
 */
public interface NonArgumentable {
    void execute(Stack<MusicBand> mystack, String[] argument);
}
