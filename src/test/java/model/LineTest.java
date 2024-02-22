package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("참여할 사람의 수를 입력받아 라인을 만든다.")
    void createLine() {
        int personCount = 4;
        Line line = new Line(personCount);
        assertThat(line.getSize()).isEqualTo(personCount - 1);
    }

    @Test
    @DisplayName("참여할 사람은 최소 2명이다.")
    void createLineThrowException() {
        int personCount = 1;
        assertThatThrownBy(() -> new Line(personCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여할 사람은 최소 2명이어야 합니다.");
    }

    @Test
    @DisplayName("사다리의 경로는 연달아 있을 수 없다.")
    void createPathThrowException() {
        List<Path> paths = List.of(Path.EXIST, Path.EXIST, Path.NOT_EXIST);
        assertThatThrownBy(() -> new Line(paths))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 경로는 연달아 있을 수 없습니다.");
    }
}