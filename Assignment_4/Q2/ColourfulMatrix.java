package Assignment_4.Q2;

public class ColourfulMatrix{
    private final String ID;
    private int[][] arrayR;
    private int[][] arrayB;
    private int[][] arrayG;

    public ColourfulMatrix(String ID, int[][] arrayR, int[][] arrayB, int[][] arrayG) {
        this.ID = ID;
        this.arrayR = arrayR;
        this.arrayB = arrayB;
        this.arrayG = arrayG;
    }

    public String getID() {
        return ID;
    }

    public int[][] getArrayR() {
        return arrayR;
    }

    public int[][] getArrayB() {
        return arrayB;
    }

    public int[][] getArrayG() {
        return arrayG;
    }

    public String Negative(){
        String toStr = null;
        toStr.concat("Negative Red Matrix : \n");
        for (int[] ints : arrayR) {
            for (int num : ints) {
                toStr.concat((num - 255) + " ");
            }
            toStr.concat("\n");
        }
        toStr.concat("Negative Blue Matrix : \n");
        for (int[] ints : arrayB) {
            for (int num : ints) {
                toStr.concat((num - 255) + " ");
            }
            toStr.concat("\n");
        }
        toStr.concat("Negative Green Matrix : \n");
        for (int[] ints : arrayG) {
            for (int num : ints) {
                toStr.concat((num - 255) + " ");
            }
            toStr.concat("\n");
        }
        return toStr;
    }

    public void setArrayR(int[][] arrayR) {
        this.arrayR = arrayR;
    }

    public void setArrayB(int[][] arrayB) {
        this.arrayB = arrayB;
    }

    public void setArrayG(int[][] arrayG) {
        this.arrayG = arrayG;
    }

    public String toString(){
        String toStr = null;
        toStr.concat("Red Color : \n");
        for (int[] ints : arrayR) {
            for (int num : ints) {
               toStr.concat(num + " ");
            }
            toStr.concat("\n");
        }
        toStr.concat("Blue Color : \n");
        for (int[] ints : arrayB) {
            for (int num : ints) {
                toStr.concat(num + " ");
            }
            toStr.concat("\n");
        }
        toStr.concat("Green Color : \n");
        for (int[] ints : arrayG) {
            for (int num : ints) {
                toStr.concat(num + " ");
            }
            toStr.concat("\n");
        }
        return toStr;
    }
}
