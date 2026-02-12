package linearandbinarysearch;

import java.util.ArrayList;

public class PeakElement {

        public static void main(String[] args) {

            int[] arr = {45, 65, 88, 97, 25, 33};

            int left = 0;
            int right = arr.length - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                boolean leftCheck = (mid == 0) || (arr[mid] > arr[mid - 1]);
                boolean rightCheck = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);

                if (leftCheck && rightCheck) {
                    System.out.println("Peak element: " + arr[mid]);
                    return;
                }

                if (mid > 0 && arr[mid - 1] > arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }



}
