package com.app.calcaposentadoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalcularActivity extends AppCompatActivity {
    String nome;
    boolean sexo;
    int idade, contribuicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);

        nome = getIntent().getStringExtra("nome");
        sexo = getIntent().getBooleanExtra("F", false);
        idade = getIntent().getIntExtra("idade", 0);
        contribuicao = getIntent().getIntExtra("contribuicao", 0);

        ((TextView)findViewById(R.id.idNome).setText(nome));
        ((TextView)findViewById(R.id.idIdade).setText(idade));
    }

    public void aposentar(View view){
        if (sexo == true && idade >= 62 && contribuicao >= 15 || sexo == false && idade >= 65 && contribuicao >= 20){
            ((TextView)findViewById(R.id.idMensagem).setText("Pode se aposentar!"));
        }else {
            ((TextView)findViewById(R.id.idMensagem).setText("Ainda não pode se aposentar!"));
            if(sexo == true) {
                ((TextView) findViewById(R.id.idCalculo).setText("Ainda precisa trabalhar " + (15-contribuicao)));
            } else {
                ((TextView) findViewById(R.id.idCalculo).setText("Ainda precisa trabalhar " + (20-contribuicao)));
            }
        }
    }
}