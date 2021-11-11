package Assignment_3;

public class Diagonal_Matrix extends Symmetric_Matrix{
    public Diagonal_Matrix(int[][] matrix, int rows, int columns) {
        super(matrix, rows, columns);
    }

    @Override
    public int determinant(){
        int ans = 1;
        int i = 0;
        for(int[] ints : this.getMatrix()){
            ans *= ints[i];
            i++;
        }
        return ans;
    }

    @Override
    public void printMatrix(){
        System.out.print(getMatrixName() + " :-\n[ ");
        int i = 0;
        for(int[] ints : this.getMatrix()){
            System.out.print(ints[i] + " ");
            i++;
        }
        System.out.print("]\n");
    }
}
