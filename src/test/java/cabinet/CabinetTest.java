package cabinet;


import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CabinetTest {

    @Test
    @DisplayName("특정 크루가 원하는 캐비넷에 배정되는지 확인")
    void allocate() throws IOException {
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

    @Test
    @DisplayName("사용하지 않는 캐비넷을 배정하지 않는지 확인")
    void autoAllocateWithExcludeCabinet() throws IOException {
        List<String> result = Cabinet.autoAllocate(40);
        assertThat(result.get(39)).isEqualTo(Cabinet.FORBIDDEN_CABINET);
    }
}