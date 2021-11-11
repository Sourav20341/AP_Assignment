package Assignment_3;

public class Identity_Matrix extends Scalar_Matrix{

    public Identity_Matrix(int[][] matrix, int rows, int columns) {
        super(matrix, rows, columns);
        this.setDeterminant(1);
    }

    @Override
    public void mean() {
        System.out.println("Mean of all elements : ");
        System.out.println(1/(float)this.getRows());
    }

    @Override
    public void rowmean() {
        System.out.println("Row wise mean : ");
        for(int i = 0;i<this.getColumns();i++){
            System.out.print(1/(float)this.getRows() + " ");
        }
    }

    @Override
    public void columnmean() {
        System.out.println("Column wise mean : ");
        for(int i = 0;i<this.getRows();i++){
            System.out.println((1/(float)this.getColumns()));
        }
    }

    @Override
    public void Multiplication(Matrix matrix1) {
        if (this.getColumns() == matrix1.getRows()) {
            for (int i = 0; i < matrix1.getRows(); i++) {
                for (int j = 0; j < matrix1.getColumns(); j++) {
                    System.out.print(matrix1.getMatrix()[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Multiplication is not possible!");
        }
    }

    @Override
    public void computeAAT() {
        System.out.println("\nAddition of matrix with it's transpose :- ");
        for(int i = 0;i<this.getRows();i++){
            for(int j = 0;j<this.getColumns();j++){
                if(i == j){
                    System.out.print(2 + " ");
                }
                else{
                    System.out.println(0 + " ");
                }
            }
            System.out.println();
        }
    }
}
