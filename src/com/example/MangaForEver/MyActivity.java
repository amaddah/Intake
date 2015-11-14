package com.example.MangaForEver;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;

public class MyActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    private Button boutonMain;
    private Button boutonEntrer;
    private EditText t;
    private TextView s;
    private String prenom;
    private CheckBox plaitIl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        boutonMain = (Button) findViewById(R.id.boutonMain);

        boutonMain.setOnClickListener(this);
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
                boutonEntrer.setOnClickListener(this);
                break;
            case R.id.jentre:
                plaitIl = (CheckBox) findViewById(R.id.plaitIl);
                if ( plaitIl.isChecked() ) {
                    // C'est bon
                    setContentView(R.layout.finintro);
                }
                else {
                    // Pas bon
                    s = (TextView) findViewById(R.id.problemePresentation);
                    s.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
