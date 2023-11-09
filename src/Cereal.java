

public class Cereal extends Material
{
    char nameMaterial;

	Cereal()
	{
		this.nameMaterial = 'C';
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
