
package singlylinkedlist;


public class SinglyLinkedList {
    Node head; // kiểu dữ liệu của head là node 
    // linked list: null 
    
    // ArrayList <Interger> arrList = New ArrayList<>(); 
    // arrList.add(7);
    public void addFirst(int value){
        // bước 1: tạo 1 cái node từ value nhập vào
       Node newNode = new Node(value);
       newNode.next = head;
       head = newNode;
    }    
    public void addLast(int value){
        // bước 1: tạo 1 cái node từ value nhập vào
        Node newNode = new Node(value);
        
        if(head == null){
            head = newNode;
            return; // ngắt tại ví trí này ko chay nữa
        }
        // bước 2: tiềm node cuối cùng 
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        // bước 3: Gán temp cho newMode; 
        temp.next = newNode;
    }
    
//    public void addByAnIndex(int index, int value){
//        Node newNode = new Node(value);
//        
//        if(index == 0){
//            addFirst(value);
//            return;
//        }
//        int count = 0;                   // 5 20 10 
//        Node temp = head;               // 2 và 30
//        while(temp.next!=null){
//            if(count == index - 1){                 // 10->20->null                   
//                newNode.next = temp.next;           // 15 thế vào vị trí 20        
//                temp.next = newNode;                // 10->15>20>null        
//                return;
//            }
//            temp = temp.next;
//            count++;
//        }
//        if(temp.next==null){
//            addLast(value);
//        }
//    }
    public int size(){
        Node temp = head;
        int index  = 0;
        while(temp!= null){
            temp=temp.next;
            index++;
        }
        return index;
    }
    public void addByAnIndex(int index, int value){
        Node newNode = new Node(value);
        Node temp = head;
        Node prev=null;
        
        if(index == 0){
            addFirst(value);
        }else if(index == size()-1){
            addLast(value);
        }else if(index>size()){
            System.out.println("Invalid Index");
        }
        
        int count = 0; 
        //1-3-5-7
        // prev = 1
        // temp = 3
        
        
        while(temp!=null&&count != index){
            
                prev = temp;
                temp = temp.next;
                count++;
           
        }
        newNode.next = temp;
        prev.next = newNode;
    }
    
    
    public int search(int index) throws Exception{
        int count = 0;
        Node temp = head;
        
        if(index >= size()||index < 0){
            throw new Exception("Not Found!");
        }
        
        while(temp != null && count!=index){
            temp = temp.next;
            count++;
        }
        return temp.value;
    }
    
    public void remoteFirst(){
        if(head!=null){
            head = head.next;
        }
    }
    
    public void remoteLast(){
        if(head == null)
            return;
        Node prev = null;
        Node temp = head;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }
    
    public void remoteByAnIndex(int index) throws java.lang.Exception{
        if (head == null){
            return;
        }else if (index == 0){
            remoteFirst();
        }else if (index == size()-1){
            remoteLast();
        }else if (index >=size()||index<0){
            throw new Exception("Invalid Index");
        }else{
            Node prev = null;
            Node temp = head;
            int count = 0;
            while(temp!=null&&count!=index){
                prev = temp;
                temp = temp.next;
                count++;
            }
            prev.next = temp.next;
        }
    }
    
    public static void main(String[] args) throws Exception {
        SinglyLinkedList sLl = new SinglyLinkedList();
        sLl.addLast(5);
        sLl.addLast(10);
        sLl.addLast(15);
        sLl.addLast(20);
        sLl.addLast(25);
        // 5->10->15->20->25
        sLl.addByAnIndex(2, 7);
        // 5->10->7->15->20->25
        sLl.remoteByAnIndex(1);
        System.out.println(sLl.search(sLl.size()-1));
    }
    
    // làm lại từ đầu
    // implement hàm add(int index, int value); Thêm 1 node vào 1 vị trí bất kỳ 

}
