package extender.character;

abstract class Ennemy
{
    /**
     * Attack a Minion and decreases its health
     */
    abstract void attack();

    /**
     * Decreases the health of the ennemy
     */
    abstract void recieveDamage( int damage );

}
