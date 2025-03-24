import java.util.Scanner;
public class BatallaPokemon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear Pokémon
        Pokemon pikachu = new Pokemon("Pikachu", 50, 15, 5);
        Pokemon charmander = new Pokemon("Charmander", 50, 12, 6);

        System.out.println("Selecciona tu Pokemon:");
        System.out.println("1. Pikachu");
        System.out.println("2. Charmander");

        int eleccion = scanner.nextInt();
        Pokemon tuPokemon = eleccion == 1 ? pikachu : charmander;
        Pokemon enemigoPokemon = eleccion == 1 ? charmander : pikachu;

        System.out.println("\n¡Has elegido a " + tuPokemon.getNombre() + "!");
        System.out.println("Tu enemigo es " + enemigoPokemon.getNombre() + ". ¡Que se armen los vergazos!\n");

        // Batalla en tiempo real
        while (tuPokemon.estaVivo() && enemigoPokemon.estaVivo()) {
            System.out.println("\nTu turno:");
            System.out.println("1. Atacar");
            System.out.println("2. Debilitar");
            int accionJugador = scanner.nextInt();

            // Acciones del jugador
            if (accionJugador == 1) {
                tuPokemon.atacar(enemigoPokemon);
            } else if (accionJugador == 2) {
                tuPokemon.debilitar(enemigoPokemon);
            } else {
                System.out.println("Accion no valida, pierdes el turno.");
            }

            if (!enemigoPokemon.estaVivo()) {
                System.out.println(enemigoPokemon.getNombre() + " ha sido derrotado. ¡" + tuPokemon.getNombre() + " gana!");
                break;
            }

            // Turno del enemigo
            System.out.println("\nTurno del enemigo:");
            int accionEnemigo = (int) (Math.random() * 2) + 1; // Acción aleatoria para el enemigo
            if (accionEnemigo == 1) {
                enemigoPokemon.atacar(tuPokemon);
            } else {
                enemigoPokemon.debilitar(tuPokemon);
            }

            if (!tuPokemon.estaVivo()) {
                System.out.println(tuPokemon.getNombre() + " ha sido derrotado. ¡" + enemigoPokemon.getNombre() + " gana!");
                break;
            }
        }

        scanner.close();
    }
}
