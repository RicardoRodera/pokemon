import java.util.Scanner;

public class Main {
	private static final int NUM_POKEMONS = 5;
	private static final int FUEGO = 1;
	private static final int AGUA = 2;
	private static final int PLANTA = 3;
	private static final int ELECTRICO = 4;
	private static Pokemon[] pokemons = new Pokemon[NUM_POKEMONS];
	private static Pokemon[] pokemonsRival = new Pokemon[NUM_POKEMONS];
	private static Scanner scanner = new Scanner(System.in);

	private static void initPokemons() {
		Pokemon charizard = new Pokemon(100, 50, 50, "charizard", FUEGO);
		pokemons[0] = charizard;
		Pokemon blastoise = new Pokemon(150, 25, 150, "blastoise", AGUA);
		pokemons[1] = blastoise;
		Pokemon venusaur = new Pokemon(300, 10, 100, "venusaur", PLANTA);
		pokemons[2] = venusaur;
		Pokemon bulbasaur = new Pokemon(250, 20, 180, "bulbasaur", PLANTA);
		pokemons[3] = bulbasaur;
		Pokemon pikachu = new Pokemon(300, 40, 200, "pikachu", ELECTRICO);
		pokemons[4] = pikachu;
	}

	private static void initPokemonsRandomly() {
		for (int i = 0; i < NUM_POKEMONS; i++) {
			pokemons[i] = new Pokemon();
			pokemons[i].setName("pokemon" + i);
		}
	}

	private static void initPokemonsRival() {
		for (int i = 0; i < NUM_POKEMONS; i++) {
			pokemonsRival[i] = new Pokemon();
			pokemonsRival[i].setName("pokemonRival" + i);
		}
	}

	private static void initMultiPokemons() {
		int seleccion = 0;
		System.out.println("Elija la opción:");
		System.out.println("1. Utilizar los pokemons del juego");
		System.out.println("2. Crear los pokemons aleatoriamente");
		while (!scanner.hasNextInt()) {
			System.out.println("Debe ser un numero entero");
			scanner.next();
		}
		seleccion = scanner.nextInt();
		while (seleccion < 1 || seleccion > 2) {
			System.out.println("Opción incorrecta");
			while (!scanner.hasNextInt()) {
				System.out.println("Debe ser un numero entero");
				scanner.next();
			}
			seleccion = scanner.nextInt();
		}
		if (seleccion == 1) {
			initPokemons();
		} else {
			initPokemonsRandomly();
		}
		initPokemonsRival();
	}

	private static void showPokemons() {
		for (int i = 0; i < NUM_POKEMONS; i++) {
			System.out.println((i + 1) + ". " + pokemons[i].getName());
		}
	}

	private static void showActualizedPokemons() {
		for (int i = 0; i < NUM_POKEMONS; i++) {
			if (pokemons[i].getHealth() > 0) {
				System.out.println((i + 1) + ". " + pokemons[i].getName());
			}
		}
	}

	private static void initCombat() {
		showPokemons();
		System.out.println("Elige el primer pokemon que desesas que luche: ");
		Pokemon uno = pokemons[scanner.nextInt() - 1];
		System.out.println("Elige al pokemon al que desesas que se enfrente: ");
		Pokemon dos = pokemons[scanner.nextInt() - 1];

		Battle.initBattle(uno, dos);
	}

	private static void initMultiCombat() {
		for (int i = 0; i < NUM_POKEMONS; i++) {
			showActualizedPokemons();
			System.out.println("Elige tu siguiente pokemon: ");
			Pokemon seleccionado = pokemons[scanner.nextInt() - 1];

			Battle.initBattle(seleccionado, pokemonsRival[i]);
			if (pokemonsRival[i].getHealth() > 0) {
				i--;
			}
		}

	}

	public static void main(String[] args) {
		int seleccion = 1;
		do {
			System.out.println("Elija la opción:");
			System.out.println("1. Utilizar los pokemons del juego");
			System.out.println("2. Crear los pokemons aleatoriamente");
			System.out.println("3. Comenzar una batalla equipo vs equipo");
			System.out.println("4. Salir");
			while (!scanner.hasNextInt()) {
				System.out.println("Debe ser un numero entero");
				scanner.next();
			}
			seleccion = scanner.nextInt();
			while (seleccion < 1 || seleccion > 4) {
				System.out.println("Opción incorrecta");
				while (!scanner.hasNextInt()) {
					System.out.println("Debe ser un numero entero");
					scanner.next();
				}
				seleccion = scanner.nextInt();
			}
			switch (seleccion) {
			case 1:
				initPokemons();
				initCombat();
				break;
			case 2:
				initPokemonsRandomly();
				initCombat();
				break;
			case 3:
				initMultiPokemons();
				initMultiCombat();
				break;
			case 4:
				System.out.println("Fin de programa");
				break;
			default:
				System.out.println("ERROR!!");
				break;
			}
		} while (seleccion != 4);
	}

	public static boolean isWeak(Pokemon pokemon1, Pokemon pokemon2) { // Devuelve true si el tipo del pokemon 1 es
																		// debil frente al tipo del pokemon 2
		int tipo1 = pokemon1.getTipo();
		int tipo2 = pokemon2.getTipo();
		switch (tipo1) {
		case FUEGO:
			if (tipo2 == AGUA) {
				return true;
			}
			break;
		case AGUA:
			if (tipo2 == PLANTA || tipo2 == ELECTRICO) {
				return true;
			}
			break;
		case PLANTA:
			if (tipo2 == FUEGO) {
				return true;
			}
			break;
		}
		return false;
	}
}
