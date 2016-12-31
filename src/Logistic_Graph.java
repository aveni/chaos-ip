
public class Logistic_Graph
{
  public static double getNext(double x, double a, double t)
  {
    return a*x*(1-x);
  }
  
  public static float[][] getData(double x_0, double a, double t, int steps)
  {
    float[][] data  = new float[steps][2];
    data[0][0] = 0;
    data[0][1] = (float) x_0;
    
    for (int i=1; i<data.length; i++)
    {
      data[i][0] = (float) (t*i);
      data[i][1] = (float)getNext(data[i-1][1], a, t);
    }
    
    return data;
  }
  
}
