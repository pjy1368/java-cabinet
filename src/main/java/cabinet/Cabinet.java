package cabinet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cabinet {
    public static final String FORBIDDEN_CABINET = "X";

    public static List<String> allocate(String memberInfo, int exclude) {
        final List<String> members = new ArrayList<>(Arrays.asList(new String[52]));
        members.set(exclude - 1, "X");
        String[] teamMembers = memberInfo.split(",");
        for (String teamMember : teamMembers) {
            int idx = Integer.parseInt(teamMember.split(":")[0]) - 1;
            String name = teamMember.split(":")[1];
            members.set(idx, name);
        }
        return members;
    }

    public static List<String> readCrewsList() throws IOException {
        final List<String> members = new ArrayList<>();
        final BufferedReader br = new BufferedReader(new FileReader("crews_nickname.txt"));

        String line = "";
        while ((line = br.readLine()) != null) {
            members.add(line);
        }
        br.close();
        return members;
    }

    public static List<String> autoAllocate() throws IOException {
        List<String> members = readCrewsList();
        members.add(FORBIDDEN_CABINET);
        Collections.shuffle(members);
        return new ArrayList<>(members);
    }

    public static List<String> autoAllocate(int exclude) throws IOException {
        List<String> members = autoAllocate();
        String name = members.get(exclude - 1);
        if (!FORBIDDEN_CABINET.equals(name)) {
            int possibleCabinet = members.indexOf(FORBIDDEN_CABINET);
            Collections.swap(members, exclude - 1, possibleCabinet);
        }
        return new ArrayList<>(members);
    }
}
