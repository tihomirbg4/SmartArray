import java.util.function.Consumer;

public class LinkedList {
    private Node head;
    private int size;
    private Node tail;

    public LinkedList() {
    }

    private static class Node {
        private int element;
        private Node next;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    public void addFirst(int element) {
        Node node = new Node(element);
        if (this.head != null) {
            node.next = this.head;
            this.head.prev = node;
        }
        this.head = node;
        if(this.isEmpty())
        {
           this.tail = this.head;
        }
        this.size++;
    }

    public void addLast(int element)
    {
        if(isEmpty())
        {
            this.addFirst(element);
            return;
        }
        Node node = new Node(element);

        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;

        this.size++;
    }

    public int removeFirst()
    {
        if(this.isEmpty())
        {
            throw new IllegalStateException("Can't remove from empty LinkedList");
        }
        Node node = this.head;
        int element = node.element;

        this.head = node.next;
        if(this.size > 1)
        {
            node.prev = null;
        }
        this.size--;

        if(this.isEmpty())
        {
            this.head = this.tail = null;
        }

        return element;
    }

    public int removeLast()
    {
       if(this.size < 2)
       {
          return this.removeFirst();
       }


       int result = this.tail.element;
       this.tail = this.tail.prev;
       this.tail.next = null;
       this.size--;


       return result;
    }


    public int get(int index)
    {
        validateIndex(index);

        Node current = this.head;

        int currentIndex = 0;
        int result = 0;
        while(current != null)
        {
            if(currentIndex == index)
            {
                result = current.element;
                break;
            }
            currentIndex++;
            current = current.next;
        }

        return result;
    }

    private void validateIndex(int index) {
        if(index < 0 || index >= this.size)
        {
            throw new IllegalArgumentException("Index " + index +
                    " was iut of structure bound!");
        }
    }

    public int size()
    {
        return this.size;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public void forEach(Consumer<Integer> consumer)
    {
        Node current = this.head;

        while(current != null)
        {
            consumer.accept(current.element);

            current = current.next;
        }
    }

    public int[] toArray()
    {
        int[] arr = new int[this.size];

        Node current = this.head;

        int index = 0;

        while(current != null)
        {
            arr[index++] = current.element;

            current = current.next;
        }

        return arr;
    }
}