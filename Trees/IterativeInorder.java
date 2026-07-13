import java.util.*;

//  left root right 
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class IterativeInorder {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;

            } else {
                if (st.empty()) {
                    break;

                }
                node = st.pop();
                ans.add(node.val);
                node = node.right;

            }

        }
        return ans;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(6);

        root.right.right = new TreeNode(7);
        List<Integer> sol = new ArrayList<Integer>();
        sol = inorderTraversal(root);
        System.out.println(sol);

    }
}