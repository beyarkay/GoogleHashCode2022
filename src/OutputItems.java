import com.rachetstudios.InputAsPojo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputItems {
    String filepath;
    // TODO rename items1 to be semantically correct
    ArrayList<OutputItem> items1;

    // TODO items2 is only needed if we're returning more than one type of object
//    ArrayList<OutputItem2> items2;

    public OutputItems(String filepath) {
        this.filepath = filepath;
    }

    public void writeToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.filepath));

        // TODO properly
        for (OutputItem o1 : items1) {
            writer.write(o1.toString() + "\n");
        }

        // TODO items2 is only needed if we're returning more than one type of object
//        for (Object o2 : items2) {
//            writer.write(String.valueOf(o2) + "\n");
//        }

        writer.close();
    }

    public static class OutputItem {
        // TODO refactor and rename these and give them more specific classes
        Object thing1;
        Object thing2;
        Object thing3;
        Object thing4;

        public OutputItem(Object thing1, Object thing2, Object thing3, Object thing4) {
            this.thing1 = thing1;
            this.thing2 = thing2;
            this.thing3 = thing3;
            this.thing4 = thing4;
        }

        @Override
        public String toString() {
            return  "thing1=" + String.valueOf(thing1) +
                    "thing2=" + String.valueOf(thing2) +
                    "thing3=" + String.valueOf(thing3) +
                    "thing4=" + String.valueOf(thing4);
        }
    }


}
