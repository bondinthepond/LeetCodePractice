package DS;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public int[][] transpose(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] matrix_transpose = new int[columns][rows];


        for(int i =0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix_transpose[j][i] = matrix[i][j];
            }
        }
        return matrix_transpose;
    }

    public void printMatrix(int[][] matrix){
        for(int i = 0; i< matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotateBy90_Clockwise_InPlace(int[][] matrix){

        int left = 0;
        int right = matrix.length-1;

//        int top = 0;
//        int bottom = matrix.length - 1;

        while(left < right){
            //right - left determines the number of rotations per layer
            //if it is a 4X4 - 3 elements need to be moved to make the rotation
            for (int offset = 0; offset < (right-left); offset++) {
                int top = left;
                int bottom = right;

               /*
                //save top left to temp
                int temp = matrix[top][left];
                //move bottom left to top left
                matrix[top][left] = matrix[bottom][left];
                //move bottom right to bottom left
                matrix[bottom][left] = matrix[bottom][right];
                //move top right to bottom right
                matrix[bottom][right] = matrix[top][right];
                //move temp to top right;
                matrix[top][right] = temp;

                the operations shown above are to rotate corner elements
                to move the elements next to corner elements, we need to consider the offset - i.e, how far it is from the corner
                this is where i can be used
                */

                //save top left to temp
                int temp = matrix[top][left + offset];

                //move bottom left to top left
                matrix[top][left+offset] = matrix[bottom - offset][left];

                //move bottom right to bottom left
                matrix[bottom - offset][left] = matrix[bottom][right-offset];

                //move top right to bottom right
                matrix[bottom][right - offset] = matrix[top + offset][right];

                //move temp to top right;
                matrix[top + offset][right] = temp;
            }
            left ++;
            right --;
        }
    }

    public void rotateBy90_AntiClockwise_InPlace(int[][] matrix) {
        int left = 0;
        int right = matrix.length-1;

//        int top = 0;
//        int bottom = matrix.length - 1;

        while(left < right){
            //right - left determines the number of rotations per layer
            //if it is a 4X4 - 3 elements need to be moved to make the rotation
            for (int offset = 0; offset < (right-left); offset++) {
                int top = left;
                int bottom = right;

                //save top left to temp
                int temp = matrix[top][left + offset];

                //move from top right to top left
                matrix[top][left + offset] = matrix[top + offset][right];

                matrix[top + offset][right] = matrix[bottom][right - offset];

                matrix[bottom][right - offset] = matrix[bottom - offset][left];

                matrix[bottom - offset][left] = temp;
            }
            left ++;
            right --;
        }
    }

        public static void traverseMatrixInASpiralOrder(int[][] matrix){

            if(matrix.length == 0)
                return;
            // Initialize our four indexes
            int top = 0;
            int down = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;


            while (true) {

                // Print top row
                for(int j = left; j <= right; j++)
                    System.out.print(matrix[top][j] + " ");
                top++;

                if (top > down || left > right) break;

                //Print the rightmost column
                for(int i = top; i <= down; i++)
                    System.out.print(matrix[i][right] + " ");
                right--;

                if (top > down || left > right) break;

                //Print the bottom row
                for(int j = right; j >= left; --j)
                    System.out.print(matrix[down][j] + " ");
                down--;

                if (top > down || left > right) break;

                //Print the leftmost column
                for(int i = down; i >= top; --i)
                    System.out.print(matrix[i][left] + " ");
                left++;
                if(top > down || left > right) break;
            }
        }

        public static void traverseMatrixInASpiral(List<ArrayList<Integer>> a){
            ArrayList<Integer> result = new ArrayList<Integer>();
            // Populate result;
            int top = 0;
            int down = a.size();
            int left = 0;
            int right = a.get(0).size();

            while(true){

                for(int j = left; j <= right; j++)
                    System.out.print(a.get(top).get(j) + " ");
                top++;

                if (top > down || left > right) break;

                //Print the rightmost column
                for(int i = top; i <= down; i++)
                    System.out.print(a.get(i).get(right) + " ");
                right--;

                if (top > down || left > right) break;

                //Print the bottom row
                for(int j = right; j >= left; --j)
                    System.out.print(a.get(down).get(j) + " ");
                down--;

                if (top > down || left > right) break;

                //Print the leftmost column
                for(int i = down; i >= top; --i)
                    System.out.print(a.get(i).get(left) + " ");
                left++;
                if(top > down || left > right) break;
            }
            }
        }
