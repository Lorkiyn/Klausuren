package Klausur3;

public class GegenstandNichtGefundenException extends Exception{

	private static final long serialVersionUID = 1L;
	private int index;
	
	GegenstandNichtGefundenException(int index) {
		this.index = index;
	}
	
	@Override
	public String getMessage() {
		return "Unter dem Index " +index +". wurde nichts gefunden!";
	}

}
