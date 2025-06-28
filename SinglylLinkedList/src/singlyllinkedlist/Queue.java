/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singlyllinkedlist;

/**
 *
 * @author hanly
 */
public class Queue {
    Node front, rear;
    
    public Queue(){
       front = rear = null;

    }
    
    public void enqueue(int data){
        Node newNode = new Node(data);
        
        if(rear == null){
            front = rear =  newNode;
            return; 
        }
        rear.next = newNode;
        rear = newNode;
    }
    
    public int dequeue(){
        if(front == null){
            return -1;
        }
        int value = front.value;
        front = front.next;
        if(front == null){
            rear = null;
        }
        return value;
    }
}
