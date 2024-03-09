import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesB {
    
    static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree
    {
        static int idx = -1;

        public static Node buildTree(int nodes[])
        {
            idx++;
            if(nodes[idx] == -1||idx >= nodes.length)
            {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);


            return newNode;
        }
     //preorder Traversal//
        public static void preorder(Node root)
        {
            if(root == null)return;

            //root -->leftnode -->rightnode
            int d = root.data;
            System.out.println(d+" ");
            preorder(root.left);
            preorder(root.right);
            
        }
       //Inorder Traversal//
        public static void inorder(Node root)
        {
            if(root ==  null)return;
            //leftnode --> root --> rightnode
            inorder(root.left);
            System.out.print(root.data +" ");
            inorder(root.right);
                
        }
        //Postorder Travesrsal//
        public static void postorder(Node root)
        {
            if(root == null)return;

            //leftnode-->rightnode-->root
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        //level order traversal uses BFS and we traverse with iterative method using queue

        public static void levelOrder(Node root)
        {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty())
            {
                Node curNode = q.remove();

                if(curNode == null)
                {
                    System.out.println();
                    if(q.isEmpty())break;
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(curNode.data+" ");
                    if(curNode.left != null)
                    q.add(curNode.left);

                    if(curNode.right != null)
                    q.add(curNode.right);
                }
            }
        }
        

    }

    public static void main(String[] args) 
    {
        System.out.print("\033[2H\033[J");
        System.out.flush();

        
        int array[] = { 1, 2, 4, -1, -1,5, -1, -1, 3, -1, 6, -1,-1 };
        
        Node root = BinaryTree.buildTree(array);
        BinaryTree.preorder(root);
        //  BinaryTree.inorder(root);
        // BinaryTree.postorder(root);

        // BinaryTree.levelOrder(root);

        // System.out.println("The Height of the tree is:"+BinaryTree.height(root));
    
       
    }
}

