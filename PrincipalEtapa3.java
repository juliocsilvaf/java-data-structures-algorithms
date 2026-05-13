package Etapa3;

/**
 * Classe principal que executa os testes da Etapa 3.
 */
public class PrincipalEtapa3 {
    public static void main(String[] args) {
        System.out.println("===========================================================================\n" +
                           "         RELATÓRIO DE EXECUÇÃO\n" +
                           "===========================================================================\n");

        // Teste 1: Contagem de elementos em uma lista estática
        System.out.println("Teste 1: Contagem de Elementos em uma Lista Estática");
        StaticList<Integer> lista = new StaticList<>(10);
        lista.insert(1, 0);
        lista.insert(2, 1);
        lista.insert(3, 2);
        lista.insert(1, 3);
        lista.insert(2, 4);

        int contagem = lista.contaElementos(1);
        System.out.println("O elemento 1 aparece " + contagem + " vezes na lista.");
        System.out.println("---------------------------------------------------\n");

        // Teste 2: Verificação de parênteses agrupados
        System.out.println("Teste 2: Verificação de Parênteses Agrupados");
        StaticStack<Character> pilha = new StaticStack<>(16);
        pilha.push('(');
        pilha.push('A');
        pilha.push('+');
        pilha.push('B');
        pilha.push(')');
        pilha.push('-');
        pilha.push('(');
        pilha.push('C');
        pilha.push('+');
        pilha.push('D');
        pilha.push(')');

        Etapa3 etapa3 = new Etapa3();
        boolean ok = etapa3.checkBrackets(pilha);
        System.out.println("A expressão tem parênteses agrupados corretamente? " + ok);
        System.out.println("---------------------------------------------------");
    }
}
