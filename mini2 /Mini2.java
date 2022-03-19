package mini2;

public class Mini2 {
	public static java.lang.String everyNth(java.lang.String s,int n)
	{
		if(s.length()<n)
		{
			return"";
			}else {
				return s.charAt(n-1) + everyNth(s.substring(n),n);
			}
			}
	public static java.lang.String noNth(java.lang.String s,int n)
	{
		if(s.length() < n)
		{
			return s;
			}else {
				return s.substring(0,n-1) + noNth(s.substring(n),n);
			}
		
	}
	public static java.lang.String unique(java.lang.String s)
	{
		if(s.length() < 2)
	{
		return s;
			} else {
				String str = unique(s.substring(1));
				if(s.charAt(0) !=s.charAt(1)) {
					str =s.charAt(0) + str;
				}
				return str;		
			}
	}
	public static int toInt (java.lang.String number) 
	{
		 if (number.length() == 0) {//base case 
	            return 0;
	        } else if (number.charAt(0)== '-')
	        	{
	        	return (toInt(number.substring(1, number.length() - 1)) * 10 + Character.getNumericValue(number.charAt(number.length() - 1)))*-1;
		 } else {
			 return toInt(number.substring(0, number.length() - 1)) * 10 + Character.getNumericValue(number.charAt(number.length() - 1));
	        } 
	        	
	        }
	        
	 public static boolean isMatched(java.lang.String s)

	    {

	        int count = 0;
	        for(int i = 0; i < s.length(); ++i)
	{
	            if(s.charAt(i) == '{')
	{         ++count;
	            }
	            else if(s.charAt(i) == '(')
	{
	                ++count;
	            }

	            else if(s.charAt(i) == '[')
	{
	                ++count;
	            }
	            else if(s.charAt(i) == '<')
	{
	               ++count;
	            }
	            else
	{
	                if(count == 0)
	{        return false;
	                }
	            }
	        }
	        return count == 0;
	    }
    
	public static double pow(double base , int exponent)
	{
		if(exponent == 0)
		{
			return 1.0;
		}
		else if(exponent > 0)
		{
			if(exponent % 2 == 0)
			{
				double half = pow(base,exponent/2);
				return half*half;
				
			}
			else {
				return base*pow(base,exponent-1);
			}
		}
		else {
			return 1.0/pow(base,-exponent);
		}
	}
	
}



