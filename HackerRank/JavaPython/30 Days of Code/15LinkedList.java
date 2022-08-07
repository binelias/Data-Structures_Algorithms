package HackerRank.JavaPython.30 Days of Code;

import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {

    public static  Node insert(Node head,int data) {
        //Complete this method
        if( head == null) {
            return new Node(data);
        }else {
            Node begin = head;
            while(begin.next != null) {
                begin = begin.next;
            }
            begin.next = new Node(data);
            return head;
        }
        
    }

    public static  Node insert2(Node head,int data) {
        //Complete this method
        if( head == null) {
            return new Node(data);
        }else if(begin.next == null) {
            head.next = new Node(data); 
        }else {
            insert2(head.next, data);
        }
        return head;
        
    }

	public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}
