

public class diameterofTree
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
    public static int height(Node root)
    {
        if(root == null)return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh)+1;
    }

    static class Info
    {
        int dia , ht;

        public Info(int dia,int ht)
        {
            this.dia = dia;
            this.ht = ht;
        }
    }
    public static Info diameter(Node root)
    {
        if(root == null)return new Info(0, 0);

        Info lInfo = diameter(root.left);
        Info rInfo = diameter(root.right);

        int diam = Math.max(Math.max(lInfo.dia, rInfo.dia), lInfo.ht+rInfo.ht);
        int ht = Math.max(lInfo.ht , rInfo.ht)+1;

        return new Info(diam, ht);
        
    }
//another way to find diameter// O(N)
static int m = 0;
    public static int diameter2(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int ldiam = diameter2(root.left);
        int rdiam = diameter2(root.right);
        
        m = Math.max(m, ldiam+rdiam+1);

       
        
        return Math.max( ldiam,rdiam)+1;
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

        System.out.println("The diameter is:"+diameter(root).dia);
     
    }
    
}
