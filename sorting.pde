PImage img;
int w, h;
boolean enter;

public void setup()
{
  w = 415;
  h = 332;
  //source: http://www.destination360.com/north-america/us/wyoming/rocky-mountains
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
    print("insertion!\n");
    enter = false;
    redraw();
    insertionSort();
  }
  else if(key == 'w') //selection
  {
    print("selection!\n");
    enter = false;
    redraw();
    selectionSort();
  }
  else if(key == 'e') //bubble
  {
    print("bubble!\n");
    enter = false;
    redraw();
    bubbleSort();
  }
  else if(key == 'r') //shell
  {
    print("shell!\n");
    enter = false;
    redraw();
    shellSort();
  }
  else if(key == 't') //merge
  {
    print("merge!\n");
    enter = false;
    redraw();
    mergeSort();
  }
  else if(key == 'y') //heap
  {
    print("heap!\n");
    enter = false;
    redraw();
    heapSort();
  }
  else if(key == 'u') //quick
  {
    print("quick!\n");
    enter = false;
    redraw();
    quickSort();
  }
}

void mess()
{
  loadPixels();
  int len = pixels.length;
  for(int i=0; i<(len/2); i++)
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

