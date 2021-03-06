package cabinet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cabinet {

    public static final String FORBIDDEN_CABINET = "X";

    public static List<String> allocateWithFixedMembers(final String fixedMemberInfo,
        final int exclude) throws IOException {
        final List<String> members = autoAllocate(exclude);
        final String[] fixedMembers = fixedMemberInfo.split(",");
        for (final String fixedMember : fixedMembers) {
            final int idx = Integer.parseInt(fixedMember.split(":")[0]) - 1;
            final String name = fixedMember.split(":")[1];
            if (!members.get(idx).equals(name)) {
                Collections.swap(members, idx, members.indexOf(name));
            }
        }
        return new ArrayList<>(members);
    }

    public static List<String> readCrewsList() throws IOException {
        final List<String> members = new ArrayList<>();
        final BufferedReader br = new BufferedReader(new FileReader("crews_nickname.txt"));

        String line = "";
        while ((line = br.readLine()) != null) {
            members.add(line);
        }
        br.close();
        return new ArrayList<>(members);
    }

    public static List<String> autoAllocate() throws IOException {
        final List<String> members = readCrewsList();
        members.add(FORBIDDEN_CABINET);
        Collections.shuffle(members);
        return new ArrayList<>(members);
    }

    public static List<String> autoAllocate(final int exclude) throws IOException {
        final List<String> members = autoAllocate();
        final String name = members.get(exclude - 1);
        if (!FORBIDDEN_CABINET.equals(name)) {
            final int possibleCabinet = members.indexOf(FORBIDDEN_CABINET);
            Collections.swap(members, exclude - 1, possibleCabinet);
        }
        return new ArrayList<>(members);
    }
}
