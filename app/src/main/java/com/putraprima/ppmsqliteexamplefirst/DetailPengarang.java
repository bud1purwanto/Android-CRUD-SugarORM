package com.putraprima.ppmsqliteexamplefirst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.putraprima.ppmsqliteexamplefirst.models.Pengarang;

public class DetailPengarang extends AppCompatActivity {
    TextView namaPengarang,umur;
    EditText updatePengarang, updateUmur;
    android.widget.RadioGroup RadioGroup;
    RadioButton radioButton;
    private Button buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pengarang);

        Intent i = getIntent();
        Long idPen = i.getLongExtra("pengarangId",0L);
        Pengarang detailPen = Pengarang.findById(Pengarang.class,idPen);
        RadioGroup = (android.widget.RadioGroup) findViewById(R.id.RadioGroup);
        namaPengarang = (TextView) findViewById(R.id.namaPengarang);
        namaPengarang.setText(detailPen.getNama());
        umur = (TextView) findViewById(R.id.umur);
        umur.setText(detailPen.getUmur());

        String jk=detailPen.getJk();
        if (jk.equalsIgnoreCase("Laki-laki")==true){
            RadioButton l = (RadioButton) findViewById(R.id.Laki);
            l.setChecked(true);
        }
        else if(jk.equalsIgnoreCase("Perempuan")==true){
            RadioButton b = (RadioButton) findViewById(R.id.Perempuan);
            b.setChecked(true);
        }

        namaPengarang.requestFocus();

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePengarang = (EditText) findViewById(R.id.namaPengarang);
                updateUmur = (EditText) findViewById(R.id.umur);
                int selectedRadioButtonID = RadioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedRadioButtonID);
                Intent i = getIntent();
                Long idPend = i.getLongExtra("pengarangId",0L);
                Pengarang updatePen = Pengarang.findById(Pengarang.class,idPend);
                updatePen.nama= updatePengarang.getText().toString();
                updatePen.umur= updateUmur.getText().toString();
                updatePen.jk= radioButton.getText().toString();
                updatePen.save();
                Intent e = new Intent(getApplicationContext(),DaftarPengarang.class);
                startActivity(e);
            }
        });
    }
}
