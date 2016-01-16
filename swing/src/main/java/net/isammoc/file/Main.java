package net.isammoc.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		PersoSave p = new PersoSave("Raymond", 42, 54);
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream("example.save"));
			try {
				out.writeUTF(p.getName());
				out.writeInt(p.getForce());
				out.writeInt(p.getCharism());
			} finally {
				out.close();
			}

			DataInputStream in = new DataInputStream(new FileInputStream("example.save"));
			try {
				String name = in.readUTF();
				int force = in.readInt();
				int charism = in.readInt();
				PersoSave apres = new PersoSave(name, force, charism);
				System.out.println(apres);
			} finally {
				in.close();
			}
		} catch (IOException e) {

		}

	}
}
