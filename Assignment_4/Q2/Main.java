package Assignment_4.Q2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        ArrayList<Matrix<GrayscaleMatrix>>gmatrices = new ArrayList<>();
        ArrayList<Matrix<ColourfulMatrix>>cmatrices = new ArrayList<>();
        while (true){
            System.out.println("\n==========================================");
            System.out.println("                  Option Menu              ");
            System.out.println("==========================================");
            System.out.println("1. Input Image");
            System.out.println("2. Create Image");
            System.out.println("3. Update Image");
            System.out.println("4. Display Image");
            System.out.println("5. Negative Image");
            System.out.println("6. Exit");
            System.out.println("==========================================\n");

            System.out.print("Enter the operation number : ");
            input = sc.nextInt();

            if(input == 1) {
                int choice;
                String ID;
                sc.nextLine();
                System.out.print("Enter the matrix ID : ");
                ID = sc.nextLine();
                System.out.print("Enter number of rows : ");
                int r;
                r = sc.nextInt();
                System.out.print("Enter number of columns : ");
                int c;
                c = sc.nextInt();
                System.out.println("\n==========================================");
                System.out.println("                  Option Menu              ");
                System.out.println("==========================================");
                System.out.println("1. Grayscale Image");
                System.out.println("2. Colourful Image");
                System.out.println("==========================================\n");
                System.out.print("Enter your operation number : ");
                choice = sc.nextInt();
                if(choice == 1){
                    int[][] arr = new int[r][c];
                    System.out.println("Enter the matrix elements : ");
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            arr[i][j] = sc.nextInt();
                        }
                    }
                    GrayscaleMatrix grayscaleMatrix = new GrayscaleMatrix(ID,arr);
                    gmatrices.add(new Matrix<>(grayscaleMatrix));
                }
                else if(choice == 2){
                    int[][] arrR = new int[r][c];
                    int[][] arrB = new int[r][c];
                    int[][] arrG = new int[r][c];
                    System.out.println("Enter the Red Color matrix elements : ");
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            arrR[i][j] = sc.nextInt();
                        }
                    }
                    System.out.println();
                    System.out.println("Enter the Blue Color matrix elements : ");
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            arrB[i][j] = sc.nextInt();
                        }
                    }
                    System.out.println();
                    System.out.println("Enter the Green Color matrix elements : ");
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            arrG[i][j] = sc.nextInt();
                        }
                    }
                    System.out.println();
                    ColourfulMatrix colourfulMatrix = new ColourfulMatrix(ID,arrR,arrB,arrG);
                    cmatrices.add(new Matrix<>(colourfulMatrix));
                }
            }

            else if(input == 2){
                int row,column,choice,option;
                String ID;
                sc.nextLine();
                System.out.print("Enter the ID of Image : ");
                ID = sc.nextLine();
                System.out.print("Enter the number of rows : ");
                row = sc.nextInt();
                System.out.print("Enter the number of columns : ");
                column = sc.nextInt();
                System.out.println("\n==========================================");
                System.out.println("             Operation Menu               ");
                System.out.println("==========================================");
                System.out.println("1. Create Grayscale Image");
                System.out.println("2. Create Colourful Image");
                System.out.println("==========================================\n");
                System.out.print("Enter your choice : ");
                option = sc.nextInt();
                System.out.println("\n==========================================");
                System.out.println("             Operation Menu               ");
                System.out.println("==========================================");
                System.out.println("1. Create ones matrix");
                System.out.println("2. Create null matrix");
                System.out.println("==========================================\n");
                System.out.print("Enter your choice : ");
                choice = sc.nextInt();
                int[][] arr1 = new int[row][column];
                if(option == 1){
                    if(choice == 1){
                        for(int i = 0;i<row;i++){
                            for(int j = 0;j<column;j++){
                                arr1[i][j] = 1;
                            }
                        }
                    }
                    else if(choice == 2){
                        for(int i = 0;i<row;i++){
                            for(int j = 0;j<column;j++){
                                arr1[i][j] = 0;
                            }
                        }
                    }
                    GrayscaleMatrix grayscaleMatrix = new GrayscaleMatrix(ID,arr1);
                    gmatrices.add(new Matrix<>(grayscaleMatrix));
                }

                else if(option == 2){
                    int[][] arr2 = new int[row][column];
                    int[][] arr3 = new int[row][column];
                    if(choice == 1){
                        for(int i = 0;i<row;i++){
                            for(int j = 0;j<column;j++){
                                arr1[i][j] = 1;
                            }
                        }
                        for(int i = 0;i<row;i++){
                            for(int j = 0;j<column;j++){
                                arr2[i][j] = 1;
                            }
                        }
                        for(int i = 0;i<row;i++){
                            for(int j = 0;j<column;j++){
                                arr3[i][j] = 1;
                            }
                        }
                    }
                    else if(choice == 2){
                        for(int i = 0;i<row;i++){
                            for(int j = 0;j<column;j++){
                                arr1[i][j] = 0;
                            }
                        }
                        for(int i = 0;i<row;i++){
                            for(int j = 0;j<column;j++){
                                arr2[i][j] = 0;
                            }
                        }
                        for(int i = 0;i<row;i++){
                            for(int j = 0;j<column;j++){
                                arr3[i][j] = 0;
                            }
                        }
                    }
                    ColourfulMatrix colourfulMatrix = new ColourfulMatrix(ID,arr1,arr2,arr3);
                    cmatrices.add(new Matrix<>(colourfulMatrix));
                }
            }

            else if(input == 3){
                String option;
                boolean ingrayscale = false;
                int index = -1;
                System.out.println("Grayscale Images' ID : ");
                for(Matrix<GrayscaleMatrix> grayscaleMatrix : gmatrices){
                    System.out.print(grayscaleMatrix.getID() + " ");
                }
                System.out.println("\n");
                System.out.println("Colourful Images' ID : ");
                for (Matrix<ColourfulMatrix> colourfulMatrixMatrix : cmatrices){
                    System.out.print(colourfulMatrixMatrix.getID() + " ");
                }
                System.out.println("\n");
                sc.nextLine();
                System.out.println("Choose Image ID from above which you have to update image : ");
                option = sc.nextLine();
                for(Matrix<GrayscaleMatrix> grayscaleMatrix : gmatrices){
                    if(grayscaleMatrix.getID().equalsIgnoreCase(option)){
                        index = gmatrices.indexOf(grayscaleMatrix);
                        ingrayscale = true;
                    }
                }
                if(!ingrayscale){
                    for(Matrix<ColourfulMatrix> colourfulMatrixMatrix : cmatrices){
                        if(colourfulMatrixMatrix.getID().equalsIgnoreCase(option)){
                            index = cmatrices.indexOf(colourfulMatrixMatrix);
                        }
                    }
                    int[][] arr1 = new int[cmatrices.get(index).getArrayR().length][cmatrices.get(index).getArrayR()[0].length];
                    int[][] arr2 = new int[cmatrices.get(index).getArrayB().length][cmatrices.get(index).getArrayB()[0].length];
                    int[][] arr3 = new int[cmatrices.get(index).getArrayG().length][cmatrices.get(index).getArrayG()[0].length];
                    System.out.println("Enter Red Coordinates : ");
                    for(int i = 0;i<cmatrices.get(index).getArrayR().length;i++){
                        for(int j =0;j<cmatrices.get(index).getArrayR()[0].length;j++){
                            arr1[i][j] = sc.nextInt();
                        }
                    }
                    System.out.println("\n");
                    System.out.println("Enter Blue Coordinates : ");
                    for(int i = 0;i<cmatrices.get(index).getArrayB().length;i++){
                        for(int j =0;j<cmatrices.get(index).getArrayB()[0].length;j++){
                            arr2[i][j] = sc.nextInt();
                        }
                    }
                    System.out.println("\n");
                    System.out.println("Enter Green Coordinates : ");
                    for(int i = 0;i<cmatrices.get(index).getArrayG().length;i++){
                        for(int j =0;j<cmatrices.get(index).getArrayG()[0].length;j++){
                            arr3[i][j] = sc.nextInt();
                        }
                    }
                    cmatrices.get(index).setArray(arr1,arr2,arr3);
                }
                else{
                    int[][] arr = new int[gmatrices.get(index).getArray().length][gmatrices.get(index).getArray()[0].length];
                    System.out.println("Enter the GrayImage Coordinates : ");
                    for(int i = 0;i<gmatrices.get(index).getArray().length;i++){
                        for(int j = 0;j<gmatrices.get(index).getArray()[0].length;j++){
                            arr[i][j] = sc.nextInt();
                        }
                    }
                    gmatrices.get(index).setArray(arr);
                }
                System.out.println("\n==========================================");
                System.out.println("       All Coordinates are updated !        ");
                System.out.println("==========================================\n");
            }

            else if(input == 4){
                String option;
                boolean ingrayscale = false;
                int index = -1;
                System.out.println("Grayscale Images' ID : ");
                for(Matrix<GrayscaleMatrix> grayscaleMatrix : gmatrices){
                    System.out.print(grayscaleMatrix.getID() + " ");
                }
                System.out.println("\n");
                System.out.println("Colourful Images' ID : ");
                for (Matrix<ColourfulMatrix> colourfulMatrixMatrix : cmatrices){
                    System.out.print(colourfulMatrixMatrix.getID() + " ");
                }
                System.out.println("\n");
                sc.nextLine();
                System.out.println("Choose Image ID from above which you have to see : ");
                option = sc.nextLine();
                for(Matrix<GrayscaleMatrix> grayscaleMatrix : gmatrices){
                    if(grayscaleMatrix.getID().equalsIgnoreCase(option)){
                        index = gmatrices.indexOf(grayscaleMatrix);
                        ingrayscale = true;
                    }
                }
                if(!ingrayscale){
                    for(Matrix<ColourfulMatrix> colourfulMatrixMatrix : cmatrices){
                        if(colourfulMatrixMatrix.getID().equalsIgnoreCase(option)){
                            index = cmatrices.indexOf(colourfulMatrixMatrix);
                        }
                    }
                    cmatrices.get(index).DisplayMatrix();
                }
                else{
                    gmatrices.get(index).DisplayMatrix();
                }
            }

            else if(input == 5){
                String option;
                boolean ingrayscale = false;
                int index = -1;
                System.out.println("Grayscale Images' ID : ");
                for(Matrix<GrayscaleMatrix> grayscaleMatrix : gmatrices){
                    System.out.print(grayscaleMatrix.getID() + " ");
                }
                System.out.println("\n");
                System.out.println("Colourful Images' ID : ");
                for (Matrix<ColourfulMatrix> colourfulMatrixMatrix : cmatrices){
                    System.out.print(colourfulMatrixMatrix.getID() + " ");
                }
                System.out.println("\n");
                sc.nextLine();
                System.out.println("Choose Image ID from above which you have to see Negative image : ");
                option = sc.nextLine();
                for(Matrix<GrayscaleMatrix> grayscaleMatrix : gmatrices){
                    if(grayscaleMatrix.getID().equalsIgnoreCase(option)){
                        index = gmatrices.indexOf(grayscaleMatrix);
                        ingrayscale = true;
                    }
                }
                if(!ingrayscale){
                    for(Matrix<ColourfulMatrix> colourfulMatrixMatrix : cmatrices){
                        if(colourfulMatrixMatrix.getID().equalsIgnoreCase(option)){
                            index = cmatrices.indexOf(colourfulMatrixMatrix);
                        }
                    }
                    cmatrices.get(index).Negative();
                }
                else{
                    gmatrices.get(index).Negative();
                }
            }

            else if(input == 6){
                System.out.println("\n==========================================");
                System.out.println("             Thanks For using !             ");
                System.out.println("==========================================\n");
                break;
            }

            else{
                System.out.println("\n==========================================");
                System.out.println("                  Wrong Input !              ");
                System.out.println("==========================================\n");
            }
        }
    }
}
