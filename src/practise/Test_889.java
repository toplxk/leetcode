package practise;

import basic.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiaokai1
 * @description
 * @date 2024/3/12 20:58
 */
public class Test_889 {
    public static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int[] preOrder = new int[]{1,2,4,5,3,6,7};
        int[] postOrder = new int[]{4,5,2,6,7,3,1};
        TreeNode tree = constructFromPrePost(preOrder, postOrder);
        System.out.println(tree);
    }

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return rebuild(preorder, 0, preorder.length - 1, postorder, 0 , postorder.length - 1);
    }

    private static TreeNode rebuild(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preorder == null || postorder == null || postorder.length == 0 || preorder.length == 0) {
            return null;
        }
        if (preStart > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        System.out.println(preorder[preStart]);
        int temp = map.get(preorder[preStart]);
        int leftLength = temp - postStart;
        node.left = rebuild(preorder, preStart + 1, preStart + leftLength, postorder, postStart, temp - 1);
        node.right = rebuild(preorder, preStart + leftLength + 1, preEnd, postorder, temp + 1, postEnd);
        return node;
    }
}
