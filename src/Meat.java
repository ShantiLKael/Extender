

public class Meat extends Material
{
    char nameMaterial;

	Meat()
	{
		this.nameMaterial = 'M';
	}

	@Override
	String labelMaterial()
	{
		for ( String str : Material.tabLib )
			if ( str.charAt(0) == this.nameMaterial ) return str;

		return null;
	}

	@Override
	char getType() { return this.nameMaterial; }

}
