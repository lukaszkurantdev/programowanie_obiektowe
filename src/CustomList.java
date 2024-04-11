import java.util.AbstractList;
import java.util.NoSuchElementException;

public class CustomList<T> extends AbstractList<T> {
    class Node {
        T value;
        Node next;
    }

    Node start;
    Node end;

    public CustomList() {
        start = end = null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T get(int i) {
        return null;
    }

    public void addLast(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;

        if(start == null) {
            start = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
    }

    public T getLast() {
        if(end == null) {
            throw new NoSuchElementException();
        }
        return end.value;
    }

    public void addFirst(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = start;

        if(start == null) {
            start = newNode;
            end = newNode;
        } else {
            start = newNode;
        }


    }
public T getFirst() {
    if(start == null) {
        throw new NoSuchElementException();
    }
    return start.value;


}

public T removeFirst() {
    if (start == null) {
        throw new NoSuchElementException();
    }
    T startValue = start.value;
    if(start == end) {
        start = null;
        end = null;
        return startValue;
    } else {
        start = start.next;
        return startValue;
    }
}

public T removeLast() {
    if (start == null) {
        throw new NoSuchElementException();
    }
    T endValue = end.value;
    if(start == end) {
        start = null;
        end = null;
        return endValue;
    } else {
        Node temp = start;
        while(temp.next != end) {
            temp = temp.next;
        }
        temp.next = null;
        end = temp;
    }
    return endValue;
    }
}
