import java.util.Arrays;

public class SortAndSearch_Q {


    // 10.1 정렬된 병합
    /**
     * 정렬된 배열 A와 B가 주어진다. A의 끝에는 B를 전부 넣을 수 있을 만큼 충분한 여유 공간이 있다，
     * B와 A를 정렬된 상태로 병합하는 메서드를작성하라，
     */
    void merge(int[] arr1, int[] arr2) {
        if(arr2.length > arr1.length) return;

        int a1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                a1 = i;
                break;
            }
        }


        int arr1Last = a1 - 1;
        int arr2Last = arr2.length - 1;
        int mergeLast = a1 + arr2Last;

        /**  */
        while (arr2Last >= 0) {

            if (arr1[arr1Last] >= arr2[arr2Last] && arr1Last >= 0) {
                arr1[mergeLast] = arr1[arr1Last];
                arr1Last--;
            } else {
                arr1[mergeLast] = arr2[arr2Last];
                arr2Last--;
            }
            mergeLast--;

        }

    }

    /** solution */


    /**
     * Anagram 묶기
     */
    // 철자 순서만 바꾼 문자열 (anagram)이 서로 인접하도록 문자열 배열을 정렬하는 메서드를작성하라.
    // compare
    int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }

    private String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    // hashMap TODO


    // 회전된 배열에서 검색
    int search(int[] arr, int left, int right, int x) {
        int mid = (left + right) / 2;

        if (x == arr[mid]) return mid;
        if (right < left) return -1;

        if (arr[left] < arr[mid]) {

            if (x >= arr[left] && x < arr[mid]) {
                return search(arr, left, mid - 1, x); // 왼 탐
            } else {
                return search(arr, mid+1, right, x); // 오른쪽 탐색
            }

        } else if (arr[mid] < arr[left]) {
            if (x > arr[mid] && x < arr[right]) {
                return search(arr, mid+1, right, x); // 오른쪽 탐색
            } else {
                return search(arr, left, mid - 1, x); // 왼 탐
            }

        } else if (arr[left] == arr[mid]) {
            if (arr[mid] != arr[right]) {
                return search(arr, mid+1, right, x); // 오른쪽 탐색
            } else {
                int result = search(arr, left, mid - 1, x);
                if (result == -1) {
                    return search(arr, mid+1, right, x); // 오른쪽 탐색
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
    /** 531p */



    public static void main(String[] args) {
        SortAndSearch_Q s = new SortAndSearch_Q();
//        int[] a = new int[10];
//        a[0] = 1;
//        a[1] = 2;
//        a[2] = 3;
//        s.merge(a, new int[]{6,7,8});

            // ["eat", "tea", "tan", "ate", "nat", "bat"]
//        s.compare("abba", "baab");
        int[] arr = {15, 16, 19,6, 8, 5, 7, 10, 14};
        s.search(arr, 0, arr.length-1, 5);

    }
}


