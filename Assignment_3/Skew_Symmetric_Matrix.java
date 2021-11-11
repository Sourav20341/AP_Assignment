package Assignment_3;

public class Skew_Symmetric_Matrix extends Square_Matrix{
    public Skew_Symmetric_Matrix(int[][] matrix, int rows, int columns) {
        super(matrix, rows, columns);
    }

    @Override
    public int determinant(){
        if(this.getRows()%2 == 0){
            return super.determinant();
        } else {
            return 0;
        }
    }
}
