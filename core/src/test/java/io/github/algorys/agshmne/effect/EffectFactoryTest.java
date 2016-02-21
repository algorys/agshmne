package io.github.algorys.agshmne.effect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.character.player.skills.SkillType;

public class EffectFactoryTest {

	@Test
	public void fromStringApplyEffectChangeLife() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new PlayerBuilder().create();
		pj.initVital();
		pj.getVital().setLife(10);
		assertTrue(10 == pj.getVital().getLife());
		underTest.fromString("LIFE10").apply(pj);
		assertTrue(20 == pj.getVital().getLife() || 0 == pj.getVital().getLife());
	}

	@Test
	public void fromStringApplyEffectChangeMana() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new PlayerBuilder().create();
		pj.initVital();
		pj.getVital().setMana(5);
		assertTrue(5 == pj.getVital().getMana());
		underTest.fromString("MANA5").apply(pj);
		assertTrue(10 == pj.getVital().getMana() || 0 == pj.getVital().getMana());
	}
	
	@Test
	public void createRandomSkillEffectModifySkills() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new PlayerBuilder().create();
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
		Player pj = new PlayerBuilder().create();
		pj.initVital();
		pj.getVital().setLife(10);
		assertEquals(10, pj.getVital().getLife());
		underTest.createRandomLifeEffect().apply(pj);
		assertNotEquals(10, pj.getVital().getLife());
	}
	
	@Test
	public void createRandomManaEffectModifyMana() {
		EffectFactory underTest = new EffectFactory();
		Player pj = new PlayerBuilder().create();
		pj.initVital();
		pj.getVital().setMana(10);
		assertEquals(10, pj.getVital().getMana());
		underTest.createRandomManaEffect().apply(pj);
		assertNotEquals(10, pj.getVital().getMana());
	}

}
