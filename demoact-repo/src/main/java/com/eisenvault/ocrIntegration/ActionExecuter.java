package com.eisenvault.ocrIntegration;

import org.alfresco.service.cmr.action.Action;
import org.alfresco.service.cmr.action.ActionDefinition;
import org.alfresco.service.cmr.repository.NodeRef;

public interface ActionExecuter {
	
	/**
	    * Get the action definition for the action
	    * 
	    * @return  the action definition
	    */
	   public ActionDefinition getActionDefinition();
		
	   /**
	    * Execute the action executer
	    * 
	    * @param action				the action
	    * @param actionedUponNodeRef	the actioned upon node reference
	    */
	   public void execute(
	     	Action action,
	        NodeRef actionedUponNodeRef);

}
