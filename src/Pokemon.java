
public class Pokemon {

	private static final int INITIAL_HEALTH = 301;
	private static final int INITIAL_STRENGT = 51;
	private static final int INITIAL_SPEED = 201;
	private static final int NUM_TIPOS = 4;
	private int health;
	private int strength;
	private int speed;
	private int tipo;
	private String name;

	public Pokemon() {
		this.health = (int) (Math.random() * INITIAL_HEALTH) + 1;
		this.strength = (int) (Math.random() * INITIAL_STRENGT) + 1;
		this.speed = (int) (Math.random() * INITIAL_SPEED) + 1;
		this.tipo = (int) (Math.random() * NUM_TIPOS - 1) + 1;
		this.name = "";
	}

	public Pokemon(int health, int strength, int speed, String name, int tipo) {
		this.health = health;
		this.strength = strength;
		this.speed = speed;
		this.name = name;
		this.tipo = tipo;
	}

	public int getHealth() {
		return this.health;
	}

	public int getStrength() {
		return this.strength;
	}

	public int getSpeed() {
		return this.speed;
	}

	public String getName() {
		return this.name;
	}

	public int getTipo() {
		return this.tipo;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
