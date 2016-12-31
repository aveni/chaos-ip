import processing.core.PApplet;

public class BifurcationDiagram extends PApplet
{

  int width = 1300;
  int height = 650;
  double startR = 2.6;
  double endR = 4;
  double dr = (endR-startR)/width;

  
  
  int numIterations = 800;;
  int numTake = 300;
  
  
  public static double getNext(double x, double a)
  {
    //return a*Math.sin(Math.PI*x);
    return a*x*(1-x);
  }
  
  public static float[][] getData(double x_0, double a, int steps)
  {
    float[][] data  = new float[steps][2];
    data[0][0] = 0;
    data[0][1] = (float) x_0;
    
    for (int i=1; i<data.length; i++)
    {
      data[i][0] = (float) (i);
      data[i][1] = (float)getNext(data[i-1][1], a);
    }
    
    return data;
  }
  
  public void drawPoints(double x_0, double dr, int numSteps)
  {   
    for (int i=0; i<numSteps; i++)
    {
      float[][] temp = getData(x_0, startR + dr*i, numIterations);
      for (int j = temp.length - numTake; j<temp.length; j++)
      {
        point((float) ((i*dr/(endR - startR))*width), height*(1-temp[j][1]));
        //System.out.println(temp[j][1]);       
      }
      //System.out.println("-----------------------------------");
    }   
  }
  
  public void setup()
  {
    size(width, height); background(255); stroke(0);
    drawPoints(.2, dr, width);
  }
  
  public static void main(String[] args)
  {
    PApplet.main(new String[] {"--present", "BifurcationDiagram"});
  }

}
