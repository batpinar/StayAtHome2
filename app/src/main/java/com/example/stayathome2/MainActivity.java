package com.example.stayathome2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.edityas);
        Button durumbtn = (Button) findViewById(R.id.buttondurum);
        final TextView sonuc = (TextView) findViewById(R.id.textView);

        //Log.v("TAG", )

                durumbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(MainActivity.this, editText.getText().toString(),Toast.LENGTH_SHORT).show();
                        int yas = yashesapla(Integer.parseInt(editText.getText().toString()));
                        int saat = CurrentHour();
                        boolean haftasonuMu = HaftaSonu();

                        if (yas<20)
                        {
                            if (saat>=13 && saat<16)
                            {
                                sonuc.setText("SERBEST1");
                            }else
                            {
                                sonuc.setText("YASAK1");
                            }
                        }

                            else if (yas>20 && yas<65)
                            {
                                if (haftasonuMu == true)
                                {
                                    if (saat<10 || saat>=20)
                                    {
                                        sonuc.setText("YASAK2");

                                    }else
                                        {
                                        sonuc.setText("SERBEST2");
                                        }
                                }else
                                    {
                                        sonuc.setText("SERBEST3");
                                    }
                            } else if (yas>=65)
                                {
                                    if (saat>=10 && saat<13)
                                    {
                                        sonuc.setText("SERBEST4");

                                    }else
                                        {
                                         sonuc.setText("YASAK3");
                                        }
                                }//else
                                  //  {
                                  //      sonuc.setText("Yanklış giriş");
                                 //   }
                        Toast.makeText(MainActivity.this, "Durumunuz Gösterildi.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public int CurrentYear()
    {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        String  tarih = dateFormat.format(date);

        int tarihint = Integer.parseInt(tarih);
        return tarihint;
    }

    public int CurrentDay()
    {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("u");
        String  tarih = dateFormat.format(date);

        int currentday = Integer.parseInt(tarih);
        return currentday;
    }

    public int CurrentHour()
    {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH");
        String  tarih = dateFormat.format(date);

        int currentday = Integer.parseInt(tarih);
        return currentday;
    }

    public boolean HaftaSonu()
    {
        if (CurrentDay() == 6 || CurrentDay() == 7)
        {
            return true;
        }else
        {
            return false;
        }
    }

    public int yashesapla(int yil)
    {
        return CurrentYear() - yil;
    }
}