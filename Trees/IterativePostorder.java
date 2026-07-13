import java.util.*;

// root left right 
 class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
     }
public class IterativePostorder{
public static List<Integer> preorderTraversal(TreeNode root){
    List<Integer> ans=new ArrayList<Integer>();
    if(root==null) return ans;
    Stack<TreeNode> st=new Stack<TreeNode>();
    st.push(root);
    while(!st.empty()){
           root=st.pop();
          
           if(root.right!=null){
               st.push(root.right);
           }
           if(root.left!=null){
            st.push(root.left);
        }
        ans.add(root.val);
    }
    return ans;

}
    public static void main(String[] args) {
        
      TreeNode root=new TreeNode(1);
      root.left=new TreeNode(2);
      root.right=new TreeNode(3);
      root.left.right=new TreeNode(4);
      root.left.left=new TreeNode(5); 
      root.right.left=new TreeNode(6);

       root.right.right=new TreeNode(7);
       List<Integer> sol=new ArrayList<Integer>();
       sol=preorderTraversal(root);
       System.out.println(sol);



    }
}