package cabinet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cabinet {

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
}
