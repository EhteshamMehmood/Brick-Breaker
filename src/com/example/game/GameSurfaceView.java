package com.example.game;


import com.example.game.R;

import android.R.color;
import android.R.string;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import android.media.MediaPlayer;

import android.net.rtp.RtpStream;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.content.Context;;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback{

	boolean gameOver=false;
	int axisX; 
    int axisY;
	private int balCurrPosX;
	private int balCurrPosY;
	
	//for loading images make bitmap vars..
	private Bitmap []tile = new Bitmap[5];   //for tiles(bricks) images..
    
	/*private Bitmap tile2 = null;
    private Bitmap tile3 = null;
    private Bitmap tile4 = null;
    private Bitmap tile5 = null;
    */
    private Bitmap movingStick = null; //for moving bar 
    
    private Bitmap mBall = null;
    
    private Bitmap btnRight=null;
    private Bitmap btnLeft=null;
    
    
//    private MediaPlayer mPlayer;
    private int mHeight; //screen height
    private int mWidth;	//screen width
	private boolean [][]touched;
    private int ballMaxY;
    private int ballMinY;
    private int ballMaxX;
    private boolean moveUp = true;
	private boolean moveRight = true;
	private Paint pnt=null;
	int score;
	int batX;
	private Bitmap gmend=null;

	
    public GameSurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
    
	public GameSurfaceView(Context context,AttributeSet attrSet) {
		super(context);
		// TODO Auto-generated constructor stub
		
		score=0;
		
		touched=new boolean[4][];
		int iMy=0; 
		int jMy=0;		
		for(;iMy<4;iMy++)
		{ 
			touched[iMy]=new boolean[7];
			for(jMy=0;jMy<7;jMy++)
			{
				touched[iMy][jMy]=false;
			}
			
		}
		
		setFocusable(true);
		pnt=new Paint(Paint.ANTI_ALIAS_FLAG);
		 
		pnt.setColor(Color.BLACK);
		pnt.setTextSize(30);
		
//		mPlayer=MediaPlayer.create(context, R.raw.au);
	//	mPlayer.start();
		//mPlayer.setLooping(true);
		
		getHolder().addCallback( this);
		setBackgroundResource(R.drawable.bg_styled_ver);
        
		//()
		
		gmend=BitmapFactory.decodeResource(getResources(),R.drawable.gameover);
		
		tile[0] = BitmapFactory.decodeResource(getResources(), R.drawable.color1);
        tile[1] = BitmapFactory.decodeResource(getResources(), R.drawable.color2);
        tile[2] = BitmapFactory.decodeResource(getResources(), R.drawable.color3);
        tile[3] = BitmapFactory.decodeResource(getResources(), R.drawable.color4);
        tile[4] = BitmapFactory.decodeResource(getResources(), R.drawable.color5);
        
        movingStick = BitmapFactory.decodeResource(getResources(), R.drawable.stick);
        mBall = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        
        btnLeft=BitmapFactory.decodeResource(getResources(), R.drawable.arrow_left);
        btnRight=BitmapFactory.decodeResource(getResources(), R.drawable.arrow_right);
        
	}

	@SuppressLint("DrawAllocation") @Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        mBall=Bitmap.createScaledBitmap(mBall, mBall.getWidth(), mBall.getWidth()	, true);
        axisX=0;
        axisY=100;
        ballMaxX=mWidth;
        
        setMeasuredDimension(mWidth, mHeight);
        batX=(mWidth-movingStick.getWidth())/2;
      
        ballMaxX=mWidth;
        ballMaxY=mHeight-200-mBall.getHeight()/2;
        ballMinY=100;
		balCurrPosX = (mWidth-mBall.getWidth())/2;
		balCurrPosY=ballMaxY;
	}
	
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		//canvas.drawPaint(pnt);
		
		canvas.drawText("Score: "+score, (mWidth/2)-40, mHeight-100, pnt);
		
		for(int i=0;i<4;i++)
		{	
			for(int inr=0;inr<7;inr++)
			{
				int xX=axisX+(tile[1].getWidth()+4)*inr;
				int yY=axisY+(tile[1].getHeight()+5)*i;
				if(!touched[i][inr])
					canvas.drawBitmap(tile[(i*4+inr)%5], xX,yY ,null);
				if(touched[i][inr]==false && balCurrPosX>=xX && balCurrPosX<=xX+tile[1].getWidth() && balCurrPosY>yY && balCurrPosY<=yY+tile[1].getHeight())
				{
					touched[i][inr]=true;
					moveUp=true;
					score++;
				 
					//	Log.d("score", "Score: "+score);
					
				}
				
			}

		}
		
		if(gameOver==true)
		{
			canvas.drawBitmap(gmend,(mWidth-gmend.getWidth())/2, (mHeight-gmend.getHeight())/2,null);
		}
		
		canvas.drawBitmap(movingStick,batX , mHeight-200,null);
		canvas.drawBitmap(mBall, balCurrPosX,balCurrPosY  ,null);
		
		
		
				
		/*
		
		//LINE FOUR
				if(!touched[3][0])
					canvas.drawBitmap(tile4, axisX, axisY+(tile1.getHeight()+5)*3,null);
				if(!touched[3][1])
					canvas.drawBitmap(tile5, axisX+78, axisY+(tile1.getHeight()+5)*3,null);
				if(!touched[3][2])
					canvas.drawBitmap(tile1, axisX+156, axisY+(tile1.getHeight()+5)*3,null);
				if(!touched[3][3])
					canvas.drawBitmap(tile2, axisX+234, axisY+(tile1.getHeight()+5)*3,null);
				if(!touched[3][4])
					canvas.drawBitmap(tile3, axisX+312, axisY+(tile1.getHeight()+5)*3,null);
				if(!touched[3][5])
					canvas.drawBitmap(tile4, axisX+390, axisY+(tile1.getHeight()+5)*3,null);
				if(!touched[3][6])
					canvas.drawBitmap(tile5, axisX+466, axisY+(tile1.getHeight()+5)*3,null);
				
				//LINE THREE
				if(!touched[2][0])
					canvas.drawBitmap(tile3, axisX, axisY+(tile1.getHeight()+5)*2,null);
				if(!touched[2][1])
					canvas.drawBitmap(tile4, axisX+78, axisY+(tile1.getHeight()+5)*2,null);
				if(!touched[2][2])
					canvas.drawBitmap(tile5, axisX+156, axisY+(tile1.getHeight()+5)*2,null);
				if(!touched[2][3])
					canvas.drawBitmap(tile1, axisX+234, axisY+(tile1.getHeight()+5)*2,null);
				if(!touched[2][4])
					canvas.drawBitmap(tile2, axisX+312, axisY+(tile1.getHeight()+5)*2,null);
				if(!touched[2][5])
					canvas.drawBitmap(tile3, axisX+390, axisY+(tile1.getHeight()+5)*2,null);
				if(!touched[2][6])
					canvas.drawBitmap(tile4, axisX+466, axisY+(tile1.getHeight()+5)*2,null);
				

				
				//LINE TWO
				if(!touched[1][0])
					canvas.drawBitmap(tile2, axisX, axisY+tile1.getHeight()+5,null);
				if(!touched[1][1])
					canvas.drawBitmap(tile3, axisX+78,axisY+tile1.getHeight()+5,null);
				if(!touched[1][2])
					canvas.drawBitmap(tile4, axisX+156,axisY+tile1.getHeight()+5,null);
				if(!touched[1][3])
					canvas.drawBitmap(tile5, axisX+234, axisY+tile1.getHeight()+5,null);
				if(!touched[1][4])
					canvas.drawBitmap(tile1, axisX+312,axisY+tile1.getHeight()+5,null);
				if(!touched[1][5])
					canvas.drawBitmap(tile2, axisX+390, axisY+tile1.getHeight()+5,null);
				if(!touched[1][6])
					canvas.drawBitmap(tile3, axisX+466, axisY+tile1.getHeight()+5,null);

				
								
						
		
		//LINE ONE
		if(!touched[0][0])
			canvas.drawBitmap(tile1, axisX, axisY,null);
		if(!touched[0][1])
			canvas.drawBitmap(tile2, axisX+78, axisY,null);
		if(!touched[0][2])
			canvas.drawBitmap(tile3, axisX+156, axisY,null);
		if(!touched[0][3])
			canvas.drawBitmap(tile4, axisX+234, axisY,null);
		if(!touched[0][4])
			canvas.drawBitmap(tile5, axisX+312, axisY,null);
		if(!touched[0][5])
			canvas.drawBitmap(tile1, axisX+390, axisY,null);
		if(!touched[0][6])
			canvas.drawBitmap(tile2, axisX+466, axisY,null);
		
		 */
		

		canvas.drawBitmap(btnLeft, btnLeft.getWidth()/2, mHeight-150,null);
		canvas.drawBitmap(btnRight, mWidth-btnRight.getWidth()-btnRight.getWidth()/2, mHeight-150,null);
	}

	Thread t=new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
			
				while (true) {
				if (balCurrPosY >= ballMaxY+40){
					gameOver=true;
				}
				
				else if(balCurrPosY<=ballMinY ){
					
					moveUp = true;
				}
				if(balCurrPosX>=mWidth){
					moveRight = false;
				}
				else if(balCurrPosX<=0){
					moveRight  = true;
				}
				
				if(moveUp)
				{
					balCurrPosY++;
					//ball with bat??
					if(balCurrPosX>=batX && balCurrPosX<=batX+movingStick.getWidth() && balCurrPosY>mHeight-200 && balCurrPosY<=mHeight-180 )
					{
						moveUp=false;
					}
					
				}
				else
					balCurrPosY--;
				
				if(moveRight)
					balCurrPosX++;
				else
					balCurrPosX--;
				
				Thread.sleep(2);
				postInvalidate();
				}
				
				
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			}
		}
	});

	@SuppressLint("DrawAllocation") 
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		
	}
	
	public void surfaceCreated(SurfaceHolder hokder) {
		// TODO Auto-generated method stub
		t.start();	
	}

	
	public void surfaceDestroyed(SurfaceHolder holder){
		t.interrupt();
		//mPlayer.stop();
		  
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	    int x = (int)event.getX();
	    int y = (int)event.getY();
	    
	    
	   /*  
	    int rightLeft = btnRight.getWidth()/2;
	    int rightRight = (btnRight.getWidth()/2)+btnRight.getWidth();
	    int rightTop = (btnRight.getWidth()/2);
	    int rightBottom = (btnRight.getWidth()/2)+btnRight.getHeight();
	    
	    
	    Rect rLeft=new Rect(leftLeft,leftTop,leftRight,leftBottom); 
	    Rect rRight=new Rect(rightLeft,rightTop,rightRight,rightBottom);
	    
	    if(rLeft.contains((int)event.getX(),(int)event.getY()))
	    {
	    	
	    	Log.d("Touched Right Button","");
	    }
	    if(rRight.contains((int)event.getX(),(int)event.getY()))
	    {
	    	
	    	Log.d("Touched Left Button","");
	    }
	    */
	    
	   
	     if(x>batX+movingStick.getWidth()/2 )
	     {
	    	 if(x<mWidth- 20)
	    	 batX+=50;
	     }
	     else// if(x<batX )
	     {
	    	 if(x>0)
	    	 batX-=50;
	     }
	    
	   Log.d("Nothing","X:"+x+" Y:"+y );
	    
	    
	return false;
	}


}
