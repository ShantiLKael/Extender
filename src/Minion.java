import java.util.HashMap;

/**
 * A Minion can collect different type of materials and also fight. It is controlled by the Player.
 * <p> The {@code health} ... It can be recovered with time </p>
 * <p> The {@code material} changes depending on the asked material </p>
 * <p> The {@code pocket} determine the number of Material </p>
 * <p> The {@code deposit} is the MaterialProducer where the minion returns the collected materials</p>
 * 
 * <p> The {@code expMaterials} represents the experiences per accumulated by the Minion per Material.
 * The experience increases the number of {@code material} when collected and the experienced itself can increase
 * by collecting materials.
 * </p>
 *  @see Player
 *  @see MaterialProducer
 */
class Minion
{
	private static int nbInstance;
	private static String[] tabName = { "Ada", "Amara", "Amana", "Jabari", "Zakari", 
										"Jaiden", "Emily", "Roger", "Elsa", "Maria" };
	private int health;
	private int name;
	//private int expFight;
	//private Ennemy attackTarget;

	private int level;

	private int       pocket;
	private Material  material;
	private MaterialProducer deposit;

	HashMap< Character, Integer > expMaterials;

	Minion( int lvl )
	{
		this.level = lvl;
		this.name = ++Minion.nbInstance;
		//this.name = tabName[ (int) (Math.random() * Minion.tabName.length) ];

		this.health = 20 * this.level;
		this.pocket = 0;
		this.deposit = null;
		this.material = null;

		this.expMaterials = new HashMap< Character, Integer >();

		for ( String str : Material.tabLib )
			this.expMaterials.put( str.charAt(0), 0 );
	}

	/**
	 * The action of a Minion collecting materials and putting it in their pocket.
	 * It also
	 */
	void createMaterials()
	{
		if ( this.deposit.isUsable() )
		{
			// The experience increases the number of material collected
			int exp = this.expMaterials.get( this.material.getType() );
			this.pocket += 10 /** exp : increases nb materials collected */;

			// Increases experience of the Minion for a specific material
			this.expMaterials.put( this.material.getType(), exp /*+ depenfing on the collected material and tyime it takes to collect it */ );

			// Decreases the health of the deposit 
			this.deposit.deteriorate(1);
		}
		// else { this.doNothing(); }
	}

	void doNothing()
	{
		this.deposit = null;
	}

	/**
	 * Assign a MaterialProducer and the Material collected by the Minion.
	 * @param producer the new deposit which will replace the old one
	 */
	void assigneProducer( MaterialProducer producer )
	{
		if ( this.pocket != 0 ) this.discharge();
		if ( this.deposit != null ) this.deposit.delMinion( this );

		this.deposit = producer;
		this.deposit.addMinion( this );

		this.material = producer.getMaterialType();
	}

	/**
	 * This method allows the Minion to discharge all of his collected materials
	 * in the deposit.
	 */
	void discharge()
	{
		this.deposit.charge( this.pocket );
		this.pocket = 0;
	}

	/**
	 * Returns the type of the Material the equivalent of the first 
	 * character of a said Material.
	 */
	char getType() { return this.material.getType(); }
	
	
	public String toString()
	{
		return "Minion " + String.format("%-7s", this.name) + " |" + this.material.labelMaterial() + "|";
	}

	int getName() { return this.name; }

}