public class Pilha {
    Acao topo;

    public Pilha() {
        this.topo = null;
    }


    public void push(Acao nova) {
        nova.proximo = topo;
        topo = nova;
    }


    public Acao pop() {
        if (topo == null) {
            System.out.println("Nenhuma acao para desfazer.");
            return null;
        }
        Acao removida = topo;
        topo = topo.proximo;
        return removida;
    }

    public boolean estaVazia() {
        return topo == null;
    }


    public void exibir() {
        if (topo == null) {
            System.out.println("Nenhuma acao registrada.");
            return;
        }
        Acao atual = topo;
        System.out.println("=== Historico (mais recente primeiro) ===");
        while (atual != null) {
            System.out.println("[" + atual.tipo + "] " + atual.descricao + " - " + atual.horario);
            atual = atual.proximo;
        }
    }
}