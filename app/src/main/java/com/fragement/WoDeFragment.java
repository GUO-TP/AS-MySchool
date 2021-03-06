package com.fragement;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import com.myschool.R;
import com.myschool.UpdateActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WoDeFragment extends Fragment implements OnClickListener{
	View v;
	Button login;
	Button update;
	EditText etusername;
	EditText etuserpass;
	Context context;
	Handler  postHandler;
	TextView text;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		context = inflater.getContext();
		 v = inflater.inflate(R.layout.fragment_wode, container, false);
		 postHandler = new PostHandler();
		 setLogin(v);
		
		return v;
	}
	private void setLogin(View v) {
		 text= (TextView) v.findViewById(R.id.mytext);
		etusername=(EditText) v.findViewById(R.id.username_ediText);
		etuserpass=(EditText) v.findViewById(R.id.userpassword_ediText);
	     login=	(Button) v.findViewById(R.id.button1);
	     update=(Button) v.findViewById(R.id.button2);
	     login.setOnClickListener(this);
	     update.setOnClickListener(this);
	}
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		int v=view.getId();
	     switch (v) {
	     case R.id.button1:
	    	 if(validate())
	    	 {
	    		 new LoginPostThread().start();
	    	 }
	    	 
	    	    break;
	     case R.id.button2:
	    	// Intent intent = new Intent();
	    	 Intent intent = new Intent();
				//设置意图
	    	 Context context =this.getActivity();
               
			intent.setClass(context,UpdateActivity.class);
	    	  //Intent intent = new Intent(getActivity(),UpdateActivity.class);
              startActivity(intent);
	    		break;
			default:
				break;
	     
	     
	     }
	     }
	
	private boolean validate() {
		// TODO Auto-generated method stub
		String username=etusername.getText().toString().trim();
		String password=etuserpass.getText().toString().trim();
		if(username.equals("")){
			
			Toast.makeText(context,"用户名不能为空", Toast.LENGTH_SHORT).show();
			return false;
		}
     if(password.equals("")){
			
			Toast.makeText(context,"密码不能为空", Toast.LENGTH_SHORT).show();
			return false;
		}

//		
		return true;
	}

	
	
class LoginPostThread extends Thread {
	@Override
	public void run() {
		super.run();
		String username=etusername.getText().toString().trim();
		String password=etuserpass.getText().toString().trim();
		String url="http://192.168.1.107:8080/a_stusys/Student/showStudentByNameAndPassword.do";
		//String url="http://192.168.1.107:8080/a_stusys/Student/showStudentByNameAndPassword.do?name="+username+"&password="+password+"";
		try {
			//创建一个URI对象，并且指定服务器的url地址
			URI uri = URI.create(url);
			
			//创建HttpClient对象
			HttpClient client = new DefaultHttpClient();
			
			//创建HttpPost对象，并且将uri封装到这个请求对象中
			HttpPost post = new HttpPost(uri);
			
			//创建集合，用来封装要发送到服务器的键值对对象NameValuePair
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			//创建NameValuePair对象并添加键值对信息
			NameValuePair pair1 = new BasicNameValuePair("name",  username);
			NameValuePair pair2 = new BasicNameValuePair("password", password);
			//将NameValuePair对象添加到List集合中
			list.add(pair1);
			list.add(pair2);
			//为请求对象设置Entity，Entity中封装了请求参数信息
			post.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
			
			//通过HttpClient对象请求服务器，并传递请求对象
			HttpResponse response = client.execute(post);
			
			//获取状态码
			int code = response.getStatusLine().getStatusCode();
			if(code == 200) {//判断是否响应成功
				//取出消息实体
				HttpEntity entity = response.getEntity();
				
				//将消息实体转为字符串
				String data = EntityUtils.toString(entity);
				
				//将从服务器获取的数据发送到UI线程显示
				Message msg = new Message();//创建Message对象，用来封装要发送的数据
				msg.obj = data;//将数据封装到Message对象的obj变量中
				postHandler.sendMessage(msg);//发送Message对象到UI线程
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class PostHandler extends Handler {
	@Override
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		//取出数据
		String data = (String) msg.obj;
		
		//显示数据
		if(data.equals("1"))
		{
			Toast.makeText(context,"登陆成功,你的ID为"+data, Toast.LENGTH_SHORT).show();
			text.setText("已登陆");
		}
		else
			Toast.makeText(context,"登陆失败你的ID为"+data, Toast.LENGTH_SHORT).show();
		//tv_show.setText(data);
	}
}



}
