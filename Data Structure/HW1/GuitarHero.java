import synthesizer.GuitarString;

public class GuitarHero {
    public static void main(String[] args) {
        GuitarString[] KeyStrings = new GuitarString[37];   
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        for(int i = 0; i < 37; i++)
            KeyStrings[i] = new GuitarString(440 * Math.pow(2, (i - 24) / 12.0));

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int i = keyboard.indexOf(key);
                KeyStrings[i].pluck();
            }
            double sample = 0.0;
            for(int i = 0; i < 37; i++)
                sample += KeyStrings[i].sample();
            StdAudio.play(sample);
            for(int j = 0; j < 37; j++)
                KeyStrings[j].tic();
        }
    }
}
