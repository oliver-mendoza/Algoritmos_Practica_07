package actividad_03;

public class BinarySearchRecursivo {
    int binarySearch(int[] arr, int lo, int hi, int x) {
        if (hi >= lo && lo < arr.length) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] > x)
                return binarySearch(arr, lo, mid - 1, x);
            else
                return binarySearch(arr, mid + 1, hi, x);
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySearchRecursivo bs = new BinarySearchRecursivo();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int x = 4;
        int result = bs.binarySearch(arr, 0, arr.length - 1, x);
        if (result == -1)
            System.out.println("Elemento no encontrado.");
        else
            System.out.println("Elemento encontrado en la posición: " + result);
    }
}