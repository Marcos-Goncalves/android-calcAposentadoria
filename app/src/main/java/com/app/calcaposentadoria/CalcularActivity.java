package com.app.calcaposentadoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalcularActivity extends AppCompatActivity {
    private String nome;
    private boolean sexo;
    private int idade, contribuicao;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);

        nome = getIntent().getStringExtra("nome");
        sexo = getIntent().getBooleanExtra("btF", false);
        idade = getIntent().getIntExtra("idade", 0);
        contribuicao = getIntent().getIntExtra("contribuicao", 0);

        ((TextView)findViewById(R.id.idNome)).setText(nome);
        ((TextView)findViewById(R.id.idIdade)).setText(String.valueOf(idade));

        aposentar();
    }

    public void aposentar(){
        if (sexo == true && idade >= 62 && contribuicao >= 15 || sexo == false && idade >= 65 && contribuicao >= 20){
            ((TextView)findViewById(R.id.idMensagem)).setText("Pode se aposentar!");
        }else {
            ((TextView)findViewById(R.id.idMensagem)).setText("Ainda não pode se aposentar!");
            if(sexo == true) {
                ((TextView) findViewById(R.id.idCalculo)).setText("Precisa trabalhar " + (15-contribuicao) + " anos!");
            } else {
                ((TextView) findViewById(R.id.idCalculo)).setText("Precisa trabalhar " + (20-contribuicao) + " anos!");
            }
        }
    }

    public void compartilhar(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, ("Aposentadoria"));
        if(sexo == true && idade >= 62 && contribuicao >= 15 || sexo == false && idade >= 65 && contribuicao >= 20){
            intent.putExtra(Intent.EXTRA_TEXT, (nome + " pode se aposentar pois tem " + idade + " anos de idade e " + contribuicao + " anos de contribuição!"));
        } else {
            intent.putExtra(Intent.EXTRA_TEXT, (nome + " não pode se aposentar pois tem " + idade + " anos de idade e " + contribuicao + " anos de contribuição!"));
        }
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Compartilhando com ..."));
    }
}