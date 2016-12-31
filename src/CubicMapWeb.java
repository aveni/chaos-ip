import processing.core.PApplet;
public class CubicMapWeb extends LogisticMapWeb
{

  int width = 650;
  int height = 650;
  int numSteps = 1000;
  double x_0 = .1;
  double r = 2.1;
  double dr = .005;
  double scale = .6;
  boolean autorun = false;
  
  public void drawQuad(int width, int height, double r, int numSteps)
  {
    float[][] quad = new float[numSteps][2];   
    for (int i=0; i<numSteps; i++)
    {
      double x = i*(1.0/(numSteps*scale));
      quad[i][0] = (float)x;
      quad[i][1] = (float) (x*(r-x*x)*scale);
    }
    normalizeXData(quad);
    drawGraph(quad, width, height);
  }
  
  public void drawWeb(int width, int height, double r, double x_0, int numSteps)
  {
    double curX = x_0;    
    double nextX = curX*(r-curX*curX);

    line((float)(scale*width*curX), (float)height, (float)(scale*width*curX), (float)(scale*height*(1-nextX) + (1-scale)*height));
    line((float)(scale*width*curX), (float)(scale*height*(1-nextX) + (1-scale)*height), (float)(scale*width*nextX), (float)(scale*height*(1-nextX) + (1-scale)*height));
    curX = nextX;

    for (int i=0; i<numSteps; i++)
    {
      nextX = curX*(r-curX*curX);
      line((float)(scale*width*curX), (float)(scale*height*(1-curX) + (1-scale)*height), (float)(scale*width*curX), (float)(scale*height*(1-nextX) + (1-scale)*height));
      line((float)(scale*width*curX), (float)(scale*height*(1-nextX) + (1-scale)*height), (float)(scale*width*nextX), (float)(scale*height*(1-nextX) + (1-scale)*height));
      curX = nextX; 
    }
  }
  


  public void setup()
  {
    frameRate(40);
    size(width, height); background(255); stroke(0);
    drawChaos(width, height, r, x_0, numSteps);
    drawStats(width, height, r, x_0, autorun);
  }


  public void draw()
  {
    background(255);
    
    if (keyPressed && keyCode==UP && r<=2.5-dr) r+=dr;
    if (keyPressed && keyCode==DOWN && r>dr) r-=dr;    
    if (keyPressed && keyCode==RIGHT && x_0<1) x_0+=.005;
    if (keyPressed && keyCode==LEFT && x_0>0) x_0-=.005;
    if (keyPressed && key==BACKSPACE) autorun = false;
    if (keyPressed && key==ENTER) autorun = true;
    if (keyPressed && key=='r') r = 0.1;
    if (autorun && r<=2.5-dr) r+=dr;   

    drawChaos(width, height, r, x_0, numSteps);
    drawStats(width, height, r, x_0, autorun);
  }
  
  public static void main(String[] args)
  {
    PApplet.main(new String[] {"--present", "CubicMapWeb"});

  }

}
