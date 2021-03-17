package com.arturtcs.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textViewGorjeta, textViewTotal, textViewPorcentagem;
    private TextInputEditText textInputValor;

    private Integer porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar             = findViewById(R.id.seekBarPorcentagem);
        textViewGorjeta     = findViewById(R.id.textViewGorjeta);
        textViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        textInputValor      = findViewById(R.id.textInputValor);
        textViewTotal       = findViewById(R.id.textViewTotal);


        seekbar();
    }

    private void cacularGorjeta(){

        String valorRecuperado = textInputValor.getText().toString();

        if ( valorRecuperado == null || valorRecuperado.isEmpty() ) {
            Toast.makeText(
                getApplicationContext(),
                    "POR FAVOR DIGITE UM VALOR PARA QUE A GORJETA SEJA CALCULADA",
                    Toast.LENGTH_LONG
            ).show();
        } else {
            //Converte String para Double
            Double valorDigitado = Double.parseDouble(valorRecuperado);

            //calcular a gorjeta total
            Double gorjeta = valorDigitado * (porcentagem/100);

            //exibe a gorjeta e o total
            //textViewGorjeta.setText("R$ " + Math.round(gorjeta));
            textViewGorjeta.setText("R$ " + gorjeta);

            Double valorTotal = valorDigitado + gorjeta;
            textViewGorjeta.setText("R$ " + valorTotal);
            }
    }

    private void seekbar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textViewPorcentagem.setText(porcentagem + "%");
                cacularGorjeta();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}