package com.example.app_android_001;

import static com.example.app_android_001.R.layout.activity_main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Crear variables para la programacion
    private EditText editTextUser;
    private EditText editTextPassword;
    private Button buttonOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //obtener las referencias de los controles visuale(vistas) y asignarlas a las variables creadas
        editTextUser = (EditText) findViewById(R.id.editTextUser);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonOk = findViewById(R.id.buttonOk);
        /*buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickButtonOk(view);
            }
        });*/
    }
    public void clickButtonOk(View view) {
        String user = editTextUser.getText().toString();
        String password = editTextPassword.getText().toString();
        if (!user.matches("") && !password.matches("")) {
            //mostrar el actuvity principal
        }else{
            Toast.makeText(this,
                    "Los datos son requeridos",
                    Toast.LENGTH_LONG).show();
        }
    }
}