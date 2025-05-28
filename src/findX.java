class SLL {
    int v;
    SLL next;

    public SLL(int v) {
        this.v = v;
        this.next = null;
    }
}

class DLL1 {
    int v;
    DLL1 next;
    DLL1 prev;

    public DLL1(int v) {
        this.v = v;
        this.next = null;
        this.prev = null;
    }
}

public class findX {
    static SLL searchSLL(SLL head, int v) {
        for (SLL atual = head; atual != null; atual = atual.next) {
            if (atual.v == v) {
                return atual;
            }
        }
        return null;
    }

    static DLL1 searchDLL(DLL1 head, int v) {
        for (DLL1 atual = head; atual != null; atual = atual.next) {
            if (atual.v == v) {
                return atual;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        // ======== Teste da Lista Simples (SLL) ========
        System.out.println("=== Lista Simplesmente Encadeada ===");

        // Criando nós
        SLL n1 = new SLL(10);
        SLL n2 = new SLL(20);
        SLL n3 = new SLL(30);

        // Ligando os nós
        n1.next = n2; n2.next = n3;

        // Buscando valor existente
        SLL resultSLL = findX.searchSLL(n1, 20);
        if (resultSLL != null) {
            System.out.println("Encontrado: " + resultSLL.v);
        } else {
            System.out.println("Não encontrado.");
        }

        // Buscando valor que não existe
        resultSLL = findX.searchSLL(n1, 50);
        if (resultSLL != null) {
            System.out.println("Encontrado: " + resultSLL.v);
        } else {
            System.out.println("Não encontrado.");
        }


        // ======== Teste da Lista Duplamente Encadeada (DLL) ========
        System.out.println("\n=== Lista Duplamente Encadeada ===");

        // Criando nós
        DLL1 d1 = new DLL1(100);
        DLL1 d2 = new DLL1(200);
        DLL1 d3 = new DLL1(300);

        // Ligando os nós
        d1.next = d2; d2.prev = d1;
        d2.next = d3; d3.prev = d2;

        // Buscando valor existente
        DLL1 resultDLL = findX.searchDLL(d1, 300);
        if (resultDLL != null) {
            System.out.println("Encontrado: " + resultDLL.v);
        } else {
            System.out.println("Não encontrado.");
        }

        // Buscando valor que não existe
        resultDLL = findX.searchDLL(d1, 500);
        if (resultDLL != null) {
            System.out.println("Encontrado: " + resultDLL.v);
        } else {
            System.out.println("Não encontrado.");
        }
    }
}