package cn.net.tongfang.framework.security.vo;

/**
 * FreeCode entity. @author MyEclipse Persistence Tools
 */

public class BirthCertificateChange implements java.io.Serializable {

	// Fields

	private String id;
	private String sourceBirthCertifiId;
	private String destBirthCertifiId;
	private String changeReasons;
	// Constructors

	/** default constructor */
	public BirthCertificateChange() {
	}

	/** full constructor */
	public BirthCertificateChange(String id, String sourceBirthCertifiId,
			String destBirthCertifiId, String changeReasons) {
		super();
		this.id = id;
		this.sourceBirthCertifiId = sourceBirthCertifiId;
		this.destBirthCertifiId = destBirthCertifiId;
		this.changeReasons = changeReasons;
	}
	// Property accessors

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSourceBirthCertifiId() {
		return sourceBirthCertifiId;
	}

	public void setSourceBirthCertifiId(String sourceBirthCertifiId) {
		this.sourceBirthCertifiId = sourceBirthCertifiId;
	}

	public String getDestBirthCertifiId() {
		return destBirthCertifiId;
	}

	public void setDestBirthCertifiId(String destBirthCertifiId) {
		this.destBirthCertifiId = destBirthCertifiId;
	}

	public String getChangeReasons() {
		return changeReasons;
	}

	public void setChangeReasons(String changeReasons) {
		this.changeReasons = changeReasons;
	}

}