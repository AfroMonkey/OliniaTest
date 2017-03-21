package com.olinia.oliniatest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    private Button send;
    private ListView list;
    private EditText txt;
    private boolean sw = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        send = (Button) findViewById(R.id.send);
        list = (ListView) findViewById(R.id.list);
        txt = (EditText) findViewById(R.id.txt);

        final MessageAdapter adapter = (new MessageAdapter(this, R.layout.message, R.id.msg));


        list.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(txt.getText().toString().trim());
                txt.setText("");
            }
        });

        txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().trim().length() > 0){
                    send.setEnabled(true);
                }
                else{
                    send.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

}
