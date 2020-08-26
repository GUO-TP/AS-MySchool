package com.fragement;

import java.util.ArrayList;
import java.util.List;

import com.adapter.MyBListAdapter;
import com.been.Type;
import com.myschool.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;


public class FenLeiFragment extends Fragment implements OnClickListener{
	    ListView blistView;
	    Context context;
	     Button button_waimai;
	     Button button_kuaidi;
	     Button button_goods;
	     WebView webView;
		String infor[]={"С��","С��","С����","С��"};
		MyBListAdapter myBListAdapter;
		List<Type> list = new ArrayList<Type>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_fenlei, container, false);
		setMenue(v);
		setHasOptionsMenu(true);
		return v;
	}
	//���ò˵�������
	private void setMenue(View v) {
		button_waimai = (Button) v.findViewById(R.id.fenlei_left_btwaimai);
		button_kuaidi = (Button) v.findViewById(R.id.fenlei_left_btkuaidi);
		button_goods = (Button) v.findViewById(R.id.fenlei_left_btgoods);
		webView= (WebView) v.findViewById(R.id.fenlei_right_webview);
		button_waimai.setOnClickListener(this);
		button_kuaidi.setOnClickListener(this);
		button_goods.setOnClickListener(this);
	}
	@Override
	public void onClick(View view) {
		
	     int v=view.getId();
	     switch (v) {
case R.id.fenlei_left_btwaimai:
		//PopupMenu pop = new PopupMenu(context, button_waimai);
		PopupMenu waimaipopup = new PopupMenu(getActivity(),  button_waimai);
		waimaipopup.getMenuInflater().inflate(R.menu.waimaipop, waimaipopup.getMenu());
		waimaipopup.show();
		waimaipopup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				switch (item.getItemId()) {//item.getItemId()��ȡ�˵���id
				case R.id.waimai_getinf:
					//Toast.makeText(context, "���ܵ���ɹ�", Toast.LENGTH_SHORT).show();
					webView.loadUrl("http://192.168.1.107:8080/a_stusys/WaiMai/showAllWaiMai.do");
					//Toast.makeText(getActivity(),"������ʱ������Ӧҳ���ˣ����������waimai����" , 0).show();
					break;
				case R.id.waimai_setinf:
					//Toast.makeText(context, "��������ɹ�", Toast.LENGTH_SHORT).show();
					//Toast.makeText(getActivity(),"������ʱ��������Ӧҳ���ˣ����������waimai����" , 0).show();
					webView.loadUrl("http://192.168.1.107:8080/a_stusys/waimaiAdd.jsp");
					break;
			
				default:
					break;
				}
				
				return true;
			}
		});	
			
				break;
case R.id.fenlei_left_btkuaidi:
				PopupMenu kuaidipopup = new PopupMenu(getActivity(),  button_kuaidi);
				kuaidipopup.getMenuInflater().inflate(R.menu.kuaidipop, kuaidipopup.getMenu());
				kuaidipopup.show();
				kuaidipopup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						switch (item.getItemId()) {//item.getItemId()��ȡ�˵���id
						case R.id.kuaidi_getinf:
							//Toast.makeText(context, "���ܵ���ɹ�", Toast.LENGTH_SHORT).show();
							//Toast.makeText(getActivity(),"������ʱ������Ӧҳ���ˣ����������kuaidi����" , 0).show();
							webView.loadUrl("http://192.168.1.107:8080/a_stusys/KuaiDi/showAllKuaiDi.do");
							break;
						case R.id.kuaidi_setinf:
							//Toast.makeText(context, "��������ɹ�", Toast.LENGTH_SHORT).show();
							//Toast.makeText(getActivity(),"������ʱ��������Ӧҳ���ˣ����������kuaidi����" , 0).show();
							webView.loadUrl("http://192.168.1.107:8080/a_stusys/kuaidiAdd.jsp");
							break;
					
						default:
							break;
						}
						
						return true;
					}
				});	
				break;
case R.id.fenlei_left_btgoods:
	PopupMenu goodspopup = new PopupMenu(getActivity(),  button_goods);
	goodspopup.getMenuInflater().inflate(R.menu.goodspop, goodspopup.getMenu());
	goodspopup.show();
	goodspopup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
		
		@Override
		public boolean onMenuItemClick(MenuItem item) {
			switch (item.getItemId()) {//item.getItemId()��ȡ�˵���id
			case R.id.goods_getinf:
				//Toast.makeText(context, "���ܵ���ɹ�", Toast.LENGTH_SHORT).show();
				//Toast.makeText(getActivity(),"������ʱ������Ӧҳ���ˣ����������goods����" , 0).show();
				webView.loadUrl("http://192.168.1.107:8080/a_stusys/Goods/showAllGoods.do");
				break;
			case R.id.goods_setinf:
				//Toast.makeText(context, "��������ɹ�", Toast.LENGTH_SHORT).show();
				//Toast.makeText(getActivity(),"������ʱ��������Ӧҳ���ˣ����������goods����" , 0).show();
				webView.loadUrl("http://192.168.1.107:8080/a_stusys/goodsAdd.jsp");
				break;
		
			default:
				break;
			}
			
			return true;
		}
	});	
				break;

			default:
				break;
			}
	}
//	@Override
//	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//	    super.onCreateOptionsMenu(menu, inflater);     
//	    inflater.inflate(R.menu.fragment_crime_list, menu);
//	}

}
