package com.niit.jukebox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayingData {

	Connection con;
	PreparedStatement pst;
	Menu menu = new Menu();
	
	public List<Song> showAllSongs() throws SQLException {
		
		con=DBConfig.getConnection();
		List<Song> songList = new ArrayList<Song>();
		
		pst = con.prepareStatement("select * from songs");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			songList.add(new Song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6),rs.getString(7)));
		}	
		return songList;
	}

	
	public void displayMethodForSongs(List<Song> songList){
		System.out.format("\n%-20s %-20s %-20s %-20s %-20s %-20s\n","S.no","Song Name","Artist Name","Genre","Album","Song Duration");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		songList.forEach(x->System.out.println(x));
	}
	
	public void searchByArtistName(List<Song> allSongs) {
		
		List<String> artist = allSongs.stream().map(x->x.getArtistName()).collect(Collectors.toList());
		System.out.println("Available Artists -> ");
		artist.forEach(x->System.out.println(x));
		
		System.out.print("\nEnter The First Letter Of Artist Name -> ");
		String artistName = menu.searching();
		List<Song> songOfArtists = allSongs.stream().filter(x->x.getArtistName().startsWith(artistName)).collect(Collectors.toList());
		displayMethodForSongs(songOfArtists);
	}


	public void searchByGenreName(List<Song> allSongs) {
		
		List<String> genre = allSongs.stream().map(x->x.getGenre()).collect(Collectors.toList());
		genre.forEach(x->System.out.println(x));
		
		System.out.print("\nEnter The First Letter Of Genre Name -> ");
		String genreName = menu.searching();
		List<Song> songOfGenre = allSongs.stream().filter(x->x.getGenre().startsWith(genreName)).collect(Collectors.toList());
		displayMethodForSongs(songOfGenre);
	}


	public void searchByAlbumName(List<Song> allSongs) {
		
		List<String> albums = allSongs.stream().map(x->x.getAlbum()).collect(Collectors.toList());
		albums.forEach(x->System.out.println(x));
		
		System.out.print("\nEnter The First Letter Of Album Name -> ");
		String albumName = menu.searching();
		List<Song> songOfAlbums = allSongs.stream().filter(x->x.getAlbum().startsWith(albumName)).collect(Collectors.toList());
		displayMethodForSongs(songOfAlbums);
		
	}


	public List<Podcast> showAllPodcast() throws SQLException {
		
		con=DBConfig.getConnection();
		List<Podcast> podcastList = new ArrayList<>();
		
		pst = con.prepareStatement("select * from podcast");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			podcastList.add(new Podcast(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),rs.getString(6)));
		}	
		return podcastList;
		
	}


	public void displayMethodForPodcast(List<Podcast> allPodcasts) {
		
		System.out.format("\n%-20s %-30s %-20s %-20s %-20s\n","S.no","Podcast Name","Language","Celebrity","Published");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		allPodcasts.forEach(x->System.out.println(x));
	}


	public void searchByPodcastName(List<Podcast> allPodcasts) {
		
		List<String> podcastName = allPodcasts.stream().map(x->x.getPodcastName()).collect(Collectors.toList());
		podcastName.forEach(x->System.out.println(x));
		
		System.out.print("\nEnter The First Letter Of Podcast Name -> ");
		String name = menu.searching();
		List<Podcast> podcastByName = allPodcasts.stream().filter(x->x.getPodcastName().startsWith(name)).collect(Collectors.toList());
		displayMethodForPodcast(podcastByName);
	}


	public void searchByCelebrityName(List<Podcast> allPodcasts) {
		
		List<String> celebrityName = allPodcasts.stream().map(x->x.getCelebsName()).collect(Collectors.toList());
		celebrityName.forEach(x->System.out.println(x));
		
		System.out.print("\nEnter The First Letter Of Celebrity Name -> ");
		String name = menu.searching();
		List<Podcast> podcastOfCelebrity = allPodcasts.stream().filter(x->x.getCelebsName().startsWith(name)).collect(Collectors.toList());
		displayMethodForPodcast(podcastOfCelebrity);
		
	}


	public void searchByPublishingdate(List<Podcast> allPodcasts) {
		
		List<Date> publishDate = allPodcasts.stream().map(x->x.getPublishDate()).collect(Collectors.toList());
		publishDate.forEach(x->System.out.println(x));
		
		System.out.print("\nEnter The Date(yyyy-mm-dd) -> ");
		String date = menu.searching();
		List<Podcast> publishingDate = allPodcasts.stream().filter(x->x.getPublishDate().toString().equalsIgnoreCase(date)).collect(Collectors.toList());
		displayMethodForPodcast(publishingDate);
		
	}

}
