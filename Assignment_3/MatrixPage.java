package Assignment_3;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class MatrixPage {

    Utility util = new Utility();

     void start() {
        Scanner sc  = new Scanner(System.in);
        ArrayList<Matrix> matrices = new ArrayList<>();
        while(true){
            System.out.println("\n===================================================================");
            System.out.println("                          Operations Menu                          ");
            System.out.println("===================================================================");
            System.out.println("1. Create a matrix by input the elements");
            System.out.println("2. Create a matrix by giving matrix type");
            System.out.println("3. Change the elements of a matrix");
            System.out.println("4. Display all the matrices labels of requested matrix");
            System.out.println("5. Perform arithmetic operations");
            System.out.println("6. Perform element wise operations");
            System.out.println("7. Transpose a matrix");
            System.out.println("8. Inverse a matrix");
            System.out.println("9. Compute means");
            System.out.println("10. Compute determinant of a matrix");
            System.out.println("11. Use singleton matrix as scalar");
            System.out.println("12. Compute addition of a matrix with it's transpose");
            System.out.println("13. Compute Eigen vectors and values");
            System.out.println("14. Solve sets of linear equations");
            System.out.println("15. Retrieve all the existing matrices of input matrix-type label");
            System.out.println("16. Exit");
            System.out.println("===================================================================\n");
            int n;
            System.out.print("Enter the operation number : ");
            n = sc.nextInt();

            if(n == 1){

                sc.nextLine();
                System.out.print("Enter number of rows : ");
                int r;
                r = sc.nextInt();
                System.out.print("Enter number of columns : ");
                int c;
                c = sc.nextInt();
                int[][] arr = new int[r][c];
                System.out.println("Enter the matrix elements : ");
                for(int i = 0;i<r;i++){
                    for(int j = 0;j<c;j++){
                        arr[i][j] = sc.nextInt();
                    }
                }

                if(r == 1 && c == 1){
                    if(util.isNull(arr)){
                        Matrix matrix = new Null_Matrix(arr,r,c);
                        matrices.add(matrix);
                    }
                    else if(util.isOnes(arr)){
                        Matrix matrix = new Ones_Matrix(arr,r,c);
                        matrices.add(matrix);
                    } else{
                        Matrix matrix = new Singleton_Matrix(arr,r,c);
                        matrices.add(matrix);
                    }

                } else if(util.isNull(arr)){
                    Matrix matrix = new Null_Matrix(arr,r,c);
                    matrices.add(matrix);

                } else if(util.isOnes(arr)){
                    Matrix matrix = new Ones_Matrix(arr,r,c);
                    matrices.add(matrix);

                }  else if(r != c){
                    if(r == 1){
                        Matrix matrix = new Row_Matrix(arr,r,c);
                        matrices.add(matrix);
                    }
                    else if(c == 1){
                        Matrix matrix = new Column_Matrix(arr,r,c);
                        matrices.add(matrix);
                    }
                    else{
                        Matrix matrix = new Rectangular_Matrix(arr,r,c);
                        matrices.add(matrix);
                    }
                }

                else{

                    if(util.determinant(arr,r) == 0){
                        Matrix matrix = new Singular_Matrix(arr,r,c);
                        matrices.add(matrix);
                    }

                    else if(util.isUpper(arr) && !util.isLower(arr)){
                        Matrix matrix = new Upper_Triangular_Matrix(arr,r,c);
                        matrices.add(matrix);
                    }
                    else if(!util.isUpper(arr) && util.isLower(arr)){
                        Matrix matrix = new Lower_Triangular_Matrix(arr,r,c);
                        matrices.add(matrix);
                    }
                    else if(util.isSymmetric(arr)){

                        if(util.isLower(arr)){
                            if(util.isScalar(arr)){
                                Matrix matrix;
                                if(arr[0][0] == 1){
                                    matrix = new Identity_Matrix(arr, r, c);
                                }
                                else{
                                    matrix = new Scalar_Matrix(arr, r, c);
                                }
                                matrices.add(matrix);
                            }

                            else{
                                Matrix matrix = new Diagonal_Matrix(arr,r,c);
                                matrices.add(matrix);
                            }
                        }

                        else{
                            Matrix matrix = new Symmetric_Matrix(arr,r,c);
                            matrices.add(matrix);
                        }
                    }

                    else if(util.isSkewSymmetric(arr)){
                        Matrix matrix = new Skew_Symmetric_Matrix(arr,r,c);
                        matrices.add(matrix);
                    }
                    else{
                        Matrix matrix = new Square_Matrix(arr,r,c);
                        matrices.add(matrix);
                    }
                }
            }

            else if(n == 2){
                int row,column;
                String matrixtype;
                System.out.println("\n=============================");
                System.out.println("Types of Matrix : ");
                System.out.println("=============================");
                System.out.println("Rectangular Matrix");
                System.out.println("Column Matrix");
                System.out.println("Row Matrix");
                System.out.println("Ones Matrix");
                System.out.println("Null Matrix");
                System.out.println("Square Matrix");
                System.out.println("Diagonal Matrix");
                System.out.println("Symmetric Matrix");
                System.out.println("Skew-Symmetric Matrix");
                System.out.println("Scalar Matrix");
                System.out.println("Identity Matrix");
                System.out.println("Singleton Matrix");
                System.out.println("Lower-triangular Matrix");
                System.out.println("Upper-triangular Matrix");
                System.out.println("Singular Matrix");
                System.out.println("=============================");
                sc.nextLine();
                System.out.print("Enter the Matrix type name : ");
                matrixtype = sc.nextLine();
                System.out.print("Enter the number of rows : ");
                row = sc.nextInt();
                System.out.print("Enter the number of columns : ");
                column = sc.nextInt();
                Matrix matrix = null;
                int[][] arr = new int[row][column];
                if(matrixtype.equalsIgnoreCase("Rectangular Matrix")){
                    for (int i = 0;i<row;i++){
                        for(int j = 0;j<column;j++){
                            arr[i][j] = ThreadLocalRandom.current().nextInt(1,10);
                        }
                    }
                    matrix = new Rectangular_Matrix(arr,row,column);
                }
                else if(matrixtype.equalsIgnoreCase("Column Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            arr[i][j] = ThreadLocalRandom.current().nextInt(1,10);
                        }
                    }
                    matrix = new Column_Matrix(arr,row,column);
                }
                else if(matrixtype.equalsIgnoreCase("Row Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            arr[i][j] = ThreadLocalRandom.current().nextInt(1,10);
                        }
                    }
                    matrix = new Row_Matrix(arr,row,column);
                }
                else if(matrixtype.equalsIgnoreCase("Ones Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            arr[i][j] = 1;
                        }
                    }
                    matrix = new Ones_Matrix(arr,row,column);
                }
                else if(matrixtype.equalsIgnoreCase("Null Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            arr[i][j] = 0;
                        }
                    }
                    matrix = new Null_Matrix(arr,row,column);
                }
                else if(matrixtype.equalsIgnoreCase("Square Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            arr[i][j] = ThreadLocalRandom.current().nextInt(1,10);
                        }
                    }
                    matrix = new Square_Matrix(arr,row,column);
                }
                else if (matrixtype.equalsIgnoreCase("Diagonal Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            if( i == j){
                                arr[i][j] = ThreadLocalRandom.current().nextInt(1,10);
                            }
                            else{
                                arr[i][j] = 0;
                            }
                        }
                    }
                    matrix = new Diagonal_Matrix(arr,row,column);
                }
                else if (matrixtype.equalsIgnoreCase("Symmetric Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            if(i == j){
                                arr[i][j] = ThreadLocalRandom.current().nextInt(1,10);
                            }
                            else if(i > j){
                                arr[i][j] = ThreadLocalRandom.current().nextInt(1,10);
                                arr[j][i] = arr[i][j];
                            }
                        }
                    }
                    matrix = new Symmetric_Matrix(arr,row,column);
                }
                else if (matrixtype.equalsIgnoreCase("Skew-Symmetric Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            if(i == j){
                                arr[i][j] = 0;
                            }
                            else if(i > j){
                                arr[i][j] = ThreadLocalRandom.current().nextInt(1,10);
                                arr[j][i] = -arr[i][j];
                            }
                        }
                    }
                    matrix = new Symmetric_Matrix(arr,row,column);
                }
                else if (matrixtype.equalsIgnoreCase("Scalar Matrix")){
                    arr[0][0] = ThreadLocalRandom.current().nextInt(2,10);
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            if(i == j){
                                arr[i][j] = arr[0][0];
                            }
                            else{
                                arr[i][j] = 0;
                            }
                        }
                    }
                    matrix = new Scalar_Matrix(arr,row,column);
                }
                else if (matrixtype.equalsIgnoreCase("Identity Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            if(i == j){
                                arr[i][j] = 1;
                            }
                            else{
                                arr[i][j] = 0;
                            }
                        }
                    }
                    matrix = new Scalar_Matrix(arr,row,column);
                }
                else if (matrixtype.equalsIgnoreCase("Singleton Matrix")){
                    arr[0][0] = ThreadLocalRandom.current().nextInt(2,10);
                    matrix = new Singleton_Matrix(arr,row,column);
                }
                else if(matrixtype.equalsIgnoreCase("Lower-triangular Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            if(j>i){
                                arr[i][j] = 0;
                            }
                            else{
                                arr[i][j] = ThreadLocalRandom.current().nextInt(1,10);
                            }
                        }
                    }
                    matrix = new Lower_Triangular_Matrix(arr,row,column);
                }
                else if(matrixtype.equalsIgnoreCase("Upper-triangular Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            if(j<i){
                                arr[i][j] = 0;
                            }
                            else{
                                arr[i][j] = ThreadLocalRandom.current().nextInt(1,10);
                            }
                        }
                    }
                    matrix = new Upper_Triangular_Matrix(arr,row,column);
                }
                else if (matrixtype.equalsIgnoreCase("Singular Matrix")){
                    for(int i = 0;i< row;i++){
                        for(int j =0;j<column;j++){
                            if( i <= j ){
                                arr[i][j] = 0;
                            }
                            else{
                                arr[i][j] = ThreadLocalRandom.current().nextInt(1,10);
                            }
                        }
                    }
                    matrix = new Singular_Matrix(arr,row,column);
                }
                System.out.println("Created Matrix : ");
                if(matrix != null){
                    matrix.printMatrix();
                    matrices.add(matrix);
                }
            }
            else if(n == 3){
                int idx;
                System.out.println("Choose Matrix : ");
                for(Matrix matrix : matrices){
                    matrix.printMatrix();
                }
                System.out.print("\nEnter the id : ");
                idx = sc.nextInt();
                matrices.get(idx).printMatrix();
                ArrayList<String>temp = matrices.get(idx).getLabels();
                int x,y,el;
                int[][] prev = matrices.get(idx).getMatrix();
                System.out.println("Enter the index of element which you have to change of above matrix : ");
                System.out.print("Enter the x co-ordinate : ");
                x = sc.nextInt();
                System.out.print("Enter the y co-ordinate : ");
                y = sc.nextInt();
                System.out.print("Enter the element which you have to insert : ");
                el = sc.nextInt();
                matrices.get(idx).getMatrix()[x-1][y-1] = el;
                matrices.get(idx).addTypes();
                for(int i = 0;i<matrices.get(idx).getLabels().size();i++) {
                    if (!matrices.get(idx).getLabels().get(i).equals(temp.get(i))) {
                        System.out.println("Matrix can't be changed because it's violates previous labels!");
                        matrices.get(idx).setLabels(temp);
                        matrices.get(idx).setMatrix(prev);
                    }
                }
                matrices.get(idx).determinant();
                matrices.get(idx).inverse();
                matrices.get(idx).transpose();
            }

            else if(n == 4){
                int idx;
                System.out.println("Choose Matrix");
                for(Matrix matrix : matrices){
                    matrix.printMatrix();
                }
                System.out.print("\nEnter the id : ");
                idx = sc.nextInt();
                System.out.println("Matrix Labels :- ");
                for(String st:matrices.get(idx).getLabels()){
                    System.out.println(st);
                }
            }

            else if(n == 5){
                int ind,Fmatind,Fmatsec;
                System.out.println("Choose :");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.print("Enter you choice : ");
                ind = sc.nextInt();
                System.out.println("Choose matrix ID which you have to use from below");
                for(Matrix matrix : matrices){
                    matrix.printMatrix();
                }
                System.out.print("Enter the ID of First matrix which you want : ");
                Fmatind = sc.nextInt();
                System.out.print("Enter the ID of Second matrix which you want : ");
                Fmatsec = sc.nextInt();
                if(ind == 1){
                    matrices.get(Fmatind).Addition(matrices.get(Fmatsec));
                }
                else if(ind == 2){
                    matrices.get(Fmatind).Subtraction(matrices.get(Fmatsec));
                }
                else if(ind == 3){
                    matrices.get(Fmatind).Multiplication(matrices.get(Fmatsec));
                }
                else if(ind == 4){
                    matrices.get(Fmatind).Division(matrices.get(Fmatsec));
                }
                else{
                    System.out.println("Wrong input!");
                }
            }

            else if(n == 6){
                int ind,Fmatind,Fmatsec;
                System.out.println("Choose :");
                System.out.println("1. Elementary Addition");
                System.out.println("2. Elementary Subtraction");
                System.out.println("3. Elementary Multiplication");
                System.out.println("4. Elementary Division");
                System.out.print("Enter you choice : ");
                ind = sc.nextInt();
                System.out.println("Choose matrix ID which you have to use from below");
                for(Matrix matrix : matrices){
                    matrix.printMatrix();
                }
                System.out.print("Enter the ID of First matrix which you want : ");
                Fmatind = sc.nextInt();
                System.out.print("Enter the ID of Second matrix which you want : ");
                Fmatsec = sc.nextInt();
                if(ind == 1){
                    matrices.get(Fmatind).Addition(matrices.get(Fmatsec));
                }
                else if(ind == 2){
                    matrices.get(Fmatind).Subtraction(matrices.get(Fmatsec));
                }
                else if(ind == 3){
                    matrices.get(Fmatind).elementaryMultplication(matrices.get(Fmatsec));
                }
                else if(ind == 4){
                    matrices.get(Fmatind).elementaryDivision(matrices.get(Fmatsec));
                }
                else{
                    System.out.println("Wrong input!");
                }
            }

            else if(n == 7){
                int idx;
                System.out.println("Choose Matrix : ");
                for(Matrix matrix : matrices){
                    matrix.printMatrix();
                }
                System.out.print("\nEnter the id : ");
                idx = sc.nextInt();
                System.out.println("Transpose : ");
                for(int[] tran : matrices.get(idx).getTranspose()){
                    for(int t : tran){
                        System.out.print(t + " ");
                    }
                    System.out.println();
                }
            }

            else if(n == 8){
                int idx;
                for(Matrix matrix : matrices){
                    matrix.printMatrix();
                }
                System.out.print("\nEnter the id : ");
                idx = sc.nextInt();
                int val = matrices.get(idx).getDeterminant();
                if (val == Integer.MAX_VALUE || val == 0){
                    System.out.println("Inverse not exists");
                    continue;
                }

                System.out.println("Inverse : ");
                for(float[] inverse : matrices.get(idx).getInverse()){
                    for (float inv : inverse){
                        System.out.print(inv + " ");
                    }
                    System.out.println();
                }
            }

            else if(n == 9){
                int idx,choice;
                System.out.println("Choose Matrix : ");
                for (Matrix matrix : matrices){
                    matrix.printMatrix();
                }
                System.out.print("\nEnter the ID of choose Matrix : ");
                idx = sc.nextInt();
                System.out.println("Choose the Operation : ");
                System.out.println("1. Row wise mean");
                System.out.println("2. Column wise mean");
                System.out.println("3. Mean of all elements");
                System.out.print("Enter the option : ");
                choice = sc.nextInt();
                if(choice == 1){
                    matrices.get(idx).rowmean();
                }
                else if (choice == 2){
                    matrices.get(idx).columnmean();
                }
                else if(choice == 3){
                    matrices.get(idx).mean();
                }
                else{
                    System.out.println("Wrong Input");
                }
            }

            else if(n == 10){
                int idx;
                for(Matrix matrix : matrices){
                    matrix.printMatrix();
                }
                System.out.print("\nEnter the id : ");
                idx = sc.nextInt();
                int val = matrices.get(idx).getDeterminant();
                if (val == Integer.MAX_VALUE){
                    System.out.println("Determinant not exists");
                    continue;
                }
                System.out.print("Determinant = " +  val);
            }

            else if(n == 11){
                int idx,Fsingmat,Fmat;
                System.out.println("Choose : ");
                System.out.println("1. Scalar Multiplication");
                System.out.println("2. Scalar Division");
                System.out.print("Enter the operation number : ");
                idx = sc.nextInt();
                System.out.println("Select the singleton matrix which you have to use as scalar : ");
                for(Matrix matrix : matrices){
                    for(String st : matrix.getLabels()){
                        if(st.equalsIgnoreCase("Singleton Matrix")){
                            matrix.printMatrix();
                        }
                    }
                }
                System.out.print("Enter the ID of matrix you chosen : ");
                Fsingmat = sc.nextInt();
                System.out.println("Now choose your second matrix with which you have to do operation : ");
                for (Matrix matrix : matrices){
                    matrix.printMatrix();
                }
                System.out.print("Enter the ID of matrix you chosen : ");
                Fmat = sc.nextInt();
                if(idx == 1){
                    matrices.get(Fsingmat).scalermultiplication(matrices.get(Fmat));
                }
                else if(idx == 2){
                    matrices.get(Fsingmat).scalerdivision(matrices.get(Fmat));
                }
                else{
                    System.out.println("Wrong input!");
                }
            }

            else if(n == 12){
                int idx;
                System.out.println("Choose Matrix : ");
                for (Matrix matrix : matrices){
                    matrix.printMatrix();
                }
                System.out.print("\nEnter the to of choose Matrix : ");
                idx = sc.nextInt();
                matrices.get(idx).computeAAT();
            }

            else if (n == 13){
                int idx;
                System.out.println("Choose Matrix : ");
                for (Matrix matrix : matrices){
                    matrix.printMatrix();
                }
                System.out.print("\nEnter the ID to choose Matrix : ");
                idx = sc.nextInt();

                matrices.get(idx).getEigenVector();
            }

            else if(n == 14){
                int nov;
                System.out.print("Enter the number of variables : ");
                nov = sc.nextInt();
                int[][] matrixA = new int[nov][nov];
                int[][] matrixB = new int[nov][1];
                String[][] matrixVar = new String[nov][1];
                System.out.println("Enter the coefficient of variables in matrix form : ");
                for(int i=0;i<nov;i++){
                    for(int j = 0;j<nov;j++){
                        matrixA[i][j] = sc.nextInt();
                    }
                }
                System.out.println("Enter the variables name : ");
                sc.nextLine();
                for(int i = 0;i<nov;i++){
                    matrixVar[i][0] = sc.nextLine();
                }
                System.out.println("\nEnter the constant in matrix form : ");
                for(int i = 0;i<nov;i++){
                    matrixB[i][0] = sc.nextInt();
                }
                Matrix matrix1 = new Square_Matrix(matrixA,nov,nov);
                Matrix matrix2 = new Column_Matrix(matrixB,nov,1);
                matrix1.multiplyinverse(matrix2);
                System.out.println("Values of variable : ");
                for(int i = 0;i<nov;i++){
                    System.out.println(matrixVar[i][0] + " : " + matrix1.getMvresult()[i][0]);
                }
            }

            else if(n == 15){
                String checklabel;
                sc.nextLine();
                System.out.print("Enter the label name : ");
                checklabel = sc.nextLine();
                System.out.println("Matrix ID/IDs which contain label " + checklabel + " is : ");
                for(Matrix matrix : matrices){
                    for(String label : matrix.getLabels()){
                        if(label.equalsIgnoreCase(checklabel)){
                            matrix.printMatrix();
                            break;
                        }
                    }
                }
            }

            else if(n == 16){
                System.out.println("\n=================");
                System.out.println("Thanks for using!");
                System.out.println("=================");
                break;
            }

            else{
                System.out.println("Wrong Input!");
            }
        }

    }

}
