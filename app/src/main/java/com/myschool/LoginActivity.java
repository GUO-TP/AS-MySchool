package com.myschool;

import java.util.ArrayList;  
import java.util.List;  
  
import android.app.Activity;  
import android.content.Context;  
import android.os.Bundle;  
import android.os.Handler;  
import android.support.v4.view.PagerAdapter;  
import android.support.v4.view.ViewPager;  
import android.support.v4.view.ViewPager.OnPageChangeListener;  
import android.view.MotionEvent;  
import android.view.View;  
import android.view.View.OnTouchListener;  
import android.view.ViewGroup;  
import android.widget.ImageView;  
import android.widget.LinearLayout;  
import android.widget.TextView;  
import android.widget.Toast;  
  
public class LoginActivity extends Activity {  
	
    private ViewPager viewpager;  
    private Context context =  LoginActivity.this;  
    private MyAdapter myAdapter;  
    private RunnableTask runnableTask = new RunnableTask();  
    // ׼��Ҫ��ʾ��ͼƬ��Դ  
//    private int[] imageIdArray = { R.drawable.shang_nine, R.drawable.shang_ten,  
//            R.drawable.tu_gangaoyou };  
    // ׼��title  
    private String[] titleArray = { "aaa", "bbb", "ccc" };  
    // �ֲ�ͼ��ʾ�ĵ�ǰҳ  
//    private int currentPosition =Integer.MAX_VALUE/2-((Integer.MAX_VALUE/2)%imageIdArray.length);  
//    int middle=Integer.MAX_VALUE/2-(Integer.MAX_VALUE/2%imageIdArray.length);  
    /** 
     * ���õ�ļ��� 
     */  
    private List<View> viewList = new ArrayList<View>();  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
//        setContentView(R.layout.item);  
//        // �ҵ�ViewPager�ؼ�  
//        viewpager = (ViewPager) findViewById(R.id.vp);  
    }  
  
    @Override  
    protected void onResume() {  
        super.onResume();  
        // ��ͼƬ���������,Ϊʲôд��onResume�������أ�  
        // ����Ϊ��viewʧȥ����ʱ��ֹͣ�����������»�ȡ����ʱҪ������������  
        // �����д��onCreate�����ֻ��activity��һ�δ���ʱ�Ż������һ��ֹͣ�������ٴλ�ȡ����Ҳ���������  
        startRoll();  
        viewpager.setOnPageChangeListener(new OnPageChangeListener() {  
  
            @Override  
            public void onPageSelected(int arg0) {  
                //������ ���ֲ�ͼ��ʾ��ǰҳʱ��һ��Ҫ��currentPosition��Ϊarg0��  
                //������ ���򣬵�������ָ�����ֲ�ͼʱ�����ֺ��ֲ�ͼ��ʾ����һ��ҳ���ǲ����ǵ�ǰ��ʾҳ�����һҳ  
                // ��������ǣ����Լ�����3���Ӽ���õ�����һҳ  
                //currentPosition = arg0;  
            }  
  
            @Override  
            public void onPageScrolled(int arg0, float arg1, int arg2) {  
                // TODO Auto-generated method stub  
  
            }  
  
            @Override  
            public void onPageScrollStateChanged(int arg0) {  
                // TODO Auto-generated method stub  
  
            }  
        });  
    }  
  
    /** 
     * ���ֲ�ͼviewpager�������� 
     */  
    public void startRoll() {  
        // ����viewpager  
        if (myAdapter == null) {  
            // 1.��һ�γ�ʼ��������  
            myAdapter = new MyAdapter();  
            viewpager.setAdapter(myAdapter);  
         //   viewpager.setCurrentItem(currentPosition);  
        } else {// 8.�ڶ��Σ�ֻ��Ҫ֪ͨ���������ݷ����˱仯��Ҫˢ��Ui  
            myAdapter.notifyDataSetChanged();  
        }  
        // 2.����һ����ʱ����Ϣ��3���ִ��runnableTask����run������Ĳ���  
        // �Ϊʲôִ�е���runnableTask��������handleMessage�أ������漰��handler��Ϣ����Դ�������  
        handler.postDelayed(runnableTask, 3000);  
    }  
  
    class RunnableTask implements Runnable {  
        @Override  
        public void run() {  
            // 3.�仯�ֲ�ͼ��ǰҪ��ʾ��ҳ��λ�ã�����1��Ϊ�˲�ʹ������ֵ��������ֲ�ͼ ͼƬ�ĸ�����ȡ����  
         //   currentPosition = currentPosition + 1;  
            // 4.������Ϣ�����̵߳�handler  
            handler.obtainMessage().sendToTarget();  
        }  
    }  
  
    private Handler handler = new Handler() {  
        // 5.���ղ�����run������������Ϣ  
        public void handleMessage(android.os.Message msg) {  
            // 6.viewpager�����µĵ�ǰҳ  
          //  viewpager.setCurrentItem(currentPosition);  
            // 7.����ִ��startRoll��������Ϊһ��ѭ��  
            startRoll();  
        }  
    };  
  
    /** 
     * �ﵱ��ָ��ס�ֲ�ͼ����ʱ���ֲ�ͼֹͣ������������ֲ�ͼʱ����ת����ؽ��� 
     */  
    public void onTouchViewPager(View view, final int position) {  
        // ��ͼƬע�ᴥ���¼�������  
        view.setOnTouchListener(new OnTouchListener() {  
  
            private long downTime;  
            private int downX;  
  
            @Override  
            public boolean onTouch(View v, MotionEvent event) {  
                switch (event.getAction()) {  
                case MotionEvent.ACTION_DOWN:// ����ȥʱ����¼���µ������ʱ�䣬�����ж��Ƿ��ǵ���¼�  
                    handler.removeCallbacksAndMessages(null);// ��ָ����ʱ��ȡ�������¼������ֲ�ͼ���ڹ�����  
                    downX = (int) event.getX();  
                    downTime = System.currentTimeMillis();  
                    break;  
                case MotionEvent.ACTION_UP:// ̧����ָʱ���ж�����̧���ʱ�������꣬������������Ϊ���  
                    // Toast.makeText(context, "��ָ̧����", 0).show();  
                    if (System.currentTimeMillis() - downTime < 500  
                            && Math.abs(downX - event.getX()) < 30) {// �￼�ǵ��ְ��º�̧��ʱ�����겻������ȫ�غϣ��������30������ƫ��  
                        // ����¼�������  
                        Toast.makeText(context,  
                                "����Ͳ�������Ӧҳ���ˣ����򿪵��ǵ�" + position + "��ͼƬ", 0)  
                                .show();  
                    }  
                    startRoll();  
                    break;  
                case MotionEvent.ACTION_CANCEL:  
                    // ��д�����Ŀ��Ϊ�����û�����ָ������ͼƬ���ܹ����ֲ�ͼ�����Զ�����  
                    startRoll();  
                    break;  
                }  
                return true;  
            }  
        });  
    }  
  
    @Override  
    protected void onPause() {  
        super.onPause();  
        // �Ƴ����е����񣬼���viewʧȥ����ʱ��ֹͣ�ֲ�ͼ�Ĺ���  
        handler.removeCallbacksAndMessages(null);  
    }  
  
    /** 
     * ����С��㣬ʹ��С��������ֲ�ͼ��λ�ö��ı���ɫ 
     */  
    private void initDot(LinearLayout dots_ll, int position) {  
        // ����ÿ�ν���������Բ����������С��㣬��Ȼ��ÿ���л���ҳ�棬������initDot��������һֱ�ۼ�С��㣬ÿ������8����  
        dots_ll.removeAllViews();  
        viewList.clear();  
     //   position=position%imageIdArray.length;  
        // �����ֲ�ͼƬ�ļ��ϣ�ÿ����һ����newһ��view�������view���ñ���ͼƬ��  
        // ������С���ĸ������β������ò��������ü�࣬���Բ��������Щ�㣬viewListҲ���С���  
//        for (int i = 0; i < imageIdArray.length; i++) {  
//            View view = new View(context);  
//            if (i == position) {  
//                view.setBackgroundResource(R.drawable.dot_focus);  
//            } else {  
//                view.setBackgroundResource(R.drawable.dot_normal);  
//            }  
  
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(  
//                    6,  
//                    6);  
//            view.setLayoutParams(layoutParams);  
//            layoutParams.setMargins(5, 0, 5, 0);  
//            dots_ll.addView(view);  
//            viewList.add(view);  
        }  
    }  
  
    /** 
     * ��������Ҫ��д�����ĸ����� 
     */  
    class MyAdapter extends PagerAdapter {  
  
        @Override  
        public boolean isViewFromObject(View arg0, Object arg1) {  
            return arg0 == arg1;  
        }  
  
        @Override  
        public int getCount() {  
            return Integer.MAX_VALUE;  
        }  
  
//        @Override  
//        public Object instantiateItem(ViewGroup container, int position) {  
//            View view = View.inflate(context, R.layout.layout_roll_view, null);  
//            ImageView imageView = (ImageView) view.findViewById(R.id.image);  
//            imageView.setImageResource(imageIdArray[position%titleArray.length]);  
//            TextView title = (TextView) view.findViewById(R.id.top_news_title);  
//            title.setText(titleArray[position%titleArray.length]);  
//            LinearLayout dots_ll = (LinearLayout) view.findViewById(R.id.dots_ll);  
//            // ����С���Ĳ���  
//            initDot(dots_ll, position);  
//            // onTouchViewPager����һ��Ҫд��instantiateItem�ڲ�����ʾ�������ǵ�ǰλ�õ�ҳ��  
//            onTouchViewPager(view, position);  
//            // ������仰����Ҫ������������д������  
//            ((ViewPager) container).addView(view);  
//            return view;  
//        }  
//  
//        @Override  
//        public void destroyItem(ViewGroup container, int position, Object object) {  
//            // ������仰����Ҫ������������д������  
//            ((ViewPager) container).removeView((View) object);  
//        }  
//    }  
}  