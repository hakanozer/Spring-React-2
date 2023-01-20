package Soru8;

public class MinMaxSumArray {

    public static int minMaxSumOfArray(int[] arr) {

        int minValue = 0;
        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            minValue = arr[0];
            maxValue = arr[0];
            if (arr[0] < arr[i]) {
                minValue = arr[i];
            }
            if (arr[0] > arr[i]) {
                maxValue = arr[i];
            }
        }
        return minValue + maxValue;
    }
}
