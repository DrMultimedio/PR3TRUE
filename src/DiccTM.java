//DNI 48727303 PALAU ALEGRIA, JOSE MANUEL
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class DiccTM implements Diccionario{

	private int nlenguas;
	private ArrayList<Character> lenguas; 
	private TreeMap<String, Vector<String>> dicc;
	private char[] lenguasaux;
	public DiccTM(){
		nlenguas = -1;
		lenguas = new ArrayList<Character>();
		dicc = new TreeMap<String, Vector<String>>(String.CASE_INSENSITIVE_ORDER);
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
		}catch (IOException ex){//si esto falla lanzaremos la excepcion
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


	public int getNlenguas(){
		return nlenguas;
	}
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
		if(dicc.containsKey(p.getOrigen())){//si tengo la palabra
			Vector<String> trad = p.getTraducciones();
			for(int i = 0 ; i<nlenguas; i++){//recorro las traducciones de palabra
				if(dicc.get(p.getOrigen()).get(i) == null && trad.get(i) != null){ //si no hay traduccion a la palabra y hay traducciones en palabra
					dicc.get(p.getOrigen()).set(i, trad.get(i));
					ret = true;
				}
				else{//si hay traduccion, habra que cambiarla SI NO ES LA MISMA :o
					if(!dicc.get(p.getOrigen()).get(i).equalsIgnoreCase(trad.get(i))){ 
						//si son diferentes sustituyo
						dicc.get(p.getOrigen()).set(i, trad.get(i));
						ret = true;
					}
					//si son iguales no hago nada
				}
			} //aqui se acaba el for
			
		}
		else{
			dicc.put(p.getOrigen(), p.getTraducciones());
			ret = true;
		}
		
		
		return ret;
	}

	@Override
	public boolean borra(String s) {
		//pues nada, haremos el iterador >:D
		boolean ret = false; //por defecto devuelvo 0
		Iterator<String> iterador = dicc.keySet().iterator(); //guardo en el iterador las palabras origen
		String iterado;
		while(iterador.hasNext()){
			iterado = iterador.next();
			if(iterado.equalsIgnoreCase(s)){
				dicc.remove(iterado);
				ret = true;
				break;
			}
			
		}
		return ret;
	}

	@Override
	public int busca(String s) {
		//pues nada, haremos el iterador >:D
		int ret = -1; //por defecto devuelvo 0
		Iterator<String> iterador = dicc.keySet().iterator(); //guardo en el iterador las palabras origen
		String iterado;
		while(iterador.hasNext()){
			iterado = iterador.next();
			if(iterado.equalsIgnoreCase(s)){
				ret = 1;
				break;
			}
			
		}
		return ret;
	}

	@Override
	public String traduce(String s, char l) {
		// TODO Auto-generated method stub
		int i = 0;
		boolean found = false;
		if(dicc.containsKey(s)){
			for(; i<lenguas.size() && found == false;i++){
				if(lenguas.get(i) == l){
					found = true;
				}
			}
		}
		if (found == true){
			return dicc.get(s).get(i);
		}
		else{
			return null;
		}
	}

	@Override
	public void visualiza() {
//npi de recorrer el arbol. Preguntare a Alicia ;_;
		//let's give a try to iterators ^^
		Iterator<String> iterador = dicc.keySet().iterator(); //guardo en el iterador las palabras origen
		String iterado;
		while(iterador.hasNext()){
			iterado = iterador.next();
			Vector <String> traducciones=dicc.get(iterado);
			System.out.print(iterado);
			for(int i=0; i<traducciones.size();i++){
				System.out.print(":"+traducciones.elementAt(i));
			}
			System.out.println();
			
		}
	}

	@Override
	public void visualiza(int j) {
		// TODO Auto-generated method stub
		//let's give a try to iterators ^^
		Iterator<String> iterador = dicc.keySet().iterator(); //guardo en el iterador las palabras origen
		String iterado;
		int k = 0;
		while(iterador.hasNext()&& k<j){
			iterado = iterador.next();
			Vector <String> traducciones=dicc.get(iterado);
			System.out.print(iterado);
			for(int i=0; i<traducciones.size();i++){
				System.out.print(":"+traducciones.elementAt(i));
			}
			k++;
			System.out.println();
			
		}
	}

	@Override
	public void visualiza(int j, char l) {
		// TODO Auto-generated method stub
		//let's give a try to iterators ^^
		int m = 0; //aqui guardare la posicion del lenguaje
		boolean found = false;
		for (; m<nlenguas; m++){
			if(lenguas.get(m) == l){
				found = true;
				break;
			}
		}

			Iterator<String> iterador = dicc.keySet().iterator(); //guardo en el iterador las palabras origen
			String iterado;
			int k = 0;
			while(iterador.hasNext() && k<j){
				iterado = iterador.next();
				Vector <String> traducciones=dicc.get(iterado);
				System.out.print(iterado);
				if(found == true){
					System.out.print(":"+traducciones.elementAt(m));
				}
				else{
					System.out.print(":");
				}
				System.out.println();
				k++;

			}
		
	}		

}
