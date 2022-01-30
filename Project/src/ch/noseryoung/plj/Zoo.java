package ch.noseryoung.plj;

public class Zoo {

    Sound sound;
    IO io = new IO();

    public void visitZoo() {
        int answer = 0;
        while (answer <= 5 && answer >= 0){
            answer = io.zooOptions();
            switch (answer) {
                case 1 -> new Sound("C:\\Users\\enes\\Documents\\TBZ\\2021-2022\\Modul 226b\\Project\\Abschlussprojekt\\Project\\M226b-MaPol-EnSpa\\Project\\Tiger-Snarl-4.wav");
                case 2 -> new Sound("C:\\Users\\enes\\Documents\\TBZ\\2021-2022\\Modul 226b\\Project\\Abschlussprojekt\\Project\\M226b-MaPol-EnSpa\\Project\\Shark-Attack.wav");
                case 3 -> new Sound("C:\\Users\\enes\\Documents\\TBZ\\2021-2022\\Modul 226b\\Project\\Abschlussprojekt\\Project\\M226b-MaPol-EnSpa\\Project\\Frog-Medium.wav");
                case 4 -> new Sound("C:\\Users\\enes\\Documents\\TBZ\\2021-2022\\Modul 226b\\Project\\Abschlussprojekt\\Project\\M226b-MaPol-EnSpa\\Project\\Whistle-Bird-High.wav");
                case 5 -> new Sound("C:\\Users\\enes\\Documents\\TBZ\\2021-2022\\Modul 226b\\Project\\Abschlussprojekt\\Project\\M226b-MaPol-EnSpa\\Project\\Crocodile Hiss and Grunt.wav");
            }
        }
    }

}
