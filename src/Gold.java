

public class Gold extends Material
{
    char nameMaterial;

	Gold()
	{
		this.nameMaterial = 'G';
	}

	@Override
	String labelMaterial()
	{
		for ( String str : Material.tabLib )
			if ( str.charAt(0) == this.nameMaterial ) return str;

		return null;
	}

	@Override
	char getCharType() { return this.nameMaterial; }

}
