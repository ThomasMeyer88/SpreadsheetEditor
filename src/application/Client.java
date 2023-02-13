package application;

public class Client {
	public String name;
	public String address;
	public String phone;
	public String email;
	public String contactDate;
	public String contactMethod;
	public String mailReturned;
	public String notes;
	public String nextSteps;
	public String docsReceived;
	public String claimPacketId;
	public String claimSubmissionDate;
	public String claimStatus;
	
	public Client(String name, String address, String phone, String email, String contactDate, String contactMethod,
			String mailReturned, String notes, String nextSteps, String docsReceived, String claimPacketId,
			String claimSubmissionDate, String claimStatus) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.contactDate = contactDate;
		this.contactMethod = contactMethod;
		this.mailReturned = mailReturned;
		this.notes = notes;
		this.nextSteps = nextSteps;
		this.docsReceived = docsReceived;
		this.claimPacketId = claimPacketId;
		this.claimSubmissionDate = claimSubmissionDate;
		this.claimStatus = claimStatus;
	}
	
	public Client() {
		super();
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactDate() {
		return contactDate;
	}
	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}
	public String getContactMethod() {
		return contactMethod;
	}
	public void setContactMethod(String contactMethod) {
		this.contactMethod = contactMethod;
	}
	public String getMailReturned() {
		return mailReturned;
	}
	public void setMailReturned(String mailReturned) {
		this.mailReturned = mailReturned;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getNextSteps() {
		return nextSteps;
	}
	public void setNextSteps(String nextSteps) {
		this.nextSteps = nextSteps;
	}
	public String getDocsReceived() {
		return docsReceived;
	}
	public void setDocsReceived(String docsReceived) {
		this.docsReceived = docsReceived;
	}
	public String getClaimPacketId() {
		return claimPacketId;
	}
	public void setClaimPacketId(String claimPacketId) {
		this.claimPacketId = claimPacketId;
	}
	public String getClaimSubmissionDate() {
		return claimSubmissionDate;
	}
	public void setClaimSubmissionDate(String claimSubmissionDate) {
		this.claimSubmissionDate = claimSubmissionDate;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	
	

}
