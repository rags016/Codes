import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        int i;
        for (i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findMaxSubArraySum(arr, n));
    }


    private static int findMaxSubArraySum(int[] arr, int n) {
        int maxLocal = Integer.MIN_VALUE;
        int maxGlobal = Integer.MIN_VALUE;
        int s, e;
        s = e = 0;
        int i;
        int temp = 0;
        boolean flag = false;
        for (i = 0; i < n; i++) {
            if (flag && arr[i] == (-1 * arr[temp])) {
                arr[temp] = -1 * arr[temp];
                temp = i;
                arr[temp] = -1 * arr[temp];
                continue;
            } else if (flag && arr[i] < (-1 * arr[temp])) {
                maxLocal -= (2 * arr[temp]);
                maxGlobal -= (2 * arr[temp]);
                arr[temp] = -1 * arr[temp];
                flag = false;
            }
            if (!flag && arr[i] < 0) {
                temp = i;
                arr[i] = -1 * arr[i];
                flag = true;
            }

//            if (arr[i] > (arr[i] + maxLocal)) {
//                s = i;
//            }

            maxLocal = Math.max(arr[i], arr[i] + maxLocal);
//            if (maxLocal > maxGlobal) {
//                e = i;
//            }

            maxGlobal = Math.max(maxLocal, maxGlobal);
        }

//        System.out.println("start " + s + " end " + e);
        return maxGlobal;

    }
}
