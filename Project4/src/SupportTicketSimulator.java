public class SupportTicketSimulator {

    private MyQueue  queue1; // Priority 1 (most urgent)
    private MyQueue  queue2; // Priority 2
    private MyQueue queue3; // Priority 3

    public SupportTicketSimulator() {
        queue1 = new MyQueue();
        queue2 = new MyQueue();
        queue3 = new MyQueue();
    }

    // Determines priority based on ticket code
    private int getPriority(String code) {
        switch (code) {
            case "SO":
            case "OU":
            case "DP":
                return 1;
            case "MF":
            case "LG":
            case "PB":
                return 2;
            case "RQ":
            case "QH":
            case "OT":
                return 3;
            default:
                return 3; // Unknown codes treated as OT
        }
    }

    // Parses the line and adds the ticket to the correct queue
    public void add(String lineFromFile) {
        String[] parts = lineFromFile.split(" ");
        if (parts.length < 3) return;
        String firstName = parts[0];
        String lastName = parts[1];
        String code = parts[2];

        int priority = getPriority(code);
        Ticket newTicket = new Ticket(firstName, lastName, code, priority);

        if (priority == 1) {
            queue1.enqueue(newTicket);
        } else if (priority == 2) {
            queue2.enqueue(newTicket);
        } else {
            queue3.enqueue(newTicket);
        }
    }

    // Returns the next HIGHEST priority ticket, or null if all queues are empty
    public Ticket processNextTicket() {
        if (!queue1.isEmpty()) {
            return queue1.dequeue();
        } else if (!queue2.isEmpty()) {
            return queue2.dequeue();
        } else if (!queue3.isEmpty()) {
            return queue3.dequeue();
        } else {
            return null; // All queues empty
        }
    }

    // Returns true only when all three queues are empty
    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty() && queue3.isEmpty();
    }
}
