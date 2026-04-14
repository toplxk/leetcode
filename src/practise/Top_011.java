package practise;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/13 14:11
 */
public class Top_011 {
    //双指针法
    public static int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int maxArea = 0;
        int low = 0, high = height.length - 1;
        while(low < high) {
            int curArea = (height[low] > height[high] ? height[high] : height[low]) * (high - low);
            maxArea = Math.max(curArea, maxArea);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int res = maxArea(height);
        System.out.println(res);
    }
}
