package com.pixelscamp.foxdarkmaster.rudepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pixelscamp.foxdarkmaster.rudepal.R;

public class TextInputActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity_text_option);

        final EditText to_translate = (EditText) findViewById(R.id.editTextTextOptionInput);
        Button bnt_translate = (Button) this.findViewById(R.id.buttonTextOptionTranslate);
        bnt_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PickLanguageActivity.class);

                if (to_translate.getText() == null) {
                    intent.putExtra("to_translate", "");
                }
                else {
                    intent.putExtra("to_translate",  to_translate.getText().toString());
                }
                startActivity(intent);
            }
        });
    }
}
