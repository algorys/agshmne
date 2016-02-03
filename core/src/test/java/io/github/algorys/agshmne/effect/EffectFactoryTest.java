package io.github.algorys.agshmne.effect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillType;

public class EffectFactoryTest {

	@Test
	public void fromStringApplyEffectChangeBoucher() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		assertTrue(0 == pj.getSkills().getSkillLevel(SkillType.boucherie));
		underTest.fromString("CBOU1").apply(pj);
		assertTrue(1 == pj.getSkills().getSkillLevel(SkillType.boucherie)
				|| -1 == pj.getSkills().getSkillLevel(SkillType.boucherie));
	}

	@Test
	public void fromStringApplyEffectChangeBucheron() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		assertTrue(0 == pj.getSkills().getSkillLevel(SkillType.bucheron));
		underTest.fromString("CBUC1").apply(pj);
		assertTrue(1 == pj.getSkills().getSkillLevel(SkillType.bucheron)
				|| -1 == pj.getSkills().getSkillLevel(SkillType.bucheron));
	}

	@Test
	public void fromStringApplyEffectChangeCuisine() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		assertTrue(0 == pj.getSkills().getSkillLevel(SkillType.cuisine));
		underTest.fromString("CCUI1").apply(pj);
		assertTrue(1 == pj.getSkills().getSkillLevel(SkillType.cuisine)
				|| -1 == pj.getSkills().getSkillLevel(SkillType.cuisine));
	}

	@Test
	public void fromStringApplyEffectChangeCultiver() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		assertTrue(0 == pj.getSkills().getSkillLevel(SkillType.cultiver));
		underTest.fromString("CCUL1").apply(pj);
		assertTrue(1 == pj.getSkills().getSkillLevel(SkillType.cultiver)
				|| -1 == pj.getSkills().getSkillLevel(SkillType.cultiver));
	}

	@Test
	public void fromStringApplyEffectChangeFouiller() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		assertTrue(0 == pj.getSkills().getSkillLevel(SkillType.fouiller));
		underTest.fromString("CFOU1").apply(pj);
		assertTrue(1 == pj.getSkills().getSkillLevel(SkillType.fouiller)
				|| -1 == pj.getSkills().getSkillLevel(SkillType.fouiller));
	}

	@Test
	public void fromStringApplyEffectChangeMagie() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		assertTrue(0 == pj.getSkills().getSkillLevel(SkillType.magie));
		underTest.fromString("CMAG1").apply(pj);
		assertTrue(1 == pj.getSkills().getSkillLevel(SkillType.magie)
				|| -1 == pj.getSkills().getSkillLevel(SkillType.magie));
	}

	@Test
	public void fromStringApplyEffectChangeMiner() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		assertTrue(0 == pj.getSkills().getSkillLevel(SkillType.miner));
		underTest.fromString("CMIN1").apply(pj);
		assertTrue(1 == pj.getSkills().getSkillLevel(SkillType.miner)
				|| -1 == pj.getSkills().getSkillLevel(SkillType.miner));
	}

	@Test
	public void fromStringApplyEffectChangePecher() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		assertTrue(0 == pj.getSkills().getSkillLevel(SkillType.pecher));
		underTest.fromString("CPEC1").apply(pj);
		assertTrue(1 == pj.getSkills().getSkillLevel(SkillType.pecher)
				|| -1 == pj.getSkills().getSkillLevel(SkillType.pecher));
	}

	@Test
	public void fromStringApplyEffectChangeLife() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		pj.initVital();
		pj.getVital().setVie(10);
		assertTrue(10 == pj.getVital().getVie());
		underTest.fromString("LIFE10").apply(pj);
		assertTrue(20 == pj.getVital().getVie() || 0 == pj.getVital().getVie());
	}

	@Test
	public void fromStringApplyEffectChangeMana() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		pj.initVital();
		pj.getVital().setMana(10);
		assertTrue(10 == pj.getVital().getMana());
		underTest.fromString("MANA10").apply(pj);
		assertTrue(20 == pj.getVital().getMana() || 0 == pj.getVital().getMana());
	}
	
	@Test
	public void createRandomSkillEffectModifySkills() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		int oldTotal = 0;
		int newTotal = 0;
		for (SkillType type : SkillType.values()) {
			oldTotal += pj.getSkills().getSkillLevel(type);
		}
		assertEquals(0, oldTotal);
		underTest.createRandomSkillEffect(1).apply(pj);
		for (SkillType type : SkillType.values()) {
			newTotal += pj.getSkills().getSkillLevel(type);
		}
		assertNotEquals(newTotal, oldTotal);
	}
	
	@Test
	public void createRandomLifeEffectModifyLife() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		pj.initVital();
		pj.getVital().setVie(0);
		assertEquals(0, pj.getVital().getVie());
		underTest.createRandomLifeEffect().apply(pj);
		assertNotEquals(0, pj.getVital().getVie());
	}
	
	@Test
	public void createRandomManaEffectModifyMana() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new Player(null);
		pj.initVital();
		pj.getVital().setMana(0);
		assertEquals(0, pj.getVital().getMana());
		underTest.createRandomManaEffect().apply(pj);
		assertNotEquals(0, pj.getVital().getMana());
	}

}
