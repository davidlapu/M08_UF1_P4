package cat.itb.m08_uf1_p4.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cat.itb.m08_uf1_p4.R;
import cat.itb.m08_uf1_p4.adapters.ListViewAdapter;
import cat.itb.m08_uf1_p4.models.Character;

public class MainActivity extends AppCompatActivity {


    private final Character[] characters = {new Character("Fishl", R.drawable.bow, R.drawable.element_electro),
            new Character("Diona", R.drawable.bow, R.drawable.element_cryo),
            new Character("Klee", R.drawable.catalyst, R.drawable.element_pyro),
            new Character("Keqing", R.drawable.sword, R.drawable.element_electro),
            new Character("Mona", R.drawable.catalyst, R.drawable.element_hydro),
            new Character("Ningguang", R.drawable.catalyst, R.drawable.element_geo),
            new Character("Noelle", R.drawable.catalyst, R.drawable.element_geo),
            new Character("Qiqi", R.drawable.sword, R.drawable.element_cryo),
            new Character("Venti", R.drawable.catalyst, R.drawable.element_anemo),
            new Character("Xiangling", R.drawable.polearm, R.drawable.element_pyro)
    };

    private final List<Character> characterList = new ArrayList<>(characters.length);
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        characterList.addAll(Arrays.asList(characters));
        setListViewAdapter();
    }

    public void setListViewAdapter() {
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, R.layout.list_item, characterList);
        listView.setAdapter(listViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

}