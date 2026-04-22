public class MyQueue {
    private Node front;
    private Node back;

    // initialize Queue
    public MyQueue() {
        front = null;
        back = null;
    }

    // Add to the back of the queue
    public void enqueue(Ticket ticket) {
        Node newNode = new Node(ticket);
        if (back == null) {
            front = newNode;
            back = newNode;
        } else {
            back.setNext(newNode);
            back = newNode;
        }
    }

    // Remove from the front of the queue
    public Ticket dequeue() {
        if (isEmpty()) {
            return null;
        }
        Ticket removedTicket  = front.getData();
        front = front.getNext();
        if (front == null) {
            back = null;
        }
        return removedTicket ;
    }

    // checks if Empty Queue
    public boolean isEmpty() {
        return front == null;
    }

}
