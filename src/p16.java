
public class p16 {
	public static void main(String[] args){

		DiccTM diccio=new DiccTM();
		diccio.leeDiccionario("p11.dic");
		System.out.println("Visualizo normal");
		System.out.println();
		diccio.visualiza();
		System.out.println();
		diccio.visualiza(40, 'E');
		System.out.println();
		diccio.visualiza(60, 'K');
		System.out.println();
		System.out.println("Saco -5. No deberia aparecer nada");
		diccio.visualiza(-5);
		System.out.println();
		System.out.println("Saco solo 5");
		diccio.visualiza(5);
		System.out.println("Saco solo 5 en portugues");
		diccio.visualiza(5, 'P');
		System.out.println("Saco solo -5 en portugues");
		diccio.visualiza(-5, 'P');
		System.out.println("Saco solo 0  en espanol");
		diccio.visualiza(0, 'P');
		System.out.println("Saco solo 0 ");
		diccio.visualiza(0);
	}
}