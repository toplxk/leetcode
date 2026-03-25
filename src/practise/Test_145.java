package practise;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lixiaokai1
 * @description
 * @date 2024/2/4 15:35
 */
public class Test_145 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(4,null, null);
        TreeNode right = new TreeNode(2, new TreeNode(3) ,null);
        TreeNode root = new TreeNode(1, left , right);
        List<Integer> res = postorderTraversal(root);
        System.out.println(res);
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) return output;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                output.add(stack.pop().val);
            }
        }
        return output;
    }
}
