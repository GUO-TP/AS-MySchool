package com.fs.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class MyScollview extends ScrollView{  
	
	private static final String TAG = "ScrollviewEdit";
    private ScrollView parent_scrollview;
    int currentY;
    public MyScollview(Context context) {  
        super(context);  
    }  
  
    public MyScollview(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }  
  
    @Override  
    public boolean onInterceptTouchEvent(MotionEvent ev) { 
    	 if (parent_scrollview == null) {
    		 
             return super.onInterceptTouchEvent(ev);
         } else {
             if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                 // 将父scrollview的滚动事件拦截
                 currentY = (int) ev.getY();
                 setParentScrollAble(false);
                
                 return super.onInterceptTouchEvent(ev);
             } else if (ev.getAction() == MotionEvent.ACTION_UP) {
                 // 把滚动事件恢复给父Scrollview
                 setParentScrollAble(true);
             } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
             }
         }
         return super.onInterceptTouchEvent(ev);
    	
       // return false;  
    }  
    private void setParentScrollAble(boolean flag) {
        parent_scrollview.requestDisallowInterceptTouchEvent(!flag);
    }
    
}  