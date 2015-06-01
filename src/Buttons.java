import processing.core.PApplet;

public class Buttons extends PApplet
{
	sort s;
	public void setup()
	{
		size(400, 300);
		s = new sort();
	}
	
	public void draw()
	{
		background(0);
	}
	
	public void mouseClicked()
	{
		if(sort.clicked = true)
			sort.clicked = false;
		else
			sort.clicked = true;
		s.redraw();
	}
	
	
}
