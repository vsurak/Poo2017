package herencia.heroes.juego;

import herencia.heroes.players.*;
import herencia.heroes.library.*;

public class JuegoHeroes 
{
	public static void main(String args[])
	{
		Heroe nuevo0 = new Heroe("Pedro", NivelHeroe.KILLER);
		Heroe nuevo1 = new Heroe();
		Gladiador nuevo2 = new Gladiador();
		
		System.out.println(nuevo0.getNombre());
		System.out.println(nuevo1.getNombre());
		System.out.println(nuevo2.getNombre());
	}
}
