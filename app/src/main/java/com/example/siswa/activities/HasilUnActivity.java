package com.example.siswa.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.siswa.R;

public class HasilUnActivity extends AppCompatActivity {
    TextView tvNISN,tvNama,tvIndo,tvEnglish,tvMat,tvKejuruan;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hasil_un);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvNISN = findViewById(R.id.tv_hasil_un_nisn);
        tvNama = findViewById(R.id.tv_hasil_un_nama);
        tvIndo = findViewById(R.id.tv_hasil_un_indo);
        tvEnglish = findViewById(R.id.tv_hasil_un_english);
        tvMat = findViewById(R.id.tv_hasil_un_matematika);
        tvKejuruan = findViewById(R.id.tv_hasil_un_kejuruan);

        b= getIntent().getExtras();

        if(b!=null){
            tvNISN.setText(""+b.getLong("nisn"));
            tvNama.setText(b.getString("nama"));
            tvIndo.setText(b.getString("indo"));
            tvEnglish.setText(b.getString("english"));
            tvMat.setText(b.getString("matematika"));
            tvKejuruan.setText(b.getString("kejuruan"));
        }
    }
}