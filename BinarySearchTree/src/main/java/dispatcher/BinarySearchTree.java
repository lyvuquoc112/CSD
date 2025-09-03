/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package dispatcher;

/**
 *
 * @author hanly
 */
public class BinarySearchTree {

    Node root;
    int count = 0;
    
    public void add(int value){
        root = add(root, value);
        count++;
    }
    
    // 5 3 7 4
    // add 6
    
    // lượt 1           5           6
    // lượt 2           7           6
    // lượt 3           null        6
    
    private Node add(Node temp, int value){
        Node newNode = new Node(value);
        if(temp == null){
            return newNode;
            // newNode(6)
        }
        //      5 < 6
        //      7 > 6
        if(temp.value > newNode.value){
                            //  null    6
            temp.left = add(temp.left, value);      
        }else if(temp.value<newNode.value){
                            //  7           6
            temp.right = add(temp.right, value) ;
        }
        return temp;
    }
    
    // In-order : trái- cha- phải
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value+" ");
            inOrder(root.right);
        }
    }
    
    public boolean search(int value){
       return search(root, value);
    }
    
    private boolean search(Node root, int value) {
        if (root != null) {
            search(root.left,value);
            if(root.value == value ){
                return true;
            }
            search(root.right,value);
        }
        return false;
    }
    
    public int countLeaf(){
        return countLeaf(root);
    }
    
    private int countLeaf(Node root){
        if(root ==  null){
            return 0;
        }if(root.left == null && root.right == null){
            return 1;
        }
        return countLeaf(root.left) +
                countLeaf(root.right);
    }
    
    // Pre-order: cha- trái- phải
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node root) {
        if(root!=null){
            System.out.print(root.value +" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    // Post-order: trái- phải- cha 
    
    public void postOrder(){
        postOrder(root);
    }
    
    private void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }
    }
    
    // tìm node nhỏ nhất, node lớn nhất
    private int findMinNode(Node root) {
        int minValue = root.value;
        while(root.left !=null){
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }
    
   private int findMaxNode(Node root){
      int maxValue = root.value;
      while(root.right!=null){
          maxValue = root.right.value;
          root = root.right;
      }
      return maxValue;
   }
   
   // delete
   public Node delete(int value){
       return delete(root, value);
   }
   
    private Node delete(Node root, int value) {
        if(root == null) return null;
        if(value < root.value){
            root.left = delete(root.left, value);
        }else if(value > root.value){
            root.right = delete(root.right, value);
        }else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            root.value = findMinNode(root.right);
            root.right = delete(root.right, root.value);
        }
        return root;
//        if(root == null) return null;
//        if(value < root.value){
//            root.left = delete(root.left, value);
//        }else if(value > root.value){
//            root.right = delete(root.right, value);
//        }else{ // trường hợp tìm được value
//            // th1: nếu như node không có con hoặc chỉ có 1 con
//            // ở đây xóa được là bởi, mặc định lá không có con, nên trái null thì gán cho phải
//            // mà phải chắc chắn null, nên có nghĩa là xóa luôn
//            if(root.left == null) return root.right; 
//            else if(root.right == null ) return root.left;
//            // th2: có 2 con
//            // Cách 1: Node trái cùng (min) của cây con bên phải 
//            root.value = findMinNode(root.right);
//            root.right = delete(root.right, root.value);// tìm node nhỏ nhất của cây bên phải
//            // Cách 2: Node phải cùng (max) của cây con bên trái
////            root.value = findMaxNode(root.left);
////            root.left = delete(root.left, root.value);
//        }
//        return root;
   }
   

   
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(4);
        bst.add(6);
        
        bst.preOrder();
        System.out.println("");
        
        System.out.println(bst);
    }

    

    

    

    

    
}
