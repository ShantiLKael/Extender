
import java.util.ArrayList;

public class App {
	public static void main( String[] args)
	{ 
		System.out.print("\t\t\t\t\t# How many factories do you want : ");
		
		// entry of number of material producer
		int entryP = 5;

		ArrayList< Minion > minions = new ArrayList< Minion >( entryP * 10 );
		ArrayList< MaterialProducer > matProducers = new ArrayList< MaterialProducer >( entryP );

		// Initialising Minion tab
		for ( int i = 0; i < minions.size(); i++ )
			minions.add( new Minion(1) );

		// Initialising MaterialProducer tab
		int nbIter = 0;
		String materialChoice =
			"\n\n\t\t\t\t" + String.format("%-12s","(C) Cereal")     +
			"\t\t"		   + String.format("%-12s","(D) Diamond")    + "\n" +
			"\t\t\t\t"	   + String.format("%-12s","(G) Gold")       +
			"\t\t"		   + String.format("%-12s","(I) Iron")       + "\n" +
			"\t\t\t\t"	   + String.format("%-12s","(M) Meat")       +
			"\t\t"		   + String.format("%-12s","(R) Rock")       + "\n" +
			"\t\t\t\t"	   + String.format("%-12s","(W) Wood");
		
		System.out.println(materialChoice);

		char entryM = 'X';
		while ( nbIter < entryP )
		{
			System.out.print("\t\t\t\t\t# What Material do the Factory n° "+ (nbIter+1) +" create : ");
			
			// entry of material type
			

			Material m = App.charToMaterial(entryM);

			if ( m != null )
			{ 
				matProducers.add( new Factory( m, 1, 8, 10 ) );
				System.out.println("\n\t\t\t\t\t>> "+ matProducers.get( nbIter ).toString() + " created !");
				nbIter++;
			}
			else
			{
				System.out.println("\n\t\t\t\t|| Wrong input the Material ( " + entryM + " ) doesn't exist  ||\n");
				System.out.println(materialChoice);
			}

			entryM = 'I';
		}

		char entry;
		do
		{
			System.out.println
			(
				"\n\n\n\t\t" + String.format("%-45s", "(E) Show every Material Producer")		+
				"\t"		     + String.format("%-45s", "(A) Assign a Material Producer to a Minion") + "\n" +
				"\t\t"	     + String.format("%-45s", "(S) Show one Material Producer")			+
				"\t"		     + String.format("%-45s", "(C) Create a Minion or Material Producer")	  + "\n" +
				"\t\t"	     + String.format("%-45s", "(W) Make a Minion collect ressources")	+ "\n\n" +
				"\t\t"	     + String.format("%-45s", "(Q) Quit the game")						+ "\n"
			);

			// ask for entry
       		entry = 'E';

			if ( entry == 'A' )
			{
				System.out.print("\t\t# Which minion do you want assigne a factory : ");
			}

			if ( entry == 'C' )
			{
				System.out.print("\t\t# Which Minion should create materials : ");
			}

			if ( entry == 'S' )
			{
				System.out.print("\t\t# Which factory do you want to show  : ");
				entryP = 1;

				Factory f = (Factory) matProducers.get( entryP-1 );
				
				System.out.print("\n\n#####-- FACTORY N°" + entryP + " --#####");
				System.out.println( f.drawFabrics() );
			}
			
			if ( entry == 'E' )
			{
				System.out.println("\t\t# Showing all informations about yout Material Producers : ");

				for ( int j = 0; j < matProducers.size(); j++ )
				{
					System.out.print("\n\t#-- N°" + (j+1) + " " + matProducers.get(j));
					
					boolean containMinion = matProducers.get(j).getNbMinions() > 0; 

					if ( containMinion ) System.out.print(" : ");

					if ( containMinion )
						for ( int i = 0; i < matProducers.get(j).getNbMinions(); i++ )
							System.out.print( matProducers.get(i).getLstMinions().get(i) + " ");
				}
			}

			entry = 'Q';
		} while ( entry != 'Q' );
		
				System.out.println("\n\n\t\t\t\t\t--->>  Merci d'avoir joué au jeu   <<---\n\n");
	}

	public static Material charToMaterial( char c )
	{
		if ( c == 'C' ) return new Cereal();
		if ( c == 'D' ) return new Diamond();
		if ( c == 'G' ) return new Gold();
		if ( c == 'I' ) return new Iron();
		if ( c == 'M' ) return new Meat();
		if ( c == 'R' ) return new Rock();
		if ( c == 'W' ) return new Wood();

		return null;
	}
}
