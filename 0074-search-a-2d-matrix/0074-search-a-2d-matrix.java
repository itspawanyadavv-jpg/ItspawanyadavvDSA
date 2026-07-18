class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length ;

        //Binary search on Array.
        int left = 0;
        int right = rows * cols - 1;

        while(left <= right){

             //Avoid integer overflow.

             int mid = left + ( right - left) /2;

             //Convert 1D matrix into  2d Matrix;

             int row = mid / cols;
             int col = mid % cols;

             int value= matrix[row][col];

             if(value == target){
                return true;
                
             }if(value  < target){
                left = mid +1;
             }else{
                right = mid - 1;
            }

            



        }
        return false ;
    }

        
}
