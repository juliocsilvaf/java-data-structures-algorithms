package Etapa3;

/**
 * Implementação de uma pilha estática genérica.
 * @param <E> Tipo de elemento armazenado na pilha.
 */
@SuppressWarnings("unchecked")
public class StaticStack<E> implements Stack<E> {
    private int top;
    private Object[] elements;

    /**
     * Construtor da pilha estática.
     * @param maxSize Tamanho máximo da pilha.
     */
    public StaticStack(int maxSize) {
        if (maxSize <= 0) throw new IllegalArgumentException("Tamanho inválido");
        this.elements = new Object[maxSize];
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == elements.length - 1;
    }

    @Override
    public int numElements() {
        return top + 1;
    }

    @Override
    public void push(E element) {
        if (isFull()) throw new OverflowException();
        elements[++top] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new UnderflowException();
        E e = (E) elements[top];
        elements[top--] = null;
        return e;
    }

    @Override
    public E top() {
        if (isEmpty()) throw new UnderflowException();
        return (E) elements[top];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("StaticStack[");
        for (int i = 0; i <= top; i++) {
            sb.append(elements[i]);
            if (i < top) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
