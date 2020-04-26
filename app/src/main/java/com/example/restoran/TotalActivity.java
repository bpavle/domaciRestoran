package com.example.restoran;



import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import static android.util.TypedValue.COMPLEX_UNIT_SP;
import static com.example.restoran.MenuActivity.zaPrenos;


public class TotalActivity extends AppCompatActivity {
    public static final String zaPrenos2="druga_jedinstvena_oznaka";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        final LinearLayout linearLayout = (LinearLayout)findViewById(R.id.ll2);

        //ako je ostalo nesto u linearLayout kada smo se vratili na prethodni aktiviti da dodamo porudzbinu, to brisemo

        getSupportActionBar().hide();

        final ArrayList<String> s = (ArrayList<String>)getIntent().getSerializableExtra(zaPrenos);

        for(String i:s){
            TextView tv;
            //tv = new TextView(new ContextThemeWrapper(this,R.style.buttonStyle));
            tv = new TextView(this);
            tv.setText(i);

            if(i.isEmpty()) continue;
            tv.setPadding(20,20,20,20);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            tv.setTextSize(COMPLEX_UNIT_SP,20);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                tv.setBackground(getDrawable(R.drawable.stavka));
            } else{
                // do something for phones running an SDK before lollipop
            }

            //kako dodati rukom pisani font na textView-ove koji se dodaju u ovoj petlji
            linearLayout.addView(tv);
        }

        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * namerno necu da overrajdujem public void finish() jer se ona poziva i u slucaju povrtka na MenuActivity
                * pritiskom sistemskom dugmeta za nazad koje bi korisnik eventualno iskoristio da izmeni svoju porudzbinu.
                * */
                EditText editText = findViewById(R.id.editText2);
                String odluka = editText.getText().toString();
                if(
                        !odluka.equals("nova narudzbina") &&
                        !odluka.equals("Nova narudzbina")&&
                        !odluka.equals("Nova narudžbina") &&
                        !odluka.equals("nova narudžbina")&&
                        !odluka.equals("нова наруџбина") &&
                        !odluka.equals("Нова наруџбина") &&
                                !odluka.equals("nova porudzbina") &&
                                !odluka.equals("Nova porudzbina") &&
                                !odluka.equals("Nova porudžbina") &&
                                !odluka.equals("nova porudžbina") &&
                                !odluka.equals("нова поруџбина")  &&
                                !odluka.equals("Нова поруџбина")
                ) {
                    Toast toast = Toast.makeText(TotalActivity.this,R.string.toastText3,Toast.LENGTH_LONG);
                    View toastView = toast.getView();
                    toast.setText(R.string.toastText3);
                    if (android.os.Build.VERSION.SDK_INT >= 21){
                        toastView.setBackground(getDrawable(R.drawable.toast));
                    }

                    toast.setView(toastView);
                    toast.show();
                    return;
                }
                Intent intent = new Intent(TotalActivity.this,MenuActivity.class);
                intent.putExtra(zaPrenos2,editText.getText().toString());
                startActivity(intent);
            }
        });


        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                pronasao sam dosta komentara na internetu koji kazu da ovo ne treba raditi...
                * */
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);



            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(TotalActivity.this, R.string.toastText1,Toast.LENGTH_LONG);
                //Toast toast = new Toast(TotalActivity.this);
                toast.setText(R.string.toastText1);
                toast.setDuration(Toast.LENGTH_SHORT);
                View toastView = toast.getView();

                if (android.os.Build.VERSION.SDK_INT >= 21){
                    toastView.setBackground(getDrawable(R.drawable.toast));
                }
                toast.setView(toastView);
                System.out.println("NACIN PREUZIMANJA: "+s.get(s.size()-1)+"a treba : "+getString(R.string.toastText1));
                if(s.get(s.size()-1).equals(getString(R.string.isporuka1))){
                    System.out.println("NACIN PREUZIMANJA: "+s.get(s.size()-1));
                    toast.setText(R.string.toastText1);
                    //toast = Toast.makeText(TotalActivity.this, R.string.toastText1,Toast.LENGTH_LONG);
                }
                else if(s.get(s.size()-1).equals(getString(R.string.isporuka2))){
                    toast.setText(R.string.toastText2);
                    //toast = Toast.makeText(TotalActivity.this, R.string.toastText2,Toast.LENGTH_LONG);
                }

                toast.show();
            }
        });

    }
}
