package vladimir.milosavljevic.exception;

public class EntityNotPresent extends MyApplicationException {

	private final Object entity;

	public EntityNotPresent(Object entity, String message) {
		super(message);
		this.entity = entity;
	}

	public Object getEntity() {
		return entity;
	}

		
}
