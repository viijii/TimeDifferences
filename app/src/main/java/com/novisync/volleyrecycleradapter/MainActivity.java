package com.novisync.volleyrecycleradapter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    static TextView t;
    TextView tv1;
    String request_url = "https://cadrac-india.000webhostapp.com/raji112233.php";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleradapter);

        t = (TextView) findViewById(R.id.t);
        tv1 = (TextView) findViewById(R.id.tv1);
        t.setText("fdfdfd");
//        String amith="nothing";
//        String amith1="nothing";
////        while (amith.equals(amith1)) {
//do {
//           // doTheAutoRefresh();
//            Log.d("TAG","1");
//        } while (amith.equals(amith1));
        //   doTheAutoRefresh();
        method();




  /*      String ee = null;
        Myasy back = new Myasy();

        try {

            ee = back.execute().get().toString();
            Log.d("TAG",ee);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        t.setText(ee);*/


    }

    /* *//* *//**//* private void doTheAutoRefresh() {
         Handler handler = new Handler();
       handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Write code for your refresh logic
                method();
            }
        }, 1000);
    }*/
    public void method() {
        String ee = null;
        Myasy back = new Myasy();
        try {

            ee = back.execute().get().toString();
            Log.d("TAG", ee);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //  t.setText(ee);
        //    Toast.makeText(getApplicationContext(),ee,Toast.LENGTH_SHORT).show();
       /* try {
            wait(1000);
            Log.d("TAG", "method: fjklhgfg");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //  method();
    }

    public class Myasy extends AsyncTask<Void, Void, String> {

        String s = "";

        @Override
        public String doInBackground(Void... voids) {

            OkHttpClient client = new OkHttpClient();

            String s1 = "0:0:0";


            Response response = null;
            client.setProtocols(Arrays.asList(Protocol.HTTP_1_1));
            RequestBody requestBody = new FormEncodingBuilder().build();
            com.squareup.okhttp.Request request = new Request.Builder().url("https://cadrac-india.000webhostapp.com/raji112233.php").post(requestBody).build();
            try {
                response = client.newCall(request).execute();
                s = response.body().string();
                Log.d("TAG", "doInBackground: " + response.body().string());

                Log.d("TAG", "doInBackground: " + s);


            } catch (IOException e) {
                e.printStackTrace();
            }
            //both times are equal then go
            if (s.equals(s1)) {

                tv1.setEnabled(true);
            } else {
                tv1.setEnabled(false);
            }

            return s;

        }

        @Override
        protected void onPostExecute(String s) {
            //super.onPostExecute(s);
            t.setText(s);

            Myasy back = new Myasy();
            try {

                back.execute().get().toString();
                //  Log.d("TAG",ee);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
