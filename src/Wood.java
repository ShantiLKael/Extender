

public class Wood extends Material
{
    char nameMaterial;

	Wood()
	{
		this.nameMaterial = 'W';
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
