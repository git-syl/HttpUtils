package wusrc.testokhttp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.button)
    Button button;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


    }

    @OnClick(R.id.button)
    public void onClick() {


        HttpUtils.doGetAsyn("http://fanyi.youdao.com/openapi.do?keyfrom=Skykai521&key=977124034&type=data&doctype=json&version=1.1&q=Hello",
                new HttpUtils.CallBack() {
                    public void onRequestComplete(final String result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });

        HttpUtils.doPostFileAsyn(new File(SDCardUtils.getSDCardPath() + "test1.jpg"),
                "http://172.16.100.106:8080/UploadFile.ashx",
                new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(final String result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });


    }

}
