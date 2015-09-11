/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.nbi.childportal.pojos.Child;
import com.nbi.childportal.pojos.Role;
import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.ngo.ChildAcademicReport;
import com.nbi.childportal.pojos.ngo.ChildHealthReport;
import com.nbi.childportal.pojos.ngo.ChildOverallReport;
import com.nbi.childportal.pojos.ngo.ChildSponsorship;
import com.nbi.childportal.pojos.ngo.PaymentDetail;
import com.nbi.childportal.pojos.ngo.Sponsor;

/**
 * @author zahmad
 *
 */
public class SearchCriteriaUtil {

	public static void addPaymentDetailCriteria(PaymentDetail paymentDetail, Criteria criteria) {
		if(paymentDetail==null) return;

		if(paymentDetail.getAmountPaid()!=null && !"".equalsIgnoreCase(paymentDetail.getAmountPaid())){
			criteria.add(Restrictions.eq("amountPaid", paymentDetail.getAmountPaid()));
		}
		if(paymentDetail.getDateOfPayment()!=null){
			criteria.add(Restrictions.eq("dateOfPayment", paymentDetail.getDateOfPayment()));
		}
		if(paymentDetail.getPaymentDetailId()!=null && !"".equalsIgnoreCase(paymentDetail.getPaymentDetailId())){
			criteria.add(Restrictions.eq("paymentDetailId", paymentDetail.getPaymentDetailId()));
		}
		if(paymentDetail.getPaymentRef()!=null && !"".equalsIgnoreCase(paymentDetail.getPaymentRef())){
			criteria.add(Restrictions.eq("paymentRef", paymentDetail.getPaymentRef()));
		}

		if(paymentDetail.getPaymentFor()!=null){
			Criteria paymentForCriteria = criteria.createCriteria("paymentFor");
			addChildSponsorshipCriteria(paymentDetail.getPaymentFor(), paymentForCriteria);
		}
	}
	public static void addChildSponsorshipCriteria(ChildSponsorship childSponsorship, Criteria criteria) {
		
		if(childSponsorship.getChild()!=null){
			Criteria childCriteria = criteria.createCriteria("child");
			addChildCriteria(childSponsorship.getChild(), childCriteria);
		}
		if(childSponsorship.getSponsor()!=null){
			Criteria sponsorCriteria = criteria.createCriteria("sponsor");
			addSponsorCriteria(childSponsorship.getSponsor(), sponsorCriteria);
		}
		if(childSponsorship.getPaymentDetail()!=null && childSponsorship.getPaymentDetail().size()>0){
			Iterator<PaymentDetail> iter = childSponsorship.getPaymentDetail().iterator();
			while(iter.hasNext()){
				Criteria paymentDetailCriteria = criteria.createCriteria("paymentDetail");
				addPaymentDetailCriteria(iter.next(), paymentDetailCriteria);
			}
		}
		if(childSponsorship.getChildSponsorshipId()!=null && !"".equalsIgnoreCase(childSponsorship.getChildSponsorshipId())){
			criteria.add(Restrictions.eq("childSponsorshipId", childSponsorship.getChildSponsorshipId()));
		}
		if(childSponsorship.getSponsorshipPaymentCycle()!=null && !"".equalsIgnoreCase(childSponsorship.getSponsorshipPaymentCycle())){
			criteria.add(Restrictions.eq("sponsorshipPaymentCycle", childSponsorship.getChildSponsorshipId()));
		}
		if(childSponsorship.getSponsorshipType()!=null && !"".equalsIgnoreCase(childSponsorship.getSponsorshipType())){
			criteria.add(Restrictions.eq("sponsorshipType", childSponsorship.getChildSponsorshipId()));
		}
	}
	public static void addSponsorCriteria(Sponsor sponsor, Criteria criteria) {
		addUserCriteria(sponsor, criteria);
	}
	public static void addChildCriteria(Child child, Criteria criteria) {
		addUserCriteria(child, criteria);
	}

	public static void addUserCriteria(User user, Criteria criteria) {
		if(user.getAadharNo()!=null){
			criteria.add(Restrictions.eq("aadharNo", user.getAadharNo()));
		}
		if(user.getUserId()!=null){
			criteria.add(Restrictions.eq("userId", user.getUserId()));
		}
		if(user.getAddress()!=null){
			criteria.add(Restrictions.eq("address", user.getAddress()));
		}
		if(user.getName()!=null){
			criteria.add(Restrictions.eq("name", user.getName()));
		}
		if(user.getLocalName()!=null){
			criteria.add(Restrictions.eq("localName", user.getLocalName()));
		}
		if(user.getFatherName()!=null){
			criteria.add(Restrictions.eq("fatherName", user.getFatherName()));
		}
		if(user.getMotherName()!=null){
			criteria.add(Restrictions.eq("motherName", user.getMotherName()));
		}
		if(user.getGender()!=null){
			criteria.add(Restrictions.eq("gender", user.getGender()));
		}
		if(user.getDob()!=null){
			criteria.add(Restrictions.eq("dob", user.getDob()));
		}
		if(user.getDob_type()!=null){
			criteria.add(Restrictions.eq("dob_type", user.getDob_type()));
		}
		if(user.getMobile()!=null){
			criteria.add(Restrictions.eq("mobile", user.getMobile()));
		}
		if(user.getEmail()!=null){
			criteria.add(Restrictions.eq("email", user.getEmail()));
		}

		if(user.getRoles()!=null && user.getRoles().size()>0){
			addRoleCriteria(user, criteria);
		}
	}

	public static void addRoleCriteria(User user, Criteria criteria) {
		Iterator<Role> iter = user.getRoles().iterator();
		while(iter.hasNext()){
			Criteria roleCriteria = criteria.createCriteria("roles");
			addRoleCriteria(iter.next(), roleCriteria);
		}
	}

	public static void addRoleCriteria(Role role, Criteria roleCriteria) {
		if(role.getRole()!=null && !"".equalsIgnoreCase(role.getRole())){
			roleCriteria.add(Restrictions.eq("role", role.getRole()));
		}
		if(role.getRoleId()!=null && 0!=role.getRoleId()){
			roleCriteria.add(Restrictions.eq("roleId", role.getRoleId()));
		}
	}
	public static void addChildAcademicReportCriteria(ChildAcademicReport childReport, Criteria criteria) {
		if(childReport.getAcademicReportId()!=null && 0!=childReport.getAcademicReportId()){
			criteria.add(Restrictions.eq("academicReportId", childReport.getAcademicReportId()));
		}
		if(childReport.getChild()!=null){
			Criteria childCriteria = criteria.createCriteria("child");
			addChildCriteria(childReport.getChild(), childCriteria);
		}
		if(childReport.getCommentsByTeacher()!=null && !"".equalsIgnoreCase(childReport.getCommentsByTeacher())){
			criteria.add(Restrictions.eq("commentsByTeacher", childReport.getCommentsByTeacher()));
		}
		if(childReport.getDateOfTest()!=null){
			criteria.add(Restrictions.eq("dateOfTest", childReport.getDateOfTest()));
		}
		if(childReport.getEnglishScore()!=null && 0!=childReport.getEnglishScore()){
			criteria.add(Restrictions.eq("englishScore", childReport.getEnglishScore()));
		}
		if(childReport.getGkScore()!=null && 0!=childReport.getGkScore()){
			criteria.add(Restrictions.eq("gkScore", childReport.getGkScore()));
		}
		if(childReport.getKannadaScore()!=null && 0!=childReport.getKannadaScore()){
			criteria.add(Restrictions.eq("kannadaScore", childReport.getKannadaScore()));
		}
		if(childReport.getMathScore()!=null && 0!=childReport.getMathScore()){
			criteria.add(Restrictions.eq("mathScore", childReport.getMathScore()));
		}
		if(childReport.getScienceScore()!=null && 0!=childReport.getScienceScore()){
			criteria.add(Restrictions.eq("scienceScore", childReport.getScienceScore()));
		}
		if(childReport.getSocialScore()!=null && 0!=childReport.getSocialScore()){
			criteria.add(Restrictions.eq("socialScore", childReport.getSocialScore()));
		}
		
	}
	public static void addChildHealthReportCriteria(ChildHealthReport childReport, Criteria criteria) {
		if(childReport.getChild()!=null){
			Criteria childCriteria = criteria.createCriteria("child");
			addChildCriteria(childReport.getChild(), childCriteria);
		}
		if(childReport.getDateOfTest()!=null){
			criteria.add(Restrictions.eq("dateOfTest", childReport.getDateOfTest()));
		}
		if(childReport.getDoctorReviewComment()!=null && !"".equalsIgnoreCase(childReport.getDoctorReviewComment())){
			criteria.add(Restrictions.eq("doctorReviewComment", childReport.getDoctorReviewComment()));
		}
		if(childReport.getHealthReportId()!=null && 0!=childReport.getHealthReportId()){
			criteria.add(Restrictions.eq("healthReportId", childReport.getHealthReportId()));
		}
		if(childReport.getHeight()!=null && !"".equalsIgnoreCase(childReport.getHeight())){
			criteria.add(Restrictions.eq("health", childReport.getHeight()));
		}
		if(childReport.getWeight()!=null && !"".equalsIgnoreCase(childReport.getWeight())){
			criteria.add(Restrictions.eq("weight", childReport.getWeight()));
		}
	}
	public static void addChildOverallReportCriteria(ChildOverallReport childReport, Criteria criteria) {
		if(childReport.getChild()!=null){
			Criteria childCriteria = criteria.createCriteria("child");
			addChildCriteria(childReport.getChild(), childCriteria);
		}
		if(childReport.getChildAcademics()!=null){
			Criteria childCriteria = criteria.createCriteria("childAcademics");
			addChildAcademicReportCriteria(childReport.getChildAcademics(), childCriteria);
		}
		if(childReport.getChildHealth()!=null){
			Criteria childCriteria = criteria.createCriteria("childHealth");
			addChildHealthReportCriteria(childReport.getChildHealth(), childCriteria);
		}
		if(childReport.getChildOverallReportId()!=null  && 0!=childReport.getChildOverallReportId()){
			criteria.add(Restrictions.eq("childOverallReportId", childReport.getChildOverallReportId()));
		}
		//Other criteria have not been added for now
	}

}
