import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GestorIntentos {
    private Stack<ArrayList<Integer>> pilaIntentos;
    private Queue<ArrayList<Integer>> colaIntentos;

    public GestorIntentos() {
        pilaIntentos = new Stack<>();
        colaIntentos = new LinkedList<>();
    }

    // Métodos para agregar intentos
    public void agregarIntentoPila(ArrayList<Integer> intento) {
        pilaIntentos.push(intento);
    }

    public void agregarIntentoCola(ArrayList<Integer> intento) {
        colaIntentos.add(intento);
    }

    // Métodos para obtener los intentos
    public Stack<ArrayList<Integer>> getIntentosPila() {
        return pilaIntentos;
    }

    public Queue<ArrayList<Integer>> getIntentosCola() {
        return colaIntentos;
    }
}
