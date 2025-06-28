/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.binarysearchtree;

/**
 *
 * @author hanly
 */
public class BinarySearchTree {

    Node root;
    public void add(int value){
        root = add(root, value);
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
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(4);
        bst.add(6);
    }
}
