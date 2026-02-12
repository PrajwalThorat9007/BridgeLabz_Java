package linearandbinarysearch;

public class BinarySearch2D {

    public static boolean searchMatrix(int[][] matrix,int target){
        int row= matrix.length;
        System.out.println(row);

        int col=matrix[0].length;
        System.out.println(col);

        int left=0;
        int right=row*col-1;
        while(left<right){
            int mid=left+(right-left)/2;
            int rows=mid/col;
            int cols=mid%col;

            int midValue=matrix[rows][cols];
            if (midValue == target) {
                return true;
            }
            else if (midValue < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
        }
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 16;

        boolean found = searchMatrix(matrix, target);

        System.out.println("Element found: " + found);
    }
}
