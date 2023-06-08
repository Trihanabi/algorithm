// TODO: - 4/15/2023
//       - √ Node
//       - √ Constructor
//       - CRUD(Create, Retrieve, Update and Delete)
//       - Methods
//          - Count nodes
//          - Reverse a linked list in-place
//          ...

public class SinglyLinkedList<T> {
    private class Node {
        public T item;
        public Node next;
        public Node(T i) {
            this.item = i;
            this.next = null;
        }
    }

    Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public SinglyLinkedList(T x){
        head = new Node(x);
        size = 1;
    }
//    CRUD
//    1. Create(adding elements)
    public void addFirst(T x) {
        Node curr = head;
        head = new Node(x);
        head.next = curr;
        size++;
    }

    public void addLast(T x) {
        Node curr = head;
        Node last = new Node(x);
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = last;
        size++;
    }
//    Retrieve(getter)
    public T get(int i) {
        if (size == 0) {
            return null;
        }
        int index = 0;
        Node curr = head;
        while (curr.next != null) {
            if (index == i) {
                return curr.item;
            }
            index++;
            curr = curr.next;
        }
        return null;
    }
//    3. Update(Changing elements)
    public void set(int i, T x) {
        if (size == 0) {
            return;
        }
        int index = 0;
        Node curr = head;
        while (curr.next != null) {
            if (index == i) {
                curr.item = x;
            }
            index++;
            curr = curr.next;
        }
    }
//    Delete(removing elements)
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T value = head.item;
        head = head.next;
        size--;
        return value;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        T value = curr.item;
        curr.next = null;
        size--;
        return value;
    }

    public T removeByIndex(int i) {
        if (size == 0) {
            return null;
        }
        if (i == 0) {
            removeFirst();
        }
        int index = 0;
        Node curr = head;
        T value = null;
        while (curr.next != null) {
            if (index == i-1) {
                value = curr.next.item;
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        size--;
        return value;
    }

    // Assume there is no size
    public int countLen() {
        Node curr = head;
        int len = 0;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }

}
