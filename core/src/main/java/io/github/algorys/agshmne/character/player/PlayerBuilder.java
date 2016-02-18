package io.github.algorys.agshmne.character.player;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.character.player.skills.factory.SkillFactory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.map.region.RandomRegionFactory;

public class PlayerBuilder {
	private Game game = new Game(new RandomRegionFactory().create());
	private int FOR = 10;
	private int DEX = 10;
	private int CON = 10;
	private int INT = 10;
	private int CHA = 10;
	private Map<SkillType, Integer> skills = new HashMap<>();
	private String name;
	private String gender = "Male";
	private String race;
	private String job;
	private Item firstItem;
	private Item secondItem;

	public PlayerBuilder() {
		for (SkillType type : SkillType.values()) {
			skills.put(type, 0);
		}
	}

	public Player create() {
		SkillFactory skillFact = new SkillFactory();
		Player player = new Player(game.getRegion().getTileFromPosition(game.getPosition()), skillFact);
		game.setPlayer(player);
		player.getSocial().setName(name);
		player.getSocial().setSexe(gender);
		player.getSocial().setRace(race);
		player.getSocial().setClasse(job);
		// Init Carac
		player.getAttributes().setFOR(FOR);
		player.getAttributes().setDEX(DEX);
		player.getAttributes().setCON(CON);
		player.getAttributes().setINT(INT);
		player.getAttributes().setCHA(CHA);
		player.initVital();
		// Init Skills
		for (Entry<SkillType, Integer> entry : skills.entrySet()) {
			player.getSkills().setSkillLevel(entry.getKey(), entry.getValue());
		}
		// Init Inventaire
		if (firstItem != null) {
			player.getInventory().addItem(firstItem);
		}
		if (secondItem != null) {
			player.getInventory().addItem(secondItem);
		}

		return player;
	}

	public PlayerBuilder setSkill(SkillType type, int value) {
		this.skills.put(type, value);
		return this;
	}

	public int getSkillLevel(SkillType type) {
		return skills.get(type);
	}

	public PlayerBuilder setFOR(int fOR) {
		FOR = fOR;
		return this;
	}

	public PlayerBuilder setDEX(int dEX) {
		DEX = dEX;
		return this;
	}

	public PlayerBuilder setCON(int cON) {
		CON = cON;
		return this;
	}

	public PlayerBuilder setINT(int iNT) {
		INT = iNT;
		return this;
	}

	public PlayerBuilder setCHA(int cHA) {
		CHA = cHA;
		return this;
	}

	public int getFOR() {
		return FOR;
	}

	public int getDEX() {
		return DEX;
	}

	public int getCON() {
		return CON;
	}

	public int getINT() {
		return INT;
	}

	public int getCHA() {
		return CHA;
	}

	public String getName() {
		return name;
	}

	public PlayerBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public PlayerBuilder setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getRace() {
		return race;
	}

	public PlayerBuilder setRace(String race) {
		this.race = race;
		return this;
	}

	public String getJob() {
		return job;
	}

	public PlayerBuilder setJob(String job) {
		this.job = job;
		return this;
	}

	public void setFirstItem(Item firstItem) {
		this.firstItem = firstItem;
	}

	public void setSecondItem(Item secondItem) {
		this.secondItem = secondItem;
	}

	public Item getFirstItem() {
		return firstItem;
	}

	public Item getSecondItem() {
		return secondItem;
	}

	public Game getGame() {
		return this.game;
	}
}
