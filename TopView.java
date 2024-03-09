import java.util.*;



public class TopView
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

    //This is information class which contains key=hd , value=node which store in HashMap
    
    static class Info{
        int hd;
        Node node;

        public Info(int hd,Node node)
        {
            this.hd = hd;
            this.node = node;
        }
    }

//TopViewOfTree  method is use to get Node.data from viewing by top side of the tree//
    public static ArrayList<Integer> TopViewOfTree(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        q.add(new Info(0, root));
        q.add(null);    
        
        int max = 0;int min = 0;
        
        while(!q.isEmpty())
        {
            Info temp = q.remove();

            if(temp == null)
            {
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    q.add(null);
                }
            }
            else
            {
                if(!map.containsKey(temp.hd))
                {
                    map.put(temp.hd,temp.node);
                }

                if(temp.node.left != null)
                {
                   q.add(new Info(temp.hd-1, temp.node.left));
                   min = Math.min(min,temp.hd-1);
                }
                if(temp.node.right != null)
                {
                    q.add(new Info(temp.hd+1, temp.node.right));
                    max = Math.max(max,temp.hd+1);
                }
            }
        }

        for(int i = min; i < max; i++)
        {
            list.add(map.get(i).val);
        }

        return list;


    }
        
//This method is use to find the nodes on kth level

       public static void klevel(Node root,int level,int k)
       {
        if(root == null)return;

        if(level == k)
        {
            System.out.print(root.val+" ");
            return;
        }

        klevel(root.left, level+1, k);
        klevel(root.right, level+1, k);


       }     
    public static void main(String[] args) {

  
            Node root = new Node(1);
            root.left = new Node(2);
           root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right = new Node(3);
            root.right.left = new Node(6);
            root.right.right = new Node(7);

            int k = 2;

            klevel(root, 1, k);
            System.out.println(TopViewOfTree(root));

    
    }
    
}
