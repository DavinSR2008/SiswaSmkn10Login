package com.example.siswa.model;

public class SppResponse{
	private Hasil hasil;

	public Hasil getHasil(){
		return hasil;
	}

	@Override
 	public String toString(){
		return 
			"SppResponse{" + 
			"hasil = '" + hasil + '\'' + 
			"}";
		}
}
