package algorithm;

/** 정렬과탐색 216p */
public class SortAndSearch {


    /** 병합정렬 (mergesort) */
    void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(array, helper, low, middle); // 왼쪽 정렬
//            mergesort(array, helper, middle + 1, high); // 오른쪽 절반 정렬
            merge(array, helper, low, middle, high); // 병합
        }
    }

    void merge(int[] array, int[] helper, int low, int middle, int high) {
        /** 절반짜리 두 배열을 helper 배열에 복사한다. */
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /** helper 배열 순회. 왼쪽, 오른쪽 절반을 비교하여 작은 원소를 원래 배열에 복사해 넣는다. */
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else { // 오른쪽 원소가 왼쪽 원소보다 작으면
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /** 왼쪽 절반 배열에 남은 원소들을 원래 배열에 복사해 넣는다. */
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    /** 퀵 정렬 218p */

    private static void swap(int[] arr,int start,int end) {
        int tmp=arr[start];
        arr[start]=arr[end];
        arr[end]=tmp;
        return;
    }

    void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) { // 왼쪽 절반 정렬
            quickSort(arr, left, index - 1);
        }

        if(index < right){ // 오른쪽 절반 정렬
            quickSort(arr, index, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left+right) / 2]; // 분할 기준 원소 선정
        while (left <= right) {
            // 왼쪽에서 오른쪽으로 옮겨야 하는 원소 탐색
            while(arr[left] < pivot) left++;

            // 오른쪽에서 왼쪽으로 옮겨야 하는 원소 탐색
            while(arr[right] > pivot) right--;

            // 원소를 스왑한 뒤 left와 right를 이동
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    /** 퀵 정렬 END */

    /**
     * 이진 탐색 220p
     */

    // 반복 탐색

    int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 재귀 탐색
    int binarySearchRecursive(int[] a, int x, int low, int high) {
        if(low > high) return -1;

        int mid = (low + high) / 2;
        if (a[mid] < x) {
            return binarySearchRecursive(a, x, mid + 1, high);
        } else if (a[mid] > x) {
            return binarySearchRecursive(a, x, low, mid - 1);
        } else {
            return mid;
        }
    }

    /** 이진 탐색 END */


    public static void main(String[] args) {
        SortAndSearch sortAndSearch = new SortAndSearch();
//        sortAndSearch.mergesort(new int[]{6, 1, 7, 8, 5});

        int[] intArr = {6, 1, 7, 8, 5};
        sortAndSearch.quickSort(intArr, 0, intArr.length - 1);

    }
}
