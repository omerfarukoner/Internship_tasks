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
public class LinkedList {

    Element head;
    Element tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void add(String element) {
        Element newElement = new Element(element);
        if (isEmpty()) {
            head = newElement;
            tail = newElement;
        } else {
            newElement.next = head;
            head = newElement;
        }
    }

    public void addLast(String element) {
        Element newElement = new Element(element);
        if (isEmpty()) {
            head = newElement;
            tail = newElement;
        } else {
            tail.next = newElement;
            tail = newElement;

        }
    }

    public void displayList() {
        Element pointer = head;
        while (true) {
            System.out.print(pointer.element + "-");
            pointer = pointer.next;
            if (pointer == null) {
                break;
            }
        }
        System.out.println(" ");
    }

    public void findMid() {
    
        Element pointer_prev_single=head,pointer_single = head,pointer_double = head;//There are 3 pointer.
        int counter=-1;//It was defined to check if length of list is double.
        if (head != null) {                                   
            while (true) {
                pointer_prev_single=pointer_single;//It follows the single
                pointer_double = pointer_double.next.next;// Double goes on two by two.
                pointer_single = pointer_single.next;//Single goes on one by one.
                counter++;
                if (pointer_double == null || pointer_double.next == null) {
                    break; //When double came to end of the list,single came to middle of the list
                }
            }
            if(counter%2==0) //If the list has double length,it has two middle element.
            System.out.println("The middle elements : " + pointer_prev_single.element + " - "+ pointer_single.element);
            else
            System.out.println("The middle element : " + pointer_single.element);
        }
    }

    public boolean isEmpty() {
        if (head != null) {
            return false;
        } else {
            return true;
        }
    }
}
