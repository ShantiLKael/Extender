package extender.weapon;

public class Spear extends Weapon
{
    private int damage;

	public Spear()
	{
		this.damage = 5;
	}

	@Override
	public int getDamage() { return this.damage; }

}
