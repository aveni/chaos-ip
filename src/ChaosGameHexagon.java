import processing.core.PApplet;

public class ChaosGameHexagon extends PApplet
{
  
  int height = 700;
  int width = (int)(1.15470053838*height);
  int numSteps = 1000000;
  int i = 0;
  int cX; int cY;
  double ratio = 2.0/3;
  
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
    if (i<20)
    {
      int n = (int) (6*Math.random());
           
      if (n==0){ cX += ((width/4 - cX)*ratio); cY += (int) (-1*cY*ratio);}
      if (n==1){ cX += ((3*width/4 - cX)*ratio); cY += (int) (-1*cY*ratio);}
      
      if (n==2){ cX +=  ((width - cX) * ratio); cY += (height/2 - cY)*ratio;}
      if (n==3){ cX +=  ((- cX) * ratio); cY += (height/2 - cY)*ratio;}
      
      if (n==4){ cX += ((width/4 - cX)*ratio); cY += (int) ((height - cY)*ratio);}
      if (n==5){ cX += ((3*width/4 - cX)*ratio); cY += (int) ((height - cY)*ratio);}
      
      
      i++;
    }
    
    if (i>=20 && i<300)
    {
      int n = (int) (6*Math.random());
      
      if (n==0){ cX += ((width/4 - cX)*ratio); cY += (int) (-1*cY*ratio);}
      if (n==1){ cX += ((3*width/4 - cX)*ratio); cY += (int) (-1*cY*ratio);}
      
      if (n==2){ cX +=  ((width - cX) * ratio); cY += (height/2 - cY)*ratio;}
      if (n==3){ cX +=  ((- cX) * ratio); cY += (height/2 - cY)*ratio;}
      
      if (n==4){ cX += ((width/4 - cX)*ratio); cY += (int) ((height - cY)*ratio);}
      if (n==5){ cX += ((3*width/4 - cX)*ratio); cY += (int) ((height - cY)*ratio);}
      
      i++; point(cX, cY);
    }
    
    
    
    if (i>=300 && i<numSteps)
    {
      
      for (int j = 0; j< 10000; j++)
      {
        int n = (int) (6*Math.random());
        
        if (n==0){ cX += ((width/4 - cX)*ratio); cY += (int) (-1*cY*ratio);}
        if (n==1){ cX += ((3*width/4 - cX)*ratio); cY += (int) (-1*cY*ratio);}
        
        if (n==2){ cX +=  ((width - cX) * ratio); cY += (height/2 - cY)*ratio;}
        if (n==3){ cX +=  ((- cX) * ratio); cY += (height/2 - cY)*ratio;}
        
        if (n==4){ cX += ((width/4 - cX)*ratio); cY += (int) ((height - cY)*ratio);}
        if (n==5){ cX += ((3*width/4 - cX)*ratio); cY += (int) ((height - cY)*ratio);}
        
        i++; point(cX, cY);
      }     
    }
    
    
  }
}
