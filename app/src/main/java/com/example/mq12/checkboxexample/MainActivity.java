package com.example.mq12.checkboxexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CheckBox checkBoxFutbol,checkBoxNatacion,checkBoxAtletismo,checkBoxIngles,checkBoxEspanol, checkBoxPortugues;
    private Button boton;
    private TableRow tableRowEquipo, tableRowIdioma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxFutbol = (CheckBox) findViewById(R.id.checkBox1);
        checkBoxNatacion = (CheckBox) findViewById(R.id.checkBox2);
        checkBoxAtletismo = (CheckBox) findViewById(R.id.checkBox3);
        checkBoxIngles = (CheckBox) findViewById(R.id.checkBox4);
        checkBoxEspanol = (CheckBox) findViewById(R.id.checkBox5);
        checkBoxPortugues = (CheckBox) findViewById(R.id.checkBox6);
        tableRowEquipo = (TableRow) findViewById(R.id.tableRowEquipo);
        tableRowIdioma = (TableRow) findViewById(R.id.tableRowIdioma);

        boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case R.id.button: 
               mostrar();
            break;
        }

    }

    private void mostrar() {
        StringBuffer mensaje = new StringBuffer();
        mensaje.append("Deporte\n");
        for(int index=0; index<((TableRow)tableRowEquipo).getChildCount(); ++index) {
            View nextChild = ((TableRow)tableRowEquipo).getChildAt(index);
            CheckBox c = (CheckBox) findViewById(nextChild.getId());

            mensaje.append(c.getText() + "  :  ").append(c.isChecked() + "\n");
            Log.d("Deporte " , "tablita: " +  mensaje.toString());

        }
        mensaje.append("Idioma\n");
        for(int index=0; index<((TableRow)tableRowIdioma).getChildCount(); ++index) {
            View nextChild = ((TableRow)tableRowIdioma).getChildAt(index);
            CheckBox c = (CheckBox) findViewById(nextChild.getId());

            mensaje.append(c.getText()+ "  :  ").append(c.isChecked() + "\n");
            Log.d("Idioma " ,"tablita: " +  mensaje.toString());
        }


        Toast.makeText(MainActivity.this, mensaje.toString(),
                Toast.LENGTH_LONG).show();

    }
}
