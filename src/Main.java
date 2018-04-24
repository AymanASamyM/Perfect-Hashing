import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "keys10000001000000.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        int[] numbers = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        Integer[] keys = Arrays.stream(numbers).boxed().toArray( Integer[]::new );
        System.out.println("Hashing "+keys.length+" Key");
        NHash nHash = new NHash();
        NSquareHash nSquareHash = new NSquareHash();
        nHash.hash(keys);
        //nSquareHash.hash(keys);
        bufferedReader.close();
    }
}
