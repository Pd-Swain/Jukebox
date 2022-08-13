package com.niit.jukebox;

import java.util.Date;

public class Podcast {

	private int podcastID;
	private String podcastName;
	private String podcastLang;
	private String celebsName;
	private Date publishDate;
	private String filePath;
	
	public Podcast(int podcastID, String podcastName, String podcastLang, String celebsName, Date publishDate,
			String filePath) {
		super();
		this.podcastID = podcastID;
		this.podcastName = podcastName;
		this.podcastLang = podcastLang;
		this.celebsName = celebsName;
		this.publishDate = publishDate;
		this.filePath = filePath;
	}
	
	public int getPodcastID() {
		return podcastID;
	}
	public void setPodcastID(int podcastID) {
		this.podcastID = podcastID;
	}
	public String getPodcastName() {
		return podcastName;
	}
	public void setPodcastName(String podcastName) {
		this.podcastName = podcastName;
	}
	public String getPodcastLang() {
		return podcastLang;
	}
	public void setPodcastLang(String podcastLang) {
		this.podcastLang = podcastLang;
	}
	public String getCelebsName() {
		return celebsName;
	}
	public void setCelebsName(String celebsName) {
		this.celebsName = celebsName;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public String toString() {
		System.out.format("\n%-20s %-30s %-20s %-20s %-20s\n",podcastID,podcastName,podcastLang,celebsName,publishDate);
		return "";
	}
	
	
	
}
