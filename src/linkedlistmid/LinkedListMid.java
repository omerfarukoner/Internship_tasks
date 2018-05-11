/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistmid;

/**
 *
 * @author Omerfaruk
 */
public class LinkedListMid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList list =new LinkedList();
        
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.addLast("6");
        list.addLast("7");
        list.addLast("8");
        list.addLast("9");
        list.addLast("10");
        list.displayList();
        list.findMid();
    }
    
}
