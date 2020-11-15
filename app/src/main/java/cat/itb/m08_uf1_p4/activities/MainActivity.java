package cat.itb.m08_uf1_p4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cat.itb.m08_uf1_p4.R;
import cat.itb.m08_uf1_p4.adapters.ViewAdapter;
import cat.itb.m08_uf1_p4.models.Character;

public class MainActivity extends AppCompatActivity {

    static final List<Character> characterList = new ArrayList<>();
    private ListView listView;
    private GridView gridView;
    private MenuItem listButton;
    private MenuItem gridButton;
    private ViewAdapter listViewAdapter ,gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);

        if (characterList.isEmpty()) {
            initializeCharList();
        }

        listViewAdapter = setListViewAdapter();
        gridViewAdapter = setGridViewAdapter();
    }

    private void initializeCharList(){
        final Character[] characters = {new Character("Fishl", R.drawable.bow, R.drawable.element_electro),
                new Character("Diona", R.drawable.bow, R.drawable.element_cryo),
                new Character("Klee", R.drawable.catalyst, R.drawable.element_pyro),
                new Character("Keqing", R.drawable.sword, R.drawable.element_electro),
                new Character("Mona", R.drawable.catalyst, R.drawable.element_hydro),
                new Character("Ningguang", R.drawable.catalyst, R.drawable.element_geo),
                new Character("Noelle", R.drawable.claymore, R.drawable.element_geo),
                new Character("Qiqi", R.drawable.sword, R.drawable.element_cryo),
                new Character("Venti", R.drawable.catalyst, R.drawable.element_anemo),
                new Character("Xiangling", R.drawable.polearm, R.drawable.element_pyro)
        };
        characterList.addAll(Arrays.asList(characters));
    }

    public ViewAdapter setListViewAdapter() {
        ViewAdapter viewAdapter = new ViewAdapter(this, R.layout.list_item, characterList);
        listView.setAdapter(viewAdapter);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(this::onItemClick);
        return viewAdapter;
    }

    public ViewAdapter setGridViewAdapter() {
        ViewAdapter gridViewAdapter = new ViewAdapter(this, R.layout.grid_item, characterList);
        gridView.setAdapter(gridViewAdapter);
        registerForContextMenu(gridView);
        gridView.setOnItemClickListener(this::onItemClick);
        return gridViewAdapter;
    }

    private void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(MainActivity.this, Form.class);
        i.putExtra("pos", position);

        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu, menu);
        listButton = menu.findItem(R.id.listViewButton);
        gridButton = menu.findItem(R.id.gridViewButton);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuButtonPlus:
                Intent i = new Intent(MainActivity.this, Form.class);
                startActivity(i);
                return true;
            case R.id.gridViewButton:
                gridButton.setVisible(false);
                listButton.setVisible(true);
                listView.setVisibility(View.GONE);
                gridView.setVisibility(View.VISIBLE);
                return true;
            case R.id.listViewButton:
                listButton.setVisible(false);
                gridButton.setVisible(true);
                gridView.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        listViewAdapter.notifyDataSetChanged();
        gridViewAdapter.notifyDataSetChanged();

        super.onStart();
    }

    public static void addNewChar(Character c) {
        characterList.add(c);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(characterList.get(info.position).getName());

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if (item.getItemId() == R.id.delete_item) {
            characterList.remove(info.position);
            gridViewAdapter.notifyDataSetChanged();
            listViewAdapter.notifyDataSetChanged();
            return true;
        }

        return super.onContextItemSelected(item);
    }
}