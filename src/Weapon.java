
abstract class Weapon
{
	public final static String[] LABELS = { "Spear", "Sword", "Mace", "Crossbow",
											"Axe", "Dagger" };

    /**
     * Returns the damage of a weapon
     */
    abstract int getDamage();
}
