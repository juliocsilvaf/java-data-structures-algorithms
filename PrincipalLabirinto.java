package Etapa1;

public class PrincipalLabirinto {
    public static void main(String[] args) {
   String arquivo = (args != null && args.length > 0)
    ? args[0]
    : "src/Etapa1/labirinto.txt";


        Labirinto l = new Labirinto(); // Cria a instância do labirinto e carrega a partir do arquivo
        l.criaLabirinto(arquivo);

        System.out.println("Labirinto (inicial):");  // Exibe o labirinto inicial
        l.imprimeLabirinto();
        System.out.println();

        boolean ok = l.percorreLabirinto(); // Tenta resolver o labirinto
        if (ok) {  // Exibe se a solução foi encontrada ou não
        System.out.println("Solução encontrada");
        } else {
        System.out.println("Solução NÃO encontrada");
        }
        System.out.println();
        
        System.out.println("Labirinto (final):"); // Exibe o labirinto final com o caminho da solução (se houver)
        l.imprimeLabirinto();
    }
}
