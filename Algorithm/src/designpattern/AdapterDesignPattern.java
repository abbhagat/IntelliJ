package designpattern;

/*
 * Adapter design pattern acts as a bridge between two incompatible interface.
 * It is used extensively by the adapter classes in java.awt.event.
 *
 * eg :- There is a media player which is capable of playing MP3 files.
 * 		 There is an advanced media player capable of playing VLC and MP4 files.
 * 		 Now I want my media player to play MP3,VLC and MP4 files
 *       we go for adapter design pattern.
 */

@FunctionalInterface
interface MediaPlayer {
    void play(String fileName, String fileType);
}

interface AdvancedMediaPlayer {
    void playVLC(String fileName);

    void playMP4(String fileName);
}

class VLC implements AdvancedMediaPlayer {

    public void playVLC(String fileName) {
        System.out.println("Playing VLC file : " + fileName);
    }

    public void playMP4(String fileName) {
    }
}

class MP4 implements AdvancedMediaPlayer {

    public void playVLC(String fileName) {
    }

    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file : " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    MediaAdapter(String fileType) {
        advancedMediaPlayer = fileType.equalsIgnoreCase("VLC") ? new VLC() : new MP4();
    }

    public void play(String fileName, String fileType) {

        if (fileType.equalsIgnoreCase("VLC")) {
            advancedMediaPlayer.playVLC(fileName);
        }

        if (fileType.equalsIgnoreCase("MP4")) {
            advancedMediaPlayer.playMP4(fileName);
        }
    }
}

class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    public void play(String fileName, String fileType) {

        switch (fileType) {
            case "mp3":
                System.out.println("Playing MP3 file : " + fileName);
                break;
            case "MP4":
            case "VLC":
                mediaAdapter = new MediaAdapter(fileType);
                mediaAdapter.play(fileName, fileType);
                break;
            default:
                System.out.println("File format not supported");
        }
    }
}

public class AdapterDesignPattern {

    public static void main(String[] args) {
        AudioPlayer ap = new AudioPlayer();
        ap.play("Songs", "MP3");
        ap.play("Movie", "MP4");
        ap.play("Movie", "VLC");
        ap.play("Vedio", "avi");
    }
}
