

public class Iron extends Material
{
    char nameMaterial;

	Iron()
	{
		this.nameMaterial = 'I';
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
