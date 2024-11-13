package com.example.ejemplosqlite;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
;

public class MainActivity extends AppCompatActivity {
    private Button btnAlta;
    private Button btnListado;
    private Button btnReset;
    private EditText etNombre;
    private ControladorMain ctr
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        recogerElementosGraficos();
        establecerEscuchadores();
    }
    private void recogerElementosGraficos(){
        btnAlta=findViewById(R.id.btnAlta);
        btnListado=findViewById(R.id.btnListado);
        btnReset=findViewById(R.id.btnReset);
        etNombre=findViewById(R.id.etNombre);
    }
    public String recogerNombreAlumno(){
        if(etNombre.getText() != null && !etNombre.getText().toString().isEmpty()){
            return etNombre.getText().toString();
        }
        return null;
    }
    public void resetName(){
        etNombre.setText("");
    }
    private void establecerEscuchadores(){
        ctr = new ControladorMain(this);
        btnAlta.setOnClickListener(ctr);
        btnReset.setOnClickListener(ctr);
        btnListado.setOnClickListener(ctr);
    }
    protected void onDestroy(){
        ctr.cerrarConexion();
        super.onDestroy();
    }

}