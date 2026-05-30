import java.util.Scanner;
import java.util.Stack;

public class EditorTextoRefatorado {

    public static void main(String[] args) {
        Stack<Acao> pilha = new Stack<Acao>();  // estrutura pronta do Java
        Scanner sc = new Scanner(System.in);
        String textoAtual = "";
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- Texto atual: \"" + textoAtual + "\" ---");
            System.out.println("1 - Digitar");
            System.out.println("2 - Apagar");
            System.out.println("3 - Substituir");
            System.out.println("4 - Desfazer");
            System.out.println("5 - Ver historico");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o texto: ");
                String digitado = sc.nextLine();
                textoAtual = textoAtual + digitado;
                pilha.push(new Acao("Digitado: " + digitado, TipoAcao.DIGITAR));

            } else if (opcao == 2) {
                System.out.print("Quantos caracteres? ");
                int n = sc.nextInt(); sc.nextLine();
                if (n <= textoAtual.length()) {
                    String apagado = textoAtual.substring(textoAtual.length() - n);
                    textoAtual = textoAtual.substring(0, textoAtual.length() - n);
                    pilha.push(new Acao("Apagado: " + apagado, TipoAcao.APAGAR));
                }

            } else if (opcao == 3) {
                System.out.print("Antiga: "); String antiga = sc.nextLine();
                System.out.print("Nova: ");   String nova = sc.nextLine();
                textoAtual = textoAtual.replace(antiga, nova);
                pilha.push(new Acao("Substituido: " + antiga + " por " + nova, TipoAcao.SUBSTITUIR));

            } else if (opcao == 4) {
                if (pilha.isEmpty()) {
                    System.out.println("Nada para desfazer.");
                } else {
                    Acao desfeita = pilha.pop();  // mesmo metodo, agora da classe pronta
                    System.out.println("Desfeito: " + desfeita.descricao);
                }

            } else if (opcao == 5) {
                System.out.println("=== Historico ===");
                for (int i = pilha.size() - 1; i >= 0; i--) {
                    Acao a = pilha.get(i);
                    System.out.println("[" + a.tipo + "] " + a.descricao);
                }
            }
        }
        sc.close();
    }
}