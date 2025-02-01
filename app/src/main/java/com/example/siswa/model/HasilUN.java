package com.example.siswa.model;

import com.google.gson.annotations.SerializedName;

public class HasilUN{

	@SerializedName("Kejuruan")
	private int kejuruan;

	@SerializedName("NISN")
	private long nISN;

	@SerializedName("Bahasa Inggris")
	private int bahasaInggris;

	@SerializedName("Nama")
	private String nama;

	@SerializedName("Matematika")
	private int matematika;

	@SerializedName("Bahasa Indonesia")
	private int bahasaIndonesia;

	public int getKejuruan(){
		return kejuruan;
	}

	public long getNISN(){
		return nISN;
	}

	public int getBahasaInggris(){
		return bahasaInggris;
	}

	public String getNama(){
		return nama;
	}

	public int getMatematika(){
		return matematika;
	}

	public int getBahasaIndonesia(){
		return bahasaIndonesia;
	}

	@Override
 	public String toString(){
		return 
			"HasilUN{" + 
			"kejuruan = '" + kejuruan + '\'' + 
			",nISN = '" + nISN + '\'' + 
			",bahasa Inggris = '" + bahasaInggris + '\'' + 
			",nama = '" + nama + '\'' + 
			",matematika = '" + matematika + '\'' + 
			",bahasa Indonesia = '" + bahasaIndonesia + '\'' + 
			"}";
		}
}