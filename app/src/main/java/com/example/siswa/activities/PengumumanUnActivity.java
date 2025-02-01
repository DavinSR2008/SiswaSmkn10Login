package com.example.siswa.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.siswa.R;
import com.example.siswa.model.PengumumanUnResponse;
import com.example.siswa.network.ServiceClient;
import com.example.siswa.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengumumanUnActivity extends AppCompatActivity {
    EditText etNis;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pengumuman_un);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNis = findViewById(R.id.et_nis_un);
        pd = new ProgressDialog(this);
    }

    public void cekHasil(View view) {
        if (etNis.getText().toString().isEmpty()) {
            Toast.makeText(this, "NIS tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        pd.setMessage("Load data...");
        pd.setCancelable(false);
        pd.show();

        String nis = etNis.getText().toString().trim();

        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);
        Call<PengumumanUnResponse> requestUN = service.requestHasilUn("un", "readPengumumanUN", nis);
        requestUN.enqueue(new Callback<PengumumanUnResponse>() {
            @Override
            public void onResponse(Call<PengumumanUnResponse> call, Response<PengumumanUnResponse> response) {
                pd.dismiss();
                if (response.body().getHasilUN().getNama().equals("nis tidak ditemukan")) {
                    Toast.makeText(PengumumanUnActivity.this, "NIS tidak ditemukan", Toast.LENGTH_SHORT).show();
                } else {
                    Bundle b = new Bundle();
                    b.putLong("nisn", response.body().getHasilUN().getNISN());
                    b.putString("nama", response.body().getHasilUN().getNama());
                    b.putString("indo", String.valueOf(response.body().getHasilUN().getBahasaIndonesia()));
                    b.putString("english", String.valueOf(response.body().getHasilUN().getBahasaInggris()));
                    b.putString("matematika", String.valueOf(response.body().getHasilUN().getMatematika()));
                    b.putString("kejuruan", String.valueOf(response.body().getHasilUN().getKejuruan()));

                    Intent i = new Intent(PengumumanUnActivity.this, HasilUnActivity.class);
                    i.putExtras(b);  // Menggunakan putExtras() bukan putExtra()

                    startActivity(i);
                    etNis.setText("");
                }
            }

            @Override
            public void onFailure(Call<PengumumanUnResponse> call, Throwable throwable) {
                pd.dismiss();
                Toast.makeText(PengumumanUnActivity.this, "Koneksi error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
