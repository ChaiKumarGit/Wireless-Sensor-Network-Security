public class Dec
{
	String getDec(long n,long sk,String s)
	{
		int bb=0;
		String ss[],sss[];
		Encryption e=new Encryption();	
		e.setValues1(n,sk);
		 sss=new String[s.length()];
		 ss=new String[s.length()];
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb=new StringBuffer();
		long  c,x;
		for(int i=0;i<s.length();i++)
		{
			sss[i]=String.valueOf(s.charAt(i));
			
		}
		for(int i=0;i<s.length();i++)
		{
			
				
				if(sss[i].equals(" "))
				{
					sb1.append(" ");
					
					
				}
				else if(sss[i].equals("\n"))
				{
					sb1.append("\n");
					sb.setLength(0);
				}
				else if(sss[i].equals("	\t"))sb1.append("\t");
				else if(sss[i].equals("|"))
				{	bb=i;
					c=e.toInteger(String.valueOf(sb.reverse()));
					
					if(c==0)
					{
						for(int k=bb;k<i;k++)
						sb1.append(sss[i]);
					}
					x=e.plainText((long)c);
					ss[i]=e.encoding2((long)x);
					if(ss[i].equals("null") )
					{
						sb1.append(sss[i]);
					}
					else
						sb1.append(ss[i]);
					sb.setLength(0);					
					bb=i;
					
				}
				else
					sb.append(sss[i]);
				
		}
		return(String.valueOf(sb1));
			
	}
}