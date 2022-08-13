package com.niit.jukebox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class App {

	public static void main(String[] args) throws SQLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Menu menu = new Menu();
		DisplayingData displayingData = new DisplayingData();
		
		PlayList playList = new PlayList();
		
		List<Song> allSongs = displayingData.showAllSongs();
		List<Podcast> allPodcasts = displayingData.showAllPodcast();
		
		int choice = menu.availableActions();
		
		do {
			if(choice == 1) {
				choice = menu.showSongOptions();
				do {
					
					switch(choice) {
					
					case 1 : displayingData.displayMethodForSongs(allSongs);
							 break;
					case 2 : displayingData.searchByArtistName(allSongs);
							 break;
					case 3 : displayingData.searchByGenreName(allSongs);
							 break;
					case 4 : displayingData.searchByAlbumName(allSongs);
							 break;
					default : System.out.println("Enter a Valid Choice or Press 5 To Go Homepage");
					}
				choice = menu.showSongOptions();
				}while(choice != 5);
				
			}else if(choice == 2) {
				choice = menu.showPodcastOptions();
				do {
					
					switch(choice) {
					
					case 1 : displayingData.displayMethodForPodcast(allPodcasts);
							 break;
					case 2 : displayingData.searchByPodcastName(allPodcasts);
							 break;
					case 3 : displayingData.searchByCelebrityName(allPodcasts);
							 break;
					case 4 : displayingData.searchByPublishingdate(allPodcasts);
							 break;
					default : System.out.println("Please Enter a Valid Choice or Press 5 To Go Homepage");
					
					}
				choice = menu.showPodcastOptions();
				}while(choice != 5);
				
			}else if(choice == 3) {
				choice = menu.showPlayListOptions();
				do {
					
					switch(choice) {
					
					case 1 : playList.createPlayList(allSongs,allPodcasts);
							 break;		 
					case 2 : playList.detailsOfPlayList();
							 break;
					default : System.out.println("Please Enter Valid Choice or Press 5 To Go Homepage");
					}
				choice = menu.showPlayListOptions();
				}while(choice != 5);
				
			}else if(choice == 7){
				
				int count = playList.detailsOfPlayList();
				
				if(count>=1) {
					
					try {
						System.out.println("\nEnter The S.no Of The Song You Want To Play ");
						AudioPlayer.id=menu.indexNumber();
						int trackID = AudioPlayer.id;
						AudioPlayer.count = count;
			    		AudioPlayer.filePath = playList.playingAudio(trackID);
			             
			    		AudioPlayer audioPlayer = new AudioPlayer();
			    		
			            audioPlayer.play();
			              
			            while (true)
			            {
			                int c = menu.showPlayOptions();
			                audioPlayer.gotoChoice(c);
			                if (c == 4)
			                break;
			            }
			    	}catch(Exception ex) {
			    		 System.out.println("Error with playing sound.");
			             ex.printStackTrace();
			    	}
					
				}
				
			}
		choice = menu.availableActions();
		}while(choice != 9);
		System.out.println("Thanks For Using Our Service.");
	}

}
