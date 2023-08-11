public class DifferentBalloon extends Balloon{
 public DifferentBalloon(int ix, int iy){
   //super();
   Balloon b = new Balloon();
   //Balloon(); does NOT work!
   x=ix;
   y=iy;
   radius=20;
 }
}
