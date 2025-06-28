    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package singlyllinkedlist;

/**
 *
 * @author hanly
 */
public class SinglylLinkedList {
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
    
    public void removeFirst(){
        if(head!=null){
            head = head.next;
        }
    }
    
    public void removeLast(){
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
    
    public void remove(int index) throws java.lang.Exception{
        if(index >= size()|| index < 0){
            return;
        }
        if(index == 0){
            removeFirst();
            return;
        }
        if(index == size()-1){
            removeLast();
            return;
        }
        Node temp = head;
        Node prev = null;
        int count = 0;
        while(temp!=null && count != index){
           count++;
           prev = temp;
           temp = temp.next;
        }
        prev.next = temp.next;
    }
    
    
    public static void main(String[] args) throws Exception {
        SinglylLinkedList sLl = new SinglylLinkedList();
        sLl.addLast(5);
        sLl.addLast(4);
        sLl.addLast(3);
        sLl.addLast(2);
        sLl.addLast(1);
        //System.out.println(sLl.size());
        //System.out.println(sLl.search(2)); // 5-4-3-2-1
       System.out.println(sLl.search(2));
        sLl.remove(2);
        System.out.println(sLl.search(2));
    }
    
    // làm lại từ đầu
    // implement hàm add(int index, int value); Thêm 1 node vào 1 vị trí bất kỳ 

    
}
