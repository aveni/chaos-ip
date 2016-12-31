import java.util.Arrays;

import processing.core.PApplet;

public class DrawGraphs extends PApplet
{

  int width=800;
  int height=600;

  public void setup()
  {
    size(width, height);
    background(255);  
    stroke(0);
/*
    double r = 3.8;
    double stable = (r-1)/r;
    float[][] data = Logistic_Graph.getData(.01, r, 1, 400);
    normalizeData(data, 1);
    drawGraph(data, width, height);
*/
 
    
/*   
    //P 1_13
    double a = .5;
    float[][] xData = P_1_13.getXData(a, 700);
    float[][] yData = P_1_13.getYData(a, 700);
    normalizeData(xData, .85); normalizeData(yData, .85);
      
    stroke(255, 0, 0); drawGraph(xData);//RED
    stroke(0, 0, 255); drawGraph(yData); //BLUE
*/
    
    
    
/*
    // x_0, y_0, r, R, a, t, steps
    float[][] X1 = P_1_7.getXData(.3, .5, .1, 1, 2, .01, 500);
    float[][] Y1 = P_1_7.getYData(.3, .5, .1, 1, 2, .01, 500);


    float[][] X2 = P_1_7.getXData(.4, .4, .1, 1, .5, .01, 10000);
    float[][] Y2 = P_1_7.getYData(.4, .4, .1, 1, .5, .01, 10000);


    normalizeData(X1); normalizeData(Y1); 
    normalizeData(X2); normalizeData(Y2);

    stroke(255, 0 ,0);
    // drawGraph(X1); //RED
    drawGraph(X2); //RED



    stroke(0, 0 ,255);
    // drawGraph(Y1); //BLUE
    drawGraph(Y2); //BLUE
*/

    /*    
    //P 1-22   
    float[][] data = P_1_22.getData(10000, 20);
    System.out.println(Arrays.deepToString(data));
    normalizeData(data);
    drawGraph(data);
     */
  }

  public void normalizeXData(float[][] a)
  {
    float max=-1;
    for (int i=0; i<a.length; i++)
    {
      if (a[i][0] > max) max = a[i][0];
    }
    for (int i=0; i<a.length; i++)
    {
      a[i][0]/=max;
    }
  }

  public void normalizeYData(float[][] a, double scale)
  {
    for (int i=0; i<a.length; i++)
    {
      a[i][1]*=scale;
    } 
  }

  public void normalizeData(float[][] a, double scale)
  {
    normalizeXData(a); normalizeYData(a, scale);
  }


  public void drawGraph(float[][] a, int width, int height)
  {
    for (int i=1; i<a.length; i++)
    {
      line(width*a[i-1][0], height*(1-a[i-1][1]), width*a[i][0], height*(1-a[i][1]));
    }
  }
  
  
  public void drawGraph(float[][] a, int width, int height, int startX, int startY)
  {
    for (int i=1; i<a.length; i++)
    {
      stroke(0, 50, 255);
      line(startX + width*a[i-1][0], startY + height*(1-a[i-1][1]), 
          startX + width*a[i][0], startY + height*(1-a[i][1]));
      
      stroke(255);
      point(startX + width*a[i-1][0], startY + height*(1-a[i-1][1]));
    }
  }

  public static void main(String[] args)
  {
    PApplet.main(new String[] {"--present", "Test"});
  }

}
