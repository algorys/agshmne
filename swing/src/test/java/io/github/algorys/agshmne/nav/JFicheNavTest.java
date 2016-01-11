package io.github.algorys.agshmne.nav;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import io.github.algorys.agshmne.start.JFicheNav;

public class JFicheNavTest {
	public static void main(String[] args) {
		JFrame jf = new JFrame("FicheNav");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JFicheNav jToto = new JFicheNav(jf);
		jf.getContentPane().add(jToto);

		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu("Menu");
		JMenuItem item = new JMenuItem(jToto.getNextAction());
		JMenuItem item2 = new JMenuItem(jToto.getPreviousAction());

		jm.add(item);
		jm.add(item2);
		jmb.add(jm);

		jf.setJMenuBar(jmb);

		jf.setSize(jf.getPreferredSize());
		jf.setVisible(true);
	}
}
