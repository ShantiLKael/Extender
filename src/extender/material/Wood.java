package extender.material;

public class Wood extends Material
{
    private char nameMaterial;

	public Wood()
	{
		this.nameMaterial = 'W';
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
