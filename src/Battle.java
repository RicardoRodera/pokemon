
public class Battle {

	public static void initBattle(Pokemon pokemon1, Pokemon pokemon2) {
		Pokemon pokemonRapido = new Pokemon();
		Pokemon pokemonLento = new Pokemon();

		while (pokemon1.getHealth() > 0 && pokemon2.getHealth() < 0) {
			if (pokemon1.getSpeed() > pokemon2.getSpeed()) {
				pokemonRapido = pokemon1;
				pokemonLento = pokemon2;
			} else {
				pokemonRapido = pokemon2;
				pokemonLento = pokemon2;
			}

			pokemonLento.setHealth(pokemonLento.getHealth() - pokemonRapido.getStrength());
			pokemonRapido.setHealth(pokemonRapido.getHealth() - pokemonLento.getStrength());

			System.out.println(pokemonRapido.getName() + " comienza el ataque contra " + pokemonLento.getName());
			System.out.println(
					pokemonRapido.getName() + " daña " + pokemonRapido.getStrength() + " a " + pokemonLento.getName()
							+ " y a " + pokemonLento.getName() + " le queda " + pokemonLento.getHealth() + "vida.");
			System.out.println(
					pokemonLento.getName() + " daña " + pokemonLento.getStrength() + " a " + pokemonRapido.getName()
							+ " y a " + pokemonRapido.getName() + " le queda " + pokemonRapido.getHealth() + "vida.");
		}

		System.out.println("----------------------------------");
		if (pokemon1.getHealth() <= 0) {
			System.out.println(pokemon1.getName() + " ha perdido el combate.");
		} else {
			System.out.println(pokemon2.getName() + " ha perdido el combate.");
		}
	}
}
