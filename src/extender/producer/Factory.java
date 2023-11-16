package extender.producer;
import java.util.ArrayList;
import java.util.List;

import extender.character.Minion;
import extender.material.Material;

public class Factory extends MaterialProducer
{
    private int health;
    private int level;
    
    private int stock;
    private Material material;

    private List< Minion > lstMinions;
    private int maxMiCapacity;

    public Factory( Material m, int lvl, int capacity, int hp )
    {
        
        this.level = lvl;
        this.health = this.level * hp;

        this.maxMiCapacity = capacity;
        this.lstMinions = new ArrayList< Minion >(this.maxMiCapacity);

        this.stock = 0;

		this.material =  m;
    }

    @Override
    public void deteriorate( int nb ) { this.health -= nb; }

    @Override
    public void charge( int nbMaterial )
    {
        this.stock += nbMaterial;
    }

    @Override
    public boolean isUsable()
    {
        if ( this.health == 0 )
        {
            this.breakFactory();
            
            for ( Minion m : this.lstMinions )
                m.doNothing();
            
            return false;
        }

        return true;
    }

    /**
     * Show on screen all of the materials containesd by the Factory.
     */
    //@Override
    private void breakFactory()
    {
        for ( int i = 0; i < stock; i++ );//del comma
            // show all of the materials on the ground
            
    }


    @Override
    public Material getMaterial()  { return this.material; }

    @Override
    public char getCharType()  { return this.material.getCharType(); }

    @Override
    public List< Minion > getLstMinions()   { return this.lstMinions; }

    @Override
    public int getNbMinions() { return this.lstMinions.size(); }

    @Override
    public boolean addMinion( Minion mi )
    {
        if ( this.getNbMinions() < this.maxMiCapacity )
        {
            this.lstMinions.add( mi );
            return true;
        }

        System.out.println("The factory is already full");
        return false;
    }

    @Override
    public void delMinion( Minion mi ) { this.lstMinions.remove(mi); }

    public String toString() { return "Factory |" + this.material.labelMaterial() + "|"; }

    @Override
    public int getMaxMiCapacity() { return maxMiCapacity; }

    public String drawFabrics()
    {
        /* HOW IT SHOWS ON CONSOLE :
                       x        # All of the Minions affected in the Factory
            .-. _______|        >>> Minion Amana |M| (i)    Minion Esla   |M| (i)
            |=|/     /  \       >>> Minion Emily |M| (i)    Minion Jaiden |M| (i)
            | |_____| '_'|      
            |_|_[X]_|____|      
                M HP

            M : stands for the Material
            i : stands for the index
            HP : design the remaining health the factory has
        */

        boolean containMinion = this.getNbMinions() != 0;

        String l1 = "           x        ";
        if ( containMinion ) l1 += "# All of the Minions affected in the Factory";

        String l2 = ".-. _______|        ";

        if ( containMinion ) l2 += ">>> ";
        for ( int i = 0; i < this.getNbMinions() /2; i++ ) 
            l2 += this.lstMinions.get(i) + " ("+i+")    ";

        String l3 = "|=|/     /  \\       ";

        if ( containMinion ) l3 += ">>> ";
        for ( int i = this.getNbMinions() /2; i < this.getNbMinions(); i++ ) 
            l3 += this.lstMinions.get(i) + " ("+i+")    ";

        String l4 = "| |_____| '_'|      ";
        String l5 = "|_|_[X]_|____|      ";
        String l6 = " " + String.format("%7s", this.material.labelMaterial()) + String.format("%4d", this.health) + "      ";

        return "\n" + l1 + "\n" + l2 + "\n" + l3 + "\n" + l4 + "\n" + l5 + "\n" + l6;
    }

    @Override
    public int getHealth() { return health; }

    public int getLevel() { return level; }

    public int getStock() { return stock; }

}