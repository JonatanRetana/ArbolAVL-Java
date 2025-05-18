public class AVLTree {
    Node raiz;

    int getAltura(Node nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    int getFactorBalance(Node nodo) {
        return nodo == null ? 0 : getAltura(nodo.izquierda) - getAltura(nodo.derecha);
    }

    Node rotarDerecha(Node y) {
        Node x = y.izquierda;
        Node T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = Math.max(getAltura(y.izquierda), getAltura(y.derecha)) + 1;
        x.altura = Math.max(getAltura(x.izquierda), getAltura(x.derecha)) + 1;

        return x;
    }

    Node rotarIzquierda(Node x) {
        Node y = x.derecha;
        Node T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = Math.max(getAltura(x.izquierda), getAltura(x.derecha)) + 1;
        y.altura = Math.max(getAltura(y.izquierda), getAltura(y.derecha)) + 1;

        return y;
    }

    Node insertar(Node nodo, int valor) {
        if (nodo == null) {
            return new Node(valor);
        }

        if (valor < nodo.valor)
            nodo.izquierda = insertar(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = insertar(nodo.derecha, valor);
        else
            return nodo;

        nodo.altura = 1 + Math.max(getAltura(nodo.izquierda), getAltura(nodo.derecha));
        int balance = getFactorBalance(nodo);

        if (balance > 1 && valor < nodo.izquierda.valor)
            return rotarDerecha(nodo);
        if (balance < -1 && valor > nodo.derecha.valor)
            return rotarIzquierda(nodo);
        if (balance > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }
        if (balance < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    void printTree(Node nodo, String prefijo, boolean esUltimo) {
        if (nodo != null) {
            System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.valor);
            printTree(nodo.izquierda, prefijo + (esUltimo ? "    " : "│   "), false);
            printTree(nodo.derecha, prefijo + (esUltimo ? "    " : "│   "), true);
        }
    }
}
