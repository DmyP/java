package presentation.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(1);
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
    }
}

class ArrayListWrapper<E> extends ArrayList<E> {

    ArrayListWrapper() {
        super(1);
    }

    @Override
    public boolean add(E e) {
        System.out.println("modCount=" + modCount + " before adding " + e);
        boolean res = super.add(e);
        System.out.println("modCount=" + modCount + " after adding " + e);
        return res;
    }

}

