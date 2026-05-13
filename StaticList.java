package Etapa3;

/**
 * Implementação de uma lista estática genérica.
 * @param <E> Tipo de elemento armazenado na lista.
 */
@SuppressWarnings("unchecked")
public class StaticList<E> implements List<E> {
    private Object[] elements;
    private int size;

    /**
     * Construtor da lista estática.
     * @param maxSize Tamanho máximo da lista.
     */
    public StaticList(int maxSize) {
        if (maxSize <= 0) throw new IllegalArgumentException("Tamanho inválido");
        this.elements = new Object[maxSize];
        this.size = 0;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == elements.length;
    }

    @Override
    public void insert(E element, int pos) {
        if (isFull()) throw new OverflowException();
        if (pos < 0 || pos > size) throw new IndexOutOfBoundsException();

        for (int i = size - 1; i >= pos; i--) {
            elements[i + 1] = elements[i];
        }
        elements[pos] = element;
        size++;
    }

    @Override
    public E remove(int pos) {
        if (isEmpty()) throw new UnderflowException();
        if (pos < 0 || pos >= size) throw new IndexOutOfBoundsException();

        E removed = (E) elements[pos];
        for (int i = pos; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removed;
    }

    @Override
    public E get(int pos) {
        if (pos < 0 || pos >= size) throw new IndexOutOfBoundsException();
        return (E) elements[pos];
    }

    @Override
    public int search(E element) {
        for (int i = 0; i < size; i++) {
            if ((elements[i] == null && element == null) ||
                (elements[i] != null && elements[i].equals(element))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Conta quantas vezes o elemento aparece na lista (método público).
     * @param el Elemento a ser contado.
     * @return Quantidade de ocorrências do elemento.
     */
    public int contaElementos(E el) {
        return contaElementosRecursivo(el, 0);
    }

    /**
     * Método recursivo privado que faz a contagem.
     */
    private int contaElementosRecursivo(E el, int index) {
        if (index >= size) return 0;
        int cont = (elements[index] == null ? el == null : elements[index].equals(el)) ? 1 : 0;
        return cont + contaElementosRecursivo(el, index + 1);
    }
}
