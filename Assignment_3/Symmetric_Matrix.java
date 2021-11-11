package Assignment_3;

public class Symmetric_Matrix extends Square_Matrix{
    public Symmetric_Matrix(int[][] matrix, int rows, int columns) {
        super(matrix, rows, columns);
    }

    @Override
    public int[][] transpose(){
        return this.getMatrix();
    }
}