package Etapa2;

import java.util.Random;
import java.util.Scanner;

/**
 * Gera um vetor de candidatos (1..100), imprime relatórios,
 * ordena por diferentes critérios e realiza pesquisa binária por nome.
 */
public class PrincipalCandidatos {

    private static final String[] NOMES = {
        "Alexandre","Amanda","Beatriz","Gabriela","Jorge","Lucas",
        "Mariana","Paulo","Rafael","Sofia","Bruno","Carla","Daniel",
        "Eduarda","Felipe","Gustavo","Helena","Isabela","João","Karen"
    };

    private static final String[] PARTIDOS = {
        "PT","PL","PSB","PSDB","PMDB","NOVO","PDT","DEM"
    };

    public static void main(String[] args) {
        Random rnd = new Random();

        // tamanho entre 1 e 100
        int n = rnd.nextInt(100) + 1;
        Candidato[] candidatos = new Candidato[n];

        // preenche vetor com dados aleatórios (permitidos nomes/partidos repetidos)
        for (int i = 0; i < n; i++) {
            String nome = NOMES[rnd.nextInt(NOMES.length)];
            String partido = PARTIDOS[rnd.nextInt(PARTIDOS.length)];
            int votos = rnd.nextInt(1000) + 1; // 1..1000
            candidatos[i] = new Candidato(nome, partido, votos);
        }

        // --- RELATÓRIO ---
        System.out.println("\n==========================================================");
        System.out.println("                     RELATÓRIO DE VOTAÇÃO");
        System.out.println("==========================================================");
        System.out.printf("%-15s %-6s %s%n", "Nome", "Part.", "Intenções");
        System.out.println("----------------------------------------------------------");

        // Ordena por nome (estável) e imprime
        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);
        System.out.println("Candidatos ordenados por nome:\n");
        for (Candidato c : candidatos) {
            System.out.println(c);
        }

        // Destaques (primeiro e último após ordenação por nome)
        if (candidatos.length > 0) {
            System.out.println("\n----------------------------------------------------------");
            System.out.println("Primeiro candidato: " + candidatos[0]);
            System.out.println("Último candidato   : " + candidatos[candidatos.length - 1]);
        }

        // Pesquisa binária por nome
        System.out.println("\n==========================================================");
        String nomeBusca;
        if (args != null && args.length > 0) {
            nomeBusca = args[0];
        } else {
            // sem args: pede no console (ou use um nome do próprio vetor)
            Scanner sc = new Scanner(System.in);
            System.out.print("Informe um nome para pesquisa (ex.: Amanda): ");
            nomeBusca = sc.nextLine().trim();
            sc.close();
        }

        int pos = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, nomeBusca);
        if (pos >= 0) {
            System.out.println("[OK] Candidato encontrado na posição " + pos + ": " + candidatos[pos]);
        } else {
            System.out.println("[NOK] Candidato com nome \"" + nomeBusca + "\" não encontrado.");
        }

        // Exemplos extras: ordenar por votos (desc) e por partido
        System.out.println("\n==========================================================");
        System.out.println("Top 10 por votos (decrescente):\n");
        OrdenarCandidatos.ordenaCandidatosPorVotos(candidatos);
        for (int i = 0; i < Math.min(10, candidatos.length); i++) {
            System.out.println(candidatos[i]);
        }

        System.out.println("\n==========================================================");
        System.out.println("Ordenado por partido:\n");
        OrdenarCandidatos.ordenaCandidatosPorPartido(candidatos);
        for (Candidato c : candidatos) {
            System.out.println(c);
        }

        System.out.println("\n============================= FIM =========================\n");
    }
}

