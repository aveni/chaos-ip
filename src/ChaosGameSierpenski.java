import processing.core.PApplet;

public class ChaosGameSierpenski extends PApplet
{
  int width = 700;
  int height = 650;
  int numSteps = 1000000;
  int i = 0;
  int cX; int cY;
  double ratio = .5;
  
  public void setup()
  {
    size(width, height);
    background(255); 
    stroke(0);
    frameRate(300);
    
    cX = width/2;
    cY = height/2;
  }
  
  public void draw()
  {
    if (i<10)
    {
      int n = (int) (3*Math.random());
            
      if (n==0){ cX += ((width/2 - cX)*ratio); cY = (int) (cY*(1-ratio));}
      if (n==1){ cX +=  ((width - cX) * ratio); cY += (height - cY)*ratio;}
      if (n==2){ cX += -1*cX*ratio; cY += (height - cY)*ratio;}
      
      
      i++;
    }
    
    if (i>=10 && i<1000)
    {
      int n = (int) (3*Math.random());
      
      if (n==0){ cX += ((width/2 - cX)*ratio); cY = (int) (cY*(1-ratio));}
      if (n==1){ cX +=  ((width - cX) * ratio); cY += (height - cY)*ratio;}
      if (n==2){ cX += -1*cX*ratio; cY += (height - cY)*ratio;}
      
      i++; point(cX, cY);
    }
    
    
    
    if (i>=1000 && i<numSteps)
    {
      
      for (int j = 0; j< 1000; j++)
      {
        int n = (int) (3*Math.random());
        
        if (n==0){ cX += ((width/2 - cX)*ratio); cY = (int) (cY*(1-ratio));}
        if (n==1){ cX +=  ((width - cX) * ratio); cY += (height - cY)*ratio;}
        if (n==2){ cX += -1*cX*ratio; cY += (height - cY)*ratio;}
        
        i++; point(cX, cY);
      }     
    }
    
    
  }
}
