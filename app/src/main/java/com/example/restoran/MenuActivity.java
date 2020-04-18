package com.example.restoran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import java.util.ArrayList;

import static android.util.TypedValue.COMPLEX_UNIT_SP;
import static com.example.restoran.TotalActivity.zaPrenos2;


public class MenuActivity extends AppCompatActivity  {
    public static final String zaPrenos = "jedinstvenaOznaka";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        getSupportActionBar().hide();
        final ArrayList<String> s = new ArrayList<String>();
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.ll);
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ll);
        LinearLayout linearLayoutHrana = (LinearLayout)findViewById(R.id.llHrana);
        LinearLayout linearLayoutPice = (LinearLayout)findViewById(R.id.llPice);
        //iz nekog raloga na nekim uredjajima se koristi ovo... PITAJ STO!
        // viewGroup= getWindow().getDecorView().findViewById(android.R.id.content);

        ArrayList<String> listaHrane=new ArrayList<>();
        ArrayList<String> listaPica=new ArrayList<>();

        listaHrane.add(getString(R.string.Jelo1));
        listaHrane.add(getString(R.string.Jelo2));
        listaHrane.add(getString(R.string.Jelo3));
        listaHrane.add(getString(R.string.Jelo4));
        listaHrane.add(getString(R.string.Jelo5));
        listaHrane.add(getString(R.string.Jelo6));
        listaHrane.add(getString(R.string.Jelo7));







        listaPica.add(getString(R.string.Pice1));
        listaPica.add(getString(R.string.Pice2));
        listaPica.add(getString(R.string.Pice3));
        listaPica.add(getString(R.string.Pice4));
        listaPica.add(getString(R.string.Pice5));
        listaPica.add(getString(R.string.Pice6));
        listaPica.add(getString(R.string.Pice7));

        for(int i=0;i<listaHrane.size();i++){
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(listaHrane.get(i));
            checkBox.setTextSize(COMPLEX_UNIT_SP,20);
            linearLayoutHrana.addView(checkBox);
        }
        for(int i=0;i<listaPica.size();i++){
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(listaPica.get(i));
            checkBox.setTextSize(COMPLEX_UNIT_SP,20);
            linearLayoutPice.addView(checkBox);
        }

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0;i<viewGroup.getChildCount();i++) {
                    View view = viewGroup.getChildAt(i);

                    if (view instanceof EditText) {
                        EditText et = (EditText) view;
                        s.add(et.getText().toString());
                    }

                    if(!(view instanceof LinearLayout)) continue;

                    ViewGroup vg = (ViewGroup) view;
                    for (int j = 0; j < vg.getChildCount(); j++) {
                        View vk = vg.getChildAt(j);
                        if (vk instanceof CheckBox) {
                            CheckBox cb = (CheckBox) vk;
                            if (cb.isChecked())
                                s.add(cb.getText().toString());
                        }
                        if (vk instanceof RadioButton) {
                            RadioButton rb = (RadioButton) vk;
                            if (rb.isChecked())
                                s.add(rb.getText().toString());

                        }


                    }
                }
                Intent Main_Menu = new Intent(MenuActivity.this,TotalActivity.class);
                Main_Menu.putExtra(zaPrenos,s);
                startActivity(Main_Menu);

                //brisemo sadrzaj arrayList-a da bismo mogli da se vratimo i dodamo/oduzmemo porudzbinu
                //a da nam se ne duplira prikaz na sledecem aktivity-ju
                s.clear();
            }

        });

        String odluka =getIntent().getStringExtra(zaPrenos2);
        if(odluka!=null)
        if(odluka.equals("nova narudzbina")){
            ((RadioButton) findViewById(R.id.radioButton1)).setChecked(true);
        }
        else if(odluka.equals("nova porudzbina")){
            ((RadioButton) findViewById(R.id.radioButton2)).setChecked(true);
        }


    }

}
