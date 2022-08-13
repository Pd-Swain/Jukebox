package com.niit.jukebox;

import java.util.Scanner;

public class Menu {

	Scanner scanner = new Scanner(System.in);
	
	public int availableActions() {
		System.out.println("\n-----Main Menu-----");
		System.out.println("\n1. Songs \n2. Podcasts \n3. PlayList \n7. Play Your PlayList \n9. Exit App\n");
		System.out.print("Choice -> ");
		int choice = scanner.nextInt();
		return choice;
	}

	public int showSongOptions() {
		
		System.out.println("\n-----Sub Menu For Songs-----");
		System.out.println("\n1. To See All Songs \n2. Search By Artists \n3. Search By Genre \n4. Search By Albums \n5. Main Menu\n");
		System.out.print("Choice -> ");
		int choice = scanner.nextInt();
		return choice;
		
	}
	
	public String searching() {
		String name=scanner.nextLine();
		return name;
	}
	
	public int showPodcastOptions() {
		System.out.println("\n-----Sub Menu For Podcast-----");
		System.out.println("\n1. All Podcast \n2. Search By Podcast Name \n3. Search By Celebrity Name \n4. Search By Publish Date \n5. Main Menu\n ");
		System.out.print("Choice -> ");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public int showPlayListOptions() {
		System.out.println("\n-----Sub Menu For PlayList-----");
		System.out.println("\n1. Create PlayList \n2. Your PlayLists \n5. Main Menu\n");
		System.out.print("Choice -> ");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public int chooseSongsOrPodcasts() {
		System.out.println(" \n1. Add Songs \n2. Add Podcasts \n3. Exit To PayList Sub Menu\n");
		System.out.print("Choice -> ");
		int choice = scanner.nextInt();
		return choice;
	}

	public int indexNumber() {
		System.out.print("Choice -> ");
		int choice = scanner.nextInt();
		while(choice<=0) {
			System.out.println("Sorry We Can't Take Below Zero, Please Provide A Positive Number ");
			System.out.print("Choice -> ");
			choice = scanner.nextInt();
		}
		return choice;
	}

	public int showPlayOptions() {
		System.out.println("\n1. Pause \n2. Resume \n3. Restart \n4. Stop \n5. Jump to specific time \n6. Next Song \n7. Previous Song");
		int choice = scanner.nextInt();
		return choice;
	}
	
}
