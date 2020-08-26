package com.myschool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.*;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends Activity {
	WebView webViwe;
	TextView t;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.showweb);// 加载.xml文件
		webViwe = (WebView) findViewById(R.id.show_webview);
		t = (TextView) findViewById(R.id.tt1);

		setInf();
		// Log.e("guotp", data);
		// int a = Integer.parseInt(data);
		// if(a==0)
		// {
		// webViwe.loadUrl("www.baidu.com");
		// }
	}

	private void setInf() {
		// TODO Auto-generated method stub

		Bundle bundle = this.getIntent().getExtras();
		// 接收name值
		String data = bundle.getString("name");
		String T=data.trim();
		// int i=Integer.parseInt(data);
		Toast.makeText(ShowActivity.this, "55" + data, 0).show();

		 int i=Integer.parseInt(data);
//		 switch (i) {
//			case 0:
//				 webViwe.loadUrl("www.baidu.com");
//				break;
//			default:
//			break;
//			}
		 if(i==0)
		 {
		 webViwe.loadUrl("http://www.baidu.com");
		 finish();
		 }
		 if(i==1)
		 {
		 webViwe.loadUrl("https://www.hao123.com");
		 }
		 t.setText("ppp:"+i);
		 finish();
	}
	  
}