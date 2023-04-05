package in.it.swiperefreshlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayList = new ArrayList<String>();
    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        listView = (ListView) findViewById(R.id.lv);

        swipeRefreshLayout.setColorSchemeResources(R.color.purple_700);

        arrayList.add("Element 1");
        arrayList.add("Element 2");
        arrayList.add("Element 3");
        arrayList.add("Element 4");
        arrayList.add("Element 5");
        arrayList.add("Element 6");
        arrayList.add("Element 7");
        arrayList.add("Element 8");
        arrayList.add("Element 9");
        arrayList.add("Element 10");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                shuffleItem();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public void shuffleItem(){
        Collections.shuffle(arrayList, new Random(System.currentTimeMillis()));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);
    }
}