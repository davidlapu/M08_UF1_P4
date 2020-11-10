package cat.itb.m08_uf1_p4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.HashMap;

import cat.itb.m08_uf1_p4.R;
import cat.itb.m08_uf1_p4.models.Character;

public class MainActivity extends AppCompatActivity {


    private final Character[] characters = {new Character("Fishl", R.drawable.bow, R.drawable.element_Electro),
            new Character("Diona", R.drawable.bow, R.drawable.element_Cryo),
            new Character("Klee", R.drawable.catalyst, R.drawable.element_Pyro),
            new Character("Keqing", R.drawable.sword, R.drawable.element_Electro),
            new Character("Mona", R.drawable.catalyst, R.drawable.element_Hydro),
            new Character("Ningguang", R.drawable.catalyst, R.drawable.element_Geo),
            new Character("Noelle", R.drawable.catalyst, R.drawable.element_Geo),
            new Character("Qiqi", R.drawable.sword, R.drawable.element_Cryo),
            new Character("Venti", R.drawable.catalyst, R.drawable.element_Anemo),
            new Character("Xiangling", R.drawable.polearm, R.drawable.element_Pyro)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}