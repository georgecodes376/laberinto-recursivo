import java.util.Random;

public class Laberinto {
    public static final char PARED = '#';
    public static final char LIBRE = '.';

    private int filas;
    private int columnas;
    private long seed;
    private char[][] matriz;
    private Random random;

    public Laberinto(int filas, int columnas, long seed) {
        this.filas = filas;
        this.columnas = columnas;
        this.seed = seed;
        this.matriz = new char[filas][columnas];
        this.random = new Random(seed);
        generar(0, 0);
    }

    private void generar(int fila, int columna) {
        if (fila == filas) {
            return;
        }
        if (columna == columnas) {
            generar(fila + 1, 0);
            return;
        }
        if (random.nextInt(100) < 30) {
            matriz[fila][columna] = PARED;
        } else {
            matriz[fila][columna] = LIBRE;
        }
        generar(fila, columna + 1);
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public long getSeed() {
        return seed;
    }

    public char getCasilla(int fila, int columna) {
        return matriz[fila][columna];
    }
}