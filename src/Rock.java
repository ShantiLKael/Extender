
public class Rock extends Material
{
    private char nameMaterial;

	Rock()
	{
		this.nameMaterial = 'R';
	}

	@Override
	public String labelMaterial()
	{
		for ( String str : Material.LABELS )
			if ( str.charAt(0) == this.nameMaterial ) return str;

		return null;
	}

	@Override
	public char getCharType() { return this.nameMaterial; }

}
