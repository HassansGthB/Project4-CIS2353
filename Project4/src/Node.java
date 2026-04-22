public class Node {
    private Ticket data;
    private Node next;

    // Constructor
    public Node(Ticket data) {
        this.data = data;
        this.next = null;
    } 

    // Getters
    public Ticket getData() { 
        return data; 
    }
    public Node getNext() { 
        return next; 
    }

    // Setter
    public void setNext(Node next) { 
        this.next = next; 
    }    

    
}
