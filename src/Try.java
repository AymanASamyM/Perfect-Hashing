import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Try {
    public static void main(String[] args) {
        NHash h = new NHash();
        Random random = new Random();
        Integer[] keys = new Integer[10];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            keys[i] = random.nextInt();
            arrayList.add(keys[i]);
        }
        h.hash(keys);
        for (int i = 0; i < 10; i++) {
            System.out.println(h.contains(keys[i]) == true);
            System.out.println(h.contains(random.nextInt()) == false);
        }
    }
}
