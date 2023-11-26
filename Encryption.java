class Encryption
{
	long z,p,q,n,e,c,d,s,pp;
	String st;
	int i,j,x,k,sum;
	long b1[],x1[];
	Encryption()
	{
		z=0;
		p=0;
		q=0;
		n=0;
		e=0;
		c=0;
		i=0;
		d=0;
		pp=0;
	}	
	public void setValues(long n1,long pk1)
	{
		n=n1;
		d=pk1;
	}
	public void setValues1(long n1,long sk1)
	{
		n=n1;
		d=sk1;
	}
	public void setValues(long p1,long q1,long pk1)
	{
		p=p1;
		q=q1;
		d=pk1;
	}
	public void cal()
	{
		n=p*q;
		z=(p-1)*(q-1);
		for(i=1;i<=z;i++)
		{
			if((d*i)%z==1)e=i;
		}
	}
	public long calPow1(long n,long n1,long b11)
	{
		s=1;
		for(i=1;i<=n1;i++)
		{
			s=(s*n)%b11;
		}
		return s;
	}
	public long calPow(long n,long n1)
	{
		s=1;
		for(i=1;i<n1;i++)
		{
			s=(s*n);
		}
		return s;
	}
	public long cipherText(long p11)
	{
		c=calPow1(p11,e,n);
		return c;
	}
	public long plainText(long c11)
	{
		pp=calPow1(c11,d,n);
		return pp;
	}
	public long encoding1(String d)
	{
		boolean bo=false;
		int n1[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
		String s1[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","}","{",".",",",";","(",")","[","]"};
		for(j=0;j<35;j++)
		{
			if(d.equalsIgnoreCase(s1[j]))
			{
				x=n1[j];
				bo=true;
			}
		
		}
		if(bo)return x;		
		else
			return 0;
	}
	public String encoding2(long x1)
	{
		boolean bo=false;
		int n1[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
		String s1[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","}","{",".",",",";","(",")","[","]"};
		for(j=0;j<35;j++)
		{
			if(x1==n1[j])
			{
				st=s1[j];
				bo=true;
			}
		}
		if(bo)return st;		
		else
			return "null";
	}
	public String toBinary(long b)
	{
		StringBuffer sb=new StringBuffer();
		do
		{
			sb.append(String.valueOf(b%2));
			b=b/2;
		}while(b>0);
		sb.reverse();
		return(new String(sb));
	}
	public long toInteger(String x)
	{
		boolean bo=false;
		try
		{
		x1=new long[x.length()];
		long j1=0;
		sum=0;
		k=0;
		for(i=0;i<x.length();i++)
		{
			x1[i]=Integer.parseInt(String.valueOf(x.charAt(i)));
		}
			for(k=i;k>0;k--)
			{
				sum+=x1[k-1]*(long)calPow(2,(long)k);
				j1+=1;			
			}
		}
		catch(Exception e)
		{
			bo=true;
		}	
		if(bo)
		{
			 sum=0;
			 return sum;
		}
		else
		return sum;
		
	}
	public boolean isPrime(long pr)
	{
		int  t=0;
		for(i=1;i<=pr;i++)if(pr%i==0)t++;
		if(t==2) return true;
		else
 		return false;
	}
	public static void main(String args[])
	{
	  Encryption ec = new Encryption();  
	
	}
	
}
