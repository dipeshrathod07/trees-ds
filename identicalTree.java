public class identicalTree 
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
    public static boolean isIdentical(Node node,Node subroot)
    {
        if(node == null && subroot == null)
        {
            return true;
        }
        else if(node == null || subroot == null || node.val != subroot.val)
        {
            return false;
        }
        
       return isIdentical(node.left, subroot.left) && isIdentical(node.right,subroot.right);
    }

    public static boolean isSubtree(Node root,Node subroot)
    {
        if(root == null)return false;

        if(root.val == subroot.val)
        {
            if(isIdentical(root, subroot))
            {
                return true;
            }
        }

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);

    }

    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
       root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(8);


        System.out.println(isSubtree(root,subroot));


     
     
    }
    
    
}
