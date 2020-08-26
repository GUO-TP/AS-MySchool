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
		//������MainActivity
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
		
//		//���ڴ�ĽǶȿ���
//		if(view==null){
//			//��һ������תΪView��
//			view= ((Activity)context).getLayoutInflater().inflate(R.layout.list_text_view, null);					
//		}
//		
//	
//		//3,��view������TextView���
//		TextView blistview =(TextView)view.findViewById(R.id.textView);
//		
//	
//		//5��׼������
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
		// 1,�Ѳ����ļ�תΪview
		view = View.inflate(context, R.layout.list_text_view, null);
        //2,����������õ�����
		viewHold = new ViewHold();
		
		viewHold.text = (TextView) view.findViewById(R.id.textView);
		
		
		
		view.setTag(viewHold);
	}else{
		viewHold=(ViewHold)view.getTag();
	}

	

	// 9,���Ҫ��ʾ������
	Type type =list.get(index);


	// 11,���ñ���
	String title = type.getTypeinfo();
	if (title.length() > 8) {
		title = title.substring(0, 6) + "...";
	}
	viewHold.text.setText(title);

	
	return view;
}

class ViewHold {
	// 2,���ͼƬ���
	
	TextView text;

}
}
