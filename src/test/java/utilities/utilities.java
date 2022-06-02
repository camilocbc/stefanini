package utilities;

public class utilities {
    public static void esperaMiliseg(int miliSeg) {
        try {
            Thread.sleep(miliSeg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
