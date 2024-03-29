package presentation.exception;

import java.io.Closeable;
import java.io.IOException;

public class TryCatchFinallyDemo {

    public static void main(String[] args) {
//        try2();
        tryWithResourcesDemo();
//        tryCatchFinallyPolymorph();

    }

    private static void try2() {
        try {
            System.err.print(" 0");
            if (true) {
                throw new Error();
            }
            System.err.print(" 1");
        } catch (Error e) {
            if (true) return;
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }

    private static void tryWithResourcesDemo() throws NullPointerException {
        nestedMethod();
        System.out.println("after nested method");
    }

    private static void nestedMethod() {
        try (CloseableDemo closeable = new CloseableDemo()) {
            // do nothing
            throw new CustomUncheckedException();
        }
    }

    private static void tryCatchFinallyPolymorph() {
        try {
            int random = (int) (Math.random() * 100);
            if (random >= 50) {
                throw new IllegalArgumentException();
            } else {
                throw new IOException();
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("exception " + ex);
        } catch (IOException ex) {
            System.out.println("exception " + ex);
        }

    }

    private static int tryCatchFinallyOrder() {
        try {
            throw new IOException();
        } catch (IOException ex) {
            throw ex;
        } finally {
            throw new IllegalArgumentException();
        }
    }
}

class CloseableDemo implements Closeable {

    @Override
    public void close() {
        System.err.println("I am closing ");
    }
}
