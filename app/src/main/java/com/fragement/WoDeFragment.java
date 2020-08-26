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
				//������ͼ
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
			
			Toast.makeText(context,"�û�������Ϊ��", 0).show();
			return false;
		}
     if(password.equals("")){
			
			Toast.makeText(context,"���벻��Ϊ��", 0).show();
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
			//����һ��URI���󣬲���ָ����������url��ַ
			URI uri = URI.create(url);
			
			//����HttpClient����
			HttpClient client = new DefaultHttpClient();
			
			//����HttpPost���󣬲��ҽ�uri��װ��������������
			HttpPost post = new HttpPost(uri);
			
			//�������ϣ�������װҪ���͵��������ļ�ֵ�Զ���NameValuePair
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			//����NameValuePair������Ӽ�ֵ����Ϣ
			NameValuePair pair1 = new BasicNameValuePair("name",  username);
			NameValuePair pair2 = new BasicNameValuePair("password", password);
			//��NameValuePair������ӵ�List������
			list.add(pair1);
			list.add(pair2);
			//Ϊ�����������Entity��Entity�з�װ�����������Ϣ
			post.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
			
			//ͨ��HttpClient����������������������������
			HttpResponse response = client.execute(post);
			
			//��ȡ״̬��
			int code = response.getStatusLine().getStatusCode();
			if(code == 200) {//�ж��Ƿ���Ӧ�ɹ�
				//ȡ����Ϣʵ��
				HttpEntity entity = response.getEntity();
				
				//����Ϣʵ��תΪ�ַ���
				String data = EntityUtils.toString(entity);
				
				//���ӷ�������ȡ�����ݷ��͵�UI�߳���ʾ
				Message msg = new Message();//����Message����������װҪ���͵�����
				msg.obj = data;//�����ݷ�װ��Message�����obj������
				postHandler.sendMessage(msg);//����Message����UI�߳�
				
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
		//ȡ������
		String data = (String) msg.obj;
		
		//��ʾ����
		if(data.equals("1"))
		{
			Toast.makeText(context,"��½�ɹ�,���IDΪ"+data, 0).show();
			text.setText("�ѵ�½");
		}
		else
			Toast.makeText(context,"��½ʧ�����IDΪ"+data, 0).show();
		//tv_show.setText(data);
	}
}



}
