package Assignment_3;

public class Null_Matrix extends Matrix {

    public Null_Matrix(int[][] matrix, int rows, int columns) {
        super(matrix, rows, columns);
        super.addTypes();
        if(rows == columns){
            this.setDeterminant(0);
            this.addTypes();
        }
    }

    @Override
    public void printMatrix(){
        System.out.println(getMatrixName() + " :-\n[0]\norder :- " + getRows() + "x" + getColumns());
    }

    @Override
    public void rowmean() {
        System.out.println("Row wise mean : ");
        for(int i = 0;i<this.getColumns();i++){
            System.out.print(0 + " ");
        }
    }

    @Override
    public void mean() {
        System.out.println("Mean of all elements : ");
        System.out.println(0);
    }

    @Override
    public void Addition(Matrix matrix1) {
        if (this.getRows() == matrix1.getRows() && this.getColumns() == matrix1.getColumns()) {
            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < this.getColumns(); j++) {
                    System.out.print(matrix1.getMatrix()[i][j]+" ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Addition is not possible!");
        }
    }

    @Override
    public void scalermultiplication(Matrix matrix1) {
        if(this.getRows() == 1 && this.getColumns() == 1){
            for(int i =0;i<matrix1.getRows();i++){
                for (int j =0;j<matrix1.getColumns();j++){
                    System.out.print(0 + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Scaler Multiplication is not possible");
        }
    }

    @Override
    public void columnmean() {
        System.out.println("Column wise mean : ");
        for(int i = 0;i<this.getRows();i++){
            System.out.println(0);
        }
    }

    @Override
    public void elementaryMultplication(Matrix matrix1) {
        if(this.getColumns() == matrix1.getColumns() && this.getRows() == matrix1.getRows()){
            System.out.println("Resultant Matrix : ");
            for (int i =0;i<this.getRows();i++){
                for(int j =0;j<getColumns();j++){
                    System.out.print(0 + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Elementary multiplication not possible");
        }
    }

    @Override
    public void Multiplication(Matrix matrix1) {
        if (this.getColumns() == matrix1.getRows()) {
            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < matrix1.getColumns(); j++) {
                    System.out.print(0 + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Multiplication is not possible!");
        }
    }

    @Override
    public void Subtraction(Matrix matrix1) {
        if (this.getRows() == matrix1.getRows() && this.getColumns() == matrix1.getColumns()) {
            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < this.getColumns(); j++) {
                    System.out.print(-matrix1.getMatrix()[i][j]+" ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Subtraction is not possible!");
        }
    }

    @Override
    public void computeAAT() {
        if(this.getColumns() == this.getRows()){
            System.out.println("\nAddition of matrix with it's transpose :- ");
            for(int i = 0;i<this.getRows();i++){
                for(int j = 0;j<this.getColumns();j++){
                    System.out.print(0 + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Not Possible");
        }
    }
}
