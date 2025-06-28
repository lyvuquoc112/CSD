/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

/**
 *
 * @author hanly
 */
public class draft {
    Node head;
    public void addFirst(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int value){
        Node newNode = new Node(value);
        
        if(head==null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public void addByAnIndex(int index, int value){
        Node newNode = new Node(value);
        
        if(index == 0){
            head = newNode;
            return;
        }
        int count = 0;
        Node temp = head;
        while(temp.next!=null){
            if(count == index - 1){                 // 10->20->null                   
                newNode.next = temp.next;           // 15 thế vào vị trí 20        
                temp.next = newNode;                // 10->15>20>null        
                return;
            }
            temp = temp.next;
            count++;
        }
        if(temp.next==null){
            addLast(value);
        }
    }
}
