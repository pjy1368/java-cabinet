package cabinet;


import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CabinetTest {

    @Test
    void allocate() {
        List<String> result = Cabinet.allocate("15:춘식,17:에어", 40);
        assertThat(result).hasSize(52);
        assertThat(result.get(14)).isEqualTo("춘식");
        assertThat(result.get(16)).isEqualTo("에어");
        assertThat(result.get(39)).isEqualTo("X");
//        showResult(result);
    }

    @Test
    void read() throws IOException {
        List<String> members = Cabinet.readCrewsList();
        assertThat(members.size()).isEqualTo(51);
    }
}