

public class Rock extends Material
{
    char nameMaterial;

	Rock()
	{
		this.nameMaterial = 'R';
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
