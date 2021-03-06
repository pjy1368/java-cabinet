package cabinet;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        final List<String> result = Cabinet.allocateWithFixedMembers("21:제이온,22:바다,23:조엘", 40);
        OutputView.showResult(result);
    }
}
