package extender.character;
import extender.weapon.Weapon;

public class Goblin extends Ennemy
{

    private int health;
    private Minion attackTarget;
    private Weapon wp;

    Goblin( int lvl )
    {
        this.health = 20 * lvl;
        this.attackTarget = null;
        //this.wp = Weapon.LABELS[ (int) (Math.random() * Weapon.LABELS.length ) ]; ADD WP
    }

    @Override
    void attack()
    {
        this.attackTarget.recieveDamage( wp.getDamage() );
    }
    
    @Override
	void recieveDamage( int damage ) { this.health -= damage; }

    
}
