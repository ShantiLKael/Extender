
public class Iron extends Material
{
    private char nameMaterial;

	Iron()
	{
		this.nameMaterial = 'I';
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
