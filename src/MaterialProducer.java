import java.util.ArrayList;

abstract class MaterialProducer
{
    /**
     * Decresases the health of the Producer.
     */
    abstract void deteriorate( int nb );

    /**
     * Fill the Producer's stock.
     */
    abstract void charge( int nbMaterial );

    /**
     * Returns true if the Factory can still produce materials.
     * WITH GUI Will show a destruction animation
     */
    abstract boolean isUsable();

    /**
     * Returns the material his primary material.
     */
    abstract Material getMaterial();

    abstract char getCharType();

    abstract ArrayList< Minion > getLstMinions();

    abstract int getNbMinions();
    abstract int getMaxMiCapacity();
    abstract int getHealth();

    abstract boolean addMinion( Minion mi );

    abstract void    delMinion( Minion mi );
}
