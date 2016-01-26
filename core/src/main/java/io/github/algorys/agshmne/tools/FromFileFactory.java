package io.github.algorys.agshmne.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.github.algorys.agshmne.items.ItemFactory;

public class FromFileFactory {
	public FromFileFactory() {
	}

	public ItemFactory createFactory(File file) throws IOException {
		ItemFactory itemFactory = new ItemFactory();
		Scanner scanner = new Scanner(file);
		try {
			String line = scanner.nextLine();
			List<String> simpleItemNames = new ArrayList<>();
			while (!line.isEmpty()) {
				simpleItemNames.add(line);
				line = scanner.nextLine();
			}
			itemFactory.setSimpleItems(simpleItemNames);
			line = scanner.nextLine();
			List<String> stackableItemNames = new ArrayList<>();
			while (!line.isEmpty()) {
				stackableItemNames.add(line);
				line = scanner.nextLine();
			}
			itemFactory.setStackableItems(stackableItemNames);
		} finally {
			scanner.close();
		}
		return itemFactory;
	}
}
