public class Matrices {
    private int[][] combinaciones;
    private String[][] resultados;

    public Matrices() {
        combinaciones = new int[10][3]; // Matriz para guardar combinaciones (10 filas, 3 columnas)
        resultados = new String[10][3]; // Matriz para guardar resultados
    }

    public void guardarCombinacion(int fila, int[] combinacion) {
        for (int i = 0; i < 3; i++) {
            combinaciones[fila][i] = combinacion[i];
        }
    }

    public void guardarResultado(int fila, String[] resultado) {
        for (int i = 0; i < 3; i++) {
            resultados[fila][i] = resultado[i];
        }
    }

    public void imprimirMatrices() {
        System.out.println("Combinaciones:");
        for (int[] fila : combinaciones) {
            boolean filaVacia = true;
            for (int num : fila) {
                if (num != 0) {
                    filaVacia = false;
                    System.out.print(num + " ");
                }
            }
            if (!filaVacia) System.out.println();
        }

        System.out.println("Resultados:");
        for (String[] fila : resultados) {
            boolean filaVacia = true;
            for (String res : fila) {
                if (res != null) {
                    filaVacia = false;
                    System.out.print(res + " ");
                }
            }
            if (!filaVacia) System.out.println();
        }
    }
}
