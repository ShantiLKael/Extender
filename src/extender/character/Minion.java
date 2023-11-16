package extender.character;
import java.util.HashMap;

import extender.material.Material;
import extender.producer.MaterialProducer;
import extender.weapon.Weapon;

/**
 * A Minion can collect different type of materials and also fight. It is controlled by the Player.
 * <p> The {@code health} ... It can be recovered with time </p>
 * <p> The {@code material} changes depending on the asked material </p>
 * <p> The {@code pocket} determine the number of Material </p>
 * <p> The {@code deposit} is the MaterialProducer where the minion returns the collected materials</p>
 * 
 * <p> The {@code experience} represents the experiences per accumulated by the Minion per Material.
 * The experience increases the number of {@code material} when collected and the experienced itself can increase
 * by collecting materials.
 * </p>
 *  @see Player
 *  @see MaterialProducer
 */
public class Minion
{
	private static int nbInstance;
	private int name;

	private static String[] tabName = { "Ada", "Amara", "Amana", "Jabari", "Zakari", 
										"Jaiden", "Emily", "Roger", "Elsa", "Maria" };
	private int health;
	private Ennemy attackTarget;
	private Weapon wp;

	private int level;

	private int pocket;
	private int maxPocket;		
	private MaterialProducer deposit;

	HashMap< Character, Integer > experience;

	public Minion( int lvl )
	{
		this.level = lvl;
		this.name = ++Minion.nbInstance;
		//this.name = tabName[ (int) (Math.random() * Minion.tabName.length) ];

		this.health = 20 * this.level;
		this.wp = null;

		this.pocket = 0;
		this.maxPocket = 10 * lvl;
		this.deposit = null;

		this.experience = new HashMap< Character, Integer >();

		// Initialising the experience map
		for ( String str : Material.LABELS )
			this.experience.put( str.charAt(0), 0 );
		
		this.experience.put( 'F', 0 ); // adding the experience named fighting
	}

	/**
	 * The action of a Minion collecting materials and putting it in their pocket.
	 * If their pockets are full, it fills the stock of the MaterialProducer.
	 */
	public void createMaterials()
	{
		if ( this.deposit != null && this.deposit.isUsable() )
		{
			// The experience increases the number of material collected
			int exp = this.experience.get( this.deposit.getCharType() );

			if ( this.isFull() ) this.discharge( this.pocket );
			else this.pocket += 10 /** exp : increases nb materials collected */;

			// Increases experience of the Minion for a specific material
			this.experience.put( this.deposit.getCharType(), exp /*+ depenfing on the collected material and tyime it takes to collect it */ );

			// Decreases the health of the deposit 
			this.deposit.deteriorate(1);
		}
		// else { this.doNothing(); }
	}

	public boolean isFull() { return this.maxPocket == this.pocket; }

	public void doNothing()
	{
		this.deposit = null;
	}

	/**
	 * Assign a MaterialProducer and the Material collected by the Minion.
	 * @param producer the new deposit which will replace the old one
	 */
	public void assigneProducer( MaterialProducer producer )
	{
		if ( this.pocket != 0 ) this.discharge( this.pocket );
		if ( this.deposit != null ) this.deposit.delMinion( this );

		this.deposit = producer;
		this.deposit.addMinion( this );
	}

	/**
	 * This method allows the Minion to discharge all of his collected materials
	 * in the deposit.
	 */
	public void discharge( int nbMat )
	{
		this.deposit.charge( nbMat );
		this.pocket -= nbMat;
	}

	/**
	 * Returns the type of the Material the equivalent of the first 
	 * character of a said Material.
	 */
	public char getCharType() { return this.deposit.getCharType(); }
	
	
	public String toString()
	{
		return "Minion " + String.format("%-7s", this.name) + 
			   this.deposit.getMaterial() != null ? " |" + this.deposit.getMaterial().labelMaterial() + "|" : "";
	}

	int getName() { return this.name; }

	public void recieveDamage( int damage ) { this.health -= damage; }
	public void attack       ( int damage ) { this.attackTarget.recieveDamage( wp.getDamage() ); }
	public void giveWeapon   ( Weapon wp  ) { this.wp = wp; }

}