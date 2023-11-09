abstract class Material 
{
	public final static String[] LABELS = { "Cereal", "Diamond", "Gold", "Iron",
											"Meat", "Rock",  "Wood" };

	/**
	 * Returns the full name of the Material.
	 */
	abstract String labelMaterial();

	/**
	 * Returns the type of the Material the equivalent of the first 
	 * character of a said Material.
	 */
	abstract char   getCharType();

	/**
	 * WITH GUI Will show a floating animation
	 * public void animation();
	 */

	/*
		switch ( rType )
		{
			case 'C' -> this.ressource = new Cereal();
			case 'D' -> this.ressource = new Diamond();
			case 'G' -> this.ressource = new Gold();
			case 'I' -> this.ressource = new Iron();
			case 'M' -> this.ressource = new Meat();
			case 'R' -> this.ressource = new Rock();
			case 'W' -> this.ressource = new Wood();
		}
	 */
}
