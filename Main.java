import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTree tree = new AVLTree();

        while (true) {
            System.out.print("Ingresa un número (-1 o 'exit' para salir): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit") || input.equals("-1")) {
                System.out.println("Finalizando ejecución...");
                break;
            }

            try {
                int valor = Integer.parseInt(input);
                tree.raiz = tree.insertar(tree.raiz, valor);
                System.out.println("\nÁrbol AVL actualizado:");
                tree.printTree(tree.raiz, "", true);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
            }
        }

        scanner.close();
    }
}
