import processing.core.PApplet;


public class GraphPolar extends DrawGraphs
{
  int width=600;
  int height=600;
  
  public void drawPolar(double[][] data)
  {    
    for (int i=1; i<data.length; i++)
    {
      double x1 = PolarX(data[i-1][0], data[i-1][1]);
      double y1 = PolarY(data[i-1][0], data[i-1][1]);
      double x2 = PolarX(data[i][0], data[i][1]);
      double y2 = PolarY(data[i][0], data[i][1]);
      
      line((float)((width*.5)*(1 + x1)), (float)((height*.5)*(1-y1)), 
          (float)((width*.5)*(1 + x2)),  (float)((height*.5)*(1-y2)));
    }
  }
  

  public static double PolarX(double r, double theta)
  {
    return Math.cos(theta)*r;
  }
  
  public static double PolarY(double r, double theta)
  {
    return Math.sin(theta)*r;
  }

  public static void normalizeR(double[][] data)
  {
    double max = -1;
    for (int i=0; i<data.length; i++)
    {
      if (data[i][0]>max) max = data[i][0];
    }
    
    for (int i=0; i<data.length; i++)
    {
      data[i][0]/=max;
    }
  }

  public void setup()
  {
    size(width, height);
    background(255);  
    stroke(0);
  }


  public static void main(String[] args)
  {
    PApplet.main(new String[] {"--present", "Test"});
  }
}
