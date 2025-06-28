/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singlyllinkedlist;

/**
 *
 * @author hanly
 */
public class Stack {
    Node top;
    
    public void push (int data){ // addFirst()
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    
    public int pop(){ // tra ve gia tri dau tien, moi them vao
        int value = top.value; // luu gia tri 
        top = top.next;         // xoa gia tri
        return value;           // tra ve gia tri
    }
}
