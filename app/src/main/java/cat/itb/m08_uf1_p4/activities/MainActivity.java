package cat.itb.m08_uf1_p4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.HashMap;

import cat.itb.m08_uf1_p4.R;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}