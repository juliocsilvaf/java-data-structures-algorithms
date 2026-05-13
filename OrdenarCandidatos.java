package Etapa2;

/**
 * Algoritmos de ordenação (estáveis) e pesquisa binária para Candidato[].
 * 
 * Observação: usamos insertion sort para garantir ESTABILIDADE.
 * - Por Nome      : ordem alfabética (A..Z), ignorando caixa.
 * - Por Partido   : ordem alfabética (A..Z), ignorando caixa.
 * - Por Votos     : ordem decrescente (maior -> menor).
 */
public class OrdenarCandidatos {

    public static void ordenaCandidatosPorNome(Candidato[] v) {
        for (int i = 1; i < v.length; i++) {
            Candidato chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j].getNome().compareToIgnoreCase(chave.getNome()) > 0) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave; // estável
        }
    }

    public static void ordenaCandidatosPorPartido(Candidato[] v) {
        for (int i = 1; i < v.length; i++) {
            Candidato chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j].getPartido().compareToIgnoreCase(chave.getPartido()) > 0) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave; // estável
        }
    }

    public static void ordenaCandidatosPorVotos(Candidato[] v) {
        // decrescente: maior para menor
        for (int i = 1; i < v.length; i++) {
            Candidato chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j].getIntencoesVotos() < chave.getIntencoesVotos()) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave; // estável
        }
    }

    /**
     * Pesquisa binária por NOME em um vetor JÁ ORDENADO POR NOME (A..Z).
     * @param v vetor ordenado por nome
     * @param nome nome a procurar
     * @return posição encontrada (primeira ocorrência), ou -1 se não existir
     */
    public static int pesquisaBinariaCandidatos(Candidato[] v, String nome) {
        int ini = 0, fim = v.length - 1;
        int pos = -1;
        while (ini <= fim) {
            int meio = (ini + fim) >>> 1;
            int cmp = v[meio].getNome().compareToIgnoreCase(nome);
            if (cmp == 0) {
                pos = meio;
                // opcional: voltar para a primeira ocorrência entre duplicados
                fim = meio - 1;
            } else if (cmp < 0) {
                ini = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return pos;
    }
}
