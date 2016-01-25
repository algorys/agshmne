package io.github.algorys.agshmne.opponent.beast;

import io.github.algorys.agshmne.tools.Tools;

public class BeastFactory {
	private BeastAttributeFactory beastAttributeFactory;

	public BeastFactory() {
		beastAttributeFactory = new BeastAttributeFactory();
	}

	public Beast createWeakWolf() {
		int level = Tools.dice(15) + 1;
		final Beast beast;
		beast = new WeakWolf(level, beastAttributeFactory.createAttributes(level));
		return beast;
	}
}
