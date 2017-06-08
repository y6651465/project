package kr.co.mycal.friend.vo;

public class MessageVO {
	private int msgNo;
	private String sender;
	private String receiver;
	private String content;
	private String regDate;
	private String raedYN;
	public int getMsgNo() {
		return msgNo;
	}
	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRaedYN() {
		return raedYN;
	}
	public void setRaedYN(String raedYN) {
		this.raedYN = raedYN;
	}
}

