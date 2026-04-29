package practise;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/27 20:27
 */
public class Top_048 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
            }
        }
    }
}
