package com.example.app_android_001;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private TextView textViewMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Obtener los datos del objeto intent
        Bundle extras=getIntent().getExtras();
        String user =extras.getString("userParm");
        String password =extras.getString("passwordParm");
        textViewMessage=findViewById(R.id.textViewMessage);
        textViewMessage.setText("Usuario: "+user+" "+"Contraseña: "+password);
    }
    public void clickButtonBrowser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        startActivity(intent);
    }
    public void clickButtonCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5555555555"));
        startActivity(intent);
    }
    public void clickButtonGoggleMaps(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=160"));
        startActivity(intent);
    }
    public void clickButtonShowThirdActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivity(intent);
    }
    public void clickButtonClose(View view) {
        this.finish();
    }
}