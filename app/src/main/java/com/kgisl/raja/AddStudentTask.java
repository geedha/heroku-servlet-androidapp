package com.kgisl.raja;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddStudentTask extends AsyncTask<String,String,String> {

    @Override
    protected String doInBackground(String... strings) {
        Log.d("post","task enry");
        String id = (String)strings[0];
        String name = (String)strings[1];
        Log.d("post","params:"+id+" "+name);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://rajaherokuservlet.herokuapp.com/add");
        Log.d("post","client");
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("id", id));
        params.add(new BasicNameValuePair("name", name));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            Log.d("post","entity");
            client.execute(httpPost);
            Log.d("post","done with posting");
            System.out.println("Done");
            client.close();
        } catch (IOException e) {
            Log.d("post","error");
            e.printStackTrace();
        }
        return "done";
    }
}
