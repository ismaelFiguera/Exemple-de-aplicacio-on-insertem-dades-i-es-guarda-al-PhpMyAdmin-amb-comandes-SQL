package almata.persistencia;




import almata.domini.Client;


public class HelperBBDDMem {
	public static void addClient(Client client) {
		
		
		GestorDB.modificaDB("INSERT INTO `Clients`(`Nom`, `1r Cognom`, `2n Cognom`, `DNI`, `Telefon`, `Correu Electronic`, `Codi Postal`, `Pais`, `Edat`, `Data Naixement`, `Hora`, `Data`)"
				+ "VALUES ('"+client.getNom()+"','"+client.getCognom1r()+"','"+client.getCognom2n()+"','"+client.getDNI()+"',"+client.getTelefono()+",'"+client.getCorreu_electronic()+"',"
						+ ""+client.getCP()+",'"+client.getPais()+"',"+client.getEdat()+",'"+client.getData_Naixement()+"','"+client.now()+"', '"+client.dia()+"')");
		
		System.out.println(client);
	}


}
