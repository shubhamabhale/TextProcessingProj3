package project3;

public class RK {
  
  public int match(String T, String P) {
    /** Your code goes here */
    int d = 10;
    int q = 13;
    int m = P.length();
    int n = T.length();
    int i, j;
    int p = 0;
    int t = 0;
    int h = 1;

    for (i = 0; i < m - 1; i++)
    {
      h = (h * d) % q;
    }
    for (i = 0; i < m; i++) 
    {
      p = (d * p + P.charAt(i)) % q;
      t = (d * t + T.charAt(i)) % q;
    }

    // Find the match
    for (i = 0; i <= n - m; i++) 
    {
      if (p == t) 
      {
        for (j = 0; j < m; j++) 
        {
          if (T.charAt(i + j) != P.charAt(j))
            break;
        }

        if (j == m)
         return i;
      }

      if (i < n - m) 
      {
        t = (d * (t - T.charAt(i) * h) + T.charAt(i + m)) % q;
        if (t < 0)
          t = (t + q);
      }
    }

    return -1;
  }

}
