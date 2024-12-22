public class NumeroRandom {
    public double getNumRandom() {
        double rand = Math.random();
        double numLimit = Math.floor(rand * 10); // Números de 0 a 9
        return numLimit;
    }
}
