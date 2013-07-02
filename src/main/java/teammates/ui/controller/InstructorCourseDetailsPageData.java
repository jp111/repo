package teammates.ui.controller;

import java.util.List;

import teammates.common.datatransfer.AccountAttributes;
import teammates.common.datatransfer.CourseDetailsBundle;
import teammates.common.datatransfer.InstructorAttributes;
import teammates.common.datatransfer.StudentAttributes;
import teammates.common.util.Config;
import teammates.common.util.Url;

public class InstructorCourseDetailsPageData extends PageData {
	
	public InstructorCourseDetailsPageData(AccountAttributes account) {
		super(account);
	}

	public CourseDetailsBundle courseDetails;
	public List<StudentAttributes> students;
	public List<InstructorAttributes> instructors;
	
	
	public String getInstructorCourseRemindLink(){
		String link = Config.PAGE_INSTRUCTOR_COURSE_REMIND;
		link = Url.addParamToUrl(link,Config.PARAM_COURSE_ID,courseDetails.course.id);
		link = addUserIdToUrl(link);
		return link;
	}
	
	
	public String getCourseStudentDetailsLink(StudentAttributes student){
		String link = Config.PAGE_INSTRUCTOR_COURSE_STUDENT_DETAILS;
		link = Url.addParamToUrl(link,Config.PARAM_COURSE_ID,courseDetails.course.id);
		link = Url.addParamToUrl(link,Config.PARAM_STUDENT_EMAIL,student.email);
		link = addUserIdToUrl(link);
		return link;
	}
	
	
	public String getCourseStudentEditLink(StudentAttributes student){
		String link = Config.PAGE_INSTRUCTOR_COURSE_STUDENT_DETAILS_EDIT;
		link = Url.addParamToUrl(link,Config.PARAM_COURSE_ID,courseDetails.course.id);
		link = Url.addParamToUrl(link,Config.PARAM_STUDENT_EMAIL,student.email);
		link = addUserIdToUrl(link);
		return link;
	}
	
	
	public String getCourseStudentRemindLink(StudentAttributes student){
		String link = Config.PAGE_INSTRUCTOR_COURSE_REMIND;
		link = Url.addParamToUrl(link,Config.PARAM_COURSE_ID,courseDetails.course.id);
		link = Url.addParamToUrl(link,Config.PARAM_STUDENT_EMAIL,student.email);
		link = addUserIdToUrl(link);
		return link;
	}
	
	
	public String getCourseStudentDeleteLink(StudentAttributes student){
		String link = Config.PAGE_INSTRUCTOR_COURSE_STUDENT_DELETE;
		link = Url.addParamToUrl(link,Config.PARAM_COURSE_ID,courseDetails.course.id);
		link = Url.addParamToUrl(link,Config.PARAM_STUDENT_EMAIL,student.email);
		link = addUserIdToUrl(link);
		return link;
	}
	
}