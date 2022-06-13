package tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class PrintTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot != null){
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(pRoot);
            boolean flag = true;
            while (!queue.isEmpty()){
                int size = queue.size();
                flag = !flag;
                ArrayList<Integer> element = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    element.add(node.val);
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }
                }
                if (flag) {
                    Collections.reverse(element);
                }
                result.add(element);
            }
        }
        return result;

    }


    public static void main(String[] args) {

    }
}
