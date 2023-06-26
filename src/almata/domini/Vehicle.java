package almata.domini;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Vehicle {
	private String DNI_Client;
	private String Tipus_Vehicle;
	private String Marca_Vehicle;
	private Float Kilometratge;
	private Float Valor_Vehicle;
	private int ID;

	
	
	public Vehicle(String dNI_Client, String tipus_Vehicle, String marca_Vehicle, Float kilometratge,
			Float valor_Vehicle, int iD) {
		super();
		this.DNI_Client = dNI_Client;
		this.Tipus_Vehicle = tipus_Vehicle;
		this.Marca_Vehicle = marca_Vehicle;
		this.Kilometratge = kilometratge;
		this.Valor_Vehicle = valor_Vehicle;
		this.ID = iD;
	}

	public Vehicle() {
		super();
	}

	public Vehicle(int iD) {
		super();
		this.ID = iD;
	}

	
	
	public String getDNI_Client() {
		return DNI_Client;
	}

	public void setDNI_Client(String dNI_Client) {
		DNI_Client = dNI_Client;
	}

	public String getTipus_Vehicle() {
		return Tipus_Vehicle;
	}

	public void setTipus_Vehicle(String tipus_Vehicle) {
		Tipus_Vehicle = tipus_Vehicle;
	}

	public String getMarca_Vehicle() {
		return Marca_Vehicle;
	}

	public void setMarca_Vehicle(String marca_Vehicle) {
		Marca_Vehicle = marca_Vehicle;
	}

	public Float getKilometratge() {
		return Kilometratge;
	}

	public void setKilometratge(Float kilometratge) {
		Kilometratge = kilometratge;
	}

	public Float getValor_Vehicle() {
		return Valor_Vehicle;
	}

	public void setValor_Vehicle(Float valor_Vehicle) {
		Valor_Vehicle = valor_Vehicle;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public LocalTime hora() {
		LocalTime a1 = LocalTime.now();
		return a1;
	}
	
	public LocalDate dia() {
		LocalDate a1 = LocalDate.now();
		return a1;
	}

	
	
	@Override
	public String toString() {
		return "Vehicle [DNI_Client=" + DNI_Client + ", Tipus_Vehicle=" + Tipus_Vehicle + ", Marca_Vehicle="
				+ Marca_Vehicle + ", Kilometratge=" + Kilometratge + ", Valor_Vehicle=" + Valor_Vehicle + ", ID=" + ID
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return ID == other.ID;
	}

}
