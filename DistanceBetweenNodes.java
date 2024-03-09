public class DistanceBetweenNodes 
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

    public static Node LCA(Node root,int n1,int n2)
    {
        if(root == null || root.val == n1 || root.val == n2)
        return root;

        Node leftlca = LCA(root.left, n1, n2);
        Node rightlca = LCA(root.right, n1, n2);

        if(rightlca == null)return leftlca;
        
        if(leftlca == null)return rightlca;

        return root;
    }
//helper fuction which helps to find the dist at a side//
    public static int helper(Node node ,int n)
    {
        if(node == null)return -1;

        if(node.val == n)return 0;

        int ldist = helper(node.left, n);
        int rdist = helper(node.right, n);

        if(ldist == -1 && rdist == -1)return -1;

        else if(rdist == -1)return ldist+1;
        else
        {
            return rdist+1;
        }
    }
//to find the distance between the nodes we have to take lowest common ancestor and pass into helper function//
    public static int distancebetweenNodes(Node root,int a,int b)
    {
        Node lca = LCA(root,a,b);
        int dist1 = helper(lca, a);
        int dist2 = helper(lca,b);

        int ans = dist1+dist2;

        return ans;
    }

    //
   
    

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
       root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


      System.out.println(distancebetweenNodes(root, 4, 9));

    }
    
}
