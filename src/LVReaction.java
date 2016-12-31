import processing.core.PApplet;


public class LVReaction extends DrawGraphs
{
 
  public static double f(double x, double y)
  {
    return x-x*y;
  }
  
  public static double g(double x, double y)
  {
    return x*y - y;
  }
  
  
  public static float[][] getXData(int numSteps, double dt, double x_0, double y_0)
  {
    float[][] X = new float[numSteps][2];
    float[][] Y = new float[numSteps][2];
    
    X[0][1] = (float) x_0;    Y[0][1] = (float) y_0;
    
    for (int i=1; i<numSteps; i++) //add times
    {
      X[i][0] = (float) (dt*i);
      Y[i][0] = (float) (dt*i);
    }
    
    for (int i=1; i<numSteps; i++)
    {
      double x =X[i-1][1]; double y = Y[i-1][1];
    
      
      X[i][1] = (float) (x + dt*f(x,y));
      Y[i][1] = (float) (y + dt*g(x,y));
    }

    return X;
  }
  
  public static float[][] getYData(int numSteps, double dt, double x_0, double y_0)
  {
    float[][] X = new float[numSteps][2];
    float[][] Y = new float[numSteps][2];
    
    X[0][1] = (float) x_0;    Y[0][1] = (float) y_0;
    
    for (int i=1; i<numSteps; i++) //add times
    {
      X[i][0] = (float) (dt*i);
      Y[i][0] = (float) (dt*i);
    }
    
    for (int i=1; i<numSteps; i++)
    {
      double x =X[i-1][1]; double y = Y[i-1][1];
    
      
      X[i][1] = (float) (x + dt*f(x,y));
      Y[i][1] = (float) (y + dt*g(x,y));
    }

    return Y;
  }
  
  
  
  
  
  
  
  

  int width=800;
  int height=600;
  int counter = 1;
  int framerate = 2000;
  
  int numSteps = 15000;
  double dx = .001;
  double x_0 = .5;
  double y_0 = .5;
  double x_0_2 = .1;
  double y_0_2 = .2;
  double x_0_3 = .8;
  double y_0_3 = .8;
  
  float[][] X1 =  getXData(numSteps, dx, x_0, y_0);
  float[][] Y1 =  getYData(numSteps, dx, x_0, y_0);  
  float[][] X2 =  getXData(numSteps, dx, x_0_2, y_0_2);
  float[][] Y2 =  getYData(numSteps, dx, x_0_2, y_0_2);
  float[][] X3 =  getXData(numSteps, dx, x_0_3, y_0_3);
  float[][] Y3 =  getYData(numSteps, dx, x_0_3, y_0_3);


  
  public void setup()
  {
    background(0);
    frameRate(framerate);
    size(width, height);
    normalizeData(X1, .2); normalizeData(Y1, .2);
    normalizeData(X2, .2); normalizeData(Y2, .2);
    normalizeData(X3, .2); normalizeData(Y3, .2);
    
/*   
    stroke(255, 0 ,0);
    drawGraph(X1, width, height); //RED

    stroke(0, 0 ,255);
    drawGraph(Y1, width, height); //BLUE
    
    stroke(255, 100 ,0);
    drawGraph(X2, width, height); //ORANGE

    stroke(0, 185, 0);
    drawGraph(Y2, width, height); //GREEN
*/    
  }
  

  
  public void draw()
  {
   
    stroke(255,0,0);
    line(width*X1[counter-1][0], height*(1-X1[counter-1][1]), width*X1[counter][0], height*(1-X1[counter][1]));
    
    stroke(0,0,255);
    line(width*Y1[counter-1][0], height*(1-Y1[counter-1][1]), width*Y1[counter][0], height*(1-Y1[counter][1]));
    
    stroke(255, 100 ,0);
    line(width*X2[counter-1][0], height*(1-X2[counter-1][1]), width*X2[counter][0], height*(1-X2[counter][1]));
    
    stroke(0,185,0);
    line(width*Y2[counter-1][0], height*(1-Y2[counter-1][1]), width*Y2[counter][0], height*(1-Y2[counter][1]));
    
    
    stroke(255, 255 ,0);
    line(width*X3[counter-1][0], height*(1-X3[counter-1][1]), width*X3[counter][0], height*(1-X3[counter][1]));
    
    stroke(255,0,255);
    line(width*Y3[counter-1][0], height*(1-Y3[counter-1][1]), width*Y3[counter][0], height*(1-Y3[counter][1]));
    
    if (counter <numSteps) counter++;
    
  }
  
  public static void main(String[] args)
  {
    PApplet.main(new String[] {"--present", "LVReaction"});
  }

}
