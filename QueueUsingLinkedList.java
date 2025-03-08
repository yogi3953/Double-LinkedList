//package StackQueueLinkedList;
import java.util.Scanner;

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
class Qnode
{
    int data;
    Qnode next;
    Qnode previous;
    Qnode(int data)
    {
        this.data=data;
        this.next=null;
        this.previous=null;
    }
}
class StackByLinkedList
{
    Node head=null;
    public Node insertionAtFront(int data,Node head)
    {
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
        return head;
    }
    public Node deletionAtFront(Node head)
    {   
        try{
        if(head==null)
        {
            System.out.println("No data to Delete :(");
            return head;
        }
        Node current=head;
        head=current.next;
        current=null;
    }
    catch(NullPointerException ne)
    {
        System.out.println("No data to delete :(");
    }
    
    return head;
    }
    public Node peek(Node head)
    {
        if(head==null)
        {
            System.out.println("No data to peek :(");
        }
        return head;
    }
    public void display(Node head)
    {
        if(head==null)
        {
            System.out.println("No data");
        }
        while(head!=null)
        {
            System.out.print(head.data+" >> ");
            head=head.next;
        }
        System.out.println();
    }
}
class QueueByDoubleLinkedList
{
    Qnode head=null;
    Qnode tail=null;
    public Qnode insertionAtFront(int data,Qnode head)
    {
        Qnode newNode=new Qnode(data);
        if(tail==null)
        {
            this.tail=newNode;
            return tail;
        }
        if(head==null)
        {
            head=newNode;
            return head;
        }
        Qnode current=head;
        current.previous=newNode;
        newNode.next=current;
        head=newNode;
        return head;
    }
    public Qnode deletionAtEnd(Qnode tail)
    {
        if (tail == null) {
            System.out.println("No data to delete :(");
            return tail;
        }
        if (tail == head) { // If only one element exists
            head = tail = null;
            return tail;
        }
        tail = tail.previous;
        tail.next = null;
       return tail; 
    }
    public Qnode peek(Qnode head)
    {
        if(head==null)
        {
            System.out.println("No data to peek :(");
            return head;
        }
        return head;
    }
    public void display(Qnode head)
    {
        if(head==null)
        {
            System.out.println("No data");
            return ;
        }
        while(head!=null)
        {
            System.out.print(head.data+" >> ");
            head=head.next;
        }
        System.out.println();
    }
}
class Main
{
    public static void main(String[]args)
    {
        StackByLinkedList sll=new StackByLinkedList();
        QueueByDoubleLinkedList qll=new QueueByDoubleLinkedList();
        Scanner sc=new Scanner(System.in);
        while(true)
        {   
            System.out.println("Which Data Structure do you need?");
            System.out.println("1.Stack :) 2.Queue :) 3. Exit :(");
            int choose=sc.nextInt();
            if (choose == 3) {
                System.out.println("Exiting Program...");
                break;
            }
            boolean CHANGE_DS=true;
            while(CHANGE_DS)
            {
            switch(choose)
            {
                case 1:

                        System.out.println("What Operations Do you want to perform on Stack?");
                        System.out.println("1.Insertion at Front :)");
                        System.out.println("2.Deletion at Front :(");
                        System.out.println("3.Finding out peek? :)");
                        System.out.println("4.Display List :)");
                        System.out.println("5.Go to main MENU :)");
                        int stackOP=sc.nextInt();
                    switch(stackOP)
                    {
                        case 1:
                                System.out.print("Enter the data to Insert:");
                                int data=sc.nextInt();
                                sll.head=sll.insertionAtFront(data,sll.head);
                                break;
                        case 2:
                                System.out.println("The Element which will be deleted is:"+sll.head.data);
                                sll.head=sll.deletionAtFront(sll.head);
                                break;
                        case 3:
                                sll.head=sll.peek(sll.head);
                                System.out.println("The peek is:"+sll.head.data);
                                break;
                        case 4:
                                System.out.println("The Present List is as:");
                                sll.display(sll.head);
                                break;
                        case 5:
                                CHANGE_DS=false;  
                                break;
                        default:
                                System.out.print("Exiting...");
                                System.out.println("Invalid Options");
                                CHANGE_DS=false; 
                                sc.close();
                    }
                break;
                case 2:
                        System.out.println("What Operations Do you want to perform on Queue?");
                        System.out.println("1.Insertion at Front :)");
                        System.out.println("2.Deletion at End :(");
                        System.out.println("3.Finding out HEAD? :)");
                        System.out.println("4.Finding out TAIL? :)");
                        System.out.println("5.Display List :)");
                        System.out.println("5.Go to main MENU :)");

                        int queueOP=sc.nextInt();
                    switch(queueOP)
                        {
                            case 1:
                                    System.out.print("Enter the data to Insert:");
                                    int data=sc.nextInt();
                                    qll.head=qll.insertionAtFront(data,qll.head);
                                    break;
                            case 2:
                                    System.out.println("The Element which will be deleted is:"+qll.tail.data);
                                    qll.tail=qll.deletionAtEnd(qll.tail);
                                    break;
                            case 3:
                                    qll.head=qll.peek(qll.head);
                                    System.out.println("The HEAD is:"+qll.head.data);
                                    break;
                            case 4:
                                    qll.tail=qll.peek(qll.tail);
                                    System.out.println("The TAIL is:"+qll.tail.data);
                                    break;
                            case 5:
                                    System.out.print("The Present List is as:");
                                    qll.display(qll.head);
                                    break;
                            case 6:
                                    CHANGE_DS=false;  
                                    break;
                            default:
                                    System.out.print("Exiting...");
                                    System.out.println("Invalid Options");
                                    CHANGE_DS=false; 
                                    sc.close();
                        }
                break;
                default:
                        System.out.print("Exiting....");
                        System.out.println("Invalid Options");
                        sc.close();
            }
            }            
        }
    }
    }
