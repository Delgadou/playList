package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("CTV3", "Jaden Smith");
        album.addSong("Circa 2015", 2.12);
        album.addSong("Falling for you", 3.43);
        album.addSong("Rainbow Bap", 4.40);
        album.addSong("LUCY!", 4.20);
        albums.add(album);

        album = new Album("TAKE TIME", "Giveon");
        album.addSong("The Beach", 3.26);
        album.addSong("World We Created", 3.13);
        album.addSong("Take Time", 0.45);
        album.addSong("World We Created", 3.13);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlayList("Falling for you", playlist);
        albums.get(0).addToPlayList("Circa 2015", playlist);
        albums.get(0).addToPlayList("LUCY!!", playlist); // Nome errado
        albums.get(0).addToPlayList(2, playlist);

        albums.get(1).addToPlayList("The Beach", playlist);
        albums.get(1).addToPlayList("World We Created", playlist);
        albums.get(1).addToPlayList(20, playlist);

        play(playlist);
    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.isEmpty()){
            System.out.println("No songs added in the playlist");
            return;
        } else {
            System.out.println("Playing now: " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Playlist Complete");
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Playing now: " + listIterator.next());
                    }else{
                        System.out.println("This is the last song from your playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Playing now: " + listIterator.previous());
                    } else {
                        System.out.println("This is the first song on playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Replaying now: " + listIterator.previous().toString());
                            goingForward = false;
                        } else {
                            System.out.println("We are at start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Replaying now: " + listIterator.next().toString());
                            goingForward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("========================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("========================");
    }

    private static void printMenu(){
        System.out.println("\nAvailable options:");
        System.out.println("0 - To quit\n" +
                "1 - To skip foward\n" +
                "2 - To skip backward\n" +
                "3 - To replay current song\n" +
                "4 - To print playlist\n" +
                "5 - To print menu\n" +
                "6 - To remove current song from the playlist" +
                "\n" +
                "Press: ");
    }

}