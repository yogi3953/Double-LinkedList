import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node previous;
    Node(int data)
    {
        this.data=data;
        this.next=null;
        this.previous=null;
    }
}
class QueueByLinkedList
{
    Node head=null;
    Node tail=null;
    public Node insertionAtEnd(int data,Node head,Node tail)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=newNode;
            return head;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.previous=temp;
        tail=newNode;     
        return head;
    }
    
    public Node deletionAtFront(Node head,Node tail)
    {
        if(head==null) return head;
        Node current=head;
        head=current.next;
        if (head != null) {
            head.previous = null;
        } 
        current=null;
        return head;
    }
    public void peek(Node head)
    {
        if(head==null)
        {
            System.out.println("No data to peek");
            return ;
        }
        System.out.println("peek is:"+head.data);
    }
    public void display(Node head)
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
    }
}
class QueueUsingLinkedList
{
    public static void main(String[]args)
    {
        QueueByLinkedList qll=new QueueByLinkedList();
        while(true)
        {
            System.out.println("Which Operation do you want to perform:");
            System.out.println("1.Insertion at End  2.Deletion at Front 3.what is peek? 4)Simply print the list");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            if(choice==0 || choice>4)
            System.out.print("INVALID OPTION:PLEASE CHOOSE FROM ABOVE OPTIONS");
            switch(choice)
            {
                case 1:
                {
                    System.out.print("Enter data: ");
                    int data=sc.nextInt();
                    qll.head=qll.insertionAtEnd(data,qll.head,qll.tail);
                }
                    break;
                case 2:
                qll.head=qll.deletionAtFront(qll.head,qll.tail);
                    break;
                case 3:
                    qll.peek(qll.head);
                     break;
                case 4:
                    qll.display(qll.head);
                    break;
                    
                default:
                    System.out.print("Exiting...");
                    sc.close();
                    System.out.println("Invalid Options");
        }
    }
    }
}
