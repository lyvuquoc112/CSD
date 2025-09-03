
//// insert dùng đẹ quy
//void insert(String xOwner, int xColor, int xSize) {
//        //You should insert here statements to complete this function
//        cif(xOwner.charAt(0) == 'B'){                            011
//            return;
//        }
//        Brick newBrick = new Brick(xOwner, xColor, xSize);      011
//        root = insert(root, newBrick);                          011
//        
//    }
//    
//    Node insert(Node root, Brick data){
//        if(root == null){
//            root = new Node (data);
//            return root;
//        }
//        if(data.color < root.info.color){                       011
//            root.left = insert(root.left, data);
//        }else if(data.color > root.info.color){                 011
//            root.right = insert(root.right, data);
//        }
//        return root;
//    }

//
//Xóa theo byCoping
//Node deleteByCoping(Node p, Node target) {
//        if (p == null) {
//            return null;
//        }
//        if (p == target) {
//            if (p.left == null) {
//                return p.right;
//            }
//            if (p.right == null) {
//                return p.left;
//            }
//            Node q = p.left;
//            while (q.right != null) {
//                q = q.right;
//            }
//            p.info = target.info;
//            p.left = deleteByCoping(p.left, q);
//            return p;
//        }
//        p.left = deleteByCoping(p.left, target);
//        p.right = deleteByCoping(p.right, target);
//        return  p;
//    }


// xóa by copyiyng theo dạng breath first, xóa cái đầu tiên
//if(root  == null){
//            return;
//        }
//        Queue q = new Queue();
//        q.enqueue(root);
//        Node r;
//        Node needDelete = null;
//        while (!q.isEmpty()) {
//            r = q.dequeue();
//            if(r.info.color < 6){
//                needDelete = r;
//                break;
//            }
//            if (r.left != null) {
//                q.enqueue(r.left);
//            }
//            if (r.right != null) {
//                q.enqueue(r.right);
//            }
//        }
//        if(needDelete!=null){
//            root  = deleteByCoping(root, needDelete);
//        }

// hàm insert mà nếu trùng thì sửa luôn thông tin
//void insert(String id, String name, double gpa, String major, double balance) {
//            // Implement this function - Insert a new student to the BST
//            // If the ID already exists, update the student's information
//            // --------------------------------------------------------
//            // YOUR CODE HERE
//            if(gpa <= 0){                            
//                return;
//            }
//            Student newStudent = new Student(id, name, gpa, major, balance);
//            root = insert(root, newStudent);     
//        }
//
//        TreeNode insert(TreeNode root, Student data){
//            if(root == null){
//                root = new TreeNode(data);
//                return root;
//            }
//            int comp = data.getId().compareToIgnoreCase(root.info.getId());
//            if(comp == 0){
//                root.info = data;
//            }
//            else if(comp < 0){                       
//                root.left = insert(root.left, data);
//            }else{                 
//                root.right = insert(root.right, data);
//            }
//            return root;
//            // --------------------------------------------------------
//        }

// tìm key nhỏ nhất
//private int leftMost(Node root) {
//        int minValue = root.value;
//        while(root.left !=null){
//            minValue = root.left.value;
//            root = root.left;
//        }
//        return minValue;
//    }
    
// tìm key lớn nhất
//   private int rightMost(Node root){
//      int maxValue = root.value;
//      while(root.right!=null){
//          maxValue = root.right.value;
//          root = root.right;
//      }
//      return maxValue;
//   }

// tìm giá trị lớn nhất mà không phải là key 
//Student findHighestGPA() {
//            // Implement this function - Find student with highest GPA
//            // --------------------------------------------------------
//            // YOUR CODE HERE
//            // --------------------------------------------------------
//            return findHighestGPA(root); // Change this return statement as needed
//        }
//        private Student findHighestGPA(TreeNode root){
//            if(root == null) return null;   
//            Student leftMax = findHighestGPA(root.left);
//            Student rightMax = findHighestGPA(root.right);
//            Student max = root.info;
//            if(leftMax != null && leftMax.getGpa() > max.getGpa()){
//                max = leftMax;
//            }if(rightMax != null && rightMax.getGpa() > max.getGpa()){
//                max = rightMax;
//            }
//            return max;
//            
//        }

// tìm giá trị nhỏ nhất nhưng không phải là key
//Student findLowestGPA() {
//            // Implement this function - Find student with highest GPA
//            // --------------------------------------------------------
//            // YOUR CODE HERE
//            // --------------------------------------------------------
//            return findLowestGPA(root); // Change this return statement as needed
//        }
//        private Student findLowestGPA(TreeNode root){
//            if(root == null) return null;   
//            Student leftMin = findLowestGPA(root.left);
//            Student rightMin = findLowestGPA(root.right);
//            Student min = root.info;
//            if(leftMax != null && leftMax.getGpa() < max.getGpa()){
//                min = leftMin;
//            }if(rightMax != null && rightMax.getGpa() < max.getGpa()){
//                min = rightMin;
//            }
//            return min;
//            
//        }

// đếm số lượng của cái gì đó thỏa yêu cầu
// int countByGPA(double threshold) {
//            // Implement this function - Count students with GPA >= threshold
//            // --------------------------------------------------------
//            // YOUR CODE HERE
//            // --------------------------------------------------------
//            return countByGPA(root, threshold); // Change this return statement as needed
//        }
//        private int countByGPA(TreeNode root, double data){
//            if(root == null) return 0;
//            int count = 0;
//            if(root.info.getGpa() >= data){
//                count++;
//            }
//            return count + countByGPA(root.left, data) + countByGPA(root.right, data);
//        }


// update tại index thứ mấy bằng số node trong cây con
//void updateTypeByPreOrderIndex(int index) {
//    List<Node> preList = new ArrayList<>();
//    collectPreOrder(root, preList);
//
//    if (index >= 0 && index < preList.size()) {
//        Node p = preList.get(index);
//        int count = countSubtreeNodes(p);
//        p.info.type = count;
//    }
//}

//Duyệt pre-order và thu thập node vào list
//void collectPreOrder(Node p, List<Node> list) {
//    if (p == null) return;
//    list.add(p);
//    collectPreOrder(p.left, list);
//    collectPreOrder(p.right, list);
//}

//Đếm số node trong một cây con:
//int countSubtreeNodes(Node p) {
//    if (p == null) return 0;
//    return 1 + countSubtreeNodes(p.left) + countSubtreeNodes(p.right);
//}


// duyệt theo tăng dần hoặc giảm dần
//void traverseByWeight(Node p, RandomAccessFile f, boolean ascending) throws Exception {
//    if (p == null) return;
//
//    if (ascending) {
//        traverseByWeight(p.left, f, true);
//        fvisit(p, f);
//        traverseByWeight(p.right, f, true);   
//    } else {
//        traverseByWeight(p.right, f, false);
//        fvisit(p, f);
//        traverseByWeight(p.left, f, false);
//    }
//}

//void collectByType(Node p, boolean ascending, ArrayList<Node> list) {
//    if (p == null) return;
//
//    if (ascending) {
//        collectByType(p.left, true, list);
//        list.add(p);
//        collectByType(p.right, true, list);
//    } else {
//        collectByType(p.right, false, list);
//        list.add(p);
//        collectByType(p.left, false, list);
//    }
//}

// in ra node leaves kèm điều kiện, theo kiểu preorder
//void printLeafColorLessThan7(Node p, RandomAccessFile f) throws Exception {
//    if (p == null) return;
//
//    if (p.left == null && p.right == null && p.info.color < 7) {
//        fvisit(p, f);
//    }
//
//    printLeafColorLessThan7(p.left, f);
//    printLeafColorLessThan7(p.right, f);
//}

// in ra  node  không phải là leaf
//void printInternalNode(Node p, RandomAccessFile f) throws Exception {
//    if (p == null) return;
//
//    if (!(p.left == null && p.right == null)) {
//        fvisit(p, f);
//    }
//
//    printInternalNode(p.left, f);
//    printInternalNode(p.right, f);
//}

// đếm lá
//public int countLeaf(){
//        return countLeaf(root);
//    }
//    
//    private int countLeaf(Node root){
//        if(root ==  null){
//            return 0;
//        }if(root.left == null && root.right == null){
//            return 1;
//        }
//        return countLeaf(root.left) +
//                countLeaf(root.right);
//    }

// đếm internnal node
//public int countInterNode(){
//        return countInterNode(root);
//    }
//    
//    private int countInterNode(Node root){
//        if(root ==  null){
//            return 0;
//        }if(root.left == null && root.right == null){
//            return 0;
//        }
//        return 1 + countInterNode(root.left) +
//                countInterNode(root.right);
//    }

// lưu các nút theo thứ tăng dần
//void collectInOrder(Node p, ArrayList<Node> list) {
//    if (p == null) return;
//    collectInOrder(p.left, list);
//    list.add(p);
//    collectInOrder(p.right, list);
//}


// Xóa một cái theo vị trí lớn hoặc nhỏ dần.
// ArrayList<Node> result = new ArrayList<>();
//        collectByType(root, true, result);
//        
//        if(result.size() >= 4){
//            Node target = result.get(3);
//            deleteByCoping(root, target);
//        }
//        //------------------------------------------------------------------------------------
//        breadth(root, f);
//        f.writeBytes("\r\n");
//        f.close();
//    }
//    
//    void collectByType(Node p, boolean ascending, ArrayList<Node> list) {
//    if (p == null) return;
//
//    if (ascending) {
//        collectByType(p.left, true, list);
//        list.add(p);
//        collectByType(p.right, true, list);
//    } else {
//        collectByType(p.right, false, list);
//        list.add(p);
//        collectByType(p.left, false, list);
//    }
//}
//    
//    
//    Node deleteByCoping(Node p, Node target) {
//        if (p == null) {
//            return null;
//        }
//        if (p == target) {
//            if (p.left == null) {
//                return p.right;
//            }
//            if (p.right == null) {
//                return p.left;
//            }
//            Node q = p.left;
//            while (q.right != null) {
//                q = q.right;
//            }
//            p.info = target.info;
//            p.left = deleteByCoping(p.left, q);
//            return p;
//        }
//        p.left = deleteByCoping(p.left, target);
//        p.right = deleteByCoping(p.right, target);
//        return  p;
//    }

    // tim node thu may ben nhanh phai
// nay la phan trong main
// ArrayList<Node> list = new ArrayList<>();
//        findNodesWithRightChildPreOrder(root, list, 3);
//
//        if (list.size() >= 3) {
//            Node target = list.get(2); // node thứ 3 có left child
//            root = rotateLeftAt(root, target); // Xoay phải thay vì trái
//        }

// duyệt theo preorder
//void findNodesWithRightChildPreOrder(Node p, ArrayList<Node> list, int limit) {
//    if (p == null || list.size() >= limit) return;
//
//    if (p.right != null) {  doi thanh trai neu de keu
//        list.add(p);
//    }
//
//    findNodesWithRightChildPreOrder(p.left, list, limit);
//    findNodesWithRightChildPreOrder(p.right, list, limit);
//}
    // quay trai 
//Node rotateLeftAt(Node root, Node p) {
//    if (p == null || p.right == null) return root;    left
//
//    Node parent = null;
//    Node current = root;
//
//    // tìm parent của p
//    while (current != null && current != p) {
//        parent = current;
//        if (p.info.type < current.info.type) {
//            current = current.left;
//        } else {
//            current = current.right;
//        }
//    }
//
//    Node r = p.right;                 left
//    p.right = r.left;                 left = right
//    r.left = p;                       rrigt
//
//    if (parent == null) return r; // p là root
//
//    if (parent.left == p) parent.left = r;
//    else parent.right = r;
//
//    return root;
//}

// Tim va xoa nut lon nhat trong cay
//void f3() throws Exception {
//        clear();
//        loadData(9);
//        String fname = "f3.txt";
//        File g123 = new File(fname);
//        if (g123.exists()) {
//            g123.delete();
//        }
//        RandomAccessFile f = new RandomAccessFile(fname, "rw");
//        breadth(root, f);
//        f.writeBytes("\r\n");
//        //------------------------------------------------------------------------------------
//        /*You must keep statements pre-given in this function.
//      Your task is to insert statements here, just after this comment,
//      to complete the question in the exam paper.*/
//        Node maxNode = findHighestPrice();
//        if (maxNode != null) {
//            root = delete(maxNode.info.price);
//        }
//
//
//        //------------------------------------------------------------------------------------
//        breadth(root, f);
//        f.writeBytes("\r\n");
//        f.close();
//    }
//
//     Node findHighestPrice() {
//        return findHighestPrice(root);
//    }
//
//    private Node findHighestPrice(Node root) {
//        if (root == null) {
//            return null;
//        }
//        Node leftMax = findHighestPrice(root.left);
//        Node rightMax = findHighestPrice(root.right);
//        Node max = root;
//        if (leftMax != null && leftMax.info.price > max.info.price) {
//            max = leftMax;
//        }
//        if (rightMax != null && rightMax.info.price > max.info.price) {
//            max = rightMax;
//        }
//        return max;
//    }
//  private int findMinNode(Node root) {
//        int minValue = root.info.price;
//        while(root.left !=null){
//            minValue = root.left.info.price;
//            root = root.left;
//        }
//        return minValue;
//    }
//    
//  public Node delete(int value){
//       return delete(root, value);
//   }
//   
//    private Node delete(Node root, int value) {
//        if(root == null) return null;
//        if(value < root.info.price){
//            root.left = delete(root.left, value);
//        }else if(value > root.info.price){
//            root.right = delete(root.right, value);
//        }else{
//            if(root.left == null) return root.right;
//            else if(root.right == null) return root.left;
//
//            root.info.price = findMinNode(root.right);
//            root.right = delete(root.right, root.info.price);
//        }
//        return root;
//    }



// hàm tiềm parent
//Node findParent(Node root, Node child) {
//    if (root == null || root == child) return null;
//    if (root.left == child || root.right == child) return root;
//
//    if (child.info.color < root.info.color) {
//        return findParent(root.left, child);
//    } else {
//        return findParent(root.right, child);
//    }
//}

// duyệt theo BST tìm node thứ 2 có con trái 
//Node findSecondNodeWithLeftSonBFS(Node root) {
//    if (root == null) return null;
//    Queue q = new Queue();
//    q.enqueue(root);
//    int count = 0;
//
//    while (!q.isEmpty()) {
//        Node current = q.dequeue();
//        if (current.left != null) {
//            count++;
//            if (count == 2) return current;         
//        }
//        if (current.left != null) q.enqueue(current.left);
//        if (current.right != null) q.enqueue(current.right);
//    }
//    return null;
//}

// duyệt theo BST tìm node thứ 2 có con phải 
//Node findSecondNodeWithRightSonBFS(Node root) {
//    if (root == null) return null;
//    Queue q = new Queue();
//    q.enqueue(root);
//    int count = 0;
//
//    while (!q.isEmpty()) {
//        Node current = q.dequeue();
//        if (current.right != null) {
//            count++;
//            if (count == 2) return current;
//        }
//        if (current.left != null) q.enqueue(current.left);
//        if (current.right != null) q.enqueue(current.right);
//    }
//    return null;
//}


// Duyệt theo postOrder rồi xóa, vị trí mong muốn
//void f3() throws Exception {
//    clear();
//    loadData(9);
//    String fname = "f3.txt";
//    File g123 = new File(fname);
//    if (g123.exists()) g123.delete();
//    RandomAccessFile f = new RandomAccessFile(fname, "rw");
//
//    // Ghi post-order ban đầu
//    postOrder(root, f);
//    f.writeBytes("\r\n");
//
//    // 1. Lưu toàn bộ node theo post-order
//    ArrayList<Node> postList = new ArrayList<>();
//    collectPostOrder(root, postList);
//
//    // 2. Tìm node thứ 6 (index 5)
//    if (postList.size() >= 6) {
//        Node target = postList.get(5);
//        root = deleteByCopying(root, target);
//    }
//
//    // 3. Ghi lại cây sau khi xóa
//    postOrder(root, f);
//    f.writeBytes("\r\n");
//    f.close();
//}

//void collectPostOrder(Node p, ArrayList<Node> list) {
//    if (p == null) return;
//    collectPostOrder(p.left, list);
//    collectPostOrder(p.right, list);
//    list.add(p);
//}

//void collectPreOrder(Node p, ArrayList<Node> list) {
//    if (p == null) return;
//    list.add(p);
//    collectPreOrder(p.left, list);
//    collectPreOrder(p.right, list);
//}

//void collectInOrder(Node p, ArrayList<Node> list) {
//    if (p == null) return;
//    collectInOrder(p.left, list);
//    list.add(p);
//    collectInOrder(p.right, list);
//}

//void collectBreadthOfWide(Node root, ArrayList<Node> list) {
//    if (root == null) return;
//    Queue q = new Queue();
//    q.enqueue(root);
//
//    while (!q.isEmpty()) {
//        Node current = q.dequeue();
//        list.add(current);
//        if (current.left != null) q.enqueue(current.left);
//        if (current.right != null) q.enqueue(current.right);
//    }
//}

//Node deleteByCopying(Node p, Node target) {
//    if (p == null) return null;
//
//    if (p.info.color == target.info.color) { // so sánh theo thuộc tính phân biệt duy nhất
//        if (p.left == null) return p.right;
//        if (p.right == null) return p.left;
//
//        // Có 2 con → tìm node lớn nhất bên trái
//        Node maxLeft = p.left;
//        Node parentOfMaxLeft = p;
//
//        while (maxLeft.right != null) {
//            parentOfMaxLeft = maxLeft;
//            maxLeft = maxLeft.right;
//        }
//
//        p.info = maxLeft.info;
//
//        // Xóa node maxLeft khỏi cây
//        if (parentOfMaxLeft == p) {
//            p.left = maxLeft.left;
//        } else {
//            parentOfMaxLeft.right = deleteByCopying(parentOfMaxLeft.right, maxLeft);
//        }
//
//        return p;
//    }
//
//    if (target.info.color < p.info.color) {
//        p.left = deleteByCopying(p.left, target);
//    } else {
//        p.right = deleteByCopying(p.right, target);
//    }
//
//    return p;
//}

// Đếm node 
//int countNodes(Node p) {
//    if (p == null) return 0;
//    return 1 + countNodes(p.left) + countNodes(p.right);
//}


// tìm node n có con phải duyệt theo preorder, đếm số node trong cây con tìm
//void f4() throws Exception {
//        clear();
//        loadData(13);;
//        String fname = "f4.txt";
//        File g123 = new File(fname);
//        if (g123.exists()) {
//            g123.delete();
//        }
//        RandomAccessFile f = new RandomAccessFile(fname, "rw");
//        preOrder(root, f);
//        f.writeBytes("\r\n");
//        //------------------------------------------------------------------------------------
//        /*You must keep statements pre-given in this function.
//      Your task is to insert statements here, just after this comment,
//      to complete the question in the exam paper.*/
//        ArrayList<Node> postList = new ArrayList<>();
//        collectPreOrder(root, postList);
//        // tìm node thứ mấy bên cây phải
//        int count  = 0;
//        Node temp = null;
//        for (Node node : postList) {
//            if(node.right!=null){
//                count++;
//                if(count == 3){
//                    temp = node;
//                    break;
//                }
//            }
//        }
//        if(temp!=null){
//            int count1  = countNodes(temp);
//            temp.info.volume = 100+ count1;
//        }
//        //------------------------------------------------------------------------------------
//        preOrder(root, f);
//        f.writeBytes("\r\n");
//        f.close();
//    }
//    void collectPreOrder(Node p, ArrayList<Node> list) {
//        if (p == null) {
//            return;
//        }
//        list.add(p);
//        collectPreOrder(p.left, list);
//        collectPreOrder(p.right, list);
//
//    }
//
//    int countNodes(Node p) {
//        if (p == null) {
//            return 0;
//        }
//        return 1 + countNodes(p.left) + countNodes(p.right);
//    }
