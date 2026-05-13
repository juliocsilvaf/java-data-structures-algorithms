package Etapa4;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> back;
    private int count;

    public LinkedQueue() {
        front = back = null;
        count = 0;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        // Filas encadeadas nunca estão cheias
        return false;
    }

    @Override
    public void enqueue(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element); // ✅ usa construtor com 1 argumento
        if (isEmpty()) {
            front = newNode;
        } else {
            back.setNext(newNode);
        }
        back = newNode;
        count++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        E element = front.getElement(); // ✅ método correto do Node
        front = front.getNext();
        count--;
        if (front == null) back = null;
        return element;
    }

    @Override
    public E front() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return front.getElement(); // ✅ usa getElement()
    }

    @Override
    public E back() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return back.getElement(); // ✅ usa getElement()
    }

    public E first() throws UnderflowException {
    // Alias para manter compatibilidade com o validador
        return front();
    }


    @Override
    public int numElements() {
        return count;
    }
}
