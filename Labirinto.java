package Etapa1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Labirinto {
    // Constantes para representar os tipos de célula
    private static final char PAREDE = 'X';
    private static final char CAMINHO_ABERTO = ' ';
    private static final char SAIDA = 'D';
    private static final char CAMINHO_SOLUCAO = '#';

    private char[][] labirinto; // Estrutura interna do labirinto

    public void criaLabirinto(String filename) {
    // Lista de possíveis caminhos onde o arquivo pode estar
        String[] candidatos = new String[] {
            filename, // Caminho padrão: src/Etapa1/labirinto.txt
            new File("out", filename).getPath(),    // Se rodar a partir de out/
            new File("bin", filename).getPath(),    // Se rodar a partir de bin/
            new File("..", filename).getPath(),     // Se rodar de dentro de out/, volta para raiz
            new File("../..", filename).getPath()   // Mais um nível acima, se necessário
        };

        File file = null;
        for (String c : candidatos) {
            File f = new File(c);
            if (f.exists() && f.isFile()) {
                file = f;
                break;
            }
        }

        if (file == null) {   // Se nenhum arquivo foi encontrado, lança exceção
            String cwd = new File(".").getAbsolutePath();
            throw new IllegalArgumentException(
                "Arquivo do labirinto não encontrado. Tentativas: "
                + String.join(" | ", candidatos)
                + " (cwd=" + cwd + ")"
            );
        }

        List<char[]> linhas = new ArrayList<>();  // Lê as linhas do arquivo e monta a matriz
        int larguraMax = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove BOM, se existir
                if (!line.isEmpty() && line.charAt(0) == '\ufeff') {
                    line = line.substring(1);
                }
                if (line.length() > larguraMax) larguraMax = line.length();
                linhas.add(line.toCharArray());
            }
            labirinto = new char[linhas.size()][larguraMax];  // Cria a matriz preenchendo espaços onde não há caracteres
            for (int i = 0; i < linhas.size(); i++) {
                char[] src = linhas.get(i);
                for (int j = 0; j < larguraMax; j++) {
                    labirinto[i][j] = (j < src.length) ? src[j] : CAMINHO_ABERTO;
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao ler o arquivo do labirinto: " + file.getPath(), e);
        }
    }


    public boolean percorreLabirinto() {
        if (labirinto == null || labirinto.length == 0) return false;
        return resolverLabirinto(0, 0);
    }

    public void imprimeLabirinto() {
        if (labirinto == null) return;
        for (int i = 0; i < labirinto.length; i++) {
            int end = labirinto[i].length - 1;
            while (end >= 0 && labirinto[i][end] == CAMINHO_ABERTO) end--;
            System.out.println(new String(labirinto[i], 0, Math.max(0, end + 1)));
        }
    }

    private boolean resolverLabirinto(int x, int y) {
        if (!dentro(x, y)) return false;
        char atual = labirinto[x][y];
        if (atual == SAIDA) return true;  // Saída encontrada
        if (atual != CAMINHO_ABERTO) return false;  // Não é caminho livre

        labirinto[x][y] = CAMINHO_SOLUCAO;  // Marca o caminho como parte da solução

        // Tenta recursivamente todas as direções
        if (resolverLabirinto(x + 1, y)) return true; // baixo
        if (resolverLabirinto(x - 1, y)) return true; // cima
        if (resolverLabirinto(x, y + 1)) return true; // direita
        if (resolverLabirinto(x, y - 1)) return true; // esquerda

        labirinto[x][y] = CAMINHO_ABERTO;  // se não deu certo, desfaz a marcação
        return false;
    }

    private boolean dentro(int x, int y) {
        return x >= 0 && y >= 0 && labirinto != null &&
               x < labirinto.length && y < labirinto[0].length;
    }
}
