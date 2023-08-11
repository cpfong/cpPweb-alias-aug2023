import java.awt.*;

class Quiz2_1
{
private int x,y,diameter;
private String b_name;
private Color b_color;

Quiz2_1(){
x=y=50;
diameter=20;
b_name="我是氣球";
b_color=Color.red;
new Quiz2_1(x,y,diameter,b_name,b_color);
}

Quiz2_1(int xp, int yp,int bd,String n,Color c){
x=xp;
y=yp;
diameter=bd;
b_name=n;
b_color=c;
}

public void moveRight(int xStep){x=x+xStep;}
public void moveLeft(int xStep){x=x-xStep;}
public void moveUp(int yStep){y=y-yStep;}
public void moveDown(int yStep){y=y+yStep;}

public void changeSize(int change){
diameter=diameter+change;
}

public void display(Graphics paper){
paper.setColor(Color.blue);
paper.drawOval(x,y,diameter,diameter);
paper.setColor(Color.red);
paper.drawString(b_name,x,y);
}
} 