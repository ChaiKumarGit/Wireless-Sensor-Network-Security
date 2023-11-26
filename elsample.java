
class elsample 
{
	public static void main(String[] args) 
	{
		
		ELGamalCipher ec = new ELGamalCipher();
		byte [] key = 9760508f15230bccb292b982a2eb840bf0581cf5;
		String Algorithm = "ELGamalAlgorithm";
		ec.engineInit(1,key,algorithm);
		System.out.println("Hello World!");
	}
}
