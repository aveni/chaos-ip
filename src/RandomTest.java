import java.util.Arrays;


public class RandomTest
{

  public static int sum(int[] config)
  {
    int sum=0;    
    for (int i: config) sum+=i;    
    return sum;
  }

  public static boolean test(int[] config)
  {
    int sum = sum(config);
    for (int i=0; i<config.length; i++)
    {
      int c = (i - (sum-config[i]) + config.length*config.length)%config.length;
      
      //System.out.println(c);
      if (c==config[i]) return true;
    }
    return false;
  }


  public static void main(String[] args)
  {
    for (int a=0; a<=3; a++)
    {
      for (int b=0; b<=3; b++)
      {
        for (int c=0; c<=3; c++)
        {
          for (int d=0; d<=3; d++)
          {
          int[] config = new int[]{a,b,c,d};
          System.out.println(Arrays.toString(config));
          if (!test(config))
          {
            System.out.println("FAIL");          
          }
          }
        }
      }
    }

  }

}
