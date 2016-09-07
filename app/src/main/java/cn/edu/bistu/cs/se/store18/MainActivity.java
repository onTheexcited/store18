package cn.edu.bistu.cs.se.store18;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnWrite=(Button) findViewById(R.id.btnWrite);
            btnWrite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OutputStream out = null;
                    try {
                        FileOutputStream fileOutputStream = openFileOutput("MyFileName", MODE_PRIVATE);
                        out = new BufferedOutputStream(fileOutputStream);
                        String content = "hello world";
                        Toast.makeText(MainActivity.this,"输入成功",Toast.LENGTH_LONG).show();
                        try {
                            out.write(content.getBytes(StandardCharsets.UTF_8));
                        } finally {
                            if (out != null)
                                out.close();

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            Button btnRead=(Button) findViewById(R.id.btnRead);
                btnRead.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        InputStream in = null;
                        try {
                            FileInputStream fileInputStream = openFileInput("MyFileName");
                            in = new BufferedInputStream(fileInputStream);
                            int c;
                            StringBuilder stringBuilder = new StringBuilder("");
                            try {
                                while ((c = in.read()) != -1) {
                                    stringBuilder.append((char) c);
                                }
                                Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
                            } finally {
                                if (in != null)
                                    in.close();

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
                }
}
