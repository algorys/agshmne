package net.isammoc.file;

public class PersoSave {
	private String name;
	private int force;
	private int charism;

	public PersoSave() {
		this("Inconnu", 1, 1);
	}

	public PersoSave(String name) {
		this(name, 1, 1);
	}

	public PersoSave(String name, int force, int charism) {
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
