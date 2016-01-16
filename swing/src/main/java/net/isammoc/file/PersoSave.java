package net.isammoc.file;

public class Personnage {
	private String name;
	private int force;
	private int charism;

	public Personnage() {
		this("Inconnu", 1, 1);
	}

	public Personnage(String name) {
		this(name, 1, 1);
	}

	public Personnage(String name, int force, int charism) {
		super();
		this.name = name;
		this.force = force;
		this.charism = charism;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getCharism() {
		return charism;
	}

	public void setCharism(int charism) {
		this.charism = charism;
	}

	@Override
	public String toString() {
		return "Personnage([" + this.name + "], " + this.force + ", " + this.charism + ")";
	}
}
