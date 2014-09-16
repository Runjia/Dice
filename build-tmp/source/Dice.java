import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die d1;
Die d2;
Die d3;
Die d4;
Die d5;

public void setup()
{
	size(500,500);
	noLoop();
}

public void draw()
{
	background(255,255,255);

	d1=new Die(0,0);
	d2=new Die(400,0);
	d3=new Die(200,200);
	d4=new Die(400,400);
	d5=new Die(0,400);

	d1.show();
	d2.show();
	d3.show();
	d4.show();
	d5.show();
	d1.roll();
	d2.roll();
	d3.roll();
	d4.roll();
	d5.roll();

	d1.addition();//shows the total number of the dots on the dice
}

public void mousePressed()
{
	redraw();
}

class Die //models one single dice cube
{
	int num,myX,myY;
	Die(int x, int y) //constructor
	{
		num=(int)(Math.random()*6+1);
		myX=x;
		myY=y;
	}
	public void roll()
	{
		fill(0);
		if (num==1){
			ellipse(myX+50,myY+50,15,15);
		}
		if(num==2){
			ellipse(myX+90,myY+10,15,15);
			ellipse(myX+10,myY+90,15,15);
		}
		if(num==3){
			ellipse(myX+90,myY+10,15,15);
			ellipse(myX+50,myY+50,15,15);
			ellipse(myX+10,myY+90,15,15);
		}
		if(num==4){
			ellipse(myX+90,myY+10,15,15);
			ellipse(myX+10,myY+90,15,15);
			ellipse(myX+90,myY+90,15,15);
			ellipse(myX+10,myY+10,15,15);
		}
		if(num==5){
			ellipse(myX+90,myY+90,15,15);
			ellipse(myX+90,myY+10,15,15);
			ellipse(myX+10,myY+90,15,15);
			ellipse(myX+10,myY+10,15,15);
			ellipse(myX+50,myY+50,15,15);
		}
		if (num==6){
			ellipse(myX+10,myY+10,15,15);
			ellipse(myX+10,myY+50,15,15);
			ellipse(myX+10,myY+90,15,15);
			ellipse(myX+90,myY+10,15,15);
			ellipse(myX+90,myY+50,15,15);
			ellipse(myX+90,myY+90,15,15);
		}
	}

	public void show()
	{
		int color1=(int)(Math.random()*255+1);
		int color2=(int)(Math.random()*255+1);
		int color3=(int)(Math.random()*255+1);
		fill(color1,color2,color3);
		rect(myX,myY,100,100);	
	}

	public void addition(){
		textSize(20);
		text("Total Number:"+(d1.num+d2.num+d3.num+d4.num+d5.num),160,350);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
