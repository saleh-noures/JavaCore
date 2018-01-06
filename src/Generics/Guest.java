package Generics;


public class Guest {

	public static void main(String[] args) {

		Tray tray = new Tray();

		tray.addGlass(new Glass<Juice>());

		tray.addGlassOfJuice(new Glass<AppleJuice>());

		tray.addGlassOfJuiceAndUppder(new Glass<Juice>());

	}

}
