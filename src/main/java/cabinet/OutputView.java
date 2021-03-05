package cabinet;

import java.util.List;

public class OutputView {

    private static final int NEW_LINE_STANDARD = 13;
    private static final String NEW_LINE = System.lineSeparator();
    private static final String CABINET_ALLOCATE_RESULT = "캐비넷 배정 결과";

    public static void showResult(final List<String> members) {
        System.out.println(CABINET_ALLOCATE_RESULT + NEW_LINE);
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < members.size(); i++) {
            appendCabinetInfo(result, i, members);
        }
        System.out.print(result.toString());
    }

    private static void appendCabinetInfo(final StringBuilder result, final int index,
        final List<String> members) {
        final String order = (index + 1) + ": " + members.get(index);
        if (index == members.size() - 1) {
            result.append(order);
            return;
        }
        result.append(order).append(", ");

        if ((index + 1) % NEW_LINE_STANDARD == 0) {
            result.append(NEW_LINE);
        }
    }
}
