package com.putraprima.ppmsqliteexamplefirst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.putraprima.ppmsqliteexamplefirst.models.Pengarang;

public class TambahPengarang extends AppCompatActivity {
    EditText txtNamaPengarang, txtUmur;
    RadioGroup RadioGroup;
    RadioButton radioButton;
    Button btnSimpanPengarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengarang);
        btnSimpanPengarang = (Button) findViewById(R.id.btnSimpanPengarang);
        txtNamaPengarang = (EditText) findViewById(R.id.txtNamaPengarang);
        txtUmur = (EditText) findViewById(R.id.txtUmur);
        RadioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        txtNamaPengarang.requestFocus();
        btnSimpanPengarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonID = RadioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedRadioButtonID);
                Pengarang mPengarang = new Pengarang(txtNamaPengarang.getText().toString(),txtUmur.getText().toString(), radioButton.getText().toString());
                mPengarang.save();
                Intent e = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(e);

            }
        });
    }
}
