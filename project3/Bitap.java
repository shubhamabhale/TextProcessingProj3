package project3;

public class Bitap {
  
  public int match(String T, String P) {
    /** Your code goes here */

        char[] text = T.toCharArray();
        char[] pattern = P.toCharArray();
        int index = bitap_search(text, pattern);

        if (index == -1) 
        {
            return -1;
        }
 
        else 
        {
            return index;
        }
  }


 
    private int bitap_search(char[] text, char[] pattern)
    {

        int len = pattern.length;
        long mask[]
            = new long[Character.MAX_VALUE + 1];
        long R = ~1;
        if (len == 0) {
            return -1;
        }
       
        if (len > 63) {
 
            System.out.println("Pattern too long!");
            return -1;
        }
       
        for (int i = 0; i <= Character.MAX_VALUE; ++i)
 
         mask[i] = ~0;
        for (int i = 0; i < len; ++i)
         mask[pattern[i]] &= ~(1L << i);

        for (int i = 0; i < text.length; ++i) {
 
             
             
           R |= mask[text[i]];
            R <<= 1;     
            if ((R & (1L << len)) == 0)
                 return i - len + 1;
        
        }
       
        return -1;
    }
}
