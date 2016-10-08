package com.pixelscamp.foxdarkmaster.rudepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pixelscamp.foxdarkmaster.rudepal.R;

public class PickLanguageActivity extends Activity {
    private String to_translate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity_pick_translate_language);

        Intent input_intent = getIntent();
        to_translate = input_intent.getStringExtra("to_translate");
        TextView to_translate_text = (TextView) this.findViewById(R.id.textViewPickTranslateLanguageWordToTranslate);
        to_translate_text.setText(to_translate);

        Button pick_button = (Button) this.findViewById(R.id.buttonPickTranslateLanguageListView);
        if(input_intent.getStringExtra("language") != null) {
            pick_button.setText(input_intent.getStringExtra("language"));
        }
        pick_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LanguageListActivity.class);
                intent.putExtra("to_translate", to_translate);
                startActivity(intent);
            }
        });

        Button go_button = (Button) this.findViewById(R.id.buttonPickTranslateLanguageGo);
        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TranslatedResultActivity.class);
                intent.putExtra("to_translate", to_translate);
                startActivity(intent);
            }
        });
    }
}
