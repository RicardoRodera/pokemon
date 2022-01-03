import java.util.Scanner;

public class Main {
	private static final int NUM_POKEMONS = 5;
	private static Pokemon[] pokemons = new Pokemon[NUM_POKEMONS];
	private static Scanner scanner = new Scanner(System.in);

	private static void initPokemons() {
		Pokemon charizard = new Pokemon(100, 50, 50, "charizard");
		pokemons[0] = charizard;
		Pokemon blastoise = new Pokemon(150, 25, 150, "blastoire");
		pokemons[1] = blastoise;
		Pokemon venusaur = new Pokemon(300, 10, 100, "venusaur");
		pokemons[2] = venusaur;
		Pokemon bulbasaur = new Pokemon(250, 20, 180, "bulbasaur");
		pokemons[3] = bulbasaur;
		Pokemon pikachu = new Pokemon(300, 40, 200, "pikachu");
		pokemons[4] = pikachu;
	}

	private static void initPokemonsRandomly() {
		for (int i = 0; i <= NUM_POKEMONS; i++) {
			pokemons[i] = new Pokemon();
			pokemons[i].setName("pokemon" + i);
		}
	}

	private static void showPokemons() {
		for (int i = 0; i < NUM_POKEMONS; i++) {
			System.out.println((i + 1) + ". " + pokemons[i].getName());
		}
	}

	private static void initCombat() {
		showPokemons();
		System.out.println("Elige el primer pokemon que desesas que luche: ");
		Pokemon uno = pokemons[scanner.nextInt() - 1];
		System.out.println("Elige al pokemon al que desesas que se enfrente: ");
		Pokemon dos = pokemons[scanner.nextInt() - 1];

		Battle battle = new Battle();
		battle.initBattle(uno, dos);
	}
}
