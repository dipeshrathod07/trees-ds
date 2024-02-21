public class BinaryTreesB {
    static class Node 
    {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree 
    {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if(idx >= nodes.length || nodes[idx] == -1) 
            {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);


            return newNode;
        }
    }

    public static void main(String[] args) 
    {
        System.out.print("\033[2H\033[J");
        System.out.flush();

        int array[] = { 1, 2, 4, -1, 5, -1, -1, 3, -1, 6, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(array);
        System.out.println(root.left.left.data);
        System.out.println(root.left.right.data);
       
    }
}

