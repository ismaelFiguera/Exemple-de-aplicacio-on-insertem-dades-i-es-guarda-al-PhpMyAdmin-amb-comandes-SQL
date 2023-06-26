package almata.domini;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.LocalDate;
import java.util.Objects;

public class Client {
	
	private String Nom;
	private String Cognom1r;
	private String Cognom2n;
	private String DNI;
	private int telefono;
	private String correu_electronic;
	private int CP; 
	private String Pais;
	private int Edat;
	private LocalDate Data_Naixement;
	
	//Constructors
	
	public Client(String nom, String cognom1r, String cognom2n, String dNI, int telefono, String correu_electronic,
			int cP, String pais, int edat, LocalDate data_Naixement) {
		super();
		Nom = nom;
		Cognom1r = cognom1r;
		Cognom2n = cognom2n;
		DNI = dNI;
		this.telefono = telefono;
		this.correu_electronic = correu_electronic;
		CP = cP;
		Pais = pais;
		Edat = edat;
		Data_Naixement = data_Naixement;
	}


	public Client(String dNI) {
		super();
		this.DNI = dNI;
	}


	public Client() {
		super();
	}

	
	//Getters y Setters
	



	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		this.Nom = nom;
	}


	public String getCognom1r() {
		return Cognom1r;
	}


	public void setCognom1r(String cognom1r) {
		this.Cognom1r = cognom1r;
	}


	public String getCognom2n() {
		return Cognom2n;
	}


	public void setCognom2n(String cognom2n) {
		this.Cognom2n = cognom2n;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		this.DNI = dNI;
	}
	
	
	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getCorreu_electronic() {
		return correu_electronic;
	}


	public void setCorreu_electronic(String correu_electronic) {
		this.correu_electronic = correu_electronic;
	}


	public int getCP() {
		return CP;
	}


	public void setCP(int cP) {
		this.CP = cP;
	}


	public String getPais() {
		return Pais;
	}


	public void setPais(String pais) {
		this.Pais = pais;
	}


	public int getEdat() {
		return Edat;
	}


	public void setEdat(int edat) {
		this.Edat = edat;
	}


	public LocalDate getData_Naixement() {
		return Data_Naixement;
	}


	public void setData_Naixement(LocalDate data_Naixement) {
		this.Data_Naixement = data_Naixement;
	}
	
 
	//Metodes de negoci
    public LocalTime now() {
    	ZoneId z1 = ZoneId.of("Europe/Paris");
    	LocalTime HoraLocal = LocalTime.now(z1);
        return HoraLocal;
    }
    
    public LocalDate dia() {
    	LocalDate a = LocalDate.now();
    	return a;
    }


	@Override
	public String toString() {
		return "Client [Nom=" + Nom + ", Cognom1r=" + Cognom1r + ", Cognom2n=" + Cognom2n + ", DNI=" + DNI
				+ ", telefono=" + telefono + ", correu_electronic=" + correu_electronic + ", CP=" + CP + ", Pais="
				+ Pais + ", Edat=" + Edat + ", Data_Naixement=" + Data_Naixement + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(DNI, other.DNI);
	}

}
