import processing.core.*;

import java.awt.Frame;

public class sort extends PApplet
{
	PImage img;
	int w, h;
	boolean used; 
	static boolean clicked;
	Buttons b;

	public void setup()
	{
//	  w = 415;
//	  h = 332;
	  //hello
	  w = 300;
	  h = 300;
	  //source: http://www.destination360.com/north-america/us/wyoming/rocky-mountains
	  img = loadImage("mountainbw.jpg");
	  size(w, h);
	  used = false;
	  clicked = false;
	  noLoop();
	  //multiple windows: https://processing.org/discourse/beta/num_1243505183.html
	  new PFrame();
	}

	public void draw()
	{
	  if(!used)
	    image(img, 0, 0);
	  
	  if(clicked)
	  {
		  fill(176, 23, 31);
		  ellipse(50, 50, 50, 50);
	  }
	  
	}

	public void keyPressed()
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
	    insertionSort();
	  }
	  else if(key == 'w') //selection
	  {
	    print("selection!\n");
	    selectionSort();
	  }
	  else if(key == 'e') //bubble
	  {
	    print("bubble!\n");
	    bubbleSort();
	  }
	  else if(key == 'r') //shell
	  {
	    print("shell!\n");
	    shellSort();
	  }
	  else if(key == 't') //merge
	  {
	    print("merge!\n");
	    try {
			mergeSort();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  else if(key == 'y') //heap
	  {
	    print("heap!\n");
	    heapSort();
	  }
	  else if(key == 'u') //quick
	  {
	    print("quick!\n");
	    quickSort();
	  }
	  used = false;
	  redraw();
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
	  System.out.println("mess done!");
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
	  System.out.println("insertion done!");
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
	  System.out.println("selection done!");
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
	    System.out.println("bubble done!");
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
	    System.out.println("shell done!");
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

	void mergeSort() throws InterruptedException
	{
		used = true;
//		int pixels[] = {6,8,4,1,9,5};
	    loadPixels();
	    int len = pixels.length;
	    int newlen = len/2;
	    updatePixels();
	    
	    divide(pixels);
	    Thread.sleep(500);
//	    printPix(pixels);
	    System.out.println("done merge!");
	}
	
	int[] divide(int[] array)
	{
		int len = array.length;
		if (len == 1){
			return array;
		}
		else{
		    int newlen = len/2;
			int left[] = new int[newlen];
		    int right[] = new int[len - newlen];
		    System.arraycopy(array, 0, left, 0, newlen);
		    System.arraycopy(array, newlen, right, 0, len - newlen);
		    left = divide(left);
		    right = divide(right);
		    int[] res = mSort(left, right);
		    return res;
		}
	}
	
	int[] mSort(int[] left, int[] right)
	{
		loadPixels();
		int len = left.length + right.length;
		int[] res = new int[len];
		int i, r, l;
		for(i=0, r=0, l=0; i<len&&r<right.length&&l<left.length; i++ ){
			if(left[l] < right[r])
			{
				res[i] = left[l];
				l++;
			}
			else
			{
				res[i] = right[r];
				r++;
			}
		}
		
		if(i<len)
		{
			if(l<left.length)
			{
				System.arraycopy(left, l, res, i, len-i);
			}
			else if(r<right.length)
			{
				System.arraycopy(right, r, res, i, len-i);
			}
		}
		
		System.arraycopy(res, 0, pixels, 0, res.length);
		
		updatePixels();
	    redraw();
		
		return res;

	}
	
	void printPix(int[] p)
	{
		for(int i=0; i<p.length; i++)
		{
			System.out.printf("%d ", p[i]);
		}
		System.out.println();
	}

	void heapSort()
	{
	    used = true;
	}

	void quickSort()
	{
	    used = true;
	}
	
	public class PFrame extends Frame
	{
		public PFrame()
		{
			setBounds(300, 300, 400, 300);
			b = new Buttons();
			add(b);
			b.init();
			setVisible(true);
		}
	}
	

}
