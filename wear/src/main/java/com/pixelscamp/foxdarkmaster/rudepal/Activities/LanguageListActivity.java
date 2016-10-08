package com.pixelscamp.foxdarkmaster.rudepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.pixelscamp.foxdarkmaster.rudepal.R;

public class LanguageListActivity extends Activity implements OnItemClickListener {
    ListView listView;

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity_choose_language);

            listView = (ListView) findViewById(R.id.list_choose_language);
            listView.setOnItemClickListener(this);

        }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        Intent intent = new Intent(view.getContext(), PickLanguageActivity.class);
        intent.putExtra("language", ((TextView) view).getText().toString());
        startActivity(intent);
    }

}

