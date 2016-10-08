package com.pixelscamp.foxdarkmaster.rudepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.pixelscamp.foxdarkmaster.rudepal.R;

public class PickLanguageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity_pick_translate_language);

        Intent input_intent = getIntent();
        TextView to_translate_text = (TextView) this.findViewById(R.id.textViewPickTranslateLanguageWordToTranslate);
        to_translate_text.setText(input_intent.getStringExtra("to_translate"));

    }
}
