package model.exception;

public class ValueError extends Exception {
	private static final long serialVersionUID = 1L;

	public ValueError(String msg) {
		super(msg);
	}
}
