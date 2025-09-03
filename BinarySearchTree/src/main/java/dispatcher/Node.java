/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispatcher;

/**
 *
 * @author hanly
 */
public class Node {
    int value;
    Node left;
    Node right;
    
    public Node(int value){
        this.value = value;
        left = right = null;
    }
}
