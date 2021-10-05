package vladimir.milosavljevic.exception;

public class ExistEntityException extends MyApplicationException {

	private static final long serialVersionUID = -7748804984530463218L;

	private final Object entity;

	public ExistEntityException(Object entity, String message) {
		super(message);
		this.entity = entity;
	}

	public Object getEntity() {
		return entity;
	}

}
