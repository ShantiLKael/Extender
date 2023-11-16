package extender.producer;
import java.util.List;

import extender.character.Minion;
import extender.material.Material;

public abstract class MaterialProducer
{
    /**
     * Decresases the health of the Producer.
     */
    public abstract void deteriorate( int nb );

    /**
     * Fill the Producer's stock.
     */
    public abstract void charge( int nbMaterial );

    /**
     * Returns true if the Factory can still produce materials.
     * WITH GUI Will show a destruction animation
     */
    public abstract boolean isUsable();

    /**
     * Returns the material his primary material.
     */
    public abstract Material getMaterial();

    public abstract char getCharType();

    public abstract List< Minion > getLstMinions();

    public abstract int getNbMinions();
    public abstract int getMaxMiCapacity();
    public abstract int getHealth();

    public abstract boolean addMinion( Minion mi );

    public abstract void    delMinion( Minion mi );
}
