import java.util.Scanner;

public class ahorcadoP {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		//Juego del ahorcado 
		String palabra;int cont=0;int contP=0;int contG=0;boolean ganador=false;boolean salir=false;boolean okP = false;int vida=3;
		//System.out.println("Introduce palabra:");
		//palabra=teclado.nextLine();
		palabra="donetes";
		char[] pal=palabra.toCharArray();
		char[] arrJ=new char[pal.length];
		char letra = 0;
		//Creando el array de juego
		for(int i=0;i<arrJ.length;i++) {
			arrJ[i]='_';
		}
		//Mostrar array de juego
		for(int i=0;i<arrJ.length;i++) {
			System.out.print(arrJ[i]+" ");
		}
		do {
			do {
				try{
					okP=true;
					System.out.println("\nIntroduce letra:");
					letra=teclado.nextLine().charAt(0);
				}catch(StringIndexOutOfBoundsException e) {
					okP=false;
					System.out.println("Debes escribir una letra");
				}
			}while(okP==false);
			if(letra=='!')
				salir=true;
			else {
			//Recorres el arrayJuego y si la letra coincide con algun caracter del array palabra--> la posicion de arrayjuego se actualiza 
				for(int i=0;i<arrJ.length;i++) {
					if(letra==pal[i]) {
						arrJ[i]=letra;
					}else {
						cont++;
						if(cont==arrJ.length)
							contP++;
					}
				}
				System.out.println("Intentos restantes: "+(3-contP));
				//Mostrar array de juego actualizado
				for(int i=0;i<arrJ.length;i++) {
					System.out.print(arrJ[i]+" ");
				}
				//Ganador
				for(int i=0;i<arrJ.length;i++) {
					if(arrJ[i]==pal[i]) {
						contG++;
						if(contG==arrJ.length)
							ganador=true;
					}
				}            
				cont=0;contG=0;
				//Comprobacion para salir del juego
				if( ganador==true || contP==3) {
					salir=true;
				}
			}
		}while(salir!=true);
		if(ganador==true)
			System.out.println("\n!!HAS GANADO!!");
		else if(contP==vida) {
			System.out.println("\n!!HAS PERDIDO!!");
			System.out.print("\nPalabra: ");
			for(int i=0;i<pal.length;i++) {
				System.out.print(pal[i]);
			}
		}
		else if(letra=='!') {
			System.out.println("\nHas salido correctamente");
		}
	}

}
