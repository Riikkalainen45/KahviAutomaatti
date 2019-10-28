
public class JuomaAutomaatti {

	private int tee;
	private int kahvi;
	private int kaakao;

	public JuomaAutomaatti() {
		this.tee = 50;
		this.kahvi = 50;
		this.kaakao = 50;
	}

	

	public int getTee() {
		return tee;
	}

	public void setTee(int tee) {
		this.tee = tee ;
	}

	public int getKahvi() {
		return kahvi;
	}

	public void setKahvi(int kahvi) {
		this.kahvi = kahvi ;
	}

	public int getKaakao() {
		return kaakao;
	}

	public void setKaakao(int kaakao) {
		this.kaakao = kaakao;
	}

	public int valmistaKahvi() {
		if (this.kahvi - 10 < 0) {
			this.kahvi = 0;	
		}
		else
			this.kahvi -= 10;

		return kahvi;
	}
 
	public int valmistaTee() {
		if (this.tee - 10 < 0) {
			this.tee = 0;
		}

		else
			this.tee -= 10;

		return tee;
	}

	public int valmistaKaakao() {
		if (this.kaakao - 10 < 0) {
			this.kaakao = 0;
		}
		else
			this.kaakao -= 10;

		return kaakao;
	}

	@Override
	public String toString() {
		return "JuomaAutomaatti [tee=" + tee + ", kahvi=" + kahvi + ", kaakao=" + kaakao + "]";
	}
}


