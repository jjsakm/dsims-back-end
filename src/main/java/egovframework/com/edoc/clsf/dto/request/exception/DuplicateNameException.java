package egovframework.com.edoc.clsf.dto.request.exception;

public class DuplicateNameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6472265477420812903L;
	
	private String fieldName;

	public DuplicateNameException(String fieldName, String message) {
		super(message);
		this.fieldName  = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}
}
