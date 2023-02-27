import java.util.Arrays;
import java.util.Comparator;

public class csa_spingboot {
    public static void main(String[] args) {

    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2-1];
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0;i<flowerbed.length;i++){
            if(flowerbed[i] ==1){
                i+=2;
            } else if (flowerbed[i + 1] == 0 || i == flowerbed[flowerbed.length - 1]) {
                n--;
                i += 2;
            }
            else {
                i += 3;
            }
        }
        if(n<=0)
            return true;
        else
            return false;
}
    //cv过来的 做不出来 /(ㄒoㄒ)/~~
    public int eraseOverlapIntervals(int[][] intervals){
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
}
