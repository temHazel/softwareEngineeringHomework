import java.util.ArrayList;
import java.util.Map;
@SuppressWarnings("unchecked")
public class JsonTreeStyle extends Style {
    public String getType(){
        return "Style";
    }
    public void draw(Map<String, Object> json, Component icon) {
        ArrayList<Boolean> boolArray = new ArrayList<>();
        printTree(json, 0, icon, boolArray);
    }

    private void printTree(Map<String, Object> map, int level, Component icon, ArrayList<Boolean> boolArray) {
        String indent = "\u2502  ".repeat(level); // Calculate indentation based on the level
        int entryCount = map.size();
        int currentIndex = 0;
        boolArray.add(false);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            currentIndex++;
            boolean isLastEntry = currentIndex == entryCount;

            // Determine useicon based on whether the entry is a leaf or a subtree
            String useicon = (entry.getValue() instanceof Map) ? icon.getMiddleIcon() : icon.getLeafIcon();
            String connector = isLastEntry ? "\u2514\u2500" : "\u251C\u2500";

            // Adjust indent for subsequent entries at the same level
            indent = "";
            if (!isLastEntry) {
            } else {
                boolArray.set(level, true);
            }
            for(int i=0;i<level;++i){
                if(boolArray.get(i)){
                    indent += "   ";
                }
                else{
                    indent += "\u2502  ";
                }
            }

            if(indent == "  ")
                System.out.println(11111);
            System.out.print(indent + connector + useicon + entry.getKey()); // Print key with useicon

            if (entry.getValue() instanceof Map) {
                // If the value is a Map, print a new line and recursively print the subtree
                System.out.println();
                printTree((Map<String, Object>) entry.getValue(), level + 1, icon, boolArray);
            } else {
                if(entry.getValue()!=null)
                    // If the value is not a Map, print the value on the same line
                    System.out.print(": " + entry.getValue());
                System.out.println("");
            }
        }
    }
    public String getMiddleIcon(){
        System.err.println("Could not call this Function From Style!");
        return null;
    }
    public String getLeafIcon(){
        System.err.println("Could not call this Function From Style!");
        return null;
    }
}
