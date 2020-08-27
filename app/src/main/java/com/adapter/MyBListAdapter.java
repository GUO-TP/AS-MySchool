package com.adapter;

import java.util.List;
import com.been.Type;
import com.myschool.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class MyBListAdapter extends BaseAdapter {
	
	List<Type> list;
	
	Context context;
	
	int length ;
	
	public MyBListAdapter(List<Type> lists,Context context){
		this.list=lists;
		//它代表MainActivity
		this.context=context;
		length=list.size();
	}

	@Override
	public int getCount() {
		
		return length;
	}

	@Override
	public Object getItem(int arg0) {
	
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		
		return arg0;
	}

	@Override
	public View getView(int index, View view, ViewGroup arg2) {
		
//		//从内存的角度考虑
//		if(view==null){
//			//把一个布局转为View，
//			view= ((Activity)context).getLayoutInflater().inflate(R.layout.list_text_view, null);					
//		}
//		
//	
//		//3,从view里面获得TextView组件
//		TextView blistview =(TextView)view.findViewById(R.id.textView);
//		
//	
//		//5，准备数据
//		Type type =list.get(index);
//
//		
//		String infor =type.getTypeinfo();
//		blistview.setText(infor);
//		
//		
//		return view;
//	}
	ViewHold viewHold=null;
	if (view == null) {
		// 1,把布局文件转为view
		view = View.inflate(context, R.layout.list_text_view, null);
        //2,创建存放引用的容器
		viewHold = new ViewHold();
		
		viewHold.text = (TextView) view.findViewById(R.id.textView);
		
		
		
		view.setTag(viewHold);
	}else{
		viewHold=(ViewHold)view.getTag();
	}

	

	// 9,获得要显示的数据
	Type type =list.get(index);


	// 11,设置标题
	String title = type.getTypeinfo();
	if (title.length() > 8) {
		title = title.substring(0, 6) + "...";
	}
	viewHold.text.setText(title);

	
	return view;
}

class ViewHold {
	// 2,获得图片组件
	
	TextView text;

}
}
