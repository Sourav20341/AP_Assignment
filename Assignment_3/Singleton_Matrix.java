package Assignment_3;

public class Singleton_Matrix extends Square_Matrix{
    public Singleton_Matrix(int[][] matrix, int rows, int columns) {
        super(matrix, rows, columns);
        this.setDeterminant(this.getMatrix()[0][0]);
    }

    @Override
    public void scalermultiplication(Matrix matrix1) {
        System.out.println("Resultant Matrix : ");
        for(int i = 0;i<matrix1.getRows();i++){
            for(int j =0;j<matrix1.getColumns();j++){
                System.out.print(matrix1.getMatrix()[i][j]*super.getMatrix()[0][0] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void scalerdivision(Matrix matrix1){
        System.out.println("Resultant Matrix : ");
        for(int i = 0;i<matrix1.getRows();i++){
            for(int j =0;j<matrix1.getColumns();j++){
                System.out.print(matrix1.getMatrix()[i][j]/(float)super.getMatrix()[0][0] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void Addition(Matrix matrix1) {
        if (matrix1.getRows() == 1 && 1 == matrix1.getColumns()) {
            System.out.print(this.getMatrix()[0][0] + matrix1.getMatrix()[0][0]);
        }
        else {
            System.out.println("Addition is not possible!");
        }
    }

    @Override
    public void Subtraction(Matrix matrix1) {
        if (matrix1.getRows() == 1 && 1 == matrix1.getColumns()) {
            System.out.print(this.getMatrix()[0][0] - matrix1.getMatrix()[0][0]);
        }
        else {
            System.out.println("Subtraction is not possible!");
        }
    }
}
