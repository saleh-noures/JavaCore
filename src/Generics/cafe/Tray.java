package Generics.cafe;

/*
? means Anything (Type)
There are three types of wildcard usages
1- Unbounded WildCards
2- Upper bounded wildcards
3- Lower bounded wildcards
*/

/* https://www.youtube.com/watch?v=1Omf1Vba44Y */

public class Tray
{
	/*Unbounded WildCards*/
	/*you can pass any type parameters E.g Object, String, ...*/
	public void addGlass(Glass<?> g)
	{
	}
	/*Upper bounded WildCards*/
	/*Any subclass of Juice class or Juice class itself */
	public void addGlassOfJuice(Glass<? extends Juice> g)
	{
	}
	/*Lower bounded WildCards*/
	/*Any Super type of OrangeJuice, E.g. Juice and Liquid */
	public void addGlassOfJuiceAndUppder(Glass<? super OrangeJuice> g)
	{
	}
}
