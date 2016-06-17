//DNI 48727303 PALAU ALEGRIA, JOSE MANUEL
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class DiccTM implements Diccionario{

	private int nlenguas;
	private ArrayList<Character> lenguas; //E español, P portugues, F frances
	private TreeMap<String, Vector<String>> dicc;
	private char[] lenguasaux;
	public DiccTM(){
		nlenguas = -1;
		lenguas = new ArrayList<Character>();
		dicc = new TreeMap<String, Vector<String>>();
	}

	@Override
	public void leeDiccionario(String f){

		//definimos las variables de instancia

		FileReader fichero= null;
		BufferedReader lectura= null;

		try{ 
			//inicializamos las variables de instancia

			fichero= new FileReader(f);
			lectura= new BufferedReader(fichero);
			String linea = lectura.readLine();
			int i=0;
			while (linea!=null){
				leerLineaDicc(linea, i);
				linea=lectura.readLine(); //leemos el documento linea a linea
				i++;
			}
		}catch(IOException e){
			System.err.println("Error con el archivo");
			System.out.println(f);
		}
		//y cerramos el fichero
		try{
			if (fichero!=null)//comprobamos que fichero no sea null
				fichero.close();
			if (lectura!=null)//ni que lectura sea null
				lectura.close();
		}catch (IOException ex){//si esto falla lanzaremos la excepci�n
			System.out.println(ex);
		}


	}
	public void leerLineaDicc(String texto, int linea) {

		if(linea==0){ //si es la primera linea, es donde este el numero de lenguas
			nlenguas= Integer.parseInt(texto);
			lenguasaux = new char[nlenguas];
		}
		if(linea==1){//si es la segunda, es donde estan las lenguas
			String separador= " ";
			String [] s = texto.split( separador ) ;
			for(int i=0; i<nlenguas;i++){
				lenguas.add(s[i].charAt(0)); //meto las lenguas en un vector de caracteres
				lenguasaux[i]=s[i].charAt(0); //y en un array de caracteres para  enviarsealas a las palabras2
			}

		}

		if(linea>1){
			String separador1= "[ ]*\\*[ ]*";

			String[] s = texto.split(separador1);
			Palabra2 p=new Palabra2(s[0], lenguasaux);

			//recorro el array que he creado separando la linea, menos uno, dado que 
			//origen ya la he almacenado
			for(int j=0; j<s.length-1 && j<p.getLenguas().length;j++){
				if (s[j]!=null)
				{
					//j+1 porque s[0] es la palabra origen
					p.setTrad(s[j+1], p.getLenguas()[j]);	

				}

			}
			inserta(p);

		}

	}


	@Override
	public boolean inserta(Palabra2 p) {
		// TODO Auto-generated method stub
		boolean ret = false;
		//comprobamos que nada sea null
		if(p != null && p.getOrigen() != null){
			for(int i = 0; i<lenguas.size(); i++){
				//comprobamos que la palabra tenga los mismos idiomas
				if(lenguas.get(i) != p.getLenguas()[i]){
					return false;
					//si uno solo no coincide salimos
				}
			}
			//a partir de este punto las lenguas son iguales
			//y nada es null
			//y el mundo es maravilloso (ok no)
			
		}
		if(dicc.containsKey(p.getOrigen())){
			
		
		}
		
		
		return ret;
	}

	@Override
	public boolean borra(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int busca(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String traduce(String s, char l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visualiza() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visualiza(int j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visualiza(int j, char l) {
		// TODO Auto-generated method stub
		
	}
}
