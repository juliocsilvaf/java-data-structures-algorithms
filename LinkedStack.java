package Etapa4;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int count;

    public LinkedStack() {
        top = null;
        count = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        // Pilha encadeada nunca fica cheia (sem limite fixo)
        return false;
    }

    @Override
    public void push(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element); // usa o construtor com 1 argumento
        newNode.setNext(top); // conecta o novo nó ao antigo topo
        top = newNode;        // atualiza o topo
        count++;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        E element = top.getElement();
        top = top.getNext();
        count--;
        return element;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return top.getElement();
    }

    @Override
    public int numElements() {
        return count;
    }
}
