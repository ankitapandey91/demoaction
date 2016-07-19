package com.act.action.executer;

import java.util.List;


import org.alfresco.service.cmr.action.Action;
import org.alfresco.service.cmr.action.ParameterDefinition;
import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.alfresco.service.cmr.repository.NodeRef;


import com.eisenvault.ocrIntegration.OCRMethods;


/**
 * 
 * Run OCR links on folders
 * @author Ankita Pandey
 * 
 */


public class EnglishFolderActionExecuter extends OCRMethods
{

	public static final String NAME = "EnglishOcr-Folder";
	/*public static final String PARAM_ASPECT_NAME = "folder-name";*/
	//private NodeService nodeService;
	

	/**
	 * Set the node service
	 *
	 * @param nodeService  the node service
	 */
	/*public void setNodeService(NodeService nodeService)
	{
		this.nodeService = nodeService;
	}
*/
	/**
	 * @param ruleAction 
	 * @see org.alfresco.repo.action.executer.ActionExecuterAbstractBase#executeImpl(Action, NodeRef)
	 */
		
/*	public void executeImpl(Action ruleAction, NodeRef actionUponNodeRef)
	{
	    List<ChildAssociationRef> childAssociationRef = nodeService.getChildAssocs(actionUponNodeRef);
	    
	    int count = 0;
	    //System.out.println("*****************************************" + nodeService.getChildAssocs(actionUponNodeRef));
	    
	    
	    for (ChildAssociationRef childAssoc : childAssociationRef) 
	    {
	      
	     // this.executeOCR(ruleAction, childAssoc.getChildRef(), NAME, "eng");
		   
	      System.out.println("******Child nodes inside are******"+ childAssoc.getChildRef());
	      count++;
	      System.out.println("******Total nodes count is******"+ count);
	      
	  
	    }
	    
    }*/
	
	public void executeImpl(Action ruleAction, NodeRef actionUponNodeRef)
	{
	    ChildAssociationRef childAssociationRef = nodeService.getPrimaryParent(actionUponNodeRef);

	    iterateThroughChildren(ruleAction,childAssociationRef);
	}
	
	public void iterateThroughChildren( Action ruleAction,ChildAssociationRef childAssocRef)
	{
	    //System.out.println("****The folder is***** "+ childAssocRef);
	    NodeRef childNodeRef = childAssocRef.getChildRef();
	    List<ChildAssociationRef> children = nodeService.getChildAssocs(childNodeRef);

	    int count = 0;
	    for (ChildAssociationRef childAssoc : children) 
	    {
	       childAssoc.getChildRef();
	      // Use childNodeRef here.
	       
	       executeOCR(ruleAction, childAssoc.getChildRef(), NAME, "eng");
	       System.out.println("******Child nodes inside are******"+ childAssoc.getChildRef());
	       count++;
		   System.out.println("******Total nodes count is******"+ count);

	      // This call recurses the method with the new child.
	      iterateThroughChildren(ruleAction,childAssoc);
	      // If there are no children then the list will be empty and so this will be skipped.


	    }
	}

	/*public void iterateThroughFolder(Action ruleAction,ChildAssociationRef childAssocRef)
	{
	    //System.out.println("****The folder is***** "+ childAssocRef);
	    NodeRef childNodeRef= childAssocRef.getChildRef();
	    List<ChildAssociationRef> children = nodeService.getChildAssocs(childNodeRef);

	    for (ChildAssociationRef childAssoc : children) 
	    {
	       ChildAssociationRef childAssociationRef = nodeService.getPrimaryParent(childNodeRef);	
	      // EnglishOCRActionExecuter engocr = new EnglishOCRActionExecuter();
	      NodeRef ref = new NodeRef("childAssociationRef");
	       this.executeOCR(ruleAction, ref, NAME, "eng");
		   //engocr.executeImpl(ruleAction, ref);
	      // childAssoc.getChildRef();
	      // Use childNodeRef here.
	      System.out.println("******Documents inside are******"+ childAssoc);
	      iterateThroughFolder(ruleAction,childAssoc);
	     
	    }
	}*/

	/**
	 * @see org.alfresco.repo.action.ParameterizedItemAbstractBase#addParameterDefinitions(java.util.List)
	 */

	@Override
	protected void addParameterDefinitions(List<ParameterDefinition> paramList) {
		// Add definitions for action parameters
		/*paramList.add(
				new ParameterDefinitionImpl(                       // Create a new parameter defintion to add to the list
						PARAM_ASPECT_NAME,                              // The name used to identify the parameter
						DataTypeDefinition.QNAME,                       // The parameter value type
						false,                                           // Indicates whether the parameter is mandatory
						getParamDisplayLabel(PARAM_ASPECT_NAME)));   */   // The parameters display label

	}
}

