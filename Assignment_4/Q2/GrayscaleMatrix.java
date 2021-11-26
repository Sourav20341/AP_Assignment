package Assignment_4.Q2;

public class GrayscaleMatrix{
    private final String ID;
    private int[][] array;

    public GrayscaleMatrix(String ID, int[][] array) {
        this.ID = ID;
        this.array = array;
    }

    public String getID() {
        return ID;
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    public String Negative(){
        String toStr = null;
        toStr  = ("Negative Matrix : \n");
        for (int[] ints : array) {
            for (int num : ints) {
                toStr += ((num - 255) + " ");
            }
            toStr += ("\n");
        }
        return toStr;
    }

    @Override
    public String toString(){
        String toStr = null;
        toStr = ("Grayscale : \n");
        for (int[] ints : array) {
            for (int num : ints) {
                toStr += (num + " ");
            }
            toStr += ("\n");
        }
        return toStr;
    }
}
