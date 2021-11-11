package Assignment_3;

public class Upper_Triangular_Matrix extends Square_Matrix{

    public Upper_Triangular_Matrix(int[][] matrix, int rows, int columns) {
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
}
