import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public abstract class Icon implements Component {
    public String getType() {
        return "Icon";
    }

    public abstract String getLeafIcon();
    public abstract String getMiddleIcon();

    // Making ConfigIcon a static inner class
    public static class ConfigIcon extends Icon {
        private static String leafIcon;
        private static String middleIcon;

        // Static block to read from YAML file once when the class is loaded
        static {
            try {
                // Read file content as a string
                String content = new String(Files.readAllBytes(Paths.get("_config.yaml")), StandardCharsets.UTF_8);
                String[] lines = content.split("\\n");

                leafIcon = lines[3].replaceAll("\\s", "");
                middleIcon = lines[1].replaceAll("\\s", "");
                System.out.println("LeafIcon:" + leafIcon);
                System.out.println("MiddleIcon:" + middleIcon);

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load icons from config.yaml", e);
            }
        }

        @Override
        public String getLeafIcon() {
            return leafIcon;
        }

        @Override
        public String getMiddleIcon() {
            return middleIcon;
        }

        public void draw(Map<String, Object> json, Component icon) {
            System.err.println("Could not call this Function From Style!");
        }
    }
    public static class DefaultIcon extends Icon {
        public String getType(){
            return "Icon";
        }
        public String getLeafIcon() {
            return "❆"; // Default icon
        }
        public String getMiddleIcon() {
            return "❅"; // Default icon
        }
        public void draw(Map<String, Object> json, Component icon){
            System.err.println("Could not call this Function From Style!");
        }
    }
    public static class PokerIcon extends Icon{
        public String getType(){
            return "Icon";
        }
        public String getLeafIcon() {
            return "♫"; // Poker face icon for intermediate nodes
        }
        public String getMiddleIcon() {
            return "♪"; // Poker face icon for intermediate nodes
        }
        public void draw(Map<String, Object> json, Component icon){
            System.err.println("Could not call this Function From Style!");
        }
    }
}
