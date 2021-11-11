package Assignment_3;

public class Singular_Matrix extends Square_Matrix{
    public Singular_Matrix(int[][] matrix, int rows, int columns) {
        super(matrix, rows, columns);
        this.setDeterminant(0);
    }

    @Override
    public void inverse(){
        System.out.println("Inverse is not possible");
    }
}
