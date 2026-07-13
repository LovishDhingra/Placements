public class binTree {
  
    
public static void main(String[] args){
  Node first =new Node(4);
   first.left=new Node(7);
   first.right=new Node(27);
   Node second=new Node(5);

   System.out.println(second.value);

  System.out.println(first.left.value);
  
  System.out.println(first.right.value);


    
}
}
 class Node{
  
    int value;
    Node right;
    Node left;

   public  Node(int data){
     value=data;
     left=null;
     right=null;
     
    }
}
