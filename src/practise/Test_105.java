package practise;

import basic.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiaokai1
 * @description
 * @date 2024/8/1 14:13
 */
public class Test_105 {
    public Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valueMap.put(inorder[i], i);
        }
        return rebuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode rebuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preorder == null || inorder == null || preStart < 0 || inStart < 0 || preEnd >= preorder.length || inEnd >= inorder.length || preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = valueMap.get(root.val);
        int left_length = index - inStart;
        root.left = rebuildTree(preorder, preStart + 1, preStart + left_length, inorder, inStart, index - 1);
        root.right = rebuildTree(preorder, preStart + left_length + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = { 3,9,20,15,7 };
        int[] inorder = { 9,3,15,20,7 };
        TreeNode res = new Test_105().buildTree(preorder, inorder);
        System.out.println(res);
    }
}
