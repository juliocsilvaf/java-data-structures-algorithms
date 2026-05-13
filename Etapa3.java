package Etapa3;

/**
 * Classe que contém o método principal para verificar parênteses agrupados corretamente.
 */
public class Etapa3 {

    /**
     * Verifica se os parênteses estão agrupados corretamente em uma expressão.
     * Critérios:
     *  (1) Número de '(' igual ao número de ')'
     *  (2) Nunca ocorre fechamento antes da abertura
     * @param s1 Pilha contendo os caracteres da expressão.
     * @return true se os parênteses estão agrupados corretamente, false caso contrário.
     */
    public boolean checkBrackets(Stack<Character> s1) {
        if (s1 == null) return true;

        StaticStack<Character> temp = new StaticStack<>(s1.numElements());
        while (!s1.isEmpty()) temp.push(s1.pop());

        int balance = 0;
        StaticStack<Character> restore = new StaticStack<>(temp.numElements());

        while (!temp.isEmpty()) {
            char c = temp.pop();
            restore.push(c);

            if (c == '(') balance++;
            else if (c == ')') {
                balance--;
                if (balance < 0) {
                    while (!restore.isEmpty()) s1.push(restore.pop());
                    while (!temp.isEmpty()) s1.push(temp.pop());
                    return false;
                }
            }
        }

        while (!restore.isEmpty()) s1.push(restore.pop());
        return balance == 0;
    }
}
