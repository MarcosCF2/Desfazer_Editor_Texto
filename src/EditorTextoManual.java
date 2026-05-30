import java.util.Scanner;

public class EditorTextoManual {

    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Scanner sc = new Scanner(System.in);
        String textoAtual = "";
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- Texto atual: \"" + textoAtual + "\" ---");
            System.out.println("1 - Digitar texto");
            System.out.println("2 - Apagar texto");
            System.out.println("3 - Substituir palavra");
            System.out.println("4 - Desfazer (Ctrl+Z)");
            System.out.println("5 - Ver historico");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o texto: ");
                String digitado = sc.nextLine();
                textoAtual = textoAtual + digitado;
                Acao acao = new Acao("Digitado: " + digitado, TipoAcao.DIGITAR);
                pilha.push(acao);
                System.out.println("Acao registrada!");

            } else if (opcao == 2) {
                System.out.print("Quantos caracteres apagar? ");
                int n = sc.nextInt();
                sc.nextLine();
                if (n > textoAtual.length()) {
                    System.out.println("Nao ha tantos caracteres.");
                } else {
                    String apagado = textoAtual.substring(textoAtual.length() - n);
                    textoAtual = textoAtual.substring(0, textoAtual.length() - n);
                    Acao acao = new Acao("Apagado: " + apagado, TipoAcao.APAGAR);
                    pilha.push(acao);
                    System.out.println("Acao registrada!");
                }

            } else if (opcao == 3) {
                System.out.print("Palavra a substituir: ");
                String antiga = sc.nextLine();
                System.out.print("Nova palavra: ");
                String nova = sc.nextLine();
                textoAtual = textoAtual.replace(antiga, nova);
                Acao acao = new Acao("Substituido: " + antiga + " por " + nova, TipoAcao.SUBSTITUIR);
                pilha.push(acao);
                System.out.println("Acao registrada!");

            } else if (opcao == 4) {
                Acao desfeita = pilha.pop();
                if (desfeita != null) {
                    textoAtual = desfeita.textoAnterior;
                    System.out.println("Desfeito: [" + desfeita.tipo + "] " + desfeita.descricao);
                    System.out.println("Texto restaurado para: \"" + textoAtual + "\"");
                }

            } else if (opcao == 5) {
                pilha.exibir();
            }
        }

        System.out.println("Editor encerrado.");
        sc.close();
    }
}