package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.exception;

public class EntityNoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityNoEncontradaException(String mensaje) {
		super(mensaje);
	}

}