package com.niit.jukebox;

public class Song {

	private int songID;
	private String songName;
	private String artistName;
	private String genre;
	private String album;
	private float songDuration;
	private String filePath;
	
	public Song(int songID, String songName, String artistName, String genre, String album, float songDuration,
			String filePath) {
		super();
		this.songID = songID;
		this.songName = songName;
		this.artistName = artistName;
		this.genre = genre;
		this.album = album;
		this.songDuration = songDuration;
		this.filePath = filePath;
	}
	
	
	public int getSongID() {
		return songID;
	}
	public void setSongID(int songID) {
		this.songID = songID;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public float getSongDuration() {
		return songDuration;
	}
	public void setSongDuration(float songDuration) {
		this.songDuration = songDuration;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public String toString() {
		System.out.format("\n%-20s %-20s %-20s %-20s %-20s %-20s\n",songID,songName,artistName,genre,album,songDuration);
		return "";
	}
	
	
}
