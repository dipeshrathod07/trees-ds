public class KthAncestorOfTree 
{
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

   
    public static int KAncestor(Node root,int n , int k)
    {
        if(root == null)return -1;

        if(root.val == n)return 0;

       int kl= KAncestor(root.left, n, k);
       int kr = KAncestor(root.right, n, k);

        if(kl == -1 && kr ==-1)return -1;

        int max = Math.max(kl,kr);
      

        if(max+1 == k){
            System.out.println(root.val);
        }

        return max+1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
       root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

    }

}
