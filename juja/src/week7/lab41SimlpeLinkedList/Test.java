package week7.lab41SimlpeLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Test {
    public static void main(String[] args) {
        //empty list
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();

        //call and check
        Iterator<Integer> iterator = null;
        try {
            iterator = simpleLinkedList.iterator();
        } catch (UnsupportedOperationException u) {
            throw new AssertionError("Iterator not implemented");
        }

        if (iterator == null)
            throw new AssertionError("Iterator must be no equals null");

        if (iterator.hasNext())
            throw new AssertionError("hasNext() must be returned false if no element");

        boolean isExceptionMethodNext = false;
        try {
            iterator.next();
        } catch (NoSuchElementException e) {
            isExceptionMethodNext = true;
        }
        if (!isExceptionMethodNext)
            throw new AssertionError("next() must be throw NoSuchElementException if no element");

        System.out.print("OK");
    }
}
