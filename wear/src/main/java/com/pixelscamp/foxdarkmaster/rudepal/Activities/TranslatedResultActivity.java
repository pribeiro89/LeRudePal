package com.pixelscamp.foxdarkmaster.rudepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

    }
}
