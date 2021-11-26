package Assignment_4.Q2;

public class Matrix<T>{

     private final T obj;

    public Matrix(T obj){
         this.obj = obj;
    }

    public String getID(){
        if(obj instanceof GrayscaleMatrix){
            return ((GrayscaleMatrix) obj).getID();
        }
        else if(obj instanceof ColourfulMatrix){
            return ((ColourfulMatrix) obj).getID();
        }
        return null;
    }

    public void setArray(int[][] arr1){
        if(obj instanceof GrayscaleMatrix){
            ((GrayscaleMatrix) obj).setArray(arr1);
        }
    }

    public void setArray(int[][] arr1,int[][] arr2,int[][] arr3){
        if(obj instanceof ColourfulMatrix){
            ((ColourfulMatrix) obj).setArrayR(arr1);
            ((ColourfulMatrix) obj).setArrayB(arr2);
            ((ColourfulMatrix) obj).setArrayG(arr3);
        }
    }

     public void DisplayMatrix(){
        if(obj instanceof GrayscaleMatrix){
            System.out.println(obj);
        }
        else if(obj instanceof  ColourfulMatrix){
            System.out.println(obj);
        }
     }

     public void Negative(){
        if(obj instanceof GrayscaleMatrix){
            System.out.println(((GrayscaleMatrix) obj).Negative());
        }
        else if(obj instanceof ColourfulMatrix){
            System.out.println(((ColourfulMatrix) obj).Negative());
        }
     }

     public int[][] getArray(){
        if(obj instanceof GrayscaleMatrix){
            return ((GrayscaleMatrix) obj).getArray();
        }
        return null;
     }

     public int[][] getArrayR(){
        if(obj instanceof ColourfulMatrix){
            return ((ColourfulMatrix) obj).getArrayR();
        }
        return null;
     }

    public int[][] getArrayB(){
        if(obj instanceof ColourfulMatrix){
            return ((ColourfulMatrix) obj).getArrayB();
        }
        return null;
    }

    public int[][] getArrayG(){
        if(obj instanceof ColourfulMatrix){
            return ((ColourfulMatrix) obj).getArrayG();
        }
        return null;
    }

}
