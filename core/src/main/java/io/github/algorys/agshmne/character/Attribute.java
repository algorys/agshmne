package io.github.algorys.agshmne.character;

public class Attribute {
	private int FOR;
	private int DEX;
	private int CON;
	private int INT;
	private int CHA;

    public Attribute () {
    }

    public Attribute( Attribute original) {
    	
    }

	public int getFOR() {
		return FOR;
	}

	public void setFOR(int fOR) {
		FOR = fOR;
	}

	public int getDEX() {
		return DEX;
	}

	public void setDEX(int dEX) {
		DEX = dEX;
	}

	public int getCON() {
		return CON;
	}

	public void setCON(int cON) {
		CON = cON;
	}

	public int getINT() {
		return INT;
	}

	public void setINT(int iNT) {
		INT = iNT;
	}

	public int getCHA() {
		return CHA;
	}

	public void setCHA(int cHA) {
		CHA = cHA;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CHA;
		result = prime * result + CON;
		result = prime * result + DEX;
		result = prime * result + FOR;
		result = prime * result + INT;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attribute other = (Attribute) obj;
		if (CHA != other.CHA)
			return false;
		if (CON != other.CON)
			return false;
		if (DEX != other.DEX)
			return false;
		if (FOR != other.FOR)
			return false;
		if (INT != other.INT)
			return false;
		return true;
	}
}
