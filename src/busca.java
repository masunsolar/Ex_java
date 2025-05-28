// Classe Nó da Lista Duplamente Encadeada
class DLL {
    int x;          // Valor armazenado no nó
    DLL next;       // Referência para o próximo nó
    DLL prev;       // Referência para o nó anterior

    // Construtor do nó
    public DLL(int x) {
        this.x = x;
        this.next = null;
        this.prev = null;
    }
}

// Classe da Lista Duplamente Encadeada
class ListDp {
    private DLL head;    // Ponteiro para o primeiro nó da lista
    private DLL tail;    // Ponteiro para o último nó da lista
    private int size;    // Contador de elementos na lista

    // Metodo para inicializar a lista
    public void inicializar() {
        head = null;     // Lista começa sem elementos
        tail = null;
        size = 0;
    }
}