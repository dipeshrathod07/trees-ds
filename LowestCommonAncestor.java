import java.util.ArrayList;

public class LowestCommonAncestor {
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
    public static boolean getPath(Node root,int n, ArrayList<Node> path)
    {
        if(root == null)return false;
        path.add(root);

        if(root.val == n)return true;

        boolean foundleft = getPath(root.left, n, path);
        boolean foundright = getPath(root.right, n, path);
        if(foundleft||foundright)return true;

        path.remove(path.size()-1);

        return false;
    }

    public static int LCA(Node root,int n1,int n2)
    {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for(;i<path1.size()&& i<path2.size();i++)
        {
            if(path1.get(i) != path2.get(i))
            {break;}
        }
        int lca = path1.get(i-1).val;

        return lca;
       
    }
    
//Second approach for finding lowest common ancestor by using stack recursion memory//
    public static Node LCA2(Node root,int n1,int n2)
    {
        if(root == null || root.val == n1||root.val == n2)return root;

        Node leftLca = LCA2(root.left,n1,n2);
        Node rightLca = LCA2(root.right, n1, n2);

        if(rightLca == null)return leftLca;

        if(leftLca == null)return rightLca;

        

        return root;
    }

    public static void main(String[] args) {

  
        Node root = new Node(1);
        root.left = new Node(2);
       root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
      root.right.right = new Node(7);

    // Node root = new Node(266);
    // root.left = new Node(298);
    // root.right = new Node(27);
    // root.right.left = new Node(119);
    // root.right.right = new Node(221);


       System.out.println(LCA2(root, 5, 4).val);

      //  System.out.println(KAncestor(root,221,2));

      
}
    
}
