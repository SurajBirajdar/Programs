package programs.program.newPrograms.binarySearch;

public class EcoSpoj {
    public static void main(String[] args) {
        int[] arr = {20, 15, 10, 17 };
        System.out.println(ekoSpoj(arr, 7));

    }

    public static boolean isValidAns(int[] trees, int m, int mid) {
        long totalWoodCount = 0;
        for(int i=0; i<trees.length; i++) {
            if(trees[i] > mid) { // 20 -
                totalWoodCount = totalWoodCount + (trees[i] - mid);
            }
        }
        if(totalWoodCount >= m) {
            return true;
        } else {
            return false;
        }
    }

    public static int ekoSpoj(int[] arr, int m) {
        int s = 0;
        int n = arr.length;
        int max = -1;
        for(int i=0; i<n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        int e = max;
        int ans = -1;
        while(s<=e) {
            int mid = s + (e-s)/2;
            if(isValidAns(arr,m, mid)) {
                ans = mid;
                s = mid + 1;  // Search higher for maximum valid height
            } else {
                e = mid - 1;  // Search lower
            }
        }
        return ans;
    }
}
