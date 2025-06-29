import java.util.*;

public class ExemploRuim {
    public static void main(String[] args) {
        List<Item> l = new ArrayList<>();
        l.add(new Item(5, true));
        l.add(new Item(3, false));
        l.add(new Item(2, true));

        int x = 0;
        for (Item i : l) {
            if (i.v()) {
                x += i.q();
            }
        }

        System.out.println("Resultado: " + x);
    }
}

class Item {
    int q;
    boolean v;

    Item(int q, boolean v) {
        this.q = q;
        this.v = v;
    }

    int q() {
        return q;
    }

    boolean v() {
        return v;
    }
}
