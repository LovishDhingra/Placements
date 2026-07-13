import java.util.ArrayDeque;
import java.util.Queue;


class Node{
     
    int data;
    Node left;
    Node right;
    Node(int val){
        data=val;
    }
    Node(int val,Node left,Node right){
        this.data=val;
        this.left=left;
        this.right=right;

    }
}

public class LevelOrder {

    public static void lvlOrder(Node node){
        Queue<Node> q=new ArrayDeque<>();
        q.add(node);
        while(!q.isEmpty()){
            int count=q.size();
            for(int i=0;i<count;i++){
                node=q.remove();
                System.out.print(node.data+ " " );
                if(node.left!=null){ 
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Node root=new Node(4);
       root.left=new Node(52);
       root.right=new Node(54);
       root.left.left=new Node(52);
       root.left.right=new Node(22);
       root.right.left=new Node(542);
       root.right.right=new Node(52);

  lvlOrder(root);
 
 


}

    }
   
