package herencia.heroes.players;

import herencia.heroes.library.NivelHeroe;
import herencia.heroes.library.Constantes;

public class Heroe {
	
	private int Vida;
	private int Puntos;
	private String Nombre;
	private NivelHeroe Nivel;
	private int PosX;
	private int PosY;
	
	public Heroe()
	{
		this("NoName",NivelHeroe.NOVATO);
	}
	
	public Heroe(String pNombre, NivelHeroe pLevel)
	{
		setNombre(pNombre);
		setNivel(pLevel);
		setVida(100);
		setPuntos(0);
		this.PosX = Constantes.ANCHO_JUEGO/2;
		this.PosY = Constantes.LARGO_JUEGO;
	}
	
	// Methods
	
	public void moverIzquierda()
	{
		this.PosX = this.PosX>0 ? this.PosX-1 : 0;
	}
	
	public void moverDerecha()
	{
		this.PosX=this.PosX<Constantes.ANCHO_JUEGO ? this.PosX+1 : Constantes.ANCHO_JUEGO;
	}
	
	public void caminar()
	{
		caminar(Constantes.PIXELS_WALK_SPEED);
	}
	
	public void saltar()
	{
		caminar(Constantes.PIXELS_PER_JUMP);
	}
	
	public void atacar()
	{
		
	}
		
	private void caminar(int pCantidadPixeles)
	{
		this.PosY = this.PosY-pCantidadPixeles>0 ? this.PosY-pCantidadPixeles : 0;
	}
	
	// Getters and setters
	public int getVida() {
		return Vida;
	}
	
	public void setVida(int vida) {
		Vida = vida;
	}
	
	public int getPuntos() {
		return Puntos;
	}
	
	public void setPuntos(int puntos) {
		Puntos = puntos;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public NivelHeroe getNivel() {
		return Nivel;
	}
	
	public void setNivel(NivelHeroe nivel) {
		Nivel = nivel;
	}
}
