import java.util.Random;

public class HashFunction {
    private int matrixHeight;
    BooleanMatrix hashMatrix;
    public HashFunction(int tableSize) {
        matrixHeight = (int) (Math.log(tableSize) / Math.log(2));
        hashMatrix = new BooleanMatrix(matrixHeight,32);
        Random random = new Random();
        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < 32; j++) {
                hashMatrix.set(i,j,random.nextBoolean());
            }
        }
    }

    public int hash(int key){
        BooleanMatrix booleanKey = new BooleanMatrix(key);
        BooleanMatrix booleanResult = BooleanMatrix.multiply(hashMatrix,booleanKey);
        int result = 0;
        int radix = 1;
        for (int i = 0; i < matrixHeight; i++) {
            if (booleanResult.get(i,0))
                result += radix;
            radix *= 2;
        }
        return result;
    }

}
