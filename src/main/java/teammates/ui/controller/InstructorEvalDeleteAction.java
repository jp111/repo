package teammates.ui.controller;

import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Config;
import teammates.logic.GateKeeper;

public class InstructorEvalDeleteAction extends InstructorEvalPageAction {
	
	@Override
	protected ActionResult execute() 
			throws EntityDoesNotExistException,	InvalidParametersException {
		
		String courseId = getRequestParam(Config.PARAM_COURSE_ID);
		String evalName = getRequestParam(Config.PARAM_EVALUATION_NAME);
		
		new GateKeeper().verifyAccessible(
				logic.getInstructorForGoogleId(courseId, account.googleId), 
				logic.getEvaluation(courseId, evalName));
		
		logic.deleteEvaluation(courseId,evalName);
		statusToUser.add(Config.MESSAGE_EVALUATION_DELETED);
		statusToAdmin = "Evaluation <span class=\"bold\">" + evalName + 
				"</span> in Course <span class=\"bold\"[" + courseId + "]/span> deleted";
		
		return createRedirectResult(Config.PAGE_INSTRUCTOR_EVAL);
	}
	
}