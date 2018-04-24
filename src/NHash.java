import java.util.ArrayList;

public class NHash implements StaticHash {
    HashFunction hashFunction;
    NSquareHash[] hashTable;
    @Override
    public void hash(Integer[] keys) {
        hashFunction = new HashFunction(keys.length);
        hashTable = new NSquareHash[keys.length];
        ArrayList<Integer>[] toHashTable = new ArrayList[keys.length];
        for (int i = 0; i < keys.length; i++) {
            int ind = hashFunction.hash(keys[i]);
            if(toHashTable[ind] == null)
                toHashTable[ind] = new ArrayList<>();
            toHashTable[ind].add(keys[i]);
        }
        int memorySpace = 0;
        for (int i = 0; i < keys.length; i++) {
            hashTable[i] = new NSquareHash();
            if(toHashTable[i] != null) {
                Integer[] tmpKeys = new Integer[toHashTable[i].size()];
                for (int j = 0; j < toHashTable[i].size(); j++) {
                    tmpKeys[j] = toHashTable[i].get(j);
                }
                hashTable[i].hash(tmpKeys);
                memorySpace += tmpKeys.length*tmpKeys.length;
            }
        }
        System.out.println("Took "+memorySpace+" memory element");
    }

    @Override
    public boolean contains(Integer key) {
        int ind = hashFunction.hash(key);
        return hashTable[ind].contains(key);
    }
}
