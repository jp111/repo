package teammates.ui.controller;

import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.exception.UnauthorizedAccessException;
import teammates.common.util.Config;
import teammates.logic.GateKeeper;

import com.google.apphosting.api.DeadlineExceededException;

public class AdminExceptionTestAction extends Action {

	@Override
	protected ActionResult execute() throws EntityDoesNotExistException,
			InvalidParametersException {

		new GateKeeper().verifyAdminPrivileges(account);

		String error = getRequestParam(Config.PARAM_ERROR);

		if (error.equals(AssertionError.class.getSimpleName())) {
			throw new AssertionError("AssertionError Testing");

		} else if (error.equals(EntityDoesNotExistException.class.getSimpleName())) {
			throw new EntityDoesNotExistException("EntityDoesNotExistException Testing");

		} else if (error.equals(UnauthorizedAccessException.class.getSimpleName())) {
			throw new UnauthorizedAccessException();

		} else if (error.equals(NullPointerException.class.getSimpleName())) {
			throw new NullPointerException();
			
		} else if (error.equals(DeadlineExceededException.class.getSimpleName())) {
			throw new DeadlineExceededException();
		}

		statusToAdmin = "adminExceptionTest";
				
		return createRedirectResult(Config.PAGE_ADMIN_HOME);
	}

}