package com.app.calcaposentadoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular (View view){
        Intent intent = new Intent(getApplicationContext(), CalcularActivity.class);
        intent.putExtra("nome", ((EditText)findViewById(R.id.idNome)).getText().toString());
        intent.putExtra("btF", ((RadioButton)findViewById(R.id.btF)).isChecked());
        intent.putExtra("idade", Integer.parseInt(((EditText)findViewById(R.id.idIdade)).getText().toString()));
        intent.putExtra("contribuicao", Integer.parseInt(((EditText)findViewById(R.id.idContribuicao)).getText().toString()));
        startActivity(intent);
    }
}