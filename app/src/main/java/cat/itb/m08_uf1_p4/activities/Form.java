package cat.itb.m08_uf1_p4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import cat.itb.m08_uf1_p4.R;
import cat.itb.m08_uf1_p4.models.Character;

public class Form extends AppCompatActivity {

    private Spinner spinnerElements, spinnerWaepons;
    private Button buttonDone;
    private EditText editTextName;
    private TextView textViewTitle;
    private Boolean loadedChar = false;
    private int itemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinnerElements = findViewById(R.id.spinnerElements);
        spinnerWaepons = findViewById(R.id.spinnerWaepons);
        buttonDone = findViewById(R.id.buttonDone);
        editTextName = findViewById(R.id.editTextName);
        textViewTitle = findViewById(R.id.formTitle);

        setElementSpinner();
        setWaeponSpinner();

        buttonDone.setOnClickListener(this::doneClicked);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            itemPos = bundle.getInt("pos");
            loadItem(itemPos);
        }
    }

    public void loadItem(int itemPos) {
        loadedChar = true;
        textViewTitle.setText(MainActivity.characterList.get(itemPos).getName());

        Character c = MainActivity.characterList.get(itemPos);
        editTextName.setText(c.getName());
    }

    private void setElementSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.elements, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerElements.setAdapter(adapter);
    }

    private void setWaeponSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.waepons, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWaepons.setAdapter(adapter);
    }

    private void doneClicked(View v) {
        String name = editTextName.getText().toString(),
                waepon = spinnerWaepons.getSelectedItem().toString(),
                element = spinnerElements.getSelectedItem().toString();

        if (waepon.isEmpty()) {
            waepon = "Bow";
        }

        if (element.isEmpty()) {
            element = "Ameno";
        }

        if (loadedChar) {
            MainActivity.characterList.remove(itemPos);
        }

        if (!name.isEmpty()){
            MainActivity.addNewChar(new Character(name, getWaeponId(waepon) ,getElementId(element)));
        }
        finish();
    }

    public int getWaeponId(String waepon) {
        switch (waepon) {
            case "Bow":
                return R.drawable.bow;
            case "Catalyst":
                return R.drawable.catalyst;
            case "Claymore":
                return R.drawable.claymore;
            case "Polearm":
                return R.drawable.polearm;
            case "Sword":
                return R.drawable.sword;
        }
        return 0;
    }

    public int getElementId(String element) {
        switch (element) {
            case "Anemo":
                return R.drawable.element_anemo;
            case "Cryo":
                return R.drawable.element_cryo;
            case "Electro":
                return R.drawable.element_electro;
            case "Dendro":
                return R.drawable.element_dendro;
            case "Geo":
                return R.drawable.element_geo;
            case "Hydro":
                return R.drawable.element_hydro;
            case "Pyro":
                return R.drawable.element_pyro;
        }
        return 0;
    }
}