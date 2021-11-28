package com.ldh.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Email_1 extends AppCompatActivity {

    private TextView textView_name_mail, textView_title_mail,textView_content_mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_click_the_mail);
        Messages messages = new Messages();
        getInformation(messages.getStr()[0]);

    }
    public void getInformation(String chosen_email)
    {
        String [] str = chosen_email.split("Title:");
        String [] s = str[1].split("Content:");
        textView_name_mail = (TextView) findViewById(R.id.textView_name_mail);
        textView_title_mail = (TextView) findViewById(R.id.textView_title);
        textView_content_mail = (TextView) findViewById(R.id.textView_content);
        textView_name_mail.setText(str[0]);
        textView_title_mail.setText(s[0]);
        textView_content_mail.setText(s[1]);
    }
}