package com.example.adapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // region Using Native Adapter
//        final String[] showNames = {
//                "Friends",
//                "Modern Family",
//                "Orange Is the New Black",
//                "Weeds",
//                "Arrested Development",
//                "Workaholics"
//        };
//
//        ArrayAdapter<String> showAdapter = new ArrayAdapter<String>(this,
//                    R.layout.item,
//                    R.id.show_name,
//                    showNames
//                );
//
//        ListView showList = new ListView(this);
//        showList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String msg = "You clicked on " + showNames[i];
//
//                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        showList.setAdapter(showAdapter);
//        setContentView(showList);
        // endregion

        final Show[] shows = {
                new Show("Friends", "Nickelodeon", 8.9f),
                new Show("Modern Family", "USA Network", 8.5f),
                new Show("Orange Is the New Black", "Netflix", 8.2f)
        };

        ArrayAdapter<Show> showAdapter = new ArrayAdapter<Show>(this, 0, shows) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Show currentShow = shows[position];

                if(convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.custom_item, null, false);
                }

                ViewHolder viewHolder = new ViewHolder();
                viewHolder.showName = convertView.findViewById(R.id.show_name);
                viewHolder.publisher = convertView.findViewById(R.id.publisher);
                viewHolder.rating = convertView.findViewById(R.id.rating);

                convertView.setTag(viewHolder);

                TextView showName = ((ViewHolder)convertView.getTag()).showName;
                TextView publisher = ((ViewHolder)convertView.getTag()).publisher;
                TextView rating = ((ViewHolder)convertView.getTag()).rating;

                showName.setText(currentShow.showName);
                publisher.setText(currentShow.publisher);
                rating.setText(Float.toString(currentShow.rating));

                return convertView;
            }
        };

        ListView showList = new ListView(this);
        showList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = "You clicked on " + shows[i].showName;

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        showList.setAdapter(showAdapter);
        setContentView(showList);

    }
}
