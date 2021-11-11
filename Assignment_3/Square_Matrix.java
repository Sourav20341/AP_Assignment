package Assignment_3;

public class Square_Matrix extends Matrix{
    private final int[][] adj = new int[super.getRows()][super.getColumns()];
    private final float[][] inverse = new float[super.getRows()][super.getColumns()];
    private final float[][] result = new float[super.getRows()][1];
    Utility util = new Utility();

    public Square_Matrix(int[][] matrix, int rows, int columns){
        super(matrix, rows, columns);
        super.setDeterminant(this.determinant());
        inverse();
        super.addTypes();
    }

    @Override
    public int determinant(){
        int n = this.getRows();
        int d = 0;
        if( n == 1){
            return this.getMatrix()[0][0];
        }
        int sign = 1;
        for(int i = 0 ;i<n;i++){
            int[][] temp = new int[n][n];
            getCofactor(this.getMatrix(),temp,0,i,n);
            d += sign * this.getMatrix()[0][i] * util.determinant(temp, n-1);
            sign = -sign;
        }
        return d;
    }

    public void getCofactor(int[][] matrix,int[][] temp, int r,int c,int n){

        int i = 0;
        int j = 0;
        for(int p = 0;p<n;p++){
            for(int q =0 ;q<n;q++){
                if(p != r && q != c){
                    temp[i][j++] = matrix[p][q];
                    if(j == n-1){
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    @Override
    public void multiplyinverse(Matrix matrix1){
        if (super.getColumns() == matrix1.getRows()) {
            for (int i = 0; i < super.getRows(); i++) {
                for (int j = 0; j < matrix1.getColumns(); j++) {
                    for(int k = 0;k<matrix1.getRows();k++){
                        result[i][0] += super.getInverse()[i][k]*matrix1.getMatrix()[k][j];
                    }
                }
            }
            super.setMvresult(result);
        } else {
            System.out.println("Multiplication is not possible!");
        }
    }

    @Override
    public void inverse() {
        if (super.getDeterminant() == 0) {
            return;
        }
        adjoin();


        for (int i = 0; i < super.getRows(); i++) {
            for (int j = 0; j < super.getColumns(); j++) {
                inverse[i][j] = (adj[i][j] / (float)super.getDeterminant());
            }
        }
        super.setInverse(inverse);
    }

    public void adjoin() {
        if (super.getColumns() == 1)
        {
            adj[0][0] = 1;
            return;
        }
        int sign;
        int n = super.getRows();
        int [][]temp = new int[n][n];

        for (int i = 0; i < super.getRows(); i++)
        {
            for (int j = 0; j < super.getColumns(); j++)
            {
                getCofactor(super.getMatrix(), temp, i, j, super.getRows());
                if((i + j) % 2 == 0){
                    sign = 1;
                }else {
                    sign = -1;
                }
                adj[j][i] = (sign)*(util.determinant(temp, n-1));
            }
        }
    }

    @Override
    public void computeAAT(){
        System.out.println("\nAddition of matrix with it's transpose :- ");
        for(int i = 0;i<super.getRows();i++){
            for(int j = 0;j<super.getColumns();j++){
                System.out.print(super.getMatrix()[i][j] + super.getTranspose()[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void getEigenVector(){

        if (this.getRows() == 1){
            int [][] vector = {{1}};
            System.out.println("Eigenvalue : " + super.getMatrix()[0][0] + "\n");
            System.out.print("Eigenvector : ");
            System.out.println(vector[0][0]);
            return;
        }

        double [] eigenVal = getEigenValues(this);
        System.out.println("Eigenvalues : ");
        for (double db : eigenVal){
            System.out.println(db);
        }
        double [][] vector1 = {{this.getMatrix()[0][1]}, {eigenVal[0] - this.getMatrix()[0][0]}};
        System.out.println("\nEigenvector:-");
        System.out.println(vector1[0][0]);
        System.out.println(vector1[1][0]);

        double [][] vector2 = {{this.getMatrix()[0][1]}, {eigenVal[1] - this.getMatrix()[0][0]}};
        System.out.println("\nEigenvector:-");
        System.out.println(vector2[0][0]);
        System.out.println(vector2[1][0]);
    }

    private double[] getEigenValues(Matrix matrix){

        double [] val = new double[2];
        int [][] arr = matrix.getMatrix();
        int dis = (arr[0][0] - arr[1][1])*(arr[0][0] - arr[1][1]) + 4 * arr[0][1] * arr[1][0];

        double sqrDis = Math.pow(dis,0.5);
        val[0] = ((arr[1][1] + arr[0][0]) + sqrDis) / 2;
        val[1] = ((arr[1][1] + arr[0][0]) - sqrDis) / 2;

        return val;
    }
}
