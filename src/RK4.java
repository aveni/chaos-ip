
public class RK4
{
  public static double f(double t, double x)
  {
    return -1;
  }
  
  public static double k1(double t, double x)
  {
    return f(t, x);
  }
  
  public static double k2(double t, double x, double dt, double k1)
  {
    return f(t + .5*dt, x + .5*k1);
  }
  
  public static double k3(double t, double x, double dt, double k2)
  {
    return f(t + .5*dt, x + .5*k2);
  }
  
  public static double k4(double t, double x, double dt, double k3)
  {
   return f(t + dt, x + k3); 
  }
  
  public static double nextX(double t, double x, double dt)
  {
    double k1 = k1(t, x);
    double k2 = k2(t, x, dt, k1);
    double k3 = k3(t, x, dt, k2);
    double k4 = k4(t, x, dt, k3);
    
    return x + (dt/6.0)*(k1 + 2*k2 + 2*k3 + k4);
  }
}
