package com.niit.jukebox;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlayList {

	Connection con;
	PreparedStatement pst;
	DisplayingData displayingData;
	Menu menu;
	
	
	public void createPlayList(List<Song> allSongs, List<Podcast> allPodcasts) throws SQLException {
		
		con=DBConfig.getConnection();
		
		menu = new Menu();
		displayingData = new DisplayingData();
		
		System.out.print("Type New/Exist PlayList Name -> ");
		String nameOfPlayList = menu.searching();
		System.out.println("Done, Press 1 to Add Songs or 2 to Add Podcasts");
		int choice = menu.chooseSongsOrPodcasts();
		
		do {
			if(choice == 1) {
				
				displayingData.displayMethodForSongs(allSongs);
				System.out.println("From Above Song List, You Can Add The Song By Selecting Their S.no");
				int index = menu.indexNumber()-1;
				
				if(allSongs.size() >= index) {

					pst=con.prepareStatement("insert into playlist(playlist_name,track,track_type,artist_name,date_of_adding,file_path) values (?,?,?,?,?,?)");
					pst.setString(1, nameOfPlayList);
					pst.setString(2, allSongs.get(index).getSongName()); //arr[1]  0,1,2
					pst.setString(3, "Song");
					pst.setString(4, allSongs.get(index).getArtistName());
					pst.setDate(5, Date.valueOf(LocalDate.now()));
					pst.setString(6, allSongs.get(index).getFilePath());
					pst.executeUpdate();
					System.out.println("Added One Song To Your PlayList -> "+nameOfPlayList);
					
				}else {
					try {
						throw new CustomException("No Songs Found");
					}catch(CustomException ce){
						System.out.println(ce.getMessage());
					}
				}
			}else if(choice == 2) {
				
				displayingData.displayMethodForPodcast(allPodcasts);
				System.out.println("From Above Podcast List, You Can Add The Podcast By Selecting Their S.no");
				int index = menu.indexNumber()-1;
				
				if(allPodcasts.size() >= index) {
					
					pst=con.prepareStatement("insert into playlist(playlist_name,track,track_type,artist_name,date_of_adding,file_path) values (?,?,?,?,?,?)");
					pst.setString(1, nameOfPlayList);
					pst.setString(2, allPodcasts.get(index).getPodcastName());
					pst.setString(3, "Podcast");
					pst.setString(4, allPodcasts.get(index).getCelebsName());
					pst.setDate(5, Date.valueOf(LocalDate.now()));
					pst.setString(6, allPodcasts.get(index).getFilePath());
					pst.executeUpdate();
					System.out.println("Added One Podcast To Your PlayList -> "+nameOfPlayList);
					
				}else {
					try {
						throw new CustomException("No Podcast Found");
					}catch(CustomException ce){
						System.out.println(ce.getMessage());
					}
				}	
			}
		choice = menu.chooseSongsOrPodcasts();
		}while(choice != 3);
		
	}

	public int detailsOfPlayList() throws SQLException {
		
		con=DBConfig.getConnection();
		
		menu = new Menu();
		
		System.out.println("Type Your PlayList Name -> ");
		String nameOfPlayList = menu.searching();
		int count = 0;
		
		pst = con.prepareStatement("select * from playlist where playlist_name = ?");
		pst.setString(1, nameOfPlayList);
		
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			System.out.println("Your PlayList -> "+nameOfPlayList);
			System.out.format("\n%-20s %-30s %-20s %-20s %-20s \n","S.no","Tracks","Track Type","Artist Name","Date Of Adding");
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			do {
				System.out.format("\n%-20s %-30s %-20s %-20s %-20s \n",rs.getInt(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6));
				count++;
			}while(rs.next());
			return count;
		}else {
			try {
				throw new CustomException("PlayList '" +nameOfPlayList+ "' Doesn't Exist, First Create One .");
			}catch(CustomException ce){
				System.out.println(ce.getMessage());
			}
			return 0;
		}	
	}

	public String playingAudio(int id) throws SQLException {
		
		con=DBConfig.getConnection();
		
		String trackName = "";
		pst=con.prepareStatement("select file_path from playlist where playlist_id=?");
		pst.setInt(1, id);
		ResultSet rs1 = pst.executeQuery();
		
		while(rs1.next()) {
			trackName=rs1.getString(1);
		}
		return trackName;
	}

}
