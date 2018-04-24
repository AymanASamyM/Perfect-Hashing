public class BooleanMatrix {
    private final int height;
    private final int width;
    private boolean[][] matrix;
    public BooleanMatrix(int height, int width){
        this.height = height;
        this.width = width;
        matrix = new boolean[height][width];
    }
    public BooleanMatrix(int value){
        this(32,1);
        String binaryValue =  Integer.toBinaryString(value);
        for (int i = 0; i < 32; i++) {
            this.set(i,0,false);
        }
        for (int i = 0; i < binaryValue.length(); i++) {
            this.set(binaryValue.length()-1-i,0,(binaryValue.charAt(i) == '1'));
        }
    }
    public boolean get(int i,int j){
        return matrix[i][j];
    }

    public void set(int i,int j,boolean element) {
        matrix[i][j] = element;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public static BooleanMatrix multiply(BooleanMatrix A, BooleanMatrix B) {
        if (A.getWidth() != B.getHeight())
            return null;
        BooleanMatrix resultMatrix = new BooleanMatrix(A.getHeight(), B.getWidth());
        for (int i = 0; i < resultMatrix.getHeight(); i++) {
            for (int j = 0; j < resultMatrix.getWidth(); j++) {
                Boolean tmp = false;
                for (int k = 0; k < A.getWidth(); k++) {
                    tmp = tmp ^ (A.get(i,k) & B.get(k,j));
                }
                resultMatrix.set(i,j,tmp);
            }
        }
        return resultMatrix;
    }
}
