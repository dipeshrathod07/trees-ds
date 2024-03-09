public class convertBTtosumBT {
    
    static class Node 
    {
        int val;
        Node left,right;

        public Node(int val)
        {
            this.val = val;
            left=right=null;
        }
    }

    public static int sumtree(Node root)
    {
        if(root == null)return 0;

        int leftchild = sumtree(root.left);
        int rightchild = sumtree(root.right);

        int data = root.val;

        int newLeft = root.left == null?0:root.left.val;
        int newRight = root.right == null?0:root.right.val;
        root.val = newLeft + leftchild +newRight+rightchild;

        return data;

    }
    public static void preorder(Node root)
    {
        if(root == null)return;

        //root -->leftnode -->rightnode
        int d = root.val;
        System.out.println(d+" ");
        preorder(root.left);
        preorder(root.right);
        
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
       root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


     //   System.out.println(distancebetweenNodes(root, 4, 9));

     sumtree(root);
     preorder(root);

    }
   
}
