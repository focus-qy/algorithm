package tree;

import java.util.ArrayList;

public class KthNode {


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void process(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;
        process(node.left, result);
        result.add(node.val);
        process(node.right, result);
    }

    public int KthNode(TreeNode proot, int k) {
        if (proot == null || k < 1) {
            return -1;
        }
        ArrayList<Integer> result = new ArrayList<>();
        process(proot, result);
        if (result.size() < k) {
            return -1;
        }
        return result.get(k - 1);
    }

    public static void main(String[] args) {

    }
}
