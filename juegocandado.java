import java.util.ArrayList;

public class juegocandado {
    public static void main(String[] args) {
        System.out.println("BIENVENIDO AL JUEGO¡¡");
        System.out.println("Estas son las reglas del juego:");
        System.out.println("Hay una combinación secreta de 3 números");
        System.out.println("Si el número es correcto ✰");
        System.out.println("Si el número es cercano ~ ");
        System.out.println("Si el número no es correcto y tampoco cercano - ");

        // Generación de números aleatorios desde NumeroRandom
        NumeroRandom random = new NumeroRandom();
        double numberA = random.getNumRandom();
        double numberB = random.getNumRandom();
        double numberC = random.getNumRandom();
        double[] lista = {numberA, numberB, numberC}; // Matriz de números aleatorios

        boolean juegoTerminado = false;

        // Pilas y Colas añadidas para registrar intentos
        GestorIntentos gestor = new GestorIntentos();

        // Matrices para guardar combinaciones y resultados
        Matrices matrices = new Matrices();

        int intentosRestantes = 5;
        int filaActual = 0;

        do {
            // Lectura de números del jugador
            lectura newLectura = new lectura();
            ArrayList<Integer> numeroJugador = newLectura.setNumber();

            // Registro en pila y cola
            gestor.agregarIntentoCola(numeroJugador);
            gestor.agregarIntentoPila(numeroJugador);

            if (numeroJugador.toString().equals("exit")) {
                juegoTerminado = true;
                System.out.println("Juego terminado");
                break;
            }

            // Comparación y respuesta
            ArrayList<String> listaRespuesta = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int pcNumero = (int) lista[i];
                int jugadorNumero = numeroJugador.get(i);
                int cpuMayor = pcNumero + 1;
                int cpuMenor = pcNumero - 1;

                if (jugadorNumero == cpuMayor || jugadorNumero == cpuMenor) {
                    listaRespuesta.add("~");
                } else if (pcNumero == jugadorNumero) {
                    listaRespuesta.add("✰");
                } else {
                    listaRespuesta.add("-");
                }
            }

            String respuesta = listaRespuesta.toString();
            System.out.println(respuesta);

            // Guardar intentos y resultados en matrices
            matrices.guardarCombinacion(filaActual, numeroJugador.stream().mapToInt(Integer::intValue).toArray());
            matrices.guardarResultado(filaActual, listaRespuesta.toArray(new String[0]));
            filaActual++;

            if (respuesta.equals("[✰, ✰, ✰]")) {
                juegoTerminado = true;
                System.out.println("¡Felicidades! Has adivinado la combinación.");
            } else {
                intentosRestantes--;
            }

        } while (!juegoTerminado && intentosRestantes > 0);

        // Mostrar mensaje si se agotaron los intentos
        if (intentosRestantes == 0 && !juegoTerminado) {
            System.out.println("Lo siento, perdiste. Has agotado tus 5 intentos.");
        }

        // Mostrar intentos registrados
        System.out.println("\nHistorial de Intentos (Cola): " + gestor.getIntentosCola());
        System.out.println("Historial de Intentos (Pila): " + gestor.getIntentosPila());

        // Imprimir matrices
        matrices.imprimirMatrices();

        System.out.println("JUEGO TERMINADO.");
    }
}
