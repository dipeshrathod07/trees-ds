public class BinaryTreeQue 
{
    static class Node{
        int val;
        Node left,right;

        public Node(int val)
        {
            this.val=val;
            left=null;
            right = null;
        }

        //This function is to find the height of tree.
        public static int height(Node root)
        {
            if(root == null)
            return 0;

            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh, rh)+1;
        }

        //Here we count Number of Nodes.
        public static int countNodes(Node root)
        {
            if(root == null)return 0;

            int l = countNodes(root.left);
            int r = countNodes(root.right);

            return l+r+1;
        }

       //This function is to find the sum of all Node//
        public static int sum(Node root)
        {
            if(root == null)return 0;

            int l = sum(root.left);
            int r = sum(root.right);

            return l+r+root.val;
        }

        // write a method that returns the count of the number of subtress having total node’s data sum equal to the value N.
        // static int c;
        //  public static int sum(Node root,int N)
        //  {
        //     if(root == null)return 0;

        //     int l = sum(root.left,N);
        //     int r = sum(root.right,N);
        //     int s = l+r+root.val;

        //     if(s == N)c++;

        //     return s;
            
        //  }

        //  public static int subTreesSum(Node root,int N)
        //  {
        //     c = 0;
        //     sum(root,N);
        //     return c;
        //  }
       
      

        public static void main(String[] args) {
            Node root = new Node(1);
             root.left = new Node(2);
            root.left.left = new Node(4);
             root.left.right = new Node(5);
             root.right = new Node(3);
             root.right.left = new Node(6);
             root.right.right = new Node(7);

           // System.out.println(sum(root));

           // System.out.println(subTreesSum(root, 5));

   

           


        }
    }
    
}
