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
        toStr =("Negative Red Matrix : \n");
        for (int[] ints : arrayR) {
            for (int num : ints) {
                toStr+=((255 - num) + " ");
            }
            toStr+=("\n");
        }
        toStr+=("Negative Blue Matrix : \n");
        for (int[] ints : arrayB) {
            for (int num : ints) {
                toStr+=((255 - num) + " ");
            }
            toStr+=("\n");
        }
        toStr+=("Negative Green Matrix : \n");
        for (int[] ints : arrayG) {
            for (int num : ints) {
                toStr+=((255 - num) + " ");
            }
            toStr+=("\n");
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
        toStr = ("Red Color : \n");
        for (int[] ints : arrayR) {
            for (int num : ints) {
               toStr+=(num + " ");
            }
            toStr+=("\n");
        }
        toStr+=("Blue Color : \n");
        for (int[] ints : arrayB) {
            for (int num : ints) {
                toStr+=(num + " ");
            }
            toStr+=("\n");
        }
        toStr+=("Green Color : \n");
        for (int[] ints : arrayG) {
            for (int num : ints) {
                toStr+=(num + " ");
            }
            toStr+=("\n");
        }
        return toStr;
    }
}
