
public class Spear extends Weapon
{
    private int damage;

	Spear()
	{
		this.damage = 5;
	}

	@Override
	int getDamage() { return this.damage; }

}
