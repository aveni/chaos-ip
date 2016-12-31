import processing.core.PApplet;


public class LogisticMapAnalysis extends LogisticMapWeb
{
  //INPUT
  int width = 650;
  int height = 650;
  int borderWidth = 10;
  int backgroundColor = 160;
  int frameRate = 40;
  
  int numWebSteps = 1000;
  int numGraphSteps = 60;
  double x_0 = .245;
  double dx = .005;
  double r = 0.1;
  double dr = .005;
  boolean autorun = true;
  
  

  public void drawLogisticPlot()
  {
    float[][] data = Logistic_Graph.getData(x_0, r, 1, numGraphSteps);
    normalizeXData(data);
    drawGraph(data, width, height, width+borderWidth, 0);
  }

  public void drawDivider()
  {
    stroke(0); 
    rect(width, 0, borderWidth, height); 
  }

  public void drawAnalysis()
  {       
    drawChaos(width, height, r, x_0, numWebSteps);
    drawLogisticPlot();
    drawDivider(); drawStats(width*2 + borderWidth, height, r, x_0, autorun);
  }

  public void setup()
  {
    frameRate(frameRate);
    stroke(0); fill(0);
    size(2*width + borderWidth, height); background(backgroundColor); 
    drawAnalysis(); 
  }

  public void draw()
  {
    background(backgroundColor);

    if (keyPressed && keyCode==UP && r<=4-dr) r+=dr;
    if (keyPressed && keyCode==DOWN && r>=dr) r-=dr;    
    if (keyPressed && keyCode==RIGHT && x_0<=1-dx) x_0+=dx;
    if (keyPressed && keyCode==LEFT && x_0>=dx) x_0-=dx;
    if (keyPressed && key==BACKSPACE) autorun = false;
    if (keyPressed && key==ENTER) autorun = true;
    if (keyPressed && key=='r') r = 0.1;
    if (autorun && r<=4-dr) r+=dr;  
    else autorun = false;

    drawAnalysis();
  }

  public static void main(String[] args)
  {
    PApplet.main(new String[] {"--present", "LogisticMapAnalysis"});
  }

}
