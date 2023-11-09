

public class Diamond extends Material
{
    char nameMaterial;

	Diamond()
	{
		this.nameMaterial = 'D';
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
