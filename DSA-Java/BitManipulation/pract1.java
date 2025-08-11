package BitManipulation;

public class pract1 {
    public static void main(String[] args) {
        int[] arr = {4, 0, 9, 6};
        permute(arr, 0);
    }

    static void permute(int[] arr, int index) {
        if (index == arr.length) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1);
            swap(arr, index, i); // backtrack
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
