import java.util.Scanner;

class Livro {
    String titulo;
    String autor;
    int ano;
    int quantidade;
    Livro proximo;

    public Livro(String titulo, String autor, int ano, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.quantidade = quantidade;
        this.proximo = null;
    }
}

class ListaLivros {
    Livro head = null;

    public void adicionar(String titulo, String autor, int ano, int quantidade) {
        Livro novo = new Livro(titulo, autor, ano, quantidade);
        if (head == null) {
            head = novo;
        } else {
            Livro aux = head;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = novo;
        }
    }

    public int totalEstoque() {
        int total = 0;
        Livro aux = head;
        while (aux != null) {
            total += aux.quantidade;
            aux = aux.proximo;
        }
        return total;
    }

    public void listarPorAnoIterativo(int ano) {
        Livro aux = head;
        while (aux != null) {
            if (aux.ano == ano) {
                System.out.println(aux.titulo + " - " + aux.autor + " (" + aux.ano + ")");
            }
            aux = aux.proximo;
        }
    }

    public void listarPorAnoRecursivo(int ano) {
        listarPorAnoRecursivoAux(head, ano);
    }

    private void listarPorAnoRecursivoAux(Livro livro, int ano) {
        if (livro == null) return;
        if (livro.ano == ano) {
            System.out.println(livro.titulo + " - " + livro.autor + " (" + livro.ano + ")");
        }
        listarPorAnoRecursivoAux(livro.proximo, ano);
    }

    public ListaLivros separarPorAno(int ano) {
        ListaLivros novaLista = new ListaLivros();
        Livro aux = head;
        while (aux != null) {
            if (aux.ano == ano) {
                novaLista.adicionar(aux.titulo, aux.autor, aux.ano, aux.quantidade);
            }
            aux = aux.proximo;
        }
        return novaLista;
    }

    public void imprimir() {
        Livro aux = head;
        while (aux != null) {
            System.out.println(aux.titulo + " - " + aux.autor + " (" + aux.ano + ") - Qtd: " + aux.quantidade);
            aux = aux.proximo;
        }
    }
}

public class SistemaLivros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaLivros lista = new ListaLivros();

        int opcao;
        do {
            System.out.println("\n====== Menu Livros ======");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Total em estoque");
            System.out.println("3. Listar livros por ano (Iterativo)");
            System.out.println("4. Listar livros por ano (Recursivo)");
            System.out.println("5. Separar livros por ano");
            System.out.println("6. Imprimir todos os livros");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    lista.adicionar(titulo, autor, ano, qtd);
                    break;
                case 2:
                    System.out.println("Total em estoque: " + lista.totalEstoque());
                    break;
                case 3:
                    System.out.print("Ano: ");
                    ano = sc.nextInt();
                    lista.listarPorAnoIterativo(ano);
                    break;
                case 4:
                    System.out.print("Ano: ");
                    ano = sc.nextInt();
                    lista.listarPorAnoRecursivo(ano);
                    break;
                case 5:
                    System.out.print("Ano para separar: ");
                    ano = sc.nextInt();
                    ListaLivros novaLista = lista.separarPorAno(ano);
                    System.out.println("Livros do ano " + ano + ":");
                    novaLista.imprimir();
                    break;
                case 6:
                    lista.imprimir();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}