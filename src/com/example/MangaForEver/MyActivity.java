package com.example.MangaForEver;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;

public class MyActivity extends Activity implements View.OnClickListener, View.OnTouchListener {
    /**
     * Called when the activity is first created.
     */
    private Button
                    boutonMain,
                    boutonEntrer;
    private EditText t;
    private TextView s;
    private String prenom;
    private CheckBox plaitIl;
    private LinearLayout l1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstimage);
        l1 = (LinearLayout) findViewById(R.id.l1);
        l1.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        setContentView(R.layout.main);
        boutonMain = (Button) findViewById(R.id.boutonMain);
        boutonMain.setOnClickListener(this);
        return false;
    }

    @Override
    public void onClick(View v) {
    /* Réagir au clic */
        switch(v.getId()) {
            case R.id.boutonMain:
                t = (EditText) findViewById(R.id.name);
                prenom = t.getText().toString();
                setContentView(R.layout.presentation);
                s = (TextView) findViewById(R.id.prenomAffiche);
                s.setText("Bonjour " + prenom + " !");
                boutonEntrer = (Button) findViewById(R.id.jentre);
                boutonEntrer.setOnClickListener(this); // Bouton "j'entre" guidant vers l'application en-elle même.
                break;
            case R.id.jentre:
                plaitIl = (CheckBox) findViewById(R.id.plaitIl);
                if ( plaitIl.isChecked() ) setContentView(R.layout.finintro);// C'est bon
                else Toast.makeText(MyActivity.this, R.string.ideeprojet, Toast.LENGTH_SHORT).show();// Pas bon
                break;
        }
    }
}
