import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class NSquareHash implements StaticHash {
    HashFunction hashFunction;
    Integer[] hashTable;
    @Override
    public void hash(Integer[] keys) {
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(keys));
        Integer[] uniqueKeys = new Integer[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        while (iterator.hasNext())
            uniqueKeys[index++] = iterator.next();
        int hashCounter = 0;
        boolean hasCollision = true;
        while (hasCollision) {
            hashCounter++;
            hasCollision = false;
            hashTable = new Integer[uniqueKeys.length*uniqueKeys.length];
            hashFunction = new HashFunction(uniqueKeys.length*uniqueKeys.length);
            for (int i = 0; i < uniqueKeys.length; i++) {
                int ind = hashFunction.hash(uniqueKeys[i]);
                if(hashTable[ind] != null) {
                    hasCollision = true;
                    break;
                }
                else
                    hashTable[ind] = new Integer(uniqueKeys[i]);
            }
        }
        System.out.println("Hashed in "+hashCounter+" times.");
    }

    @Override
    public boolean contains(Integer key) {
        if(hashFunction == null)
            return false;
        int ind = hashFunction.hash(key);
        if(hashTable[ind] == null)
            return false;
        if(hashTable[ind].equals(key))
            return true;
        else
            return false;
    }
}
