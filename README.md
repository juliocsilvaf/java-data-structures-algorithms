# 🧩 Estruturas de Dados e Algoritmos em Java

Projeto acadêmico desenvolvido para a disciplina de **Laboratório II** na **Unisinos – Universidade do Vale do Rio dos Sinos** (2025/1).

Sistema em Java com 4 etapas progressivas cobrindo algoritmos de busca, ordenação, estruturas de dados estáticas e encadeadas.

---

## 📋 Visão Geral

**Disciplina:** Laboratório I  
**Linguagem:** Java  
**Paradigma:** Programação Orientada a Objetos + Estruturas de Dados

---

## 📁 Estrutura do Projeto

```
src/
├── Etapa1/
│   ├── Labirinto.java          ← Resolução de labirinto por backtracking recursivo
│   ├── PrincipalLabirinto.java ← Main da Etapa 1
│   └── labirinto.txt           ← Arquivo de entrada do labirinto
│
├── Etapa2/
│   ├── Candidato.java          ← Classe com nome, partido e intenções de voto
│   ├── OrdenarCandidatos.java  ← Insertion sort estável + pesquisa binária
│   ├── PrincipalCandidatos.java← Main da Etapa 2
│   ├── nomes.txt               ← Nomes para geração aleatória
│   └── partidos.txt            ← Partidos para geração aleatória
│
├── Etapa3/
│   ├── List.java               ← Interface de lista
│   ├── Stack.java              ← Interface de pilha
│   ├── StaticList.java         ← Lista estática genérica com contagem recursiva
│   ├── StaticStack.java        ← Pilha estática genérica
│   ├── Etapa3.java             ← Verificação de parênteses com pilha
│   ├── OverflowException.java  ← Exceção de capacidade excedida
│   ├── UnderflowException.java ← Exceção de estrutura vazia
│   └── PrincipalEtapa3.java   ← Main da Etapa 3
│
└── Etapa4/
    ├── Queue.java              ← Interface de fila
    ├── Stack.java              ← Interface de pilha
    ├── Node.java               ← Nó genérico para estruturas encadeadas
    ├── LinkedStack.java        ← Pilha encadeada genérica
    ├── LinkedQueue.java        ← Fila encadeada genérica
    ├── OverflowException.java  ← Exceção de capacidade excedida
    ├── UnderflowException.java ← Exceção de estrutura vazia
    └── PrincipalEtapa4.java   ← Main da Etapa 4
```

---

## 🔄 Etapas do Projeto

### Etapa 1 – Labirinto (Backtracking Recursivo)
Resolução de labirinto lido de arquivo `.txt` usando algoritmo de **backtracking recursivo**.

- Lê o labirinto de `labirinto.txt` como matriz de chars
- Percorre recursivamente tentando todas as direções (baixo, cima, direita, esquerda)
- Marca o caminho solução com `#` e desfaz marcações em becos sem saída
- Exibe o labirinto antes e depois da resolução

```
 XXXXXX  XXXXXX
  X XX XXXXXX X
X  X XXX   XXXX
  XX X XXX XXXX
X     XX XXXX X
XX  XXX XXXX XX
XX     DXXXXXXX
```

**Conceitos:** Recursão, backtracking, leitura de arquivo, matriz de chars

---

### Etapa 2 – Ordenação e Pesquisa de Candidatos
Sistema de candidatos eleitorais com ordenação estável e pesquisa binária.

- Array de tamanho aleatório (1–100) com candidatos gerados aleatoriamente
- **Insertion Sort estável** por nome, partido e votos (decrescente)
- **Pesquisa binária** por nome no array ordenado — retorna primeira ocorrência

```
Nome            Part.   Votos
Alexandre       PSB       989
Amanda          PL        576
Beatriz         PSB       972
...
[OK] Candidato encontrado na posição 5: Amanda    PSB    867
```

**Conceitos:** Insertion sort, estabilidade de algoritmos, pesquisa binária, generics

---

### Etapa 3 – Estruturas Estáticas (Lista e Pilha)
Implementação de lista e pilha estáticas genéricas com interfaces.

- `List<E>` — interface com insert, remove, get, search
- `StaticList<E>` — lista estática com **contagem recursiva** de elementos
- `Stack<E>` — interface de pilha com push, pop, top
- `StaticStack<E>` — pilha estática com overflow/underflow
- `Etapa3.checkBrackets()` — verifica se parênteses estão balanceados usando pilha

**Conceitos:** Interfaces, generics, recursão, pilha estática, tratamento de exceções

---

### Etapa 4 – Estruturas Encadeadas (Pilha e Fila)
Implementação de pilha e fila encadeadas genéricas com nó.

- `Node<E>` — nó genérico com element e next
- `LinkedStack<E>` — pilha encadeada sem limite de capacidade
- `LinkedQueue<E>` — fila encadeada com front, back, enqueue e dequeue
- Estruturas **nunca ficam cheias** — crescem dinamicamente

**Conceitos:** Listas encadeadas, nós, pilha/fila dinâmica, generics

---

## 💡 Conceitos Aplicados

- **Recursão** — backtracking (labirinto) e contagem recursiva (lista)
- **Algoritmos de ordenação** — Insertion Sort estável
- **Pesquisa binária** — busca eficiente O(log n)
- **Estruturas de dados** — lista, pilha e fila (estáticas e encadeadas)
- **Interfaces e generics** — `List<E>`, `Stack<E>`, `Queue<E>`
- **Tratamento de exceções** — `OverflowException`, `UnderflowException`
- **Leitura de arquivos** — `BufferedReader`, `FileReader`

---

## ▶️ Como Executar

```bash
# Compilar
javac -d out src/Etapa1/*.java
javac -d out src/Etapa2/*.java
javac -d out src/Etapa3/*.java
javac -d out src/Etapa4/*.java

# Executar cada etapa
java -cp out Etapa1.PrincipalLabirinto src/Etapa1/labirinto.txt
java -cp out Etapa2.PrincipalCandidatos
java -cp out Etapa3.PrincipalEtapa3
java -cp out Etapa4.PrincipalEtapa4
```

---

## 🎓 Contexto

Projeto desenvolvido como **Laboratório I** no curso de **Tecnólogo em Análise e Desenvolvimento de Sistemas** na **Unisinos**, semestre 2025/1.

---

*Julio Cesar da Silva Filho | [LinkedIn](https://www.linkedin.com/in/julio-cesar-filho-84241842/)*
