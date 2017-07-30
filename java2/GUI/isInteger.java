private boolean isInteger( String s )
//return true if s contains a non-negative integer string
{
	for (int k=0; k<s.length();k++) //import static java.lang.Character.*; at top
	{
	    if( !isDigit(s.charAt(k))
	        return false;
	}
	return true;
}