package entity;

import java.util.Date;
import java.util.Random;

public class Deal {

	private String dealId;
	private String productType;
	private String buyTimeYear;
	private String buyTimeMonth;
	private String price;
	private String newLevel;
	private String introduce;
	private String contact;
	private String contactPhone;
	private String userName;


	public Deal(String dealId, String productType, String buyTimeYear, String buyTimeMonth, String price, String newLevel, String introduce, String contact, String contactPhone, String userName) {
		this.dealId = dealId;
		this.productType = productType;
		this.buyTimeYear = buyTimeYear;
		this.buyTimeMonth = buyTimeMonth;
		this.price = price;
		this.newLevel = newLevel;
		this.introduce = introduce;
		this.contact = contact;
		this.contactPhone = contactPhone;
		this.userName = userName;
	}

	public Deal(String productType, String buyTimeYear, String buyTimeMonth, String price, String newLevel, String introduce, String contact, String contactPhone, String userName) {
		this.dealId = randomId();
		this.productType = productType;
		this.buyTimeYear = buyTimeYear;
		this.buyTimeMonth = buyTimeMonth;
		this.price = price;
		this.newLevel = newLevel;
		this.introduce = introduce;
		this.contact = contact;
		this.contactPhone = contactPhone;
		this.userName = userName;
	}

	public Deal() {
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}


	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}


	public String getBuyTimeYear() {
		return buyTimeYear;
	}

	public void setBuyTimeYear(String buyTimeYear) {
		this.buyTimeYear = buyTimeYear;
	}


	public String getBuyTimeMonth() {
		return buyTimeMonth;
	}

	public void setBuyTimeMonth(String buyTimeMonth) {
		this.buyTimeMonth = buyTimeMonth;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public String getNewLevel() {
		return newLevel;
	}

	public void setNewLevel(String newLevel) {
		this.newLevel = newLevel;
	}


	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "Deal{" +
				"dealId='" + dealId + '\'' +
				", productType='" + productType + '\'' +
				", buyTimeYear=" + buyTimeYear +
				", buyTimeMonth=" + buyTimeMonth +
				", price=" + price +
				", newLevel='" + newLevel + '\'' +
				", introduce='" + introduce + '\'' +
				", contact='" + contact + '\'' +
				", contactPhone='" + contactPhone + '\'' +
				", userName='" + userName + '\'' +
				'}';
	}


	public String randomId(){
		int N = 11;
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int length = str.length();
		Random random1=new Random();

		StringBuffer s=new StringBuffer();
		for (int i = 0; i < N; i++) {

			int number=random1.nextInt(length);

			char c = str.charAt(number);
			s.append(c);
		}
		return new String(s);
	}
}