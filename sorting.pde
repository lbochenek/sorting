PImage img;
int w, h;
boolean used;

public void setup()
{
  w = 415;
  h = 332;
  //source: http://www.destination360.com/north-america/us/wyoming/rocky-mountains
  img = loadImage("mountain.jpg");
  size(w, h);
  used = false;
  noLoop();
}

void draw()
{
  if(!used)
    image(img, 0, 0);
}

void keyPressed()
{
  used = false;
  redraw();
  if((keyCode == RETURN)||(keyCode == ENTER))
  {
    print("enter pressed\n");
    mess();
  }
  else if(key == 'q') //insertion
  {
    print("insertion!\n");
    redraw();
    insertionSort();
  }
  else if(key == 'w') //selection
  {
    print("selection!\n");
    redraw();
    selectionSort();
  }
  else if(key == 'e') //bubble
  {
    print("bubble!\n");
    redraw();
    bubbleSort();
  }
  else if(key == 'r') //shell
  {
    print("shell!\n");
    redraw();
    shellSort();
  }
  else if(key == 't') //merge
  {
    print("merge!\n");
    redraw();
    mergeSort();
  }
  else if(key == 'y') //heap
  {
    print("heap!\n");
    redraw();
    heapSort();
  }
  else if(key == 'u') //quick
  {
    print("quick!\n");
    redraw();
    quickSort();
  }
}

void mess()
{
  used = true;
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
  used = true;
  loadPixels();
  int len = pixels.length;
  for(int j=1; j<len; j++)
  {
    if(j>1)
      loadPixels();
    int key = pixels[j];
    int i = j-1;
    while((i > 0)&&(pixels[i]>key))
    {
      pixels[i+1] = pixels[i];
      i--;
    }
    pixels[i+1] = key;
    updatePixels();
    redraw();
  }
}

void selectionSort()
{
  used = true;
  loadPixels();
  int len = pixels.length;
  for(int i=0; i<len; i++)
  {
    if(i>0)
      loadPixels();
    int key = pixels[i];
    int smallest = i;
    for(int j=i; j<len; j++)
    {
      if(pixels[j] < pixels[smallest])
        smallest = j;
    }
    pixels[i] = pixels[smallest];
    pixels[smallest] = key;
    updatePixels();
    redraw();
  }
}

void bubbleSort()
{
    used = true;
    loadPixels();
    int len = pixels.length;
    for(int i=0; i<len-1; i++)
    {
      if(i>0)
        loadPixels();
      for(int j=len-1; j>=(i+1); j--)
      {
        if (pixels[j] < pixels[j-1])
        {
          int t = pixels[j];
          pixels[j] = pixels[j-1];
          pixels[j-1] = t;
        }  
      }
      updatePixels();
      redraw();
    }
}

void shellSort()
{
    used = true;
    loadPixels();
    int len = pixels.length;
    int interval = floor(len/2);
    while(interval > 0)
    {
      for(int i=0; i<interval; i++)
      {
        if(i>0)
          loadPixels();
        for(int j=i+interval; j<len; j+=interval)
        {
          if(pixels[j-interval] > pixels[j])
          {
            swap(j, interval);
          }
        }
        updatePixels();
        redraw();
      }
      interval = floor(interval/2);
    }
}

void swap(int ind, int inter)
{
  if(ind < inter)
    return;
  if(pixels[ind-inter] > pixels[ind])
  {
    int t = pixels[ind];
    pixels[ind] = pixels[ind-inter];
    pixels[ind-inter] = t;
  }
  else
    return;
    
  swap((ind-inter), inter);
}

void mergeSort()
{
    used = true;
}

void heapSort()
{
    used = true;
}

void quickSort()
{
    used = true;
}

