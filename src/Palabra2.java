//DNI 48727303 PALAU ALEGRIA, JOSE MANUEL
import java.util.*;
//palabra2 contendrá una palabra con sus traducciones
public class Palabra2 {
	private char[] lenguas; 
	private String origen; //palabra de la lengua origen
	private Vector<String> trad;
	
	//constructor con dos parametros
	public Palabra2(String p, char [] l){
		
		origen= p;
		lenguas=l;
		
		//inicializo el vector trad
		trad = new Vector<String>();
		if (lenguas!=null){ //si lenguas no es null
		for(int i=0;i<lenguas.length;i++){
			trad.add("");
		}
		}
		else{ //si lenguas es null inicializo sin lenguas
			//inicializo el array de caracteres
			lenguas = new char[3];
			//pongo los valores por defecto
			lenguas[0] = 'E';
			lenguas[1] = 'F';
			lenguas[2] = 'P';
			
			//inicializo el vector trad
			trad = new Vector<String>();
			for(int i=0;i<lenguas.length;i++){
				trad.add("");
			}
		}
	}
	
	//constructor solo con string
	public Palabra2(String p){
		
		origen=p;
		
		//inicializo el array de caracteres
		lenguas = new char[3];
		//pongo los valores por defecto
		lenguas[0] = 'E';
		lenguas[1] = 'F';
		lenguas[2] = 'P';
		
		//inicializo el vector trad
		trad = new Vector<String>();
		for(int i=0;i<lenguas.length;i++){
			trad.add("");
		}
	}

	
	
	//constructor solo con char
	public Palabra2(char[] l){
		
		//pongo lenguas al valor que nos pasan
		lenguas=l;
		//pongo origen a vacío
		origen="";
		
		//inicializo el vector trad
		trad = new Vector<String>();
		for(int i=0;i<lenguas.length;i++){
			trad.add("");
		}
	}
	
	//almacena una traduccion
	public int setTrad(String t, char l){
		
		//compruebo donde esta el idioma en cuestion
		for(int i=0; i<lenguas.length;i++){
			
			//si encuentro la lengua en cuestion, meto la traduccion en la posicion de la lengua
			if (l==lenguas[i]){ 
				if(!trad.get(i).equals(t)){ //si es la misma no hago nada
				trad.setElementAt(t, i);
				return i;
				}
				//el return devuelve la posicion de trad que ocupa la traduccion almacenada
			}
		}
		
		//el return aqui devuelve la posicion de trad que ocupa la traduccion almacenada
		//por defecto, devuelve -1
		return -1;
		
	}
	public String getOrigen(){
		
		return origen;
		
	}
	
	public String getTraduccion(char l){
		
		//esto devuelve la cadena con la traduccion de la la lengua l, por defecto null
		//compruebo donde está el idioma en cuestion
		for(int i=0; i<lenguas.length;i++){
			
			//si encuentro la lengua en cuestion, devuelvo la traduccion en la posicion de la lengua
			if (l==lenguas[i]){ 
				if(trad.get(i).equals(""))
				{
					return null;
				}
				else{
					return trad.get(i);
				}
				
			}
		}
		
		return null;
		
	}
	public Vector<String> getTraducciones(){
		return trad;
	}
	public void escribeInfo(){
		//este metodo escribe por pantalla con el formato origen:trad1:trad2:trad3...:tradi
		System.out.print(origen);
		for(int i=0;i<lenguas.length;i++){
			System.out.print(":" + trad.get(i));
		}
		System.out.println();
	}
	public int combinaPalabra(Palabra2 p){
		//este metodo combina dos palabras, si sus atributos origen y lenguas coinciden
		//devuelve donde se insertó, o menos 1 por defecto
		int ret=0;
		if (this.origen.equals(p.origen)&&this.lenguas.length==p.lenguas.length)
		{
			for(int i=0; i<lenguas.length;i++)
			{
				if(this.lenguas[i] == p.lenguas[i] && p.getTraduccion(p.lenguas[i])!=null)
				{
					
					if(this.setTrad(p.getTraduccion(lenguas[i]), lenguas[i])>=ret)
						ret++;
				}
			}
		}
		if (ret>0)
			return ret;
		else
		return -1;
	}

	public char[] getLenguas() {
		return lenguas;
	}

	public void escribeInfoTrad(char l) {
		
		//devuelvo una cadena con origen:trad1:trad2:trad3
		System.out.print(origen);
		System.out.print(":" + this.getTraduccion(l));
		System.out.println();
		
	}
	
}
