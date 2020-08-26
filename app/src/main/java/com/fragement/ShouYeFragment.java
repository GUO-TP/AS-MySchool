package com.fragement;

import com.been.Singer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.adapter.MyAListAdapter;
import com.adapter.MyAListAdapter2;
import com.adapter.MyGridAdapter;
import com.adapter.MyPagerAdapter;
import com.been.Advertisement;
import com.been.Goods;
import com.been.HomeData;
import com.been.News;
import com.been.NewsData;
import com.been.RadioList;
import com.been.Slider;
import com.fs.widget.Constant;
import com.myschool.MainActivity;
import com.myschool.R;
import com.myschool.ShowActivity;
import com.net.OnMyResponse;
import com.net.ServerApi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class ShouYeFragment extends Fragment {
	View view;
	int index;
	GridView gridView;
	ListView alistView;
	Context context;
	MyGridAdapter myGridAdapter;
	MyAListAdapter myAListAdapter;
	MyAListAdapter2 myAListAdapter2;
	//List<Advertisement> slider=new ArrayList<Advertisement>();
//	List<Goods> list = new ArrayList<Goods>();
//	List<Singer> lists;
//	int image[] = { R.drawable.singer_1, R.drawable.singer_2,
//			R.drawable.singer_3, R.drawable.singer_4, R.drawable.singer_5,
//			R.drawable.singer_6, R.drawable.singer_7, R.drawable.singer_8,
//			R.drawable.singer_9, R.drawable.singer_10 };
//	String name[] = { "容祖儿", "徐佳莹", "李克勤", "黄致列", "金志文", "张信哲", "李玟", "老狼",
//			"坂本龍一", "孝敏" };
//	String introduces[] = {
//			"容祖儿（Joey Yung），1980年6月16日生于中国香港，中国香港女歌手。香港英皇集团旗下艺人。",
//			"徐佳莹，台湾创作女歌手。2008年参加第三届《超级星光大道》夺得冠军，踏入歌坛。发表《LaLa首张创作专辑》、《理想人生》等作品，创作实力备受肯定。",
//			"李克勤，香港著名粤语流行曲歌手、演员、主持人，擅长演绎多种曲风，以浪漫情歌和励志快歌为主，声线以高、清、亮见称，有“零瑕疵歌手”的美誉；曾荣获十大劲歌金曲榜“最受欢迎男歌手”、香港杰出歌手奖、港台最佳流行男歌手等音乐奖项。",
//			"黄致列，1982年12月3日出生，韩国男歌手。2007年2月13日发行首张单曲专辑《致列》正式出道。2015年2月以选手身份出演Mnet《看见你的声音》被再次关注。2016年，黄致列参与中国《我是歌手》节目。",
//			"金志文，内地男歌手、唱作型艺人、专职音乐编曲。2007年发行首张个人专辑《兄弟小文》，主打歌《左眼皮跳跳》风靡网络；2012年参加《中国好声音》，重新演绎刘若英经典单曲《为爱痴狂》而受到关注。个人专辑作品，《爱比不爱更寂寞》、《图门江一号》、《梦想·家》等。",
//			"张信哲，台湾知名男歌手。其嗓音清澈而明亮，尤其擅长抒情慢歌，是华语乐坛公认的“情歌王子”。凭第一张专辑《说谎》一炮而红，在20世纪90年代与叱咤华语乐坛的“四大天王”齐名。服役退伍后重返歌坛，演唱《难以抗拒你容颜》依旧畅销。",
//			"李玟（CoCo Lee），国际流行歌手。1993年获香港TVB新人歌唱大赛亚军，崭露头角；1994年转战台湾发片并成名；1999年转签美国Sony Music，进军国际乐坛，发行《Just No Other Way》、《Exposed》等英文专辑；",
//			"狼，原名王阳，内地男歌手，发表《同桌的你》、《恋恋风尘》等音乐作品。",
//			"1952年出生于日本东京。东京艺术大学硕士毕业。1978年以专辑《Thousand Knives》出道。同年与细野晴臣、高桥幸宏一起组成YMO。组合解散之后，坂本龙一活跃在音乐、电影、出版、广告等媒体方面。1982年，与矢野显子结婚。",
//			"朴孝敏（Park Hyo Min ，박효민），1989年5月30日出生于韩国釜山，毕业于成均馆大学，韩国女歌手、演员，女子演唱团体T-ara成员之一。2009年7月29日以演唱团体T-ara正式出道；同年10月在韩国KBS电视台综艺节目《青春不败》担任固定嘉宾。2012年6月，参演韩国SBS连续剧《我的女友是九尾狐》。" };
//	int images[] = { R.drawable.g1, R.drawable.g2, R.drawable.g3,R.drawable.g4, 
//	     R.drawable.g5,R.drawable.g6,R.drawable.g7,R.drawable.g8
//	    };
//	String names[] = { "1" ,"2","3","4","5","6","7","8",
//			};
//    String urls[]={"https://img.alicdn.com/simba/img/TB1VwS9XVHM8KJjSZFwSuwibXXa.jpg",
//    		"https://img.alicdn.com/simba/img/TB1jisgX3nD8KJjy1XdSuuZsVXa.jpg",
//    		"https://img.alicdn.com/tps/i4/TB1zINGbnnI8KJjy0FfSuwdoVXa.jpg_1080x1800Q75s50.jpg",
//    		"https://img.alicdn.com/tps/i4/TB1g0xiiLBNTKJjy0FdSuwPpVXa.jpg",
//    		"https://img.alicdn.com/tps/i4/TB1ef3lahHI8KJjy1zbSuuxdpXa.jpg"};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		context = inflater.getContext();
		view = inflater.inflate(R.layout.fragment_main, container, false);
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	// 和Activity断开联系
	@Override
	public void onDetach() {
		Log.i("hq", "onDetach");
		super.onDetach();
	}
	ViewPager viewPager;
	// 定义一个点集合
	private List<View> dots;

	private int oldPosition = 0;// 记录上一次点的位置

	private int currentItem; // 当前页面
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getWidget();
		// 2,联网请求数据
		getDataFromNet();
        
		//getGridinit();
		//setViewPagerData(slider);
        getAListinit();
        
        //setAListDataFromNet();
	}
	

	

	/**
	 * 获得组件
	 */
	private void getWidget() {
		getViewPager();
		// getAListinit();
	}

	int widthViewPager;
	int heightViewPager;

	private void getViewPager() {
		// 1,获得viewPager对象
		viewPager = (ViewPager) view.findViewById(R.id.reconmendFragmentViewPager);
		// 2,设置宽度和高度
	//setviewPager();
	//	viewPager.getLayoutParams().width = widthViewPager = Constant.width;
	//	viewPager.getLayoutParams().height = heightViewPager = Constant.height / 4;

		
		// 2,实现view动态的监听
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				//index=position;
			}

			@Override
			public void onPageSelected(int position) {

				// 1,获取上一个位置，并且把点的状体设置成默认状体
				dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
				// 2,获取到选中页面对应的点，设置为选中状态
				dots.get(position).setBackgroundResource(R.drawable.dot_focused);
				// 下面是记录本次的位置，因为在滑动，他就会变成过时的点了
				oldPosition = position;
				// 关联页卡
				currentItem = position;
				index=position;
//				Timer timer = new Timer();
//			    TimerTask task = new TimerTask() {
//			        @Override
//			        public void run() {
//			            try {
//			              index=index+1; 
//			            	
//			            	
//			            	
//			            } catch (Exception e) {
//			                e.printStackTrace();
//			            }
//			        }
//			    };
			

		
//				int pageIndex = position;
//				 if (position == 0) {  
//			            // 当视图在第一个时，将页面号设置为图片的最后一张。  
//			            pageIndex = pics.length;  
//			        } else if (position== pics.length + 1) {  
//			            // 当视图在最后一个是,将页面号设置为图片的第一张。  
//			            pageIndex = 1;  
//			        }  
//			        if (position != pageIndex) {  
//			            viewPager.setCurrentItem(pageIndex, false);  
//			            return;  
//			        }  
			}

			@Override
			public void onPageScrollStateChanged(int state) {
				
//				 int currentItem =viewPager.getCurrentItem();
//                 Intent it = new Intent();
//                 it.setClass(getActivity(), ShowActivity.class);
//                 it.putExtra("story_id",currentItem );
//                 startActivity(it);
			}
		});
		
		viewPager.setOnTouchListener(new View.OnTouchListener() {
            int touchFlag = 0;
            float x = 0, y = 0;
            ViewConfiguration configuration = ViewConfiguration.get(context);
    		int mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        touchFlag = 0;
                       x = event.getX();
                        y = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                       float xDiff = Math.abs(event.getX() - x);
                        float yDiff = Math.abs(event.getY() - y);
                       if (xDiff < mTouchSlop && xDiff >= yDiff)
                            touchFlag = 0;
                       else
                           touchFlag = -1;
                        break;
                    case MotionEvent.ACTION_UP:
                        if (touchFlag == 0) {
                            int currentItem =viewPager.getCurrentItem();
                             
                            Log.e("guotp", ""+currentItem);
                            Toast.makeText(context, ""+currentItem, 0);
                            Intent it = new Intent();
                            it.setClass(getActivity(), ShowActivity.class);
                          //用Bundle携带数据
                            Bundle bundle=new Bundle();
                            //传递name参数为tinyphp
                            bundle.putString("name", ""+currentItem);
                            it.putExtras(bundle);
                           // it.putExtra("viewid",currentItem );
                           // it.putExtra("viewid",1 );
                            startActivity(it);
                        }
                        break;
                }
                return false;
            }
        });
		
		
		
	}
	
//private void setviewPager() {
//		// TODO Auto-generated method stub
//	int length = urls.length;
//	// 2,根据图片的长度创建数据
//	for (int i = 0; i < length; i++) {
//		// 3,根据每项的数据创建歌手对象，每个对象对应一个列表项
//		Advertisement ad=new Advertisement(urls[i]);
//		slider.add(ad);
//	
//	}
//	}

private void getDotView(int length) {
		
	// 1,装点点的集合
	dots = new ArrayList<View>();
	// 3,显示点的容器
	LinearLayout linearLayout = (LinearLayout) view
			.findViewById(R.id.reconmendFragmentDotViewLayout);
	for (int i = 0; i < length; i++) {
		// 4,创建点视图
		View dotView = new View(context);
		// 5,把点视图放到显示的容器
		linearLayout.addView(dotView);
		// 6,设置点的背景图片
		dotView.setBackgroundResource(R.drawable.dot_normal);
		// 7,设置点的宽度和高度
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(8, 8);
		params.leftMargin = 5;
		params.rightMargin = 5;
		// 8,设置点的参数
		dotView.setLayoutParams(params);
		// 9,把点的参数放到管理的容器
		dots.add(dotView);
	}
	// 3,并且，默认第一个是选中状态
	dots.get(0).setBackgroundResource(R.drawable.dot_focused);
	}




//	private void getGridinit() {
// 
//		// TODO Auto-generated method stub
//		gridView = (GridView) getActivity().findViewById(R.id.shouye_gridView);
//		setData();
//		myGridAdapter = new MyGridAdapter(list, context);
//		gridView.setAdapter(myGridAdapter);
//	}
//
//	private void setData() {
//		// TODO Auto-generated method stub
//		int length = images.length;
//		// 2,根据图片的长度创建数据
//		for (int i = 0; i < length; i++) {
//			// 3,根据每项的数据创建歌手对象，每个对象对应一个列表项
//			Goods singer = new Goods(images[i], names[i]);
//			// 4,把歌手对象添加到列表里面
//			list.add(singer);
//		}
//	}
	/**
	 * 从网上获得数据
	 */
	String url = "https://c.y.qq.com/musichall/fcgi-bin/fcg_yqqhomepagerecommend.fcg?g_tk=5381&uin=0&format=json&inCharset=utf-8&outCharset=utf-8&notice=0&platform=h5&needNewCode=1&_=1507434287475";
	String url2 ="http://192.168.1.107:8080/a_stusys/News/showAllNews.do";
	private void getDataFromNet() {
		ServerApi serverApi = new ServerApi(context);
		serverApi.getData(url, new OnMyResponse() {

			@Override
			public void onResponse(Object ob) {
				// 1,获得联网的数据
				
				HomeData homeData = (HomeData) ob;
				// 2,把数据给viewPager
				setViewPagerData(homeData.data.slider);
				   //setViewPagerData(Advertisement);
			//	serGridViewDate(homeData.data.slider);
			}
		}, HomeData.class);
//		serverApi.getData(url2, new OnMyResponse() {
//
//			@Override
//			public void onResponse(Object ob) {
//				// 1,获得联网的数据
//				
//				NewsData newsData =(NewsData) ob;
//				//List<News> news=(List<News>) ob;
//				System.out.println(newsData);
////				// 2,把数据给viewPager
//				setViewPagerData(newsData.news);
//				   //setViewPagerData(Advertisement);
//			//	serGridViewDate(homeData.data.slider);
//			}
//		}, NewsData.class);
		

	}
	
//	protected void serGridViewDate(List<Slider> slider) {
//		// TODO Auto-generated method stub
//	//	myGridAdapter = new MyGridAdapter(slider, context);
//		myGridAdapter = new MyGridAdapter(list, context);
//		gridView.setAdapter(myGridAdapter);
//		
//	}
	
	MyPagerAdapter myPagerAdapter;
	//private void setViewPagerData(List<Advertisement> slider) {
	//private void setViewPagerData(List<News> slider) {
	private void setViewPagerData(List<Slider> slider) {
		// 1,创建适配器，并且传入数据
		myPagerAdapter = new MyPagerAdapter(slider, context);
		// 2,显示视图
		
		viewPager.setAdapter(myPagerAdapter);
		// 3,创建显示的圆点
		getDotView(slider.size());
	}
	
	private void getAListinit() {
		// TODO Auto-generated method stub
//		alistView =  (ListView) getActivity().findViewById(R.id.alistview_gridView);
//		setAListData();
		setAListDataFromNet();
//		myAListAdapter = new MyAListAdapter(lists, context);
//		alistView.setAdapter(myAListAdapter);
	}
	
	
	
//	private void setAListData() {
//		// TODO Auto-generated method stub
//		lists = new ArrayList<Singer>();
//    	int length =images.length;
//    	for(int i=0;i<length;i++){
//    		//创建每个视图要显示的数据
//    		Singer singer = new Singer(image[i],name[i],introduces[i]);
//    		lists.add(singer);
//	}
//	}
	
	private void setAListDataFromNet() {
		ServerApi serverApi = new ServerApi(context);
		serverApi.getData(url, new OnMyResponse() {

			@Override
			public void onResponse(Object ob) {
				// 1,获得联网的数据
				HomeData homeData = (HomeData) ob;
				// 2,把数据给viewPager
				setTestListData(homeData.data.radioList);
				   //setViewPagerData(Advertisement);
			     //	serGridViewDate(homeData.data.slider);
			}
		}, HomeData.class);
//		serverApi.getData(url2, new OnMyResponse() {
//
//			@Override
//			public void onResponse(Object ob) {
//				// 1,获得联网的数据
//				NewsData newsData =(NewsData) ob;
//				//List<News> news=(List<News>) ob;
//				System.out.println(newsData);
////				// 2,把数据给viewPager
//				setTestListData(newsData.news);
//			}
//		}, NewsData.class);
	}
	
	
	private void setTestListData(List<RadioList> radioList) {
		//private void setTestListData(List<News> news) {
		// 1,创建适配器，并且传入数据
		alistView =  (ListView) getActivity().findViewById(R.id.alistview_gridView);
		myAListAdapter2 = new MyAListAdapter2(radioList, context);
		//myAListAdapter2 = new MyAListAdapter2(news, context);
		// 2,显示视图
		
		alistView.setAdapter(myAListAdapter2);
		alistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Toast.makeText(getActivity(), "Click item" + i, Toast.LENGTH_SHORT).show();
                Intent it2 = new Intent();
                it2.setClass(getActivity(), ShowActivity.class);
                //用Bundle携带数据
                Bundle bundle=new Bundle();
                //传递name参数为tinyphp
                bundle.putString("name", "listItem"+i);
                it2.putExtras(bundle);
               // it.putExtra("viewid",currentItem );
               // it.putExtra("viewid",1 );
                Log.e("guotp", "5555555555");
               startActivity(it2);
            }
        });

	}
		
	
	
	// fragment中的界面被销毁
	@Override
	public void onDestroyView() {
		Log.i("hq", "onDestroyView");
		super.onDestroyView();
	}

	}
