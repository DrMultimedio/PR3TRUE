//Autor JMPA
//En mi siguiente truco, traducire unas palabras ricas ricas si se diese el caso
public class p08 {
	public static void main(String[] args){

		DiccTM diccio=new DiccTM();
		diccio.leeDiccionario("p11.dic");
		diccio.visualiza();
		System.out.println();
		System.out.println("Ahora las trad");
		System.out.println("Le paso tv ->" + diccio.traduce("tv", 'E'));
		System.out.println("Le paso un Tv ->" + diccio.traduce("Tv", 'F'));
		System.out.println("Le paso un tV ->" + diccio.traduce("tV", 'P'));
		System.out.println("Le paso un west ->" + diccio.traduce("west", 'P'));
		System.out.println("Le paso un West ->" + diccio.traduce("West", 'F'));
		System.out.println("Le paso un wrOng ->" + diccio.traduce("wrOng", 'P'));
		System.out.println("Le paso un wrONG ->" + diccio.traduce("wrONG", 'E'));
		System.out.println("Le paso un family ->" + diccio.traduce("family", 'E'));
		System.out.println("Le paso un faMily ->" + diccio.traduce("faMily", 'P'));
		System.out.println("Le paso un family ->" + diccio.traduce("family", 'F'));

		//esta traduccion no existe
		System.out.println("Le paso un family ->" + diccio.traduce("family", 'k'));
		System.out.println("Le paso un idioma que no existe ->" + diccio.traduce("warm", 'B'));
		System.out.println("Le paso una palabra que no existe ->" +diccio.traduce("perrete", 'F'));
		System.out.println("Le paso una palabra que no existe y un idioma que tampoco->" +diccio.traduce("null", 'B'));
		System.out.println("Le paso null ->" + diccio.traduce(null, 'B'));

	}
}
