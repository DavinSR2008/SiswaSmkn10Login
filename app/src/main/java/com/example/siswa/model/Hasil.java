package com.example.siswa.model;

public class Hasil{
	private String maret;
	private String mei;
	private String november;
	private String september;
	private String januari;
	private String februari;
	private String juni;
	private String agustus;
	private String oktober;
	private String juli;
	private String april;
	private String desember;

	public String getMaret(){
		return maret;
	}

	public String getMei(){
		return mei;
	}

	public String getNovember(){
		return november;
	}

	public String getSeptember(){
		return september;
	}

	public String getJanuari(){
		return januari;
	}

	public String getFebruari(){
		return februari;
	}

	public String getJuni(){
		return juni;
	}

	public String getAgustus(){
		return agustus;
	}

	public String getOktober(){
		return oktober;
	}

	public String getJuli(){
		return juli;
	}

	public String getApril(){
		return april;
	}

	public String getDesember(){
		return desember;
	}

	@Override
 	public String toString(){
		return 
			"Hasil{" + 
			"maret = '" + maret + '\'' + 
			",mei = '" + mei + '\'' + 
			",november = '" + november + '\'' + 
			",september = '" + september + '\'' + 
			",januari = '" + januari + '\'' + 
			",februari = '" + februari + '\'' + 
			",juni = '" + juni + '\'' + 
			",agustus = '" + agustus + '\'' + 
			",oktober = '" + oktober + '\'' + 
			",juli = '" + juli + '\'' + 
			",april = '" + april + '\'' + 
			",desember = '" + desember + '\'' + 
			"}";
		}
}
