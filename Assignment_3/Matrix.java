package Assignment_3;

import java.util.*;

public class Matrix {

    private ArrayList<String>Labels = new ArrayList<>();
    private final String matrixName;
    private int[][] matrix;
    private final int rows;
    private final int columns;
    private int determinant;
    private final int[][] transpose;
    private float[][] inverse;
    private float[][] mvresult;

    private static int id = 0;

    public Matrix(int[][] matrix,int rows,int columns) {
        this.matrixName = "ID " + id;
        this.matrix = matrix;
        this.rows = rows;
        this.columns = columns;
        this.determinant = Integer.MAX_VALUE;
        this.transpose = this.transpose();
        inverse = new float[rows][columns];

        id++;
    }

    public String getMatrixName() {
        return matrixName;
    }

    public void setMatrix(int[][] matrix){
        this.matrix = matrix;
    }

    public float[][] getMvresult() {
        return mvresult;
    }

    public void setMvresult(float[][] mvresult) {
        this.mvresult = mvresult;
    }

    public void setLabels(ArrayList<String> labels) {
        Labels = labels;
    }

    public float[][] getInverse(){
        return this.inverse;
    }

    public void setInverse(float[][] inverse){
        this.inverse = inverse;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setDeterminant(int determinant) {
        this.determinant = determinant;
    }

    public int getDeterminant(){
        return determinant;
    }

    public ArrayList<String> getLabels() {
        return Labels;
    }

    public void Addlabel(String name){
        Labels.add(name);
    }

    public int[][] getTranspose() {
        return transpose;
    }

    public int[][] transpose(){
        int [][] mat = new int[columns][rows];
        for(int i = 0 ;i< rows;i++) {
            for (int j = 0; j < columns; j++) {
                mat[j][i] = matrix[i][j];
            }
        }
        return mat;
    }
    public int determinant(){
        System.out.println("Determinant is not define!");
            return Integer.MAX_VALUE;
    }

    public void multiplyinverse(Matrix matrix1){
        System.out.println("Not possible");
    }

    public void inverse(){
        System.out.println("Inverse is not possible");
    }

    public void computeAAT(){
        System.out.println("Not Possible");
    }

    public void getEigenVector(){
        System.out.println("Not Possible");
    }

    public void printMatrix(){
        System.out.println("\n"+matrixName + " :- ");
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<columns;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void scalermultiplication(Matrix matrix1){
        System.out.println("Scaler Multiplication is not possible");
    }

    public void scalerdivision(Matrix matrix1){
        System.out.println("Scaler Division is not possible");
    }

    public void mean(){
        System.out.println("Mean of all elements : ");
        int n = 0;
        for(int i = 0;i<rows;i++){
            for(int j =0;j<columns;j++){
                n+= matrix[i][j];
            }
        }
        System.out.println(n/ (float)(columns*rows));
    }

    public void elementaryDivision(Matrix matrix1){
        if(columns == matrix1.getColumns() && rows == matrix1.getRows()){
            System.out.println("Resultant Matrix : ");
            for (int i =0;i<rows;i++){
                for(int j =0;j<columns;j++){
                    if(matrix1.getMatrix()[i][j] == 0){
                        System.out.println("Elementary Division not possible");
                        return;
                    }
                }
            }

            for (int i =0;i<rows;i++){
                for(int j =0;j<columns;j++){
                    System.out.print(matrix[i][j]/(float)matrix1.getMatrix()[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Elementary Division not possible");
        }
    }

    public void rowmean(){
        System.out.println("Row wise mean : ");
        for(int i = 0;i<columns;i++){
            int n = 0;
            for(int j = 0;j<rows;j++){
                n+= matrix[j][i];
            }
            System.out.print((n/(float)rows) + " ");
        }
    }

    public void columnmean(){
        System.out.println("Column wise mean : ");
        for(int i = 0;i<rows;i++){
            int n = 0;
            for(int j = 0;j<columns;j++){
                n+= matrix[i][j];
            }
            System.out.println((n/(float)columns));
        }
    }

    public void elementaryMultplication(Matrix matrix1){
        if(columns == matrix1.getColumns() && rows == matrix1.getRows()){
            System.out.println("Resultant Matrix : ");
            for (int i =0;i<rows;i++){
                for(int j =0;j<columns;j++){
                    System.out.print(matrix[i][j]*matrix1.getMatrix()[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Elementary multiplication not possible");
        }
    }

    public void Multiplication(Matrix matrix1) {
        if (columns == matrix1.getRows()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < matrix1.getColumns(); j++) {
                    int n = 0;
                    for(int k = 0;k<matrix1.getRows();k++){
                        n+= matrix[i][k]*matrix1.getMatrix()[k][j];
                    }
                    System.out.print(n + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Multiplication is not possible!");
        }
    }

    public void Subtraction(Matrix matrix1) {
        if (rows == matrix1.getRows() && columns == matrix1.getColumns()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(matrix[i][j] - matrix1.getMatrix()[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Subtraction is not possible!");
        }
    }

    public void Division(Matrix matrix1){
        if(columns == matrix1.getRows() && matrix1.getDeterminant() != 0){
            System.out.println("Resultant matrix : ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < matrix1.getColumns(); j++) {
                    int n= 0;
                    for(int k = 0;k<matrix1.getRows();k++) {
                        n+=matrix[i][k]*matrix1.getInverse()[k][j];
                    }
                    System.out.print(n + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Division is not possible");
        }
    }
    public void Addition(Matrix matrix1) {
        if (rows == matrix1.getRows() && columns == matrix1.getColumns()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(matrix[i][j] + matrix1.getMatrix()[i][j]+" ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Addition is not possible!");
        }
    }

    public void addTypes(){
        Utility util = new Utility();

        if(util.isOnes(this.matrix)){
            Addlabel("Ones Matrix");
        }

        if(util.isNull(this.matrix)){
            Addlabel("Null Matrix");
        }

        if(rows != columns){
            Addlabel("Rectangular Matrix");
        }

        if(rows == 1 && columns!=1){
            Addlabel("Row Matrix");
        }

        if(rows!=1 && columns == 1){
            Addlabel("Column Matrix");
        }

        if(rows == columns){
            Addlabel("Square Matrix");
            if(rows == 1){
                Addlabel("Singleton Matrix");
            }

            if(this.getDeterminant() == 0){
                Addlabel("Singular Matrix");
            }

            if(util.isSkewSymmetric(this.matrix)){
                Addlabel("Skew-Symmetric Matrix");
            }

            if(util.isSymmetric(this.matrix)){
                Addlabel("Symmetric Matrix");
            }

            if(util.isUpper(this.matrix)){
                Addlabel("Upper-triangular Matrix");
            }

            if(util.isLower(this.matrix)){
                Addlabel("Lower-triangular Matrix");
            }

            if(util.isLower(this.matrix) && util.isUpper(this.matrix)){
                Addlabel("Diagonal Matrix");
            }

            if(util.isScalar(this.matrix)){
                Addlabel("Scalar Matrix");
                if(matrix[0][0] == 1){
                    Addlabel("Identity Matrix");
                }
            }
        }
    }
}


