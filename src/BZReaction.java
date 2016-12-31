import java.util.Arrays;

import processing.core.PApplet;




public class BZReaction extends DrawGraphs
{

  
  
  
  public static double f(double x, double y, double z)
  {
    return (.0000762*y - x*y + x*(1-x))/(.0099);
  }

  public static double g(double x, double y, double z)
  {
    return (-.0000762*y - x*y + z)/(.0000198);
  }

  public static double h(double x, double y, double z)
  {
    return x-z;
  }


  public static float[][] getXData(int numSteps, double dt, double x_0, double y_0, double z_0)
  {
    double[][] X = new double[numSteps][2];
    double[][] Y = new double[numSteps][2];
    double[][] Z = new double[numSteps][2];
    

    X[0][1] = x_0;    Y[0][1] = y_0; Z[0][1] = z_0;

    for (int i=1; i<numSteps; i++) //add times
    {
      X[i][0] = (dt*i);
      Y[i][0] = (dt*i);
      Z[i][0] = (dt*i);
    }

    for (int i=1; i<numSteps; i++)
    {
      double x =X[i-1][1]; double y = Y[i-1][1]; double z = Z[i-1][1];


      X[i][1] = (x + dt*f(x,y,z));
      Y[i][1] = (y + dt*g(x,y,z));
      Z[i][1] = (z + dt*h(x,y,z));
    }

    float[][] data = new float[numSteps][2];
    
    for (int i=0; i<numSteps; i++)
    {
      data[i][0] = (float) X[i][0];
      data[i][1] = (float) X[i][1];
    }
    return data;
  }


  public static float[][] getYData(int numSteps, double dt, double x_0, double y_0, double z_0)
  {
    double[][] X = new double[numSteps][2];
    double[][] Y = new double[numSteps][2];
    double[][] Z = new double[numSteps][2];
    

    X[0][1] = x_0;    Y[0][1] = y_0; Z[0][1] = z_0;

    for (int i=1; i<numSteps; i++) //add times
    {
      X[i][0] = (dt*i);
      Y[i][0] = (dt*i);
      Z[i][0] = (dt*i);
    }

    for (int i=1; i<numSteps; i++)
    {
      double x =X[i-1][1]; double y = Y[i-1][1]; double z = Z[i-1][1];


      X[i][1] = (x + dt*f(x,y,z));
      Y[i][1] = (y + dt*g(x,y,z));
      Z[i][1] = (z + dt*h(x,y,z));
    }

    float[][] data = new float[numSteps][2];
    
    for (int i=0; i<numSteps; i++)
    {
      data[i][0] = (float) Y[i][0];
      data[i][1] = (float) Y[i][1];
    }
    return data;
  }

  public static float[][] getZData(int numSteps, double dt, double x_0, double y_0, double z_0)
  {
    double[][] X = new double[numSteps][2];
    double[][] Y = new double[numSteps][2];
    double[][] Z = new double[numSteps][2];
    

    X[0][1] = x_0;    Y[0][1] = y_0; Z[0][1] = z_0;

    for (int i=1; i<numSteps; i++) //add times
    {
      X[i][0] = (dt*i);
      Y[i][0] = (dt*i);
      Z[i][0] = (dt*i);
    }

    for (int i=1; i<numSteps; i++)
    {
      double x =X[i-1][1]; double y = Y[i-1][1]; double z = Z[i-1][1];


      X[i][1] = (x + dt*f(x,y,z));
      Y[i][1] = (y + dt*g(x,y,z));
      Z[i][1] = (z + dt*h(x,y,z));
    }

    float[][] data = new float[numSteps][2];
    
    for (int i=0; i<numSteps; i++)
    {
      data[i][0] = (float) Z[i][0];
      data[i][1] = (float) Z[i][1];
    }
    return data;
  }








  int width=800;
  int height=600;
  int counter = 1;
  int framerate = 2000;

  int numSteps = 1000000;
  double dt = .00001;
  double x_0 = .1;
  double y_0 = .1;
  double z_0 = .1;

  float[][] X1 =  getXData(numSteps, dt, x_0, y_0, z_0);
  float[][] Y1 =  getYData(numSteps, dt, x_0, y_0, z_0); 
  float[][] Z1 =  getZData(numSteps, dt, x_0, y_0, z_0);




  public void setup()
  {
    background(0);
    frameRate(framerate);
    size(width, height);
    normalizeData(X1, 1); normalizeData(Y1, 1.0/1500); normalizeData(Z1,4);

    System.out.println(Arrays.deepToString(Y1));
       
      stroke(255, 0 ,0);
      drawGraph(X1, width, height); //RED

      stroke(0, 0 ,255);
      //drawGraph(Y1, width, height); //BLUE

        
  }



  public void draw()
  {
/*
    stroke(255,0,0);
    line(width*X1[counter-1][0], height*(1-X1[counter-1][1]), width*X1[counter][0], height*(1-X1[counter][1]));

    stroke(0,255,0);
   // line(width*Y1[counter-1][0], height*(1-Y1[counter-1][1]), width*Y1[counter][0], height*(1-Y1[counter][1]));

    stroke(0,0,255);
   // line(width*Z1[counter-1][0], height*(1-Z1[counter-1][1]), width*Z1[counter][0], height*(1-Z1[counter][1]));
   
    if (counter <numSteps) counter++;
*/
  }

  public static void main(String[] args)
  {
    PApplet.main(new String[] {"--present", "BZReaction"});
  }

}

