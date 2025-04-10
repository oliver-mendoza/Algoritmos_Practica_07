package actividad_03;

public class BinarySearchIterativo {
    int binarySearch(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySearchIterativo bs = new BinarySearchIterativo();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int x = 6;
        int result = bs.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Elemento no encontrado.");
        else
            System.out.println("Elemento encontrado en la posición: " + result);
    }
}