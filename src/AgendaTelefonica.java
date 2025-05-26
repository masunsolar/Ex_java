import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class Contato {
    String nome;
    String telefone;
    String celular;
    String email;
    Date dataAniversario;
    Contato proximo;

    public Contato(String nome, String telefone, String celular, String email, Date dataAniversario) {
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.dataAniversario = dataAniversario;
        this.proximo = null;
    }
}

class ListaAgenda {
    Contato head = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void cadastrar(String nome, String telefone, String celular, String email, String dataAniversarioStr) {
        try {
            Date dataAniversario = sdf.parse(dataAniversarioStr);
            Contato novo = new Contato(nome, telefone, celular, email, dataAniversario);
            if (head == null) {
                head = novo;
            } else {
                Contato aux = head;
                while (aux.proximo != null) {
                    aux = aux.proximo;
                }
                aux.proximo = novo;
            }
            System.out.println("Contato cadastrado com sucesso.");
        } catch (ParseException e) {
            System.out.println("Data inválida. Use o formato dd/MM/yyyy.");
        }
    }

    public void imprimir() {
        if (head == null) {
            System.out.println("Agenda vazia.");
            return;
        }
        Contato aux = head;
        while (aux != null) {
            System.out.println("Nome: " + aux.nome);
            System.out.println("Telefone: " + aux.telefone);
            System.out.println("Celular: " + aux.celular);
            System.out.println("Email: " + aux.email);
            System.out.println("Aniversário: " + sdf.format(aux.dataAniversario));
            System.out.println("----------------------------");
            aux = aux.proximo;
        }
    }

    public Contato buscar(String nome) {
        Contato aux = head;
        while (aux != null) {
            if (aux.nome.equalsIgnoreCase(nome)) {
                return aux;
            }
            aux = aux.proximo;
        }
        return null;
    }

    public void editar(String nome) {
        Contato c = buscar(nome);
        if (c == null) {
            System.out.println("Contato não encontrado.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Novo telefone: ");
        c.telefone = sc.nextLine();
        System.out.print("Novo celular: ");
        c.celular = sc.nextLine();
        System.out.print("Novo email: ");
        c.email = sc.nextLine();
        System.out.print("Nova data de aniversário (dd/MM/yyyy): ");
        try {
            c.dataAniversario = sdf.parse(sc.nextLine());
        } catch (ParseException e) {
            System.out.println("Data inválida.");
        }
        System.out.println("Contato atualizado.");
    }

    public void remover(String nome) {
        if (head == null) {
            System.out.println("Agenda vazia.");
            return;
        }
        if (head.nome.equalsIgnoreCase(nome)) {
            head = head.proximo;
            System.out.println("Contato removido.");
            return;
        }
        Contato aux = head;
        while (aux.proximo != null) {
            if (aux.proximo.nome.equalsIgnoreCase(nome)) {
                aux.proximo = aux.proximo.proximo;
                System.out.println("Contato removido.");
                return;
            }
            aux = aux.proximo;
        }
        System.out.println("Contato não encontrado.");
    }

    public void removerDuplicados() {
        Contato atual = head;
        while (atual != null) {
            Contato comparador = atual;
            while (comparador.proximo != null) {
                if (atual.nome.equalsIgnoreCase(comparador.proximo.nome)) {
                    comparador.proximo = comparador.proximo.proximo;
                } else {
                    comparador = comparador.proximo;
                }
            }
            atual = atual.proximo;
        }
        System.out.println("Duplicados removidos.");
    }
}

public class AgendaTelefonica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaAgenda agenda = new ListaAgenda();
        int opcao;

        do {
            System.out.println("\n====== Menu Agenda ======");
            System.out.println("1. Cadastrar contato");
            System.out.println("2. Imprimir contatos");
            System.out.println("3. Buscar contato");
            System.out.println("4. Editar contato");
            System.out.println("5. Remover contato");
            System.out.println("6. Remover duplicados");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();  // <-- CORREÇÃO AQUI

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Celular: ");
                    String celular = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Data de Aniversário (dd/MM/yyyy): ");
                    String data = sc.nextLine();
                    agenda.cadastrar(nome, telefone, celular, email, data);
                    break;
                case 2:
                    agenda.imprimir();
                    break;
                case 3:
                    System.out.print("Nome para buscar: ");
                    nome = sc.nextLine();
                    Contato c = agenda.buscar(nome);
                    if (c != null) {
                        System.out.println("Encontrado:");
                        System.out.println("Telefone: " + c.telefone);
                        System.out.println("Celular: " + c.celular);
                        System.out.println("Email: " + c.email);
                        System.out.println("Aniversário: " + agenda.sdf.format(c.dataAniversario));
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nome para editar: ");
                    nome = sc.nextLine();
                    agenda.editar(nome);
                    break;
                case 5:
                    System.out.print("Nome para remover: ");
                    nome = sc.nextLine();
                    agenda.remover(nome);
                    break;
                case 6:
                    agenda.removerDuplicados();
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