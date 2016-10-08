package com.pixelscamp.foxdarkmaster.rudepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pixelscamp.foxdarkmaster.rudepal.R;

public class TranslatedResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity_translated);

        Intent intent = getIntent();
        TextView to_translate_text = (TextView) this.findViewById(R.id.text_translated_totranslate);
        to_translate_text.setText(intent.getStringExtra("to_translate"));

        Button button_new = (Button) this.findViewById(R.id.button_translated_again);
        button_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
