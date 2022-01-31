package ch.noseryoung.plj;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * This Class handles the Sound for the Zoo.
 */
public class Sound {
    public Sound(String filename) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("There was an error with the sound file");
        }
    }
}