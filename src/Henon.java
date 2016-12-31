import java.util.Arrays;

import processing.core.PApplet;

public class Henon extends DrawGraphs
{
  int width = 1300 + 2;
  int height = 650;

  public static double getNextX(double x, double y, double a, double b)
  {
    return a - x*x + b*y;
  }

  public static float[][] getXData(double a, double b, int numSteps, double x_0, double y_0)
  {
    float[][] X = new float[numSteps][2];
    float[][] Y = new float[numSteps][2];

    X[0][1] = (float) x_0;    Y[0][1] = (float) y_0;

    for (int i=1; i<numSteps; i++) //add times
    {
      X[i][0] = (float) (i);
      X[i][1] = (float) getNextX(X[i-1][1], Y[i-1][1], a, b);

      Y[i][0] = (float) (i);
      Y[i][1] = X[i-1][1];
    }

    return X;
  }

  public static float[][] getYData(double a, double b, int numSteps, double x_0, double y_0)
  {
    float[][] X = new float[numSteps][2];
    float[][] Y = new float[numSteps][2];

    X[0][1] = (float) x_0;    Y[0][1] = (float) y_0;

    for (int i=1; i<numSteps; i++) //add times
    {
      X[i][0] = (float) (i);
      X[i][1] = (float) getNextX(X[i-1][1], Y[i-1][1], a, b);

      Y[i][0] = (float) (i);
      Y[i][1] = X[i-1][1];
    }

    return Y;
  }

  public static float[][] getXDataControl(double a, double b, int numSteps, double x_0, double y_0)
  {
    double a_0 = a + 0;
    double[][] X = new double[numSteps][2];
    double[][] Y = new double[numSteps][2];

    X[0][1] = x_0;    Y[0][1] = y_0;

    for (int i=1; i<numSteps; i++) //add times
    {

      X[i][0] = i;

      X[i][1] = getNextX(X[i-1][1], Y[i-1][1], a, b);

      Y[i][0] = i;
      Y[i][1] = X[i-1][1];


      //Chaos control
      double x = (X[i][1]);
      double y = (Y[i][1]);

      if (Math.abs(x-y) < .1)
      {
        double A = x*x + (1-b)*x;

        if (Math.abs(a_0 - A) < .2) a = A;
        if (Math.abs(a_0 - A) > .3) a = a_0;
        System.out.println(i + "\t" + x);
      }
    }

    float[][] X2 = new float[numSteps][2];
    for (int i=0; i<numSteps; i++)
    {
      X2[i][0] = (float) X[i][0];
      X2[i][1] = (float) X[i][1];
    }


    return X2;
  }

  public static float[][] getYDataControl(double a, double b, int numSteps, double x_0, double y_0)
  {
    double a_0 = a + 0;
    double[][] X = new double[numSteps][2];
    double[][] Y = new double[numSteps][2];

    X[0][1] = x_0;    Y[0][1] = y_0;

    for (int i=1; i<numSteps; i++) //add times
    {

      X[i][0] = i;

      X[i][1] = getNextX(X[i-1][1], Y[i-1][1], a, b);

      Y[i][0] = i;
      Y[i][1] = X[i-1][1];


      //Chaos control
      double x = (X[i][1]);
      double y = (Y[i][1]);

      if (Math.abs(x-y) < .1)
      {
        double A = x*x + (1-b)*x;

        if (Math.abs(a_0 - A) < .2) a = A;
        if (Math.abs(a_0 - A) > .3) a = a_0;

      }
    }

    float[][] Y2 = new float[numSteps][2];
    for (int i=0; i<numSteps; i++)
    {
      Y2[i][0] = (float) Y[i][0];
      Y2[i][1] = (float) Y[i][1];
    }


    return Y2;
  }





  public void drawGraph(float[][] a, int width, int height, int startW)
  {
    for (int i=1; i<a.length; i++)
    {
      line(startW + width*a[i-1][0], height*(1-a[i-1][1]) - height/2, startW + width*a[i][0], height*(1-a[i][1]) - height/2) ;
    }
  }

  public void plotGraph(float[][] X, float[][] Y, int width, int height)
  {
    stroke(0);

    line(0, height/2, width, height/2);
    line(width/2, 0, width/2, height);

    for (int i=0; i<X.length; i++)
    {
      point(width/2 + width*X[i][1], height*(1-Y[i][1]) - height/2) ;
    } 
  }


  public void setup()
  {
    size(width, height);
    background(255);  
    stroke(255, 0, 0); fill(255, 0, 0); rect(width/2 - 1, 0, 3, height);
    stroke(0);

    double a = 1.4;
    double b = .3;
    int numSteps = 10000;
    int start = 0; int end = 100;
    double x_0 = 0; double y_0 = 0;



    float[][] X = getXData(a, b, numSteps, x_0, y_0);
    float[][] Y = getYData(a, b, numSteps, x_0, y_0);
    float[][] XControl = getXDataControl(a, b, numSteps, x_0, y_0);
    float[][] YControl = getYDataControl(a, b, numSteps, x_0, y_0);

    float[][] Xslice = new float[end-start][2];
    for (int i=0; i<end-start; i++)
    {
      Xslice[i][0] = i; Xslice[i][1] = X[start+i][1];
    }
    float[][] XControlslice = new float[end-start][2];
    for (int i=0; i<end-start; i++)
    {
      XControlslice[i][0] = i; XControlslice[i][1] = XControl[start+i][1];
    }


    normalizeData(Xslice, .25);
//    drawGraph(Xslice, width/2, height, width/2 + 3);
    normalizeData(X, .25); normalizeData(Y, .25);
//    plotGraph(X, Y, width/2 - 1, height);


    normalizeData(XControlslice, .25);
    drawGraph(XControlslice, width/2, height, width/2 + 3);
    normalizeData(XControl, .25); normalizeData(YControl, .25);
    plotGraph(XControl, YControl, width/2 - 1, height);
  }


  public static void main(String[] args)
  {
    PApplet.main(new String[] {"--present", "Henon"});
  }

}
