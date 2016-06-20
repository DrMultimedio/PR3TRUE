
public class p07 {
	public static void main(String[] args){
	    Diccionario diccio=new DiccTM();
	    diccio.leeDiccionario("p07.dic");
	    diccio.visualiza();
	    System.out.println("No deberia haber nada aqui");
	    char[] lenguas = new char[2];
	    lenguas[0] = 'S';
	    lenguas[1] = 'E';
	    Palabra2 pal1 = new Palabra2("Frisk", lenguas);
	    Palabra2 pal2 = new Palabra2("Sans", lenguas);
	    Palabra2 pal21 = new Palabra2("Sans", lenguas);
	    Palabra2 pal22 = new Palabra2("Sans", lenguas);
	    Palabra2 pal3 = new Palabra2("Papyrus", lenguas);
	    Palabra2 pal4 = new Palabra2("Toriel", lenguas);
	    Palabra2 pal5 = new Palabra2("Undyne", lenguas);
	    Palabra2 pal6 = new Palabra2("Asgore", lenguas);
	    Palabra2 pal7 = new Palabra2("Frisk");
	    Palabra2 pal8 = new Palabra2("Undyne", lenguas);
	    Palabra2 pal9 = new Palabra2("Asgore", lenguas);
	    
	    pal1.setTrad("El infante caido", 'S');
	    pal1.setTrad("The fallen child", 'E');
	    pal2.setTrad("El bromista", 'S');
	    pal21.setTrad("The judge", 'E');
	    pal22.setTrad("The joker", 'E');
	    pal4.setTrad("Goat mom", 'E');
	    pal4.setTrad("Da queen", 'E');
	    pal5.setTrad("La verdadera heroina", 'S');
	    pal6.setTrad("Goat dad", 'E');
	    pal8.setTrad("Fishy", 'E');
	    pal8.setTrad("Sushi", 'S');
	    pal9.setTrad("El rey", 'S');
	    pal9.setTrad("Goat dad", 'E');

	    System.out.println("Insertamos pal 1 -> " + diccio.inserta(pal1) );
	    System.out.println("Insertamos pal 1 otra vez-> " + diccio.inserta(pal1) );
	    System.out.println("Insertamos pal 2 -> " + diccio.inserta(pal2) );
	    System.out.println("Insertamos pal 3 -> " + diccio.inserta(pal3) );
	    System.out.println("Insertamos pal 4 -> " + diccio.inserta(pal4) );
	    System.out.println("Insertamos pal 5 -> " + diccio.inserta(pal5) );
	    System.out.println("Insertamos pal 6 -> " + diccio.inserta(pal6) );
	    System.out.println("Insertamos pal 7 -> " + diccio.inserta(pal7) );
	    System.out.println("Insertamos pal 8 -> " + diccio.inserta(pal8) );
	    System.out.println("Insertamos pal 9 -> " + diccio.inserta(pal9) );
	    System.out.println("Insertamos pal 2,1 -> " + diccio.inserta(pal21) );
	    System.out.println("Insertamos pal 2,2 -> " + diccio.inserta(pal22) );
	    System.out.println();
	    System.out.println("SHOW ME WHAT YOU GOT");
	    diccio.visualiza();
	
	}
}
