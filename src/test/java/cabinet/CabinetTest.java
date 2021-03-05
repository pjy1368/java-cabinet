package cabinet;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CabinetTest {

    @Test
    @DisplayName("특정 크루가 원하는 캐비넷에 배정되는지 확인")
    void allocateWithFixedMembers() throws IOException {
        final List<String> result =
            Cabinet.allocateWithFixedMembers("21:제이온,22:바다,23:조엘", 40);
        assertThat(result).hasSize(52);
        assertThat(result.get(20)).isEqualTo("제이온");
        assertThat(result.get(21)).isEqualTo("바다");
        assertThat(result.get(22)).isEqualTo("조엘");
        assertThat(result.get(39)).isEqualTo("X");
        OutputView.showResult(result);
    }

    @Test
    @DisplayName("크루가 총 몇명인지 확인")
    void read() throws IOException {
        final List<String> members = Cabinet.readCrewsList();
        assertThat(members).hasSize(51);
    }

    @Test
    @DisplayName("사용하지 않는 캐비넷을 배정하지 않는지 확인")
    void autoAllocateWithExcludeCabinet() throws IOException {
        final List<String> result = Cabinet.autoAllocate(40);
        assertThat(result.get(39)).isEqualTo(Cabinet.FORBIDDEN_CABINET);
    }
}