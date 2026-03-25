package basic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author lixiaokai1
 * @description
 * @date 2024/2/4 15:18
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTreeNode(Integer[] val) {
        if (val.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(val[0]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        boolean isLeft = true;
        for (int i = 1; i < val.length; i++) {
            TreeNode peek = queue.getFirst();
            if(isLeft) {
                if(val[i] != null) {
                    peek.left = new TreeNode(val[i]);
                    queue.add(peek.left);
                }
                isLeft = false;
            } else {
                if (val[i] != null) {
                    peek.right = new TreeNode(val[i]);
                    queue.add(peek.right);
                }
                queue.removeFirst();
                isLeft = true;
            }
        }
        return treeNode;
    }

    @Override
    public String toString() {
        return TreeNode.levelOrder(this);
    }

    private static String levelOrder(TreeNode root) {
        if (root == null) {
            return "";
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",");
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                continue;
            }
            if (node.left != null) {
                queue.offer(node.left);
                sb.append(node.left.val + ",");
            } else {
                queue.offer(null);
                sb.append("null,");
            }
            if (node.right != null) {
                queue.offer(node.right);
                sb.append(node.right.val + ",");
            } else {
                queue.offer(null);
                sb.append("null,");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }
}
