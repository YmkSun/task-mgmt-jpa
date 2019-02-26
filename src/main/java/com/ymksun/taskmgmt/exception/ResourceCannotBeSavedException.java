package com.ymksun.taskmgmt.exception;

@SuppressWarnings("serial")
public class ResourceCannotBeSavedException extends ApplicationPlatformException {
	
	public static enum RESOURCE_CANNOT_BE_CREATED_REASON {
		
        NAME_VALUE_NULL_STAGE;

        public String errorMessage() {
            if (name().toString().equalsIgnoreCase("NAME_VALUE_NULL_STAGE")) { return "name value is null in %s"; }
            return name().toString();
        }

    }

	public ResourceCannotBeSavedException(RESOURCE_CANNOT_BE_CREATED_REASON reason, String resourceName) {
		super(String.format(reason.errorMessage(), resourceName));
	}

}
