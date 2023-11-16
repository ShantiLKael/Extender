package extender.material;

public class Diamond extends Material
{
    private char nameMaterial;

	public Diamond()
	{
		this.nameMaterial = 'D';
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
