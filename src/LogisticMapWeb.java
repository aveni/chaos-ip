import processing.core.PApplet;

public class LogisticMapWeb extends DrawGraphs
{
  int width = 650;
  int height = 650;
  int numSteps = 1000;
  double x_0 = .25;
  double r = 0.1;
  double dr = .005;
  boolean autorun = true;


  public void drawQuad(int width, int height, double r, int numSteps)
  {
    float[][] quad = new float[numSteps][2];   
    for (int i=0; i<numSteps; i++)
    {
      double x = i*(1.0/numSteps);
      quad[i][0] = (float)x;
      quad[i][1] = (float) (r*x*(1-x));
    }
    normalizeXData(quad);
    drawGraph(quad, width, height);
  }

  public void drawLine(int width, int height, int numSteps)
  {
    float[][] line = new float[numSteps][2];
    for (int i=0; i<numSteps; i++)
    {
      line[i][0] = (float) (i*(1.0/numSteps));
      line[i][1] = (float) (i*(1.0/numSteps));
    }
    drawGraph(line, width, height);   
  }

  public void drawWeb(int width, int height, double r, double x_0, int numSteps)
  {
    double curX = x_0;    
    double nextX = r*curX*(1-curX);

    line((float)(width*curX), height, (float)(width*curX), (float)(height*(1-nextX)));
    line((float)(width*curX), (float)(height*(1-nextX)), (float)(width*nextX), (float)(height*(1-nextX)));
    curX = nextX;

    for (int i=0; i<numSteps; i++)
    {
      nextX = r*curX*(1-curX);
      line((float)(width*curX), (float)(height*(1-curX)), (float)(width*curX), (float)(height*(1-nextX)));
      line((float)(width*curX), (float)(height*(1-nextX)), (float)(width*nextX), (float)(height*(1-nextX)));
      curX = nextX; 
    }
  }


  public void drawStats(int width, int height, double r, double x_0, boolean autorun)
  {
    stroke(0);
    fill(255); rect(width-100,height-30,100,30);
    textSize(10); fill(0);   
    text("R-Value: " + ((int)(r*1000 +.5))/1000.0, width-90, height-15);
    text("X-Initial: " + ((int)(x_0*1000 +.5))/1000.0, width-90, height-5);
    if (autorun) text("Autorun ON", 10, 20);
    else text("Autorun OFF", 10, 20);
  }


  public void drawChaos(int width, int height, double r, double x_0, int numSteps)
  {
    stroke(0);
    drawQuad(width, height, r, numSteps); drawLine(width, height, numSteps); 
    stroke(0, 50, 255); drawWeb(width, height, r, x_0, numSteps);  
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
    
    if (keyPressed && keyCode==UP && r<=4-dr) r+=dr;
    if (keyPressed && keyCode==DOWN && r>dr) r-=dr;    
    if (keyPressed && keyCode==RIGHT && x_0<1) x_0+=.005;
    if (keyPressed && keyCode==LEFT && x_0>0) x_0-=.005;
    if (keyPressed && key==BACKSPACE) autorun = false;
    if (keyPressed && key==ENTER) autorun = true;
    if (keyPressed && key=='r') r = 0.1;
    if (autorun && r<=4-dr) r+=dr;   

    drawChaos(width, height, r, x_0, numSteps);
    drawStats(width, height, r, x_0, autorun);
  }


  public static void main(String[] args)
  {
    PApplet.main(new String[] {"--present", "LogisticMapWeb"});
  }

}
