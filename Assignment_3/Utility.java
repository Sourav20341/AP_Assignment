package Assignment_3;

class Utility {

    boolean isScalar(int [][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != matrix[0][0]){
                return false;
            }
        }
        return true;
    }

    boolean isOnes(int[][] matrix){

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] != 1) {
                    return false;
                }
            }
        }
        return false;
    }

    boolean isNull(int[][] matrix){
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

     boolean isUpper(int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > j) {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    boolean isLower(int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i < j) {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isSymmetric(int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isSkewSymmetric(int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != -matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int determinant(int[][] matrix,int n){
        int d = 0;
        if( n == 1){
            return matrix[0][0];
        }
        int[][] temp = new int[n][n];
        int sign = 1;
        for(int i = 0 ;i<n;i++){
            getCofactor(matrix,temp,0,i,n);
            d += sign * matrix[0][i] * determinant(temp,n-1);
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
}
