 ||__TRAVERSAL__//get array list by breadth-first traversal
 ||     ||______//get array list by preorder
 ||     ||______//get array list by postorder
 ||     ||______//get array list by inorder
 ||
 ||___INSERT____//insert by string
 ||       ||____//insert by integer/double
 ||       ||____//insert have age > 4 use BTF
 ||
 ||___COUNT_____//count node in tree
 ||       ||____//count node have 1 child
 ||       ||____//count node have exactly 2 child
 ||       ||____//count height of tree
 ||
 ||___DELETE___
 ||     ||______//delete by copy node p
 ||     ||______//Delete by merging node p
 ||
 ||___BALANCE___//balance tree
 ||     ||______//balance simple array list
 ||
 ||___ROTATE____//rotate left node
 ||    ||_______//rotate right node
 ||
 ||___GET_______//get node by string
 ||       ||____//get node by integer/double
 ||       ||____//get node father
 ||       ||____//get node right-most node
 ||       ||____//get node left-most node
 ||
 ||___CHECK_____//Check node have 2 sons or not
 ||       ||____//Check node have just be 1 sons ( left of right)
 ||       ||____//Check node have at least 1 sons ( left of right)
 ||       ||____//Check node have left son or not
 ||       ||____//Check node have right son or not
 ||	
 ||___OTHER_____//calculate level of node
 ||      ||_____//calculate factor
 ||      ||_____//copy all node to tree by inorder traversal
 ||      ||_____//Calculate balance factor 
 ||      ||_____//Calculate level all node
 ||      ||_____//balance a binary search tree
 
//get array list by breadth-first traversal
    void breadth2(Node p, ArrayList<Node> f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            f.add(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
	
//get array list by preorder
    public void preorder2(Node p, ArrayList<Node> f) throws Exception{
        if(p == null){
            return;
        }
        f.add(p);
        preorder2(p.left,f);
        preorder2(p.right,f);
    }
	
//get array list by postorder
	public void postorder2(Node p, ArrayList<Node> f) throws Exception{
        if(p == null){
            return;
        }
        postorder2(p.left,f);
        postorder2(p.right,f);
        f.add(p);
    }
	
//get array list by inorder
    void inOrder2(Node p, ArrayList<Node> f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
            f.add(p);
        inOrder2(p.right, f);
    }
	 
//insert by string
    public void insert(Person x){
        Node p = new Node(x);
        if(isEmpty()){root = p; return;}
        Node f = null;
        Node q = root;
        while(q != null){
            if(q.info.name.equals(x.name)){
                return;
            }
            else if(q.info.name.compareToIgnoreCase(x.name) > 0){f = q; q = q.left;}
            else{f = q; q = q.right;}
        }
        if(f.info.name.compareToIgnoreCase(x.name) > 0) f.left = p;
        else f.right = p;
    }
    
//insert by integer/double
    public void insert(Car x){
	 Node q=new Node(x);
     if(isEmpty())
      {root=q;
        return;
       }
     Node f,p;
     f=null;p=root;
     while(p!=null)
       {if(p.info.price == x.price)
          {
            return;
          }
         f=p;
         if(x.price < p.info.price) p=p.left; else p=p.right;
       } 
      if(x.price< f.info.price) f.left=q; else f.right=q;
    } 
 
//insert have age > 4 use BTF
    public void breadthModifier(){
	if(root == null){ return; //change
            MyQueue m = new MyQueue();
            m.enqueue(root);
            while(!m.isEmpty()){
                Node q = (Node)m.dequeue();         
                if(q.left != null){
                    m.enqueue(q.left);
                }
                if(q.right != null){
                    m.enqueue(q.right);
                }
                if(q.info.age > 4){
                    h.insert(q.info);
                }
            }
		}
	}
 	 
 
//count node in tree
    public int count(Node p){
	 if(p==null) return(0);
	   int k,h,r;
	   k = count(p.left);
	   h = count(p.right);
	   r = k+h+1;
	   return(r);
	 }
	
//count node have 1 child
   int countModifer(Node p) {
      int n = 0;
      MyQueue m = new MyQueue();
        m.enqueue(p);
        while(!m.isEmpty()) {
            Node q = (Node)m.dequeue();
            if(q.left != null) m.enqueue(q.left);
            if(q.right != null) m.enqueue(q.right);
            // If q has only one child, increment c by 1
            if(q.left == null && q.right != null) n++;
            if(q.right == null && q.left != null) n++;
        }
      return n;
  }
 
//count node have exactly 2 child
    int countNodeCo2con(Node p) {
      int n = 0;
      MyQueue m = new MyQueue();
        m.enqueue(p);
        while(!m.isEmpty()) {
            Node q = (Node)m.dequeue();
            if(q.left != null) m.enqueue(q.left);
            if(q.right != null) m.enqueue(q.right);
            if(q.left != null && q.right != null) n ++;
        }
      return n;
     }
  
//count height of tree
    public int height(Node p) {
        if (p == null) {
            return 0;
        }
        int l = height(p.left) + 1;
        int r = height(p.right) + 1;
        return (l > r) ? l : r;
    }
 

 
//delete by copy node p
    public void deleteByCopy(Node p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            return;
        }
        // Find Node f where f is father of p
        Node f = null;
        Node q = root;
        while (q != null) {
            if(q.info.equals(p.info)) break;
            f=q;
            if (q.info.owner.compareTo(p.info.owner) > 0) {         // Changed
                q = q.left;
            } else {
                q = q.right;
            }
        }
        // 1. p is a leaf (no right and left child)
        if (p.left == null && p.right == null) {
            // a BST has a Node only
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else if (f.right == p) {
                f.right = null;
            }
        } // 2. p has a left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {// remove root
                root = p.left;
            } else if (f.right == p) {
                f.right = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            }
        } // 3. p has a right child only
        else if (p.right != null && p.left == null) {
            if (f == null) {// remove root
                root = p.right;
            } else if (f.right == p) {
                f.right = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            }
        } // 4. Both of right and left child 
        else if (p.left != null && p.right != null) {
            f = null;
            Node rp = p.left;
            while (rp.right != null) {
                f = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (f == null) {// rp has no right child 
                p.left = rp.left;
            } else {
                f.right = rp.left;
            }
        }
    }
//xxxxxxxxxxxxxxxxxx

//Delete by merging node p
public void deleteByMerging(Node p) {
    if (isEmpty() || p == null) {
        return;
    }

    Node f = null; // Node cha của p
    Node q = root; // Node dùng để duyệt cây
    while (q != null && !q.info.equals(p.info)) {
        f = q;
        if (q.info.compareTo(p.info) > 0) {
            q = q.left;
        } else {
            q = q.right;
        }
    }

    if (q == null) { // Không tìm thấy p trong cây
        return;
    }

    // Nếu p có ít nhất một nút con là null
    if (p.left == null || p.right == null) {
        Node next = (p.left != null) ? p.left : p.right;

        if (f == null) {
            root = next; // p là root
        } else if (f.left == p) {
            f.left = next;
        } else {
            f.right = next;
        }
    } else { // p có cả hai nút con
        Node tmp = p.left; // Bắt đầu từ cây con trái của p
        while (tmp.right != null) { // Tìm nút phải cực trái
            tmp = tmp.right;
        }

        tmp.right = p.right; // Hợp nhất cây con phải của p vào

        if (f == null) {
            root = p.left; // Nếu p là root, cây con trái của p trở thành root mới
        } else if (f.left == p) {
            f.left = p.left;
        } else {
            f.right = p.left;
        }
    }
}

//xxxxxxxxxxx
    Node findNodeWithTwoChildren(Node p) throws Exception {
        Queue queue = new Queue();
        if (isEmpty()) {
            return null;
        }
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            if (node.left != null && node.right != null && node.info.price < 7) {
                return node;
            } else {
                if (node.left != null) {
                    queue.enqueue((node.left));
                }
                if (node.right != null) {
                    queue.enqueue((node.right));
                }
            }
        }
        return null;
    }

//xxxxxx
    Node findNodeWithLeftChildren(Node p) throws Exception {
        Queue queue = new Queue();
        if (isEmpty()) {
            return null;
        }
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            if (node.left != null) {
                if (node.info.price < 7) {
                    return node;
                } else {
                    queue.enqueue((node.left));
                }
            }
            if (node.right != null) {
                queue.enqueue((node.right));
            }
        }
        return null;
    }
 
//balance tree
    public void balance(ArrayList a, int first, int last){
        if(first > last) return;
        int m = (first + last) /2;
        Person x = ((Node)a.get(m)).info;
        insert(x);
        balance(a, first, m-1);
        balance(a, m+1, last);
    }
	
//balance simple array list
    public void balance(Node p){
        ArrayList a = new ArrayList();
        buildArray(a, p);
        int first = 0;
        int last = a.size() - 1;
        BSTree b = new BSTree(); //create new tree 
        b.balance(a, first, last);
        root = b.root; //referen root to root b
    } 
 
//rotate right node 
public void rotateRight(Node parent) {
    if (parent == null || parent.left == null) {
        return;
    }

    Node child = parent.left;
    parent.left = child.right;
    child.right = parent;

    if (parent == root) {
        root = child;
    } else {
        Node grandparent = father(parent);
        if (grandparent.left == parent) {
            grandparent.left = child;
        } else {
            grandparent.right = child;
        }
    }
}

//rotate left node
public void rotateLeft(Node parent) {
        if (parent == null || parent.right == null) {
            return;
        }
        Node child = parent.right;
        parent.right = child.left;
        child.left = parent;
        // Update root if necessary
        if (parent == root) {
            root = child;
        } else {
            Node grandparent = father(parent);
            if (grandparent.left == parent) {
                grandparent.left = child;
            } else {
                grandparent.right = child;
            }
        }
    }

	
//get node father
    Node father(Node q){
	 Node f,p;
     f=null;p=root;
     while(p!=null)
       {if(p.info.key == q.info.key) break;
         f=p;
         if(q.info.key < p.info.key)  p=p.left; else p=p.right;
       }
     return(f);
    }

//get node right-most node
public Node findRightmostNode(Node root) {
    if (root == null) {
        return null;
    }

    Node current = root;
    while (current.right != null) {
        current = current.right;
    }

    return current;
}

//get node left-most node
public Node findLeftmostNode(Node root) {
    if (root == null) {
        return null; // Cây rỗng, không có node nào để tìm kiếm
    }

    Node current = root;
    while (current.left != null) {
        current = current.left;
    }

    return current;
}

		
//get node by string
    public Node getNode(String xName) {
    Node p = root;
    while (p != null) {
        int cmp = p.info.getBcode().compareToIgnoreCase(xName);
        if (cmp > 0) {
            p = p.left;
        } else if (cmp < 0) {
            p = p.right;
        } else {
            return p; // node found
        }
    }
    return null; // node not found
}
	
//get node by integer/double
    public Node getNode(int x) {
        Node p = root;
        while (p != null) {
            if (p.info.key > x) p = p.left;
            else if (p.info.key < x) p = p.right;
            return p;
        }
        return null;
    }

//Check node have 2 sons or not
 public boolean hasTwoChildren(Node node) {
    return node != null && node.left != null && node.right != null;
}

//Check node have just be 1 sons ( left of right)
public boolean hasExactlyOneChild(Node node) {
    return node != null && (node.left != null ^ node.right != null);
}

//Check node have at least 1 sons ( left of right)
public boolean hasAtLeastOneChild(Node node) {
    return node != null && (node.left != null || node.right != null);
}

//Check node have left son or not
public boolean hasLeftChild(Node node) {
    return node != null && node.left != null;
}

//Check node have right son or not
public boolean hasRightChild(Node node) {
    return node != null && node.right != null;
}

//calculate level of node
    public void calLevel(Node p){
        if(p == null){
            return;
        }
        MyQueue m = new MyQueue();
        m.enqueue(p);
        p.level = 1;//first, leve = 1
        while(!m.isEmpty()){
            Node q = (Node)m.dequeue();         
            if(q.left != null){
                q.left.level = q.level +1;
                m.enqueue(q.left);
            }
            if(q.right != null){
                q.right.level = q.level +1;
                m.enqueue(q.right);
            }
            
        }        
    }

//calculate factor
    public void calculateBalance(Node p){
        if(p == null){
            return;
        }
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while(!m.isEmpty()){
            Node q = (Node)m.dequeue();         
            if(q.left != null){
                m.enqueue(q.left);
            }
            if(q.right != null){
                m.enqueue(q.right);
            }
            q.bal = height(q.right) - height(q.left); 
            if(isAVL && q.bal < -1 || q.bal > 1){// De cho  thuc hien nhieu
                isAVL = false;
            }
        }        
    }

//copy all node to tree by inorder traversal
    public void buildArray(ArrayList a, Node p){
        if(p == null){
            return;
        }
        buildArray(a, p.left);
        a.add(p);
        buildArray(a, p.right);
    }

	
//Calculate balance factor 
  void calculateFactorBalance(RandomAccessFile  f123) throws Exception{
     boolean isAVL = true;
     MyQueue q = new MyQueue();
     q.enqueue(root);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
         r.bal = height(r.right) - height(r.left);//int bal in class Node; // balance factor of the node p = height(p.right) - height(p.left)
         if(r.bal>=2 || r.bal<=-2) isAVL = false;
         if(r.left!=null) q.enqueue(r.left);
         if(r.right!=null) q.enqueue(r.right);
       }
     breadthBal(root,f123);
    if(!isAVL)
     f123.writeBytes("\r\nThe tree is not an AVL tree\r\n");
     else
      f123.writeBytes("\r\nThe tree is an AVL tree\r\n");
  }
  public void breadthBal(Node  p, RandomAccessFile f) throws Exception{//use for balance factor
	if(p==null) return;
    MyQueue q = new MyQueue();
    q.enqueue(p); Node r;
    while(!q.isEmpty())
     {r = q.dequeue();
      fvisitBal(r,f);
      if(r.left != null) q.enqueue(r.left);
      if(r.right != null) q.enqueue(r.right);
     }
   }
  void fvisitBal(Node p, RandomAccessFile f) throws Exception
    {if(p != null) 
      f.writeBytes("("+p.info.name+","+p.info.age+","+p.bal+") ");
    }
  
 //Calculate level all node
  void calculateLevelAllNode(){
	MyQueue q = new MyQueue();
    if(isEmpty()) return; 
    root.level=1;
     q.enqueue(root);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        if(r.left!=null) r.left.level = r.level +1;//level in class node
        if(r.right!=null) r.right.level = r.level +1;
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
	void fvisitLevel(Node p, RandomAccessFile f) throws Exception
    {if(p != null) 
      f.writeBytes("("+p.info.name+","+p.info.age+","+p.level+") ");
    }

//balance a binary search tree 
	void balance(){
	 ArrayList<Person> t;
     t = new ArrayList<Person>();
     inOrder(t,root);
     int n = t.size();
     clear();
     balance(t,0,n-1);
   }
   void inOrder(ArrayList<Person> t, Node p){
	if(p==null) return;
    inOrder(t,p.left);
    t.add(p.info);
    inOrder(t,p.right);
  }
  void balance(ArrayList<Person> t, int i, int j)
  {if(i>j) return;
    int k=(i+j)/2;
    insert(t.get(k));//insert person
    balance(t,i,k-1);
    balance(t,k+1,j);
  }
