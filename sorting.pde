PImage img;
int w, h;
boolean enter;

public void setup()
{
  w = 415;
  h = 332;
  img = loadImage("mountain.jpg");
  size(w, h);
  enter = false;
  noLoop();
}

void draw()
{
  if(!enter)
    image(img, 0, 0);
}

void keyPressed()
{
  if((keyCode == RETURN)||(keyCode == ENTER))
  {
    print("enter pressed\n");
    enter = true;
    mess();
  }
  else if(key == 'q') //insertion
  {
    enter = false;
    redraw();
  }
  else if(key == 'w') //selection
  {
    enter = false;
    redraw();
  }
  else if(key == 'e') //bubble
  {
    enter = false;
    redraw();
  }
  else if(key == 'r') //shell
  {
    enter = false;
    redraw();
  }
  else if(key == 't') //merge
  {
    enter = false;
    redraw();
  }
  else if(key == 'y') //heap
  {
    enter = false;
    redraw();
  }
  else if(key == 'u') //quick
  {
    enter = false;
    redraw();
  }
}

void mess()
{
  loadPixels();
  int len = pixels.length;
  for(int i=0; i<len; i++)
  {
    if(i>0)
      loadPixels();
    pixels[len-1-i] = pixels[i];
    updatePixels();
    redraw();
  }
}

void insertionSort()
{
  
}

void selectionSort()
{
  
}

void bubbleSort()
{
  
}

void shellSort()
{
  
}

void mergeSort()
{
  
}

void heapSort()
{
  
}

void quickSort()
{
}

