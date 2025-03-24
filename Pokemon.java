import java.util.Scanner;

public class Pokemon {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;

    public Pokemon(String nombre, int vida, int ataque, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void atacar(Pokemon enemigo) {
        int danio = ataque - enemigo.defensa;
        danio = Math.max(danio, 0); // Evitar daño negativo
        enemigo.vida -= danio;
        System.out.println(nombre + " ataca a " + enemigo.getNombre() + " causando " + danio + " puntos de daño.");
    }

    public void debilitar(Pokemon enemigo) {
        enemigo.defensa -= 2;
        enemigo.defensa = Math.max(enemigo.defensa, 0); // Evitar defensa negativa
        System.out.println(nombre + " debilita a " + enemigo.getNombre() + ". Defensa de " + enemigo.getNombre() + " ahora es " + enemigo.defensa + ".");
    }

    public boolean estaVivo() {
        return vida > 0;
    }
}