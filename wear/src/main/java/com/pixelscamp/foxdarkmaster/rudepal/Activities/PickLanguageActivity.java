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
    private String language_code = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity_pick_translate_language);

        Intent input_intent = getIntent();
        to_translate = input_intent.getStringExtra("to_translate");
        TextView to_translate_text = (TextView) this.findViewById(R.id.textViewPickTranslateLanguageWordToTranslate);
        to_translate_text.setText(to_translate);

        Button pick_button = (Button) this.findViewById(R.id.buttonPickTranslateLanguageListView);
        String picked_language = input_intent.getStringExtra("language");
        if (picked_language != null) {
            pick_button.setText(picked_language);
            language_code = pickedLanguageCode(picked_language);
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
                if (language_code != "") {
                    intent.putExtra("language_locale", language_code);
                }
                startActivity(intent);
            }
        });
    }

    public String pickedLanguageCode (String language) {
        String language_code;
        switch (language) {
            case "Portuguese":
                language_code = "pt-PT";
                break;
            case "English":
                language_code = "en-US";
                break;
            case "Spanish":
                language_code = "es-ES";
                break;
            case "Italian":
                language_code = "it-IT";
                break;
            case "French":
                language_code = "fr-FR";
                break;
            case "Japanese":
                language_code = "ja";
                break;
            case "German":
                language_code = "de-DE";
                break;
            default:
                language_code = "";
                System.out.println("Language not found!");
                break;
        }
        return language_code;
    }
}
